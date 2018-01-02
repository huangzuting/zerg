package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.Address;

@Repository
public interface AddressMapper {

	public Address selectId(int id);

	public List<Address> selectPid(int pid);

	public Address selectName(String name);
	
	public void add(Address address);
	
	public void update(Address address);
	
	public void delete(int id);

	public Address selects(String[] contents);
	
	public List<Address> selectLevel(int level);
}
