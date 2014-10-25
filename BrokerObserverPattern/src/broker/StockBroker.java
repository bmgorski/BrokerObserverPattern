package broker;

import java.util.HashMap;

public enum StockBroker {
	INSTANCE;
	
	private StockBroker() {}
	private HashMap<String, Stock> stocks = new HashMap<String, Stock>();
	
	
	public StockBroker getInstance(){
		return INSTANCE;
	}
	
	public StockStatus getCurrentStockStatus(String stockSymbol){
		return getStock(stockSymbol).getCurrentStockStatus();
	}
	
	public Stock getStock(String stockSymbol){
		return stocks.get(stockSymbol);
	}
	
	public void addStock(Stock stock){
		stocks.put(stock.getStockSymbol(), stock);
	}
}
