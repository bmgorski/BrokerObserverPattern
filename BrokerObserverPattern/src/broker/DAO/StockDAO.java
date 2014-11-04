package broker.DAO;

import java.util.HashMap;

import subject.Stock;
import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;

public class StockDAO {
	private StockDAO() {};

	private HashMap<String, Stock> stocks = new HashMap<String, Stock>();
	private static StockDAO stockDAO;
	
	public static synchronized StockDAO getInstance(){
		if(stockDAO == null){
			stockDAO = new StockDAO();
		}
		
		return stockDAO;
	}

	public HashMap<String, Stock> getStocks(){
		return stocks;
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