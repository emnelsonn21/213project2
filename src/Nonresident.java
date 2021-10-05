public class Nonresident extends Student {

	public Nonresident(Profile profile, boolean isFullTime, int creditHours) {
		super(profile, isFullTime, creditHours);
	}
	
	@Override
	public void tuitionDue() { //why would this return void? shouldn't it return the value of tuition?
		//also how are we supposed to access the information of the student if there's no input??
		
		double tuition;
		
		if(!this.getIsFullTime()) {
			tuition = (966 * this.getCreditHours()) + 2614.4;
		}
		
		else {
			tuition = 29737 + 3268;
		
		//create instance of student??? how to access credit hours???
		//when calling : exampleResident.tuitionDue();
		
			if (this.getCreditHours() > 16) {
				tuition += (966 * (this.getCreditHours() - 16));
			}
		}
		
		this.setTuitionDue(tuition);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}


}
