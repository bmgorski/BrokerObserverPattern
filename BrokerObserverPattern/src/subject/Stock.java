package subject;

import java.util.Collections;
import java.util.Vector;

import observable.event.NewStockEvent;
import moderator.Moderator;

public class Stock extends ObservableSubject {
	private String stockSymbol;
	private Vector<StockStatus> statuses;

	public Stock(String stockSymbol, StockStatus status) {
		this.statuses = new Vector<StockStatus>();
		statuses.add(status);
		this.stockSymbol = stockSymbol;
		
		//Get instance of the Moderator
		this.addObserver(Moderator.getInstance());
		
		//Notify the Moderator of the new stock creation
		notifyObservers(new NewStockEvent());
	}

	public void addStatus(StockStatus aStatus) {
		statuses.add(aStatus);
		Collections.sort(statuses);
		
		//Notify the Moderator of the new stockStatus creation
		notifyObservers(new NewStockEvent());
	}

	public StockStatus getCurrentStockStatus() {
		return statuses.get(0);
	}

	public Vector<StockStatus> getStockStatus() {
		return statuses;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

	@Override
	public void notifyObservers(Object arg) {
		super.notifyObservers(arg);
	}
	
}
