package observable.event;

import subject.Stock;
import subject.StockStatus;

public abstract class ObservableEventBase implements IObservableEvent {
	private Stock newStock;
	private StockStatus newStatus;
	
	
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
