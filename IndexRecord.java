/* 

Bhambare , Soham                               

 */


package xyz;

public class IndexRecord{
	//declaring required variables
	private String key;
	private int where;

	//default constructor
	public IndexRecord() {

	}

	//parameterized constructor
	public IndexRecord(String key, int where) {
		this.key = key;
		this.where = where;
	}

	//getters and setters methods
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getWhere() {
		return where;
	}

	public void setWhere(int where) {

		this.where = where;
	}
}