import java.util.Scanner;
import java.util.StringTokenizer;

public class TuitionManager {

	public static final int MINFULLTIME = 12; 
	public void run() {
		Roster roster = new Roster();
		Student[] newRoster = new Student[4];
		roster.setStudents(newRoster);
		
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		String str = sc.nextLine();
		
		while(sc.hasNextLine()) {
			String input = sc.next();
			
			input = input.replace(" ", "");
			StringTokenizer tokenizer = new StringTokenizer(input,",");
			
			if (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				String newInput = input.replaceAll(command + ",", "");
				
				String name;
				String major;
				//int noCredits = 0;
				//double tuitionDue = 0;
				//boolean isFullTime = false;
				int tuitionDue = 0;
				Profile profile = new Profile();
				Student newStudent = new Student();
				Student foundStudent = new Student();
				
				switch (command) {
					case "AR": //name = tokenizer.nextToken();
							   //major = tokenizer.nextToken();
							   //profile = makeNewProfile(profile, name, major);
							   //Resident newResident = makeNewResident(input, tokenizer, profile, noCredits, tuitionDue, isFullTime);
							   //noCredits = Integer.valueOf(tokenizer.nextToken());
							   //isFullTime = (noCredits < MINFULLTIME) ? false : true;
							   //Resident newResident = new Resident(profile, isFullTime, tuitionDue, noCredits);
							   //newResident.setTuitionDue(newResident.getTuitionDue());
							   Resident newResident = makeNewResident(newInput, tokenizer);
							   roster.add(newResident);
							   
					case "AN" : //name = tokenizer.nextToken();
					   			//major = tokenizer.nextToken();
					   			//profile = makeNewProfile(profile, name, major);
					   			//noCredits = Integer.valueOf(tokenizer.nextToken());
					   			//isFullTime = (noCredits < MINFULLTIME) ? false : true;
					   		//	Nonresident newNonresident = new Nonresident(profile, isFullTime, noCredits);
					   			Nonresident newNonresident = makeNewNonresident(newInput, tokenizer);
					   			roster.add(newNonresident);
					   			
					case "AI" : //name = tokenizer.nextToken();
								//major = tokenizer.nextToken();
								//profile = makeNewProfile(profile, name, major);
								//noCredits = Integer.valueOf(tokenizer.nextToken());
								//isFullTime = (noCredits < MINFULLTIME) ? false : true;
								//isStudyAbroad = Boolean.valueOf(tokenizer.nextToken());
								//International newInternational = new International(profile, isFullTime, noCredits, isStudyAbroad);
								International newInternational = makeNewInternational(newInput, tokenizer);
								roster.add(newInternational);
								
					case "AT" : //name = tokenizer.nextToken();
								//major = tokenizer.nextToken();
								//profile = makeNewProfile(profile, name, major);
								//noCredits = Integer.valueOf(tokenizer.nextToken());
								//isFullTime = (noCredits < MINFULLTIME) ? false : true;
								//state = tokenizer.nextToken().toUpperCase();
								//Tristate newTristate = new Tristate(profile, isFullTime, noCredits, state);
								Tristate newTristate = makeNewTristate(newInput, tokenizer);
								roster.add(newTristate);
								
					case "R" : name = tokenizer.nextToken();
							   major = tokenizer.nextToken();
							   profile = makeNewProfile(name, major);
							   newStudent = new Student(profile);
							   roster.remove(newStudent);
							   
					case "T" : name = tokenizer.nextToken();
							   major = tokenizer.nextToken();
							   profile = makeNewProfile(name, major);
							   newStudent = new Student(profile);
							   foundStudent = roster.giveStudent(newStudent);
							   foundStudent.setTuitionDue(foundStudent.getTuitionDue() - Integer.valueOf(tokenizer.nextToken()));
							   //THE NEXT TOKEN IS A DATE SO MAKE SURE IT'S VALID!! 
							   //USE LAST PROJECT TO FIGURE OUT HOW TO DO ALL THAT
					case "C" : roster.getAllTuitions();
							   System.out.println("Calculation Completed");
							   
					case "F" : name = tokenizer.nextToken();
					   	       major = tokenizer.nextToken();
					   	       profile = makeNewProfile(name, major);
					   	       newStudent = new Student(profile);
					   	       foundStudent = roster.giveStudent(newStudent);
					   	       int reducedPrice = Integer.valueOf(tokenizer.nextToken());
					   	       if (reducedPrice < 0 || reducedPrice > 10000) {
					   	    	   throw new IllegalArgumentException("financial aid value invalid");
					   	       }
					   	       foundStudent.setTuitionDue(foundStudent.getTuitionDue() - Integer.valueOf(tokenizer.nextToken()));
					   	       
					case "S" : profile = makeNewProfile2(newInput, tokenizer);
			   	       		   newStudent = new Student(profile);
			   	       		   International foundInternational = roster.getInternational(newStudent);
			   	       		   foundInternational.setIsStudyAbroad(true);
						
					case "P" : if (newRoster[0] == null) {
								   System.out.println("the roster is empty");
					           }else {
					
					        	   System.out.println("* list of students in the roster **");
					 		   
					        	   for (int i = 0; i < roster.getSize(); i++) {
					        		   System.out.println(newRoster[i].toString());
					        	   }
					
					        	   System.out.println("end of roster");
					           }
						
					case "PN" :  if (newRoster[0] == null) {
							           System.out.println("the roster is empty");
						     }else {
						
						        	   System.out.println("* list of students ordered by name **");
						        	   
						        	   Student[] sortedRoster = new Student[roster.getSize()];
						        	   
						        	   for(int i = 0; i < roster.getSize(); i++) {
						       			sortedRoster[i] = newRoster[i];
						        	   }
						        	   
						        	   //sort
						        	   for(int i= 0; i < roster.getSize(); i++) {
						        		   for(int j = i + 1; j < roster.getSize(); i++) {
						        			   if((sortedRoster[j].getProfile().getName().compareTo(sortedRoster[i].getProfile().getName())) < 0){
						        				   Student temp = sortedRoster[i];
						        				   sortedRoster[i] = sortedRoster[j];
						        				   sortedRoster[j] = temp;
						        			   }
						        		   }
						        	   }
						        	   
						        	   for (int i = 0; i < roster.getSize(); i++) {
						        		   System.out.println(sortedRoster[i].toString());
						        	   }
						
						        	   System.out.println("end of roster");
						    }
						
					case "PT" : if (newRoster[0] == null) {
									   System.out.println("the roster is empty");
						        }else {
						
						        	   System.out.println("* list of students made payments ordered by payment date **");
						        	   
						        	   //check how many students have made payments
						        	   int studentPayments = 0;
						        	  
						        	   for(int i = 0; i < roster.getSize(); i++) {
						        		   String date = "--/--/--";
						        			if(newRoster[i].datePaid != null) {
						        				date = newRoster[i].datePaid.printAsString(newRoster[i].datePaid);
						        			}
						        			
						        			if((date.equals("--/--/--")) == false) {
						        				studentPayments++;
						        			}
						        	   }
						        	   
						        	   //make new array with only students that made payments
						        	   Student[] sortedRoster = new Student[studentPayments];
						        	   int index = 0;
						        	   
						        	   for(int i = 0; i < roster.getSize(); i++) {
						        		   String date = "--/--/--";
						        			if(newRoster[i].datePaid != null) {
						        				date = newRoster[i].datePaid.printAsString(newRoster[i].datePaid);
						        			}
						        			
						        			if((date.equals("--/--/--")) == false) {
						        				sortedRoster[index] = newRoster[i];
						        				index++;
						        			}
						        		   
						        	   }
						        	   
						        	   //sort
						        	   for (int i = 0; i < studentPayments; i++) {
						        		   for (int j = 1; j < studentPayments; j++) {
						       				//if j is older than i, swap i and j
						        			   if (sortedRoster[i].datePaid.compareTo(sortedRoster[j].datePaid) == 1) {
						        				   Student temp = sortedRoster[i];
						        				   sortedRoster[i] = sortedRoster[j];
						        				   sortedRoster[j] = temp;
						       				   }
						       				}
						       			}
						        	   
						        	   for (int i = 0; i < studentPayments; i++) {
						        		   System.out.println(sortedRoster[i].toString());
						        	   }
						
						        	   System.out.println("end of roster");
						        }
			   	       		   
			   	    //now just the prints UGH that's a tomorrow problem
					default: throw new IllegalArgumentException("invalid command");
							   
				}
				
			}
		}
		
		sc.close();
		
	}
	
	
	public Resident makeNewResident(String line, StringTokenizer T) {
		String name = T.nextToken();
		String major = T.nextToken();
		Profile profile = makeNewProfile(name, major);
		int noCredits = Integer.valueOf(T.nextToken());
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		Resident newResident = new Resident(profile, isFullTime, noCredits, tuitionDue);
		newResident.setTuitionDue(newResident.getTuitionDue());
		newResident.tuitionDue();
		return newResident;
		
	}
	
	public Nonresident makeNewNonresident(String line, StringTokenizer T) {
		String name = T.nextToken();
		String major = T.nextToken();
		Profile profile = makeNewProfile(name, major);
		int noCredits = Integer.valueOf(T.nextToken());
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		Nonresident newNonresident = new Nonresident(profile, isFullTime, noCredits, tuitionDue);
		newNonresident.setTuitionDue(newNonresident.getTuitionDue());
		newNonresident.tuitionDue();
		return newNonresident;
		
	}
	
	public International makeNewInternational(String line, StringTokenizer T) {
		String name = T.nextToken();
		String major = T.nextToken();
		Profile profile = makeNewProfile(name, major);
		int noCredits = Integer.valueOf(T.nextToken());
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		boolean isStudyAbroad = Boolean.valueOf(T.nextToken());
		International newInternational = new International(profile, isFullTime, noCredits, tuitionDue, isStudyAbroad);
		newInternational.setTuitionDue(newInternational.getTuitionDue());
		newInternational.tuitionDue();
		return newInternational;
		
	}
	
	public Tristate makeNewTristate(String line, StringTokenizer T) {
		String name = T.nextToken();
		String major = T.nextToken();
		Profile profile = makeNewProfile(name, major);
		int noCredits = Integer.valueOf(T.nextToken());
		boolean isFullTime = (noCredits < MINFULLTIME) ? false : true;
		double tuitionDue = 0;
		String state = T.nextToken().toUpperCase();
		//error statement for if state isn't NY or CT
		Tristate newTristate = new Tristate(profile, isFullTime, noCredits, tuitionDue, state);
		newTristate.setTuitionDue(newTristate.getTuitionDue());
		newTristate.tuitionDue();
		return newTristate;
		
	}
	
	public Profile makeNewProfile(String name, String strMajor) {
		Profile profile = new Profile();
		String strMajorCap = strMajor.toUpperCase();
		Major major = Major.valueOf(strMajorCap);
		profile.setName(name);
		profile.setMajor(major);
		return profile;
	}
	
	public Profile makeNewProfile2(String line, StringTokenizer T) {
		String name = T.nextToken();
		String strMajor = T.nextToken().toUpperCase();
		Major major = Major.valueOf(strMajor);
		Profile profile = new Profile();
		profile.setName(name);
		profile.setMajor(major);
		return profile;
		
	}
	

	
}
