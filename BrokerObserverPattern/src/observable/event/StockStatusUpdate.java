package observable.event;

public class StockStatusUpdate implements ObservableEvent {

	@Override
	public String getEventName() {
		return "Stock Status Update";
	}

}