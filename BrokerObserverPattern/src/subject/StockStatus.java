package subject;

import java.text.SimpleDateFormat;
import java.util.Date;

import broker.money.Money;

public class StockStatus implements Comparable<StockStatus> {
	private Date dateTime;
	private Money money;
	private static final SimpleDateFormat dFormate = new SimpleDateFormat("yyyy.MM.dd G HH:mm:ss z");

	public StockStatus(Date dateTime, Money money) {
		this.dateTime = dateTime;
		this.money = money;
	}

	public Money getMoney() {
		return money;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public int compareTo(StockStatus o) {
		if (this.dateTime.before(o.dateTime)) {
			return 1;
		} else if(this.dateTime.after(o.dateTime)) {
			return -1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "At " + dFormate.format(dateTime) + " the price was " + money.formattedAmount();
	}
}
