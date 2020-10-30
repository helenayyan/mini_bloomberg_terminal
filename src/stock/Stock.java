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
     * @param industry           -  the industry of the security
     * @param description        - the description of the security
     * @param listOfBoardMembers - the board members of the security
     */
    public Security addBasicSecurityInfo(Industry industry, String description, List<Integer> listOfBoardMembers) {
        //TODO validate inputs
        return new Security(industry, description, listOfBoardMembers);
    }


    /**
     * Add new price for a Security
     *
     * @param securityId - security to update
     * @param price      - new price
     * @param timeStamp  - new timestamp
     */
    void addTick(String securityId, float price, LocalDate timeStamp) {
        securityList.get(securityId).insertPrice(price, timeStamp);
    }

    /**
     * All time high of a security
     *
     * @param securityId
     * @return
     */
    public float allTimeHigh(String securityId) {
        return securityList.get(securityId).getHighestPrice();
    }

    /**
     * All time low of a security
     *
     * @param securityId
     * @return
     */
    public float allTimeLow(String securityId) {
        return securityList.get(securityId).getLowestPrice();
    }

    /**
     * All prices for a security in a given interval
     *
     * @param securityId
     * @param startTime
     * @param endTime
     */
    public Map<LocalDate, Float> getAllPriceHistory(String securityId, LocalDate startTime, LocalDate endTime) {
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