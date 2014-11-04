package observer;

import java.util.Observable;

import mediator.EventMediator;
import observable.event.NewStockEvent;
import subject.Stock;
import subject.StockStatus;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;
import broker.DAO.StockDAO;

public class StockBroker extends StockObserver {
	
	private static StockBroker stockBroker;
	
	public static synchronized StockBroker getInstance(){
		if(stockBroker == null){
			stockBroker = new StockBroker();
		}
		
		return stockBroker;
	}

	private StockBroker() {
		EventMediator moderator = EventMediator.getInstance();
		moderator.addObserver(this, new NewStockEvent());
	}

	public StockStatus getCurrentStockStatus(String stockSymbol) {
		return getStock(stockSymbol).getCurrentStockStatus();
	}

	/**
	 * @param stockSymbol
	 * @return {@link Stock} or null if not stock exists
	 * 
	 */
	public Stock getStock(String stockSymbol) {
		try {
			return StockDAO.getInstance().getStock(stockSymbol);
		} catch (StockDoesNotExsist e) {
			//e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param stock
	 * @return 1 if the stock was added 0 if the stock already exists
	 *
	 */
	public int addStock(Stock stock) {
		try {
			StockDAO.getInstance().addStock(stock);
			return 1;
		} catch (StockAlreadyExsists e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Stock Broker Update Follows:");
		
		Stock stock = (Stock)o;
		addStock(stock);
		
		System.out.println(stock.toString());
		System.out.println(stock.getCurrentStockStatus().toString());
		System.out.println();
	}

}
