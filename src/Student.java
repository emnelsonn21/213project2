/**
This class defines the type Student, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Student {
	/**
	Sets the amount of tuituion due from student
	@author Emily Nelson
	*/
	public void tuitionDue() {
	}
	
	
	
	private Profile profile;
	private boolean isFullTime;
	private int creditHours;
	private double tuitionDue;
	Date datePaid = new Date();
	
	/**
	Sets the profile of student
	@param profile the profile to set 
	@author Emily Nelson
	*/
	public Student(Profile profile) {
		this.profile = profile;
	}
	
	//constructor attempt 1
	public Student(Profile profile, boolean isFullTime, int creditHours) {
		this.profile = profile;
		this.isFullTime = isFullTime;
		this.creditHours = creditHours;
	}
	
	
	//constructor attempt 2
	/**
	Constructor for a Student
	@param profile the profile to set 
	@param isFullTime sets the student to being full time or not 
	@param creditHours the credit hours to set
	@param tuitionDue the tuition due to set
	@author Emily Nelson
	*/
	public Student(Profile profile, boolean isFullTime, int creditHours, double tuitionDue) {
		this.profile = profile;
		this.isFullTime = isFullTime;
		this.creditHours = creditHours;
		this.tuitionDue = tuitionDue;
	}
	
	
	
	private int fullTimeUniversityFee = 3268;
	private double partTimeUniversityFee = 3268 * 0.8;
	
	public Student() {
		
	}
	
	//NEED TO FIX!!!!!!!!!!
	/**
	Returns the student in string form
	@return textual represential of student 
	@author Cristofer Gomez-Martinez
	*/
	@Override
	public String toString() {
		String date = "--/--/--";
		if(datePaid != null) {
			date = datePaid.printAsString(datePaid);
		}
		
		String className= this.getClass().getName();
		
		//need to figure out total payment and className
		
		return profile.toString() + ":" + String.valueOf(creditHours) + " credit hours" + ":tuition due:" 
		+ String.valueOf(tuitionDue) + ":total payment:" + String.valueOf(tuitionDue) + ":last payment date: " + date
		+ ":" + className;
	}
	
	
	public Profile getProfile() {
		return profile;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public boolean getIsFullTime() {
		return isFullTime;
	}
	
	public void setIsFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	
	public int getCreditHours() {
		return creditHours;
	}
	
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	public double getTuitionDue() {
		return tuitionDue;
	}
	
	public void setTuitionDue(double tuitionDue) {
		this.tuitionDue = tuitionDue;
	}
}
