
public class Directory implements Comparable<Directory> {
	
	private String firstName;
	private String lastName;
	private String number;
	
	//pre: must be 3 string parameters
	//post: when a Directory object is declared, the parameters values are transferred to the field values.
	public Directory(String nameFirst, String nameLast, String number) {
		this.firstName = nameFirst;
		this.lastName = nameLast;
		this.number = number;
	}
	//pre: no parameter
	//post: returns first name
	public String getFirst() {
		return firstName;
	}
	//pre: no parameter
	//post: returns the last name
	public String getLast() {
		return lastName;
	}
	//pre: no parameter
	//post: returns the phone number
	public String getNumber() {
		return number;
	}
	//pre: parameter must be of type string
	//post: sets the new first name
	public void setFirst(String first) {
		firstName = first;
	}
	//pre: parameter must be of type string
	//post: sets the new last name
	public void setLast(String last) {
		lastName = last;
	}
	//pre: parameter must be of type string
	//post: sets the new phone number 
	public void setNumber(String num) {
		number = num;
	}
	//pre: parameter must be of type Directory
	//post: compares the implicit parameter to Directory d that sorts objects by last name
	public int compareTo(Directory d) {
		int x = 0;
		if (lastName.compareTo(d.lastName) > 0) {
			 x = 1;
		}
		else if (lastName.compareTo(d.lastName) < 0) {
			x = -1;
		}
		return x;
	}
	//pre: parameter must be of type string
	//post: returns the string of each field value
	public String toString() {
		return firstName + "          " + lastName + "          " + number;
	}

}
