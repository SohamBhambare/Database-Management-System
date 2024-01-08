/* 

Bhambare , Soham                    

 */


package xyz;

public class DataBaseRecord {
	//declaring required variables
	private String ID;
	private String firstName;
	private String lastName;

	public DataBaseRecord(String ID, String firstName, String lastName) {
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	//getters and setters
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	//toString method
	public String toString() {
		return ID + " " + firstName + " " + lastName;
	}

}