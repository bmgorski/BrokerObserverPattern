package observer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Observable;

import errors.StockAlreadyExsists;
import broker.DAO.StockDAO;
import mediator.EventMediator;
import observable.event.NewStockEvent;
import observable.event.StockStatusUpdate;
import subject.Stock;

public class StockMonitor extends StockObserver {
	
	private static StockMonitor stockMonitor;
	
	public static synchronized StockMonitor getInstance(){
		if(stockMonitor == null){
			stockMonitor = new StockMonitor();
		}
		
		return stockMonitor;
	}
	
	private HashMap<String, Stock> getStocks(){
		return StockDAO.getInstance().getStocks();
	}

	private StockMonitor() {
		EventMediator moderator = EventMediator.getInstance();
		moderator.addObserver(this, new NewStockEvent());
		moderator.addObserver(this, new StockStatusUpdate());
	}

	/**
	 * @param stock
	 * @return 1 if the stock was added 0 if the stock already exists
	 *
	 */
	public int addStock(Stock stock) {
		try {
			StockDAO.getInstance().addStock(stock);
			return 1;
		} catch (StockAlreadyExsists e) {
			//e.printStackTrace();
		}
		return 0;
	}


	public void update(Observable o, Object arg) {
		if(arg instanceof NewStockEvent){
			addStock((Stock)o);
		}
		
		System.out.println("Stock Monitor Update Follows:");
		
		Collection<Stock> stocks = getStocks().values();
		
		for(Stock stock : stocks){
			System.out.println(stock.toString());
			System.out.println(stock.getCurrentStockStatus().toString());
			System.out.println();
		}
	}
}
