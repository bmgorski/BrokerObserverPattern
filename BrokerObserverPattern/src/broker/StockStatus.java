package broker;

import java.util.Date;

import broker.money.Money;

public class StockStatus implements Comparable<StockStatus>{
	public StockStatus(Date dateTime, Money money) {
		this.dateTime = dateTime;
		this.money = money;
	}
	
	private Date dateTime;
	private Money money;
	
	protected Money getMoney() {
		return money;
	}

	protected Date getDateTime() {
		return dateTime;
	}

	
	@Override
	public int compareTo(StockStatus o) {
		if(this.dateTime.before(o.dateTime)){
			return 0;
		}
		else{ 
			return 1;
		}
	}
}
