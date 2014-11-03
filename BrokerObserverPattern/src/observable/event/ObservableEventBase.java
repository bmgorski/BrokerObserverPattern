package observable.event;

import subject.Stock;
import subject.StockStatus;

public abstract class ObservableEventBase implements IObservableEvent {
	private Stock newStock;
	private StockStatus newStatus;
	private String symbol;
	
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Stock getNewStock() {
		return newStock;
	}
	public void setNewStock(Stock newStock) {
		this.newStock = newStock;
	}
	public StockStatus getNewStatus() {
		return newStatus;
	}
	public void setNewStatus(StockStatus newStatus) {
		this.newStatus = newStatus;
	}
	
	
}
