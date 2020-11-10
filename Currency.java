import java.util.Comparator;

class TimestampComp implements Comparator<Currency>{

	@Override
	public int compare(Currency c1, Currency c2){
		if(c1.getTimestamp() < c2.getTimestamp())
			return 1;
		else
			return -1;
	}
}

class Currency{
	String toCurrency;
	String fromCurrency;
	double price;
	Integer timestamp;
	
	public Currency(String fromCurrency, String toCurrency, double price, Integer timestamp) {
		this.toCurrency = toCurrency;
		this.fromCurrency = fromCurrency;
		this.price = price;
		this.timestamp = timestamp;
	}
	
	public void display(Currency c) {
		System.out.println(c.fromCurrency + " to " + c.toCurrency + " with a price of " + c.price + " at time " + c.timestamp);
	}
	
	public String getToCurrency() {
		return toCurrency;
	}
	
	public String getFromCurrency() {
		return fromCurrency;
	}
	
	public double getPrice() {
		return price;
	}
	
	public Integer getTimestamp() {
		return timestamp;
	}
	
	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}
	
	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}
	
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	} 
 }