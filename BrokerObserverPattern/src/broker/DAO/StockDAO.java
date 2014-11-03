package broker.DAO;

import java.util.HashMap;

import subject.Stock;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;

public enum StockDAO {
	INSTANCE;

	private StockDAO() {};

	private HashMap<String, Stock> stocks = new HashMap<String, Stock>();

	public StockDAO getInstance() {
		return INSTANCE;
	}

	public Stock getStock(String stockSymbol) throws StockDoesNotExsist {
		if (!stocks.containsKey(stockSymbol)) {
			throw new StockDoesNotExsist();
		}

		return stocks.get(stockSymbol);
	}

	public void addStock(Stock stock) throws StockAlreadyExsists {
		if (stocks.containsKey(stock.getStockSymbol())) {
			throw new StockAlreadyExsists();
		} else {
			stocks.put(stock.getStockSymbol(), stock);
		}
	}

}