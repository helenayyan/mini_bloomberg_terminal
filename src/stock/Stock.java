package stock;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class to operate on Securities
 */
public class Stock {

    /**
     * Security ID as String, coming from outside -> generated somewhere else (usually a hash) - string
     */
    private Map<String, Security> securityList;

    /**
     * Empty Constructor
     */
    public Stock() {
        securityList = new HashMap<>();
    }

    /**
     * Add Security Info of a security
     *
     * @param securityId         - ID of security to be added
     * @param industry           -  the industry of the security
     * @param description        - the description of the security
     * @param listOfBoardMembers - the board members of the security
     */
    public Security addBasicSecurityInfo(String securityId, Industry industry, String description, List<Integer> listOfBoardMembers) {
        //TODO validate inputs
        Security security = new Security(industry, description, listOfBoardMembers);
        securityList.put(securityId, security);
        return security;
    }


    /**
     * Add new price for a Security
     *
     * @param securityId - security to update
     * @param price      - new price
     * @param timeStamp  - new timestamp
     */
    void addTick(String securityId, double price, LocalDate timeStamp) {
        securityList.get(securityId).insertPrice(price, timeStamp);
    }

    /**
     * All time high of a security
     *
     * @param securityId - the security to query for
     * @return - highest price
     */
    public double allTimeHigh(String securityId) {
        return securityList.get(securityId).getHighestPrice();
    }

    /**
     * All time low of a security
     *
     * @param securityId - the security to query for
     * @return - lowest price
     */
    public double allTimeLow(String securityId) {
        return securityList.get(securityId).getLowestPrice();
    }

    /**
     * Get price history of a security in a given interval
     *
     * @param securityId - security to search for
     * @param startTime  - interval start
     * @param endTime    - interval end
     * @return - map with keys: date and values: price
     */
    public Map<LocalDate, Double> getAllPriceHistory(String securityId, LocalDate startTime, LocalDate endTime) {
        Security security = securityList.get(securityId);

        return security.getAllPriceHistory(startTime, endTime);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Stock{" +
                "securityList=" + securityList +
                '}';
    }
}