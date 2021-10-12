import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
This class contains the method that organizes the user input
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class TuitionManager {

	public static final int MINFULLTIME = 12; 
	public static final int MIN_CREDS = 3;
	public static final int MAX_CREDS =24;
	
	/**
	Reads the command lines from the console
	@author Emily Nelson, Cristofer Gomez-Martinez
	*/
	public void run() {
		System.out.println("Tuition Manager starts running");
		Roster roster = new Roster();
		Student[] newRoster = new Student[4];
		roster.setStudents(newRoster);
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		
		while(sc.hasNextLine()) {
			String input = sc.next();
	
			StringTokenizer tokenizer = new StringTokenizer(input,",");
			
			if (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				command = command.trim();
				String newInput = input.replaceAll(command + ",", "");
				
				String name;
				String major;
				//int tuitionDue = 0;
				Profile profile = new Profile();
				Student newStudent = new Student();
				Student foundStudent = new Student();
				boolean worked = false;
				
				switch (command) {
					case "AR": Resident newResident = makeNewResident(newInput, tokenizer);
							   if (newResident == null) {
								   break;
							   }
							   addStudent(newResident, worked, roster);
							   break;
							   
					case "AN" : Nonresident newNonresident = makeNewNonresident(newInput, tokenizer);
					   			if (newNonresident == null) {
									   break;
								   }
								   addStudent(newNonresident, worked, roster);
					   			break;
					   			
					case "AI" : International newInternational = makeNewInternational(newInput, tokenizer);
								if (newInternational == null) {
									   break;
								   }
								addStudent(newInternational, worked, roster);
								break;
								
					case "AT" : Tristate newTristate = makeNewTristate(newInput, tokenizer);
								if (newTristate == null) {
									break;
								}
								addStudent(newTristate, worked, roster);
								break;
								
					case "R" : name = tokenizer.nextToken();
							   major = tokenizer.nextToken().trim();
							   profile = makeNewProfile(name, major);
							   newStudent = new Student(profile);
							   worked = roster.remove(newStudent);
							   if (worked == true) {
								   System.out.println("Student removed");
							   } else {
								   System.out.println("Student not found");
							   }
							   break;
							   
					case "T" : name = tokenizer.nextToken();
							   major= tokenizer.nextToken();
							   Double amtPaid = Double.valueOf(tokenizer.nextToken());
							   Date newDate = new Date(tokenizer.nextToken().trim());
							   if (!newDate.isValid()) {
								   System.out.println("Invalid date");
							   }
							   profile = makeNewProfile(name, major);
							   newStudent = new Student(profile);
							   foundStudent = roster.giveStudent(newStudent);
							   if (foundStudent.getTuitionDue() >= amtPaid) {
								   foundStudent.setTuitionDue(foundStudent.getTuitionDue() - amtPaid);
							   } else {
								   System.out.println("Payment exceeds tuition due.");
							   }
							   foundStudent.setDatePaid(newDate);
							   System.out.println("Tuition updated");
							   break;
							   
					case "C" : roster.getAllTuitions();
							   System.out.println("Calculation Completed");
							   break;
							   
					case "F" : name = tokenizer.nextToken();
					   	       major = tokenizer.nextToken();
					   	       profile = makeNewProfile(name, major);
					   	       newStudent = new Student(profile);
					   	       foundStudent = roster.giveStudent(newStudent);
					   	       if (!(foundStudent instanceof Resident)) {
					   	    	   System.out.println("Non-resident student doesn't qualify for the award.");
					   	    	   break;
					   	       }
					   	       if (!foundStudent.getIsFullTime()) {
					   	    	   System.out.println("Parttime student doesn't qualify for the award.");
					   	    	   break;
					   	       }
					   	       if (foundStudent.getDidFinancialAid() != 0) {
					   	    	   System.out.println("Awarded once already.");
					   	    	   break;
					   	       }
					   	       double discountedPrice = Integer.valueOf(tokenizer.nextToken().trim());
					   	       if (discountedPrice < 0 || discountedPrice > 10000) {
					   	    	  System.out.println("financial aid value invalid.");
					   	       }
					   	       foundStudent.setTuitionDue(foundStudent.getTuitionDue() - discountedPrice);
					   	       foundStudent.setDidFinancialAid(discountedPrice);
					   	       System.out.println("Financial aid applied.");
					   	       break;
					   	       
					case "S" : profile = makeNewProfileFromCommand(newInput, tokenizer);
			   	       		   newStudent = new Student(profile);
			   	       		   International foundInternational = roster.getInternational(newStudent);
			   	       		   if (foundInternational != null) {
			   	       			   foundInternational.setIsStudyAbroad(true);
			   	       		   } else {
			   	       			   System.out.println("International Student not found");
			   	       		   }
			   	       		   break;
			   	       		   
					case "P" : roster.print();
							   break;
							   
					case "PT" : roster.printByPaymentDate();
					  			break;
					  			
					case "PN" : roster.printByName();
							    break;
			   	       		   
			   	    //now just the prints UGH that's a tomorrow problem
					default: System.out.println("Command " + command + " not supported!");
							   
				}
				
			}
		}
		
		sc.close();
		
	}
	
	/**
	Makes new instance of Resident where all attributes are filled
	@param line the string being tokenized
	@param T the current token from string
	@return instance of Resident
	@author Emily Nelson
	*/	
	public Resident makeNewResident(String line, StringTokenizer T) {
		String name= null;
		String major = null;
		Profile profile = new Profile();
		
		try {
			name = T.nextToken();
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		try {
			major = T.nextToken().trim();
			profile = makeNewProfile(name, major);
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
			
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		
		int noCredits = 0;
		try {
			noCredits = Integer.valueOf(T.nextToken().trim());
		} 
		catch (NumberFormatException nfe){
			System.out.println("invalid credit hours");
			return null;
		} catch (NoSuchElementException nse){
			System.out.println("Credit hours missing.");
			return null;
		}
		if (noCredits < 0) {
			System.out.println("Credit hours cannot be negative.");
		}
		if (noCredits < MIN_CREDS) {
			System.out.println("Minimum credit hours is 3.");
			return null;
		}
		if (noCredits > MAX_CREDS) {
			System.out.println("Credit hours exceed the maximum 24.");
			return null;
		}
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		Resident newResident = new Resident(profile, isFullTime, noCredits, tuitionDue);
		newResident.setTuitionDue(newResident.getTuitionDue());
		newResident.tuitionDue();
		return newResident;
		
	}
	
	/**
	Makes new instance of Nonresident where all attributes are filled
	@param line the string being tokenized
	@param T the current token from string
	@return instance of Nonresident
	@author Emily Nelson
	*/
	public Nonresident makeNewNonresident(String line, StringTokenizer T) {
		String name= null;
		String major = null;
		Profile profile = new Profile();
		
		try {
			name = T.nextToken();
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		try {
			major = T.nextToken().trim();
			profile = makeNewProfile(name, major);
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
			
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		
		int noCredits = 0;
		try {
			noCredits = Integer.valueOf(T.nextToken().trim());
		} 
		catch (NumberFormatException nfe){
			System.out.println("invalid credit hours");
			return null;
		} catch (NoSuchElementException nse){
			System.out.println("Credit hours missing.");
			return null;
		}
		if (noCredits < 0) {
			System.out.println("Credit hours cannot be negative.");
		}
		if (noCredits < MIN_CREDS) {
			System.out.println("Minimum credit hours is 3.");
			return null;
		}
		if (noCredits > MAX_CREDS) {
			System.out.println("Credit hours exceed the maximum 24.");
			return null;
		}
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		Nonresident newNonresident = new Nonresident(profile, isFullTime, noCredits, tuitionDue);
		newNonresident.setTuitionDue(newNonresident.getTuitionDue());
		newNonresident.tuitionDue();
		return newNonresident;
		
	}
	
	/**
	Makes new instance of International where all attributes are filled
	@param line the string being tokenized
	@param T the current token from string
	@return instance of International
	@author Emily Nelson
	*/
	public International makeNewInternational(String line, StringTokenizer T) {
		String name= null;
		String major = null;
		Profile profile = new Profile();
		
		try {
			name = T.nextToken();
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		try {
			major = T.nextToken().trim();
			profile = makeNewProfile(name, major);
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
			
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		
		int noCredits = 0;
		try {
			noCredits = Integer.valueOf(T.nextToken().trim());
		} 
		catch (NumberFormatException nfe){
			System.out.println("invalid credit hours");
			return null;
		} catch (NoSuchElementException nse){
			System.out.println("invalid credit hours");
			return null;
		}
		if (noCredits < 0) {
			System.out.println("Credit hours cannot be negative.");
		}
		if (noCredits < MIN_CREDS) {
			System.out.println("Minimum credit hours is 3.");
			return null;
		}
		
		
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		
		boolean isStudyAbroad;
		try {
			isStudyAbroad = Boolean.valueOf(T.nextToken());
		} catch(NoSuchElementException e) {
			System.out.println("Missing whether international student is study abroad");
			return null;
		}
		
		if (noCredits < MINFULLTIME && isStudyAbroad == false) {
			System.out.println("International students must enroll in at least 12 credits.");
			return null;
		}
		if (noCredits > MINFULLTIME && isStudyAbroad == true) {
			System.out.println("International students studying abroad may not enroll in more than 12 credits.");
			return null;
		}
		International newInternational = new International(profile, isFullTime, noCredits, tuitionDue, isStudyAbroad);
		newInternational.setTuitionDue(newInternational.getTuitionDue());
		newInternational.tuitionDue();
		return newInternational;
		
	}
	
	/**
	Makes new instance of Tristate where all attributes are filled
	@param line the string being tokenized
	@param T the current token from string
	@return instance of Tristate
	@author Emily Nelson
	*/
	public Tristate makeNewTristate(String line, StringTokenizer T) {
		String name= null;
		String major = null;
		Profile profile = new Profile();
		
		try {
			name = T.nextToken();
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		try {
			major = T.nextToken().trim();
			profile = makeNewProfile(name, major);
		} catch (NoSuchElementException e) {
			System.out.println("Missing data in command line.");
			return null;
			
		} catch (NullPointerException e) {
			System.out.println("Missing data in command line.");
			return null;
		}
		
		
		int noCredits = 0;
		try {
			noCredits = Integer.valueOf(T.nextToken().trim());
		} 
		catch (NumberFormatException nfe){
			System.out.println("invalid credit hours");
			return null;
		} catch (NoSuchElementException nse){
			System.out.println("invalid credit hours");
			return null;
		}
		if (noCredits < 0) {
			System.out.println("Credit hours cannot be negative.");
		}
		if (noCredits < 3) {
			System.out.println("Minimum credit hours is 3.");
			return null;
		}
		if (noCredits > 24) {
			System.out.println("Credit hours exceed the maximum 24.");
			return null;
		}
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		String state = T.nextToken().toUpperCase();
		//error statement for if state isn't NY or CT
		Tristate newTristate = new Tristate(profile, isFullTime, noCredits, tuitionDue, state);
		newTristate.setTuitionDue(newTristate.getTuitionDue());
		newTristate.tuitionDue();
		return newTristate;
		
	}
	/**
	Makes new instance of Profile given name and major where all attributes are filled
	@param name the name to set for Profile
	@param strMajor the major to set for Profile
	@return instance of Profile
	@author Emily Nelson
	*/
	public Profile makeNewProfile(String name, String strMajor) {
		Profile profile = new Profile();
		String strMajorCap = strMajor.toUpperCase();
		Major major = null;
		try 
		{
			major = Major.valueOf(strMajorCap);
		
		} 
		catch (IllegalArgumentException e) {
			System.out.println(strMajor + " is not a valid major");
		}
		profile.setName(name);
		profile.setMajor(major);
		return profile;
	}
	
	/**
	Makes new instance of Profile from command line where all attributes are filled
	@param line the string being tokenized
	@param T the current token from string
	@return instance of Profile
	@author Emily Nelson
	*/
	public Profile makeNewProfileFromCommand(String line, StringTokenizer T) {
		String name = T.nextToken();
		String strMajor = T.nextToken().toUpperCase();
		Major major = null;
		try 
		{
			major = Major.valueOf(strMajor);
		
		} 
		catch (IllegalArgumentException e) {
			System.out.println(strMajor + " is not a valid major");
		}
		Profile profile = new Profile();
		profile.setName(name);
		profile.setMajor(major);
		return profile;
		
	}
	
	public void addStudent(Student student, boolean worked, Roster roster) {
		   worked = roster.add(student);
		   if (worked == true) {
			   System.out.println("Student added");
		   }
		   else {
			   System.out.println("Student already in roster");
		   }
	}
