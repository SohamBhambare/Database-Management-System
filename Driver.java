/* 

Bhambare , Soham                                 

 */


package xyz;

import java.util.*;
public class Driver {

	public static void main(String[] args) {

		DataBase d = new DataBase(100);
		int response;
		Scanner keyboard = new Scanner(System.in);

		d.insert("31111", "Sean", "Dunn");
		d.insert("29922", "Geoffrey", "Duong");
		d.insert("31100", "Nicholas", "Fazekas");
		d.insert("22223", "Stefano", "Prezioso");
		d.insert("11224", "Mohana", "Puvvada");
		d.insert("11226", "Rakhi", "Ravikumar");
		d.insert("11227", "Matthew", "Salyers");
		d.insert("49587", "William", "Gillespie");
		d.insert("29282", "Caleb", "Hess");
		d.insert("34512", "Jared", "Armatis");
		d.insert("35176", "Allan", "Beckman");
		d.insert("22113", "Zhen", "Wang");
		d.insert("12345", "Jordan", "Wingett");
		d.insert("34987", "Keith", "Belt");
		d.insert("22234", "Tyler", "Bixler");
		d.insert("22567", "Quentin", "Chambers");
		d.insert("28456", "Adithya", "Chinni");
		d.insert("28456", "Michael", "Donheiser");
		d.insert("33331", "Mikhail", "Kondrashov");
		d.insert("33332", "Laura", "Kraus");
		d.insert("49888", "Phillip", "Krupp");
		d.insert("44112", "John", "Maass");
		d.insert("44223", "Amanda", "McCarty");
		d.insert("44335", "Gregory", "Moldovan");
		d.insert("44556", "Adekunle", "Oshiyoye");
		d.insert("33112", "Frank", "Pagalos");
		d.insert("33221", "Zackery", "Perski");
		d.insert("77556", "Jordan", "Saunders");
		d.insert("77665", "Ashlynne", "Simpson");
		d.insert("33112", "Kyle", "Szalai");
		d.insert("21354", "Robert", "Witting");


		do
		{
			System.out.println(" 1 Add a new student");
			System.out.println(" 2 Delete a student");
			System.out.println(" 3 Find a student by ID");
			System.out.println(" 4 List students by ID increasing");
			System.out.println(" 5 List students by first name increasing");
			System.out.println(" 6 List students by last name increasing");
			System.out.println(" 7 List students by ID decreasing");
			System.out.println(" 8 List students by first name decreasing");
			System.out.println(" 9 List students by last name decreasing");
			System.out.println(" ");
			System.out.println(" 0 End");

			response=keyboard.nextInt();

			switch (response)
			{
			case 1: d.addIt(); 			
			break;
			case 2: d.deleteIt();		
			break;
			case 3: d.findIt();		
			break;
			case 4: d.ListByIDAscending();		
			break;
			case 5: d.ListByFirstAscending();	
			break;
			case 6: d.ListByLastAscending();
			break;
			case 7: d.ListByIDDescending();
			break;
			case 8: d.ListByFirstDescending();
			break;
			case 9: d.ListByLastDescending();
			break;
			default:                
			}

		} while (response!=0);
	}
}