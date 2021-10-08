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
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public void setMajor(Major newMajor) {
		this.major = newMajor;
	}
}
