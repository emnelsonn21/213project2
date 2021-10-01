public class International extends Nonresident {

	private boolean isStudyAbroad; //might need setters and getters ugh 
	
	public International(Profile profile, boolean isFullTime, boolean isStudyAbroad) {
		super(profile, isFullTime);
		this.isStudyAbroad = isStudyAbroad;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}


}
