package observer;

import java.util.Observable;

import observable.event.*;
import subject.Stock;
import subject.StockStatus;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;
import broker.DAO.StockDAO;

public class StockBroker implements Observer {

	private static StockBroker instance=null;
	
	
	public static StockBroker getInstance(){
		if(instance==null)
			instance = new StockBroker();
		
		return instance;
	}
	
	/**
	 * Private to prevent outside instantiations
	 */
	private StockBroker() {
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

			return StockDAO.INSTANCE.getStock(stockSymbol);
		} catch (StockDoesNotExsist e) {
			e.printStackTrace();

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
			StockDAO.INSTANCE.addStock(stock);
			return 1;
		} catch (StockAlreadyExsists e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void update(Observable observable, ObservableEventBase event) {
		//if the event type was of NewStockEvent then add the stock to the collection
		if (event instanceof NewStockEvent){
			addStock(event.getNewStock());
		}		
	}
}
