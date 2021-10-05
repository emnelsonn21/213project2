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
		
		//StringTokenizer tokenizer = new StringTokenizer(str);
		
		while(sc.hasNextLine()) {
			String input = sc.next();
			//C, P, PN, PT have 1
			//S
			//T has 4: T,John Doe,CS,1000,7/13/2021
			
			input.replace(" ", "");
			StringTokenizer tokenizer = new StringTokenizer(input,",");
			
			if (tokenizer.hasMoreElements()) {
				String command = tokenizer.nextToken();
				
				String name;
				String major;
				int noCredits;
				double tuiitionDue;
				boolean isFullTime;
				boolean isStudyAbroad;
				String state;
				Profile profile = new Profile();
				
				switch (command) {
					case "AR": name = tokenizer.nextToken();
							   major = tokenizer.nextToken();
							   profile = makeNewProfile(profile, name, major);
							   noCredits = Integer.valueOf(tokenizer.nextToken());
							   isFullTime = (noCredits < MINFULLTIME) ? false : true;
							   Resident newResident = new Resident(profile, isFullTime, noCredits);
							   roster.add(newResident);
							   
					case "AN" : name = tokenizer.nextToken();
					   			major = tokenizer.nextToken();
					   			profile = makeNewProfile(profile, name, major);
					   			noCredits = Integer.valueOf(tokenizer.nextToken());
					   			isFullTime = (noCredits < MINFULLTIME) ? false : true;
					   			Nonresident newNonresident = new Nonresident(profile, isFullTime, noCredits);
					   			roster.add(newNonresident);
					   			
					case "AI" : name = tokenizer.nextToken();
								major = tokenizer.nextToken();
								profile = makeNewProfile(profile, name, major);
								noCredits = Integer.valueOf(tokenizer.nextToken());
								isFullTime = (noCredits < MINFULLTIME) ? false : true;
								isStudyAbroad = Boolean.valueOf(tokenizer.nextToken());
								International newInternational = new International(profile, isFullTime, noCredits, isStudyAbroad);
								roster.add(newInternational);
								
					case "AT" : name = tokenizer.nextToken();
								major = tokenizer.nextToken();
								profile = makeNewProfile(profile, name, major);
								noCredits = Integer.valueOf(tokenizer.nextToken());
								isFullTime = (noCredits < MINFULLTIME) ? false : true;
								state = tokenizer.nextToken().toUpperCase();
								Tristate newTristate = new Tristate(profile, isFullTime, noCredits, state);
								roster.add(newTristate);
								
					case "R" : name = tokenizer.nextToken();
							   major = tokenizer.nextToken();
							   profile = makeNewProfile(profile, name, major);
							   Student newStudent = new Student(profile);
							   roster.remove(newStudent);
								
					default: throw new IllegalArgumentException();
							   
				}
				
			}
		}
		
		sc.close();
		
	}
	
	public Profile makeNewProfile(Profile profile, String name, String strMajor) {
		String strMajorCap = strMajor.toUpperCase();
		Major major = Major.valueOf(strMajorCap);
		profile.setName(name);
		profile.setMajor(major);
		return profile;
	}
}
