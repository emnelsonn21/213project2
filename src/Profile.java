public class Profile {
	private String name;
	private Major major;
	
	@Override
	public String toString() {
		return name + major;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Profile) {
			Profile profile = (Profile) obj;
			return profile.name.equals(this.name) && profile.major.equals(this.major); 
		}
		
		return false;
	}
}
