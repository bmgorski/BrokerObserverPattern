package broker;

import java.util.Collections;
import java.util.Observable;
import java.util.Vector;

public class Stock extends Observable{
	private String stockSymbol;
	private Vector<StockStatus> statuses;
	
	
	public Stock(String aStockSymbol, StockStatus aStatus){
		statuses = new Vector<StockStatus>();
		statuses.add(aStatus);
		stockSymbol=aStockSymbol;
	}
	
	public void addStatus(StockStatus aStatus){
		statuses.add(aStatus);
	}
	
	public StockStatus getCurrentStockStatus(){
		Collections.sort(statuses);
		return statuses.get(0);
		
	}
	
	
	public Vector<StockStatus> getStats(){
		return statuses;
	}
	
	public String getStockSymbol(){
		return stockSymbol;
	}
	
}
