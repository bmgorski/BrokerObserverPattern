package subject;

import java.util.Collections;
import java.util.Vector;

import broker.StockStatus;

public class Stock extends Subject {
	private String stockSymbol;
	private Vector<StockStatus> statuses;

	public Stock(String aStockSymbol, StockStatus aStatus) {
		statuses = new Vector<StockStatus>();
		statuses.add(aStatus);
		stockSymbol = aStockSymbol;
	}

	public void addStatus(StockStatus aStatus) {
		statuses.add(aStatus);
	}

	public StockStatus getCurrentStockStatus() {
		Collections.sort(statuses);
		return statuses.get(0);

	}

	public Vector<StockStatus> getStats() {
		return statuses;
	}

	public String getStockSymbol() {
		return stockSymbol;
	}

}
