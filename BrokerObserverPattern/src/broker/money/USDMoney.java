package broker.money;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class USDMoney implements Money {
	private BigDecimal amount;
	
	public USDMoney(BigDecimal amount) {
		this.amount = amount;
	}
	
	@Override
	public NumberFormat getNumberFormat() {
		return NumberFormat.getCurrencyInstance(getMoneyLocal());
	}

	@Override
	public Locale getMoneyLocal() {
		return Locale.US;
	}

	@Override
	public BigDecimal getAmount() {
		return amount;
	}

	@Override
	public void setAmount(BigDecimal amount) {
		if(amount == null){
			throw new NullPointerException("Amount of Money Cannot be Null");
		}
		
		this.amount = amount;
	}

	@Override
	public String formattedAmount() {
		return getNumberFormat().format(getAmount());
	}

}
