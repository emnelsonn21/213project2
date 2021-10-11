/**
This class defines a Roster and contains all methods to edit a given roster
@author Emily Nelson, Cristofer Gomez-Martinez
*/
public class Roster {
	private Student[] roster;
	private int size;
	
	/**
	Finds the index where the student is located in the Student array
	@param student the student being looked for
	@return the index of the student if found, -1 otherwise
	@author Emily Nelson
	*/
	private int find(Student student) {
		for (int index = 0; index < size; index++) {
			if (student.equals(roster[index])) {
				return index;
			}
		}
		return -1;
	}
	
	/**
	Returns the array of students
        @return Student array
	@author Emily Nelson 
	*/
	public Student[] getStudents() {
		return roster;
	}
	
	/**
	Sets the Student array to a new Student array
	@param newStudents the new Student array to set
	@author Emily Nelson
	*/
	public void setStudents(Student[] newStudents) {
		this.roster = newStudents;
	}
	
	/**
	Increases the capacity of the Student array by 4
	Grown whenever array is full
	@author Emily Nelson
	*/
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
	
	/**
	Checks if a student can be added to the Student array
	Adds student to Student array if student is not found in array
	Does nothing if the student is alrady in the albums array
	@param student the student that is to be added
	@return true if student is not in albums array, false otherwise
	@author Emily Nelson
	*/
	public boolean add(Student student) {
		
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
	
	/**
	Checks if a student can be removed from the Student array
	Removes student from Student array if student is found
	Does nothing if the student is not in Student array
	@param student the student that is to be removed
	@return true if student is in Student array, false otherwise
	@author Emily Nelson
	*/
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
	
	// did this in Tuition manager
	public void  print() {
		if (roster[0] == null) {
			System.out.println("the roster is empty");
			return;
		}
		
		for (int i = 0; i < size; i++) {
			System.out.println(roster[i].toString());
		}
		
		System.out.println("end of roster");
		
	}
	
	/**
	Finds the first empty index/spot in the Student array
	@return the index if an empty spot is found, -1 otherwise
	@author Emily Nelson
	*/
	private int findEmptySpot() {
		for (int i = 0; i < roster.length; i++) {
			if (roster[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	Returns the size of Roster
        @return size of Roster
	@author Emily Nelson 
	*/
	public int getSize() {
		return size;
	}
	
	/**
	Gets the index where the student is located in the Student array
	@param student the student being looked for
	@return the index of the student if found, null otherwise
	@author Emily Nelson
	*/
	public Student giveStudent(Student student) {
		for (int index = 0; index < size; index++) {
			if (student.equals(roster[index])) {
				return roster[index];
			}
		}
		return null;
	}
	
	/**
	Gets the index where the International student is located in the Student array
	@param student the Internation student being looked for
	@return the index of the International student if found, null otherwise
	@author Emily Nelson
	*/
	public International getInternational(Student student) {
		Student stud = new Student();
		for (int index = 0; index < size; index++) {
			if (student.equals(roster[index])) {
				stud = roster[index];
				if (stud instanceof International) {
					International inter = (International) stud;
					return inter;
				} else {
					throw new IllegalArgumentException("International student not found");
				}
			}
		}
		
		return null;
	}
	
	/**
	Gets the tuition due for all students the Student array
	@author Emily Nelson
	*/
	public void getAllTuitions() {
		for (int index = 0; index < size; index++) {
			roster[index].tuitionDue();
		}
	}
	
	
}

