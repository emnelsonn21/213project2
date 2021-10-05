public class Tristate extends Nonresident {

	private String state;
	
	public Tristate(Profile profile, boolean isFullTime,  int creditHours, String state) {
		super(profile, isFullTime, creditHours);
		this.state = state;
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
				tuition += (404 * (this.getCreditHours() - 16));
			}
		}
		
		if (this.getState().equals("NY")) {
			tuition -= 4000;
		} 
		else if (this.getState().contentEquals("CT")) {
			tuition -= 5000;
		}
		
		this.setTuitionDue(tuition);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	public String getState() {
		return state;
	}
	public void setState(String newState) {
		this.state = newState;
	}


}
