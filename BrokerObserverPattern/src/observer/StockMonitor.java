package observer;

import java.util.ArrayList;
import java.util.Observable;

import errors.StockAlreadyExsists;
import errors.StockDoesNotExsist;
import broker.DAO.StockDAO;
import observable.event.*;
import subject.Stock;

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
		
		if(event instanceof StockStatusUpdate){
			try{
				StockDAO.INSTANCE.addStockStatus(event.getNewStatus(), event.getSymbol());
				ArrayList<Stock> currentStocks = StockDAO.INSTANCE.getStocks();
				
				
			}catch(StockDoesNotExsist e){
				e.printStackTrace();
			}
		}
		
	}

}
