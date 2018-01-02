package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.Card;
import rental_management.system.bean.Person;





@Repository
public interface PersonMapper {
	public List<Person> list();
	
	public Person getPerson(int id);
	
	public void insert(Person person);
	
	public Person selectName(String name);
	
}
