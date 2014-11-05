package subject;

import java.util.Collections;
import java.util.Vector;

import observable.event.NewStockEvent;
import observable.event.StockStatusUpdate;
import mediator.EventMediator;

public class Stock extends ObservableSubject {
	private String stockSymbol;
	private Vector<StockStatus> statuses;

	public Stock(String stockSymbol, StockStatus status) {
		this.statuses = new Vector<StockStatus>();
		statuses.add(status);
		this.stockSymbol = stockSymbol;
		
		//Get instance of the Moderator
		this.addObserver(EventMediator.getInstance());
		this.setChanged();
		
		//Notify the Moderator of the new stock creation
		this.notifyObservers(new NewStockEvent());
	}

	public void addStatus(StockStatus aStatus) {
		statuses.add(aStatus);
		Collections.sort(statuses);
		
		//Notify the Moderator of the new stockStatus creation
		this.setChanged();
		notifyObservers(new StockStatusUpdate());
		
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
	public String toString() {
		return "Stock Symbol: " + this.stockSymbol;
	}
}
