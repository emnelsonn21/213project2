public class International extends Nonresident {

	private boolean isStudyAbroad; //might need setters and getters ugh 
	
	public International(Profile profile, boolean isFullTime, int creditHours, boolean isStudyAbroad) {
		super(profile, isFullTime, creditHours);
		this.isStudyAbroad = isStudyAbroad;
	}
	
	@Override
	public void tuitionDue() { //why would this return void? shouldn't it return the value of tuition?
		
		double tuition;
		
		if(this.getIsStudyAbroad()) {
			tuition = 3268 + 2650;
		}
		
		else {
			tuition = 29737 + 3268 + 2650;
			
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
	
	public boolean getIsStudyAbroad() {
		return isStudyAbroad;
	}
	public void setIsStudyAbroad(boolean isStudyAbroad) {
		this.isStudyAbroad = isStudyAbroad;
	}


}
