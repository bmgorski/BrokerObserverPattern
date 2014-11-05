package observable.event;

public class StockStatusUpdate implements ObservableEvent {
	public static final String EVENT_NAME = "Stock Status Update";
	
	public String getEventName() {
		return EVENT_NAME;
	}
}