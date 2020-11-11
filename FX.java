import java.util.*;
import javafx.util.Pair;

class FX extends Currency{
	
	TreeSet<Currency> ts = new TreeSet<Currency>(new TimestampComp());
	HashMap<String, Pair<Double, Integer>> map = new HashMap<String, Pair<Double, Integer>>();
	HashSet<String> currency = new HashSet<String>();
	static int nrCurrencies = 0;
	
	public FX(String fromCurrency, String toCurrency, double price, Integer timestamp) {
		super(toCurrency, fromCurrency, price, timestamp);
	}
	
	void addForeignExchangeValue(String fromCurrency, String toCurrency, double price, Integer timestamp){
		//TreeSet used for the next 2 functions
		Currency c = new Currency(fromCurrency, toCurrency, price, timestamp);
		ts.add(c);
		
		//Making a hashset with every unique currency
		currency.add(fromCurrency);
		currency.add(toCurrency);
		
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
    
    /*void roydFloyd(){
    	for(String k:currency) {
 		   for(String i:currency) {
 		      for(String j:currency) {
 		    	String str1 = i + " " + j;  
 		    	String str2 = i + " " + k;
 		    	String str3 = k + " " + j;
 		        if (map.containsKey(str1) && map.containsKey(str2) && map.containsKey(str3)) {
 		        	Integer timestamp = Math.max(Math.max(map.get(str1).getValue(), map.get(str2).getValue()), map.get(str3).getValue());
 		        	Double price = Math.min(map.get(str1).getKey(), (map.get(str2).getKey() * map.get(str3).getKey()));
 		        	Pair<Double, Integer> pair = new Pair<Double, Integer>(price, timestamp);
 		            map.put(str1, pair);
 		        }
 		      }
 		   }
    	}	
    }*/

    void displayBestPriceToBuyCurrency(String fromCurrency, String toCurrency){
    	String str1 = fromCurrency + " " + toCurrency;
    	for(String k:currency){ 
  		    	String str2 = fromCurrency + " " + k;
  		    	String str3 = k + " " + toCurrency;
  		        if (map.containsKey(str1) && map.containsKey(str2) && map.containsKey(str3)) {
  		        	Integer timestamp = Math.max(Math.max(map.get(str1).getValue(), map.get(str2).getValue()), map.get(str3).getValue());
  		        	Double price = Math.min(map.get(str1).getKey(), (map.get(str2).getKey() * map.get(str3).getKey()));
  		        	Pair<Double, Integer> pair = new Pair<Double, Integer>(price, timestamp);
  		            map.put(str1, pair);
  		        }
  		}	
    	System.out.println("Best price to buy currency from " + fromCurrency + " to " + toCurrency + " is: " + map.get(str1).getKey());  	
    } 
	
}