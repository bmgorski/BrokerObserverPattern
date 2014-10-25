package broker;

public enum StockBroker {
	INSTANCE;
	
	
	private String abc;
	
	private StockBroker() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute (String arg) {
        // Perform operation here 
    }

	public String getAbc() {
		return abc;
	}

	public void setAbc(String abc) {
		this.abc = abc;
	}
}
