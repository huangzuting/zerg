package rental_management.system.service;

import java.util.List;

import rental_management.system.bean.Person;



public interface PersonService {
	public List<Person> list();
	
	public Person getPerson(int id);
	
	public void insert(Person person);
	
	public Person seleteName(String name);
	
}
