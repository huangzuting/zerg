package rental_management.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rental_management.system.bean.Card;
import rental_management.system.mapper.CardMapper;
import rental_management.system.service.CardService;


@Service
public class CardServiceImlp implements CardService {

	@Autowired
	CardMapper cardMapper;
	
	@Override
	public List<Card> list() {
		
		return cardMapper.list();
	}
	
	@Override
	public void insert(Card card) {
		cardMapper.insert(card);
		
	}
	
	
	@Override
	public Card selectId(int id) {
		return cardMapper.selectId(id);
	}
	
	@Override
	public void update(Card card) {
		cardMapper.update(card);
		
	}
	
	
	@Override
	public Card selectName(String name) {
		return cardMapper.selectName(name);
	}
}
