package rental_management.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPropertyMapper {

     public void insert(@Param("userId")int userId,@Param("addressId")int addressId);
     public void deleteuser(int addressId);
     public void deleteaddress(int userId);
     public void updateuser(@Param("userId")int userId,@Param("addressId")int addressId);
     public void updateaddress(@Param("userId")int userId,@Param("addressId")int addressId);
     public List<Integer> selectuser(int userId);
     public List<Integer> selectaddress(int addressId);
}
