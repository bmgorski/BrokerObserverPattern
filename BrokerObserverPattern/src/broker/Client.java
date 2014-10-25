package broker;

public class Client {
	private StockBroker aBroker; 
	
	public Client(){
		aBroker =  StockBroker.INSTANCE;
	}
	
	void doSomethingWithStockStatus(String stockSymbol){
		
	}
}
