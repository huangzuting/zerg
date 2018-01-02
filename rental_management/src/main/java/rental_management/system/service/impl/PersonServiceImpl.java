package rental_management.system.service.impl;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rental_management.system.bean.Person;
import rental_management.system.mapper.PersonMapper;
import rental_management.system.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonMapper personMapper;
	
	@Override
	public List<Person> list() {
		
		return personMapper.list();
	}
	@Override
	public Person getPerson(int id) {
		
		return personMapper.getPerson(id);
	}

	@Override
	public void insert(Person person) {
		personMapper.insert(person);
		
	}
	@Override
	public Person seleteName(String name) {
		
	 return personMapper.selectName(name);
	}
}
