import java.util.*;

import javafx.util.Pair;

class FX extends Currency{
	
	TreeSet<Currency> ts = new TreeSet<Currency>(new TimestampComp());
	HashMap<String, Pair<Double, Integer>> map = new HashMap<String, Pair<Double, Integer>>();
	static int nrCurrencies = 0;
	
	public FX(String fromCurrency, String toCurrency, double price, Integer timestamp) {
		super(toCurrency, fromCurrency, price, timestamp);
	}
	
	void addForeignExchangeValue(String fromCurrency, String toCurrency, double price, Integer timestamp){
		//TreeSet used for the next 2 functions
		Currency c = new Currency(fromCurrency, toCurrency, price, timestamp);
		ts.add(c);
		
		//HashMap of currencies with updated prices every time we add a new foreign exchange value, based on the timestamp
		String currencies = fromCurrency + " " + toCurrency;
		//Checking if the price is already updated
		if(!map.containsKey(currencies) || map.get(currencies).getValue() < timestamp) {
			Pair<Double, Integer> pair = new Pair<Double, Integer>(price, timestamp); 
			map.put(currencies, pair);
		}
		nrCurrencies++;
    }

    void displayTop10RecentPrices(){
    	Iterator iterator = ts.iterator();
    	int it = 0;
	    	while(iterator.hasNext() && it < 10){
	    			display((Currency) iterator.next());
	    			it++;
	    		}		
    }

    void displayTopMostRecentPricesForCurrencyPair(String fromCurrency, String toCurrency, Integer numberOfPrices){
    	Iterator iterator = ts.iterator();
    	int it = 0;
    		while(iterator.hasNext() && it < numberOfPrices) {
    			Currency c = (Currency)(iterator.next());
    				if(c.fromCurrency == fromCurrency && c.toCurrency == toCurrency){
    					display(c);
    					it++;
    				}
    		}
    }

    void displayBestPriceToBuyCurrency(String fromCurrency, String toCurrency){
    	String currencies = fromCurrency + " " + toCurrency;
    	System.out.println("Best price to buy currency from " + fromCurrency + " to " + toCurrency + " is: " + map.get(currencies).getKey());
    	
    	// drum minim- drumul minim dintre 2 pcte fixe sau dintre oricare 2 puncte, dfs, 
    	// cu roy-floyd with values
    	//in graf se adauga valorile dupa timestamp
    	//pot sa ramana <price, timestamp> 
    } 
	
}