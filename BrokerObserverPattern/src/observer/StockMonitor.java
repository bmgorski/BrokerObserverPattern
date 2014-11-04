package observer;

import mediator.EventMediator;
import observable.event.NewStockEvent;
import observable.event.ObservableEvent;
import observable.event.StockStatusUpdate;
import subject.Stock;
import subject.StockStatus;
import subject.ObservableSubject;

public class StockMonitor extends StockObserver {
	
	private static StockMonitor stockMonitor;
	
	public static synchronized StockMonitor getInstance(){
		if(stockMonitor == null){
			stockMonitor = new StockMonitor();
		}
		
		return stockMonitor;
	}

	private StockMonitor() {
		EventMediator moderator = EventMediator.getInstance();
		moderator.addObserver(this, new NewStockEvent());
		moderator.addObserver(this, new StockStatusUpdate());
	}

	@Override
	public void update(ObservableSubject subject, ObservableEvent observableEvent) {
		String eventType = observableEvent.getEventName();
		
		
		
		switch (eventType) {
		case NewStockEvent.EVENT_NAME:
			Stock stock = (Stock)subject;
			StockStatus stockStatus = stock.getCurrentStockStatus();
			
			System.out.println("StockMonitor says: new stock created: StockSymbole - " + stock.getStockSymbol() +
					"Stock Last Status Time - " + stockStatus.getDateTime() + " Money - " + stockStatus.getMoney().formattedAmount() );
			break;

		default:
			break;
		}
			
		
	}
}
