/* 

Bhambare , Soham                                

 */


package xyz;

public class IndexArray {
	//declaring required variables
	private IndexRecord[] indexArray;
	private int records;
	private int iterator;
	private DataBase datBase;

	//parameterised constructor
	public IndexArray(int size) {
		indexArray = new IndexRecord[size];
		records = 0;
		// Initialize the iterator to 0.
		iterator = 0; 
	}

	//method to insert record
	public void insert(String key, int where) {
		//placing a new IndexRecord in index array
		indexArray[records] = new IndexRecord(key, where);
		records++;

		//iterating over elements and checking and sorting accordingly
		for(int i = records - 1; i > 0 && key.compareTo(indexArray[i-1].getKey()) < 0; i--) {
			IndexRecord tempRecord = indexArray[i];
			indexArray[i] = indexArray[i-1];
			indexArray[i-1] = tempRecord;
		}

	}

	public int find(String key) {
		for (int i = 0; i < indexArray.length; i++) {
			if(indexArray[i] != null ) {
				// Retrieve the key from the current index in the indexArray
				indexArray[i].getKey();
				if (indexArray[i].getKey().equals(key)) {
					return i;
				}

			}
		}
		return -1;
	}

	public void delete(String key) {
		int index = find(key);
		if (index != -1) {
			for (int i = index; i < records - 1; i++) {
				indexArray[i] = indexArray[i + 1];
			}
			// Remove the reference to the last element.
			indexArray[records - 1] = null; 
			records--;

			if (iterator > index) {
				// Decrement the iterator if it was pointing to the deleted index.
				iterator--; 
			}
		}
	}

	//setting iterator to 0
	public void iteratorInitFront() {
		iterator = 0;
	}

	//setting iterator to last element of the array
	public void iteratorInitBack() {
		iterator = records - 1;
	}

	//checking if there is a next element
	public boolean hasNext() {
		return iterator < records;
	}

	//checking if there is a previous element
	public boolean hasPrevious() {
		return iterator >= 0;
	}

	//gets the next element and increments the iterator
	public int getNext() {
		if (hasNext()) {
			return indexArray[iterator++].getWhere();
		} else {
			// Handle the error as needed.
			return -1; 
		}
	}

	//gets the previous element and decrements the iterator
	public int getPrevious() {
		if (hasPrevious()) {
			return indexArray[iterator--].getWhere();
		} else {
			// Handle the error as needed.
			return -1; 
		}
	}



}