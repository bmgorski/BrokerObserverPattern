package observable.event;

public class NewStockEvent extends ObservableEventBase {

	@Override
	public String getEventName() {
		return "New Stock Created";
	}

}
