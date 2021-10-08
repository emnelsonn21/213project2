
public class Tristate extends Nonresident {

	private String state;
	
	public Tristate(Profile profile, boolean isFullTime,  int creditHours, double tuitionDue, String state) {
		super(profile, isFullTime, creditHours, tuitionDue);
		this.state = state;
	}
	
	public static final int FULL_TIME_TUITION = 29737;
	public static final int FULL_TIME_FEE = 3268;
	public static final double PART_TIME_FEE = 3268 * 0.8;
	public static final int PRICE_PER_CREDIT_HOUR = 966;
	public static final int MAX_CREDIT_NO_FEE = 16;
	public static final int NY_DISCOUNT = 4000;
	public static final int CT_DISCOUNT = 5000;
	
	@Override
	public void tuitionDue() { //why would this return void? shouldn't it return the value of tuition?
		//also how are we supposed to access the information of the student if there's no input??
		
		double tuition;
		
		if(!this.getIsFullTime()) {
			tuition = (PRICE_PER_CREDIT_HOUR * this.getCreditHours()) + PART_TIME_FEE;
		}
		
		else {
			tuition = FULL_TIME_TUITION + FULL_TIME_FEE;
		
		//create instance of student??? how to access credit hours???
		//when calling : exampleResident.tuitionDue();
		
			if (this.getCreditHours() > MAX_CREDIT_NO_FEE) {
				tuition += (PRICE_PER_CREDIT_HOUR * (this.getCreditHours() - MAX_CREDIT_NO_FEE));
			}
		}
		
		if (this.getState().equals("NY")) {
			tuition -= NY_DISCOUNT;
		} 
		else if (this.getState().contentEquals("CT")) {
			tuition -= CT_DISCOUNT;
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
