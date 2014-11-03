package observer;

import java.util.Observable;

import observable.event.*;

public class StockMonitor implements Observer {

	private static StockMonitor instance;
	
	/**
	 * Private to prevent outside instantiations
	 */
	private StockMonitor(){
		
	}
	
	public StockMonitor getInstance(){
		if(instance==null)
			instance = new StockMonitor();
		
		return instance;
	}
	
	
	
	@Override
	public void update(Observable observable, ObservableEventBase event) {
		// TODO Auto-generated method stub
		
	}

}
