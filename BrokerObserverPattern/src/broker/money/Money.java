package broker.money;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public interface Money {
	
	Locale getMoneyLocal();
	
	NumberFormat getNumberFormat();
	
	BigDecimal getAmount();
	
	void setAmount(BigDecimal amount);
	
	String formattedAmount();
}
