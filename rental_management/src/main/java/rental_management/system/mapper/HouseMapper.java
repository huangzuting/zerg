package rental_management.system.mapper;


import java.util.List;

import org.springframework.stereotype.Repository;


import rental_management.system.bean.House;

@Repository
public interface HouseMapper {

	public House selectHouseId(int houseId);
	public void insert(House house);
	public void delete(int houseId);
	public List<House> selectAll();
}
