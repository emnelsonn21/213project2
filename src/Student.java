
public class Student {
	public void tuitionDue() {
	}
	
	
	
	private Profile profile;
	private boolean isFullTime;
	private int creditHours;
	private double tuitionDue;
	Date datePaid = new Date();
	
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
	@Override
	public String toString() {
		return "hello";
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
