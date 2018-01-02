package rental_management.system.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import rental_management.system.bean.Dev;
@Repository
public interface DevMapper {

	public void insert(Dev dev);
	public void delete(int id);
	public void update(Dev dev);
	public Dev selecthouse(int houseId);
	public Dev selectid(int id);
	public List<Dev> selectAll();
}
