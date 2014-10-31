package observer;

import java.util.Observable;

import observable.event.ObservableEvent;
import subject.Stock;
import subject.StockStatus;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;
import broker.DAO.StockDAO;

public class StockBroker implements Observer {

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
	public void update(Observable observable, ObservableEvent event) {
		// TODO Auto-generated method stub
		
	}
}
