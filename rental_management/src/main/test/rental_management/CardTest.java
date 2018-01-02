package rental_management;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rental_management.system.bean.Card;
import rental_management.system.service.CardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml",
		"classpath:spring.xml", "classpath:spring-tx.xml", })
public class CardTest {

	@Autowired
	private CardService cardService;


	@Test
	public void Test() {
		List<Card> list = cardService.list();
		for (Card person : list) {
			System.out.println(person);
		}

	}

	@Test
	public void Test2() {
		Card card = new Card();
		card.setPersonId(1);
		card.setName("插入测试");
		card.setCardNo("999999");
		card.setStatus(1);
		card.setUserId(1);

		cardService.insert(card);
	}

}
