package broker.DAO;

import java.util.ArrayList;
import java.util.HashMap;

import subject.Stock;
import subject.StockStatus;
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
	
	/**
	 * 
	 * @param status the status to add to the stock instance
	 * @param symbol the symbol of the stock to add the status to.
	 * @throws StockDoesNotExsist when the stock isn't in the hashmap
	 */
	public void addStockStatus(StockStatus status, String symbol)throws StockDoesNotExsist{
		if(!stocks.containsKey(symbol))
			throw new StockDoesNotExsist();
		
		Stock temp = stocks.get(symbol);
		stocks.remove(temp);
		temp.addStatus(status);
		stocks.put(symbol, temp);
	}
	
	/**
	 * 
	 * @return ArrayList containing all the stocks in the system
	 */
	public ArrayList<Stock> getStocks(){
		return new ArrayList<Stock>(stocks.values());
	}
	

}