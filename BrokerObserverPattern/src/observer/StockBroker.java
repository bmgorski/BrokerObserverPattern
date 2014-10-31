package observer;

import java.util.Observable;

import subject.Stock;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;
import broker.StockStatus;
import broker.DAO.StockDAO;

public class StockBroker extends Observer {

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

	public void addStock(Stock stock) {
		try {
			StockDAO.INSTANCE.addStock(stock);
		} catch (StockAlreadyExsists e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
