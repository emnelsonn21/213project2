
public class Nonresident extends Student {

	public Nonresident(Profile profile, boolean isFullTime, int creditHours, double tuitionDue) {
		super(profile, isFullTime, creditHours, tuitionDue);
	}
	
	public static final int FULL_TIME_TUITION = 29737;
	public static final int FULL_TIME_FEE = 3268;
	public static final double PART_TIME_FEE = 3268 * 0.8;
	public static final int PRICE_PER_CREDIT_HOUR = 966;
	public static final int MAX_CREDIT_NO_FEE = 16;
	
	@Override
	public void tuitionDue() { //why would this return void? shouldn't it return the value of tuition?
		//also how are we supposed to access the information of the student if there's no input??
		
		double tuition;
		
		if(!this.getIsFullTime()) {
			tuition = (PRICE_PER_CREDIT_HOUR * this.getCreditHours()) + PART_TIME_FEE;
		}
		
		else {
			tuition = FULL_TIME_TUITION + FULL_TIME_FEE;
		
		
			if (this.getCreditHours() > MAX_CREDIT_NO_FEE) {
				tuition += (PRICE_PER_CREDIT_HOUR * (this.getCreditHours() - MAX_CREDIT_NO_FEE));
			}
		}
		
		this.setTuitionDue(tuition);
		
	}
	
	@Override
	public String toString() {
		return super.toString();
	}


}
