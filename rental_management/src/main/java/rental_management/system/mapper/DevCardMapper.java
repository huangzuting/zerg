package rental_management.system.mapper;
 
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DevCardMapper {
	 public void insert(@Param("devId")int devId,@Param("cardId")int cardId);
     public void deletecard(int cardId);
     public void deletedev(int devId);
     public void updatecard(@Param("devId")int devId,@Param("cardId")int cardId);
     public void updatedev(@Param("devId")int devId,@Param("cardId")int cardId);
     public List<Integer> selectcard(int user);
     public List<Integer> selectdev(int address);
     public List<Integer> selectdevall();
     public void deletedevcard(@Param("devId") int devId,@Param("cardId")int cardId);
}
