public class Roster {
	private Student[] roster;
	private int size;
	
	
	private int find(Student student) {
		for (int index = 0; index < size; index++) {
			if (student.equals(roster[index])) {
				return index;
			}
		}
		return -1;
	}
	
	
	private void grow() {
		Student[] grownRoster = new Student[roster.length + 4];
		
		for (int i = 0; i < roster.length; i++) {
			grownRoster[i] = roster[i];
		}
		
		for (int i = roster.length; i < grownRoster.length; i++) {
			grownRoster[i] = null;
		}
		
		roster = grownRoster;
	}
	
	
	public boolean add(Student student) {
		//have to consider: res, nonres, tristate, international?
		
		if (find(student) != -1) {
			return false; //student already found, have to throw error !
		}
		
		if ((size != 0) && (size % 4 == 0)) {
			grow();
		}
		
		int index = findEmptySpot();
		roster[index] = student;
		size++;
		return true;
	}
	
	public boolean remove(Student student) {
		if (find(student) == -1) {
			return false;
		}
		
		int index = find(student);
		roster[index] = null;
		size--;
		
		if (index < roster.length - 1) {
			 while (index < roster.length - 2) { //length is 5 highest index is 4
				 roster[index] = roster[index + 1];
				 index++;
			 }
			 
			 roster[index] = null;
		}
		
		return true;
	}
	
	private int findEmptySpot() {
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	
}

