package rental_management.system.service;

import java.util.List;

import rental_management.system.bean.Card;

public interface CardService {
	public List<Card> list();
	
	public void insert(Card card);
	
	public Card selectId(int id);
	
	public void update(Card card);
	
	public Card selectName(String name);
	
}
