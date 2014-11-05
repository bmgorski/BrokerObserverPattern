package observable.event;

public class NewStockEvent implements ObservableEvent {
	public static final String EVENT_NAME = "New Stock Created";
	
	public String getEventName() {
		return EVENT_NAME;
	}
}
