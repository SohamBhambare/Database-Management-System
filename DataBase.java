/* 

Bhambare , Soham                           

 */


package xyz;

import java.util.*;
import java.util.Arrays;

public class DataBase {

	//declaring required variables
	private DataBaseRecord[] myDB;
	private IndexArray ID, First, Last;
	private int records;

	Scanner kb = new Scanner(System.in);

	//parameterised constructor
	public DataBase(int size) {
		records = 0;
		myDB = new DataBaseRecord[size];
		ID = new IndexArray(size);
		First = new IndexArray(size);
		Last = new IndexArray(size);
	}


	public void insert(String id, String firstName, String lastName) {
		// Create a new database record
		DataBaseRecord newRecord = new DataBaseRecord(id, firstName, lastName);
		// Check if the array is empty or if the newRecord should be inserted at the end
		if (records == 0 || id.compareTo(myDB[records - 1].getID()) >= 0) {
			myDB[records] = newRecord;
		} else {
			int i = records - 1;
			// Find the correct position to insert the newRecord
			while (i >= 0 && id.compareTo(myDB[i].getID()) < 0) {
				myDB[i + 1] = myDB[i];
				i--;
			}
			// Insert the newRecord in its correct position
			myDB[i + 1] = newRecord;
		}
		// Insert into the respective index arrays
		ID.insert(id, records);
		First.insert(firstName, records);
		Last.insert(lastName, records);

		records++;
	}


	public void sortDB() {
		// Check if there are records to sort
		if (records <= 1) {
			return; // Nothing to sort
		}
		// Perform insertion sort on the myDB array
		for (int i = 1; i < records; i++) {
			DataBaseRecord currentRecord = myDB[i];
			int j = i - 1;

			while (j >= 0 && currentRecord.getID().compareTo(myDB[j].getID()) < 0) {
				myDB[j + 1] = myDB[j];
				j--;
			}

			myDB[j + 1] = currentRecord;
		}
	}


	//method to add a new student to the databse
	public void addIt() {
		//takes input from the user
		System.out.print("Enter student ID: ");
		String id = kb.next();
		System.out.print("Enter first name: ");
		String firstName = kb.next();
		System.out.print("Enter last name: ");
		String lastName = kb.next();
		//calls find method with id as the parameter
		int index = ID.find(id);
		//checks if user already exists
		if(index != -1) {
			DataBaseRecord student = myDB[index];
			System.out.println("User already exist!");
			return;
		}
		//uses insert method to add it to the database
		insert(id, firstName, lastName);
	}


	//method to delete a student from the database
	public void deleteIt() {
		sortDB();
		System.out.print("Enter student ID to delete: ");
		String id = kb.next();
		int index = ID.find(id);

		if (index != -1) {
			// Use the index from the IndexArray to directly access the record in myDB
			DataBaseRecord student = myDB[index];
			// Use the student object to get the first name and last name
			ID.delete(id);
			First.delete(student.getFirstName());
			Last.delete(student.getLastName());
			System.out.println("Student with ID " + id + " has been deleted.");
			// Shift the remaining students to fill the gap
			for (int i = index; i < records - 1; i++) {
				myDB[i] = myDB[i + 1];
			}
			// Clear the last entry and decrement the number of records
			myDB[records - 1] = null;
			records--;
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}


	//method to find a student from the database
	public void findIt() {
		//sorts the database records to ensure they are in order
		sortDB();
		//asks for input
		System.out.print("Enter student ID to find: ");
		String id = kb.next();

		//calls find method with id as the parameter
		int index = ID.find(id);

		if (index != -1) {
			// Use the index from the IndexArray to directly access the record in myDB
			DataBaseRecord student = myDB[index];
			System.out.println("ID: " + student.getID());
			System.out.println("First Name: " + student.getFirstName());
			System.out.println("Last Name: " + student.getLastName());
			System.out.println("-----------");
		} else {
			System.out.println("Student with ID " + id + " not found.");
		}
	}


	//method to list records by ID in ascending order
	public void ListByIDAscending() {
		//using bubble sort to compare adjacent records based on their ID's
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare first names of adjacent records and swap if out of order
				if (myDB[j].getID().compareTo(myDB[j + 1].getID()) > 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}


	//method to list records by first name in ascending order
	public void ListByFirstAscending() {
		//using bubble sort to compare adjacent records based on their first names
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare first names of adjacent records and swap if out of order
				if (myDB[j].getFirstName().compareTo(myDB[j + 1].getFirstName()) > 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}


	//method to list records by last name in ascending order
	public void ListByLastAscending() {
		//using bubble sort to compare adjacent records based on their last names
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare last names of adjacent records and swap if out of order
				if (myDB[j].getLastName().compareTo(myDB[j + 1].getLastName()) > 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}


	//method to list records by ID in descending order
	public void ListByIDDescending() {
		//using bubble sort to compare adjacent records based on their IDs
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare IDs of adjacent records and swap if out of order
				if (myDB[j].getID().compareTo(myDB[j + 1].getID()) < 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}


	//method to list records by first name in descending order
	public void ListByFirstDescending() {
		// Bubble sort the records in descending order based on first name
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare first names of adjacent records and swap if out of order
				if (myDB[j].getFirstName().compareTo(myDB[j + 1].getFirstName()) < 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}


	//method to list records by last name in descending order
	public void ListByLastDescending() {
		// Bubble sort the records in descending order based on last name
		for (int i = 0; i < records - 1; i++) {
			for (int j = 0; j < records - i - 1; j++) {
				// Compare last names of adjacent records and swap if out of order
				if (myDB[j].getLastName().compareTo(myDB[j + 1].getLastName()) < 0) {
					// Swap the records in myDB
					DataBaseRecord temp = myDB[j];
					myDB[j] = myDB[j + 1];
					myDB[j + 1] = temp;
				}
			}
		}

		// Display the sorted records
		for (int i = 0; i < records; i++) {
			if (myDB[i] != null) {
				System.out.println(myDB[i].toString());
			}
		}
	}

}
