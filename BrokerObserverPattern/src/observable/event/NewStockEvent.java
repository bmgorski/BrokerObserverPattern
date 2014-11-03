package observable.event;

public class NewStockEvent implements ObservableEvent {

	@Override
	public String getEventName() {
		return "New Stock Created";
	}

}
