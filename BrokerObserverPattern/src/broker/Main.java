package broker;

import java.math.BigDecimal;
import java.util.Date;

import broker.money.USDMoney;
import subject.Stock;
import subject.StockStatus;
import mediator.EventMediator;

public class Main {

	public static void main(String[] args) {
		EventMediator moderator = EventMediator.getInstance();
		
		Stock stock = new Stock("ABC", new StockStatus(new Date(), new USDMoney(new BigDecimal("22"))));
		
	}

}
