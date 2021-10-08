
public class International extends Nonresident {

	private boolean isStudyAbroad; 
	
	public International(Profile profile, boolean isFullTime, int creditHours, double tuitionDue, boolean isStudyAbroad) {
		super(profile, isFullTime, creditHours, tuitionDue);
		this.isStudyAbroad = isStudyAbroad;
	}
	
	public static final int FULL_TIME_TUITION = 29737;
	public static final int FULL_TIME_FEE = 3268;
	public static final int ADDITIONAL_FEE = 2650;
	public static final double PART_TIME_FEE = 3268 * 0.8;
	public static final int PRICE_PER_CREDIT_HOUR = 966;
	public static final int MAX_CREDIT_NO_FEE = 16;
	
	@Override
	public void tuitionDue() { //why would this return void? shouldn't it return the value of tuition?
		
		double tuition;
		
		if(this.getIsStudyAbroad()) {
			tuition = FULL_TIME_FEE + ADDITIONAL_FEE;
		}
		
		else {
			tuition = FULL_TIME_TUITION + FULL_TIME_FEE + ADDITIONAL_FEE;
			
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
	
	public boolean getIsStudyAbroad() {
		return isStudyAbroad;
	}
	public void setIsStudyAbroad(boolean isStudyAbroad) {
		this.isStudyAbroad = isStudyAbroad;
	}


}
