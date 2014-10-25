package broker;

public enum StockBroker {
	INSTANCE;
	
	private StockBroker() {}
	
	public StockBroker getInstance(){
		return INSTANCE;
	}
	
	
}
