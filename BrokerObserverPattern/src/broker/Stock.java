package broker;

import java.util.Observable;
import java.util.Vector;

public class Stock extends Observable{
	public String stockSymbol;
	public Vector<StockStatus> statuses;
	
	
	public Stock(String aStockSymbol, StockStatus aStatus){
		statuses = new Vector<StockStatus>();
		statuses.add(aStatus);
		stockSymbol=aStockSymbol;
	}
	
	public void addStatus(StockStatus aStatus){
		statuses.add(aStatus);
	}
	
	
	
}
