/**
This class defines the type Student, with all of its attributes and methods
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Student {
	/**
	Does nothing
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
		if(this.datePaid.getDay() != 0) {
			date = datePaid.printAsString(datePaid);
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		double totalPayment = 0;
		if (this.getDidFinancialAid() != 0) {
			totalPayment = originalTuition - tuitionDue - didFinancialAid;
		} else {
			totalPayment = originalTuition - tuitionDue;
		}
		
		return profile.toString() + ":" + String.valueOf(creditHours) + " credit hours" + ":tuition due:" 
		+ df.format(tuitionDue) + ":total payment:" + df.format(totalPayment) + ":last payment date: " + date + ":";
	}
	
	/**
	Returns the profile of the student
	@return profile of student
	@author Emily Nelson
	*/  
	public Profile getProfile() {
		return profile;
	}
	
	/**
	Sets the profile of the student to a new profile
	@param profile the new profile to set 
	@author Emily Nelson
	*/
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	/**
	Checks if the student is full-time
	@return true if student is full-time, false otherwise
	@author Emily Nelson
	*/
	public boolean getIsFullTime() {
		return isFullTime;
	}
	
	/**
	Sets the student to either full-time or not
	@param isFullTime the new boolean value to set
	@author Emily Nelson
	*/
	public void setIsFullTime(boolean isFullTime) {
		this.isFullTime = isFullTime;
	}
	
	/**
	Returns the credit hours of student
	@return credit hours of student
	@author Emily Nelson
	*/
	public int getCreditHours() {
		return creditHours;
	}
	
	/**
	Sets the credit hours of the student to new credit hours
	@param creditHours the new credit hours to set 
	@author Emily Nelson
	*/
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	
	/**
	Returns the tuition due from student
	@return tuition due from student
	@author Emily Nelson
	*/
	public double getTuitionDue() {
		return tuitionDue;
	}
	
	/**
	Sets the tuition due from student to new tuition due
	@param tuitionDue the new tuition due to set 
	@author Emily Nelson
	*/
	public void setTuitionDue(double tuitionDue) {
		this.tuitionDue = tuitionDue;
	}
}
