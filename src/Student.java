public class Student {
	public void tuitionDue() {
	}
	
	private Profile profile;
	private boolean isFullTime;
	private int creditHours;
	
	public Student(Profile profile, boolean isFullTime) {
		this.profile = profile;
		this.isFullTime = isFullTime;
	}
	

	
	//private boolean isFullTime;
	
	private int fullTimeUniversityFee = 3268;
	private double partTimeUniversityFee = 3268 * 0.8;
	
	@Override
	public String toString() {
		return "hello";
	}
}
