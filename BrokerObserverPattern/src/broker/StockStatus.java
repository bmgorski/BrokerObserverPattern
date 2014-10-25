package broker;

import java.math.BigDecimal;
import java.util.Date;

public class StockStatus {
	public StockStatus(Date dateTime, BigDecimal money) {
		this.dateTime = dateTime;
		this.money = money;
	}
	
	private Date dateTime;
	private BigDecimal money;
	
	protected Date getDateTime() {
		return dateTime;
	}
	protected BigDecimal getMoney() {
		return money;
	}
}
