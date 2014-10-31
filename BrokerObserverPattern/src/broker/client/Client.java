package broker.client;

import observer.StockBroker;

public abstract class Client {
	private StockBroker broker;

	public StockBroker getBroker() {
		return broker;
	}

	public void setBroker(StockBroker broker) {
		this.broker = broker;
	}
	
	
}
