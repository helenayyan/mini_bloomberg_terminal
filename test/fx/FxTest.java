package fx;

import org.junit.jupiter.api.Test;

public class FxTest {

    @Test
    public void addFx(){
        FX fcn = new FX(null, null, 0, null);
        fcn.addForeignExchangeValue("euro", "lei", 4.5, 1234);
        fcn.addForeignExchangeValue("euro", "pound", 3.5, 123);
        fcn.addForeignExchangeValue("pound", "lei", 1.5, 1400);
        fcn.addForeignExchangeValue("euro", "franc", 4.7, 2500);
        fcn.addForeignExchangeValue("euro", "leva", 8.5, 10);
        fcn.addForeignExchangeValue("leva", "franc", 0.5, 4000);
        fcn.addForeignExchangeValue("krikri", "lei", 6.4, 150);
        fcn.addForeignExchangeValue("euro", "krikri", 3.5, 3456);
        fcn.addForeignExchangeValue("krikri", "pound", 2.5, 1112);
        fcn.addForeignExchangeValue("krikri", "leva", 7.4, 768);
        fcn.addForeignExchangeValue("franc", "lei", 0.5, 908);
        fcn.addForeignExchangeValue("euro", "lei", 5.2, 1100);
        fcn.addForeignExchangeValue("franc", "leva", 2.3, 1400);

    }

    @Test
    public void getLatest10Test(){
        FX fcn = new FX(null, null, 0, null);
        fcn.addForeignExchangeValue("euro", "lei", 4.5, 1234);
        fcn.addForeignExchangeValue("euro", "pound", 3.5, 123);
        fcn.addForeignExchangeValue("pound", "lei", 1.5, 1400);
        fcn.addForeignExchangeValue("euro", "franc", 4.7, 2500);
        fcn.addForeignExchangeValue("euro", "leva", 8.5, 10);
        fcn.addForeignExchangeValue("leva", "franc", 0.5, 4000);
        fcn.addForeignExchangeValue("krikri", "lei", 6.4, 150);
        fcn.addForeignExchangeValue("euro", "krikri", 3.5, 3456);
        fcn.addForeignExchangeValue("krikri", "pound", 2.5, 1112);
        fcn.addForeignExchangeValue("krikri", "leva", 7.4, 768);
        fcn.addForeignExchangeValue("franc", "lei", 0.5, 908);
        fcn.addForeignExchangeValue("euro", "lei", 5.2, 1100);
        fcn.addForeignExchangeValue("franc", "leva", 2.3, 1400);

        fcn.displayTop10RecentPrices();
        fcn.displayTopMostRecentPricesForCurrencyPair("euro", "lei", 2);
        //fcn.roydFloyd();
        fcn.displayBestPriceToBuyCurrency("euro", "franc");
        fcn.displayBestPriceToBuyCurrency("euro", "lei");
    }
}
