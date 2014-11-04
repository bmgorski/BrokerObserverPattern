package broker;

import java.math.BigDecimal;
import java.util.Date;

import observer.StockBroker;
import observer.StockMonitor;
import broker.money.USDMoney;
import subject.Stock;
import subject.StockStatus;
import mediator.EventMediator;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		EventMediator moderator = EventMediator.getInstance();
		StockBroker stockBroker = StockBroker.getInstance();
		StockMonitor stockMonitor = StockMonitor.getInstance();
		
		Stock stock = new Stock("ABC", new StockStatus(new Date(), new USDMoney(new BigDecimal("22"))));
		
		Stock stock2 = new Stock("ABCD", new StockStatus(new Date(), new USDMoney(new BigDecimal("29"))));
	

	}

}
