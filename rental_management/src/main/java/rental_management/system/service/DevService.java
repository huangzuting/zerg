package rental_management.system.service;

import java.util.List;

import rental_management.system.bean.Dev;

public interface DevService {
	public void addorupdate(Dev dev);
	public void delete(int id);
	public Dev selecthouse(int houseId);
	public Dev selectid(int id);
	public List<Dev> selectAll();
}
