package observable.event;

public class StockStatusUpdate extends ObservableEventBase {

	@Override
	public String getEventName() {
		return "Stock Status Update";
	}

}