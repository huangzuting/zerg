package rental_management.system.mapper;

import java.util.List;

import rental_management.system.bean.Card;



public interface CardMapper {
	public List<Card> list();
	
	public void insert(Card card) ;
	
	public void update(Card card);
	
	public Card selectId(int id);
	
	public Card selectName(String name);
	
}
