package stock;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class to operate on Securities
 */
public class Stock {

    /**
     * Security ID coming from outside -> generated somewhere else (usually a hash) - string
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
     * All time high of a security
     *
     * @param securityId
     * @return
     */
    public float allTimeHigh(int securityId) {
        return securityList.get(securityId).getHighestPrice();
    }

    /**
     * All time low of a security
     *
     * @param securityId
     * @return
     */
    public float allTimeLow(int securityId) {
        return securityList.get(securityId).getLowestPrice();
    }

    /**
     * All prices for a security in a given interval
     *
     * @param securityId
     * @param startTime
     * @param endTime
     */
    public Map<LocalDate, Float> getAllPriceHistory(int securityId, LocalDate startTime, LocalDate endTime) {
        Security security = securityList.get(securityId);
        Map<LocalDate, Float> result = Collections.emptyMap();
        Map<LocalDate, Float> securityHistory = security.getPriceList();

        for (Map.Entry<LocalDate, Float> entry : securityHistory.entrySet()) {
            if (entry.getKey().compareTo(startTime) > 0 && entry.getKey().compareTo(endTime) < 0) {
                result.put(entry.getKey(), entry.getValue());
            }
        }

        return result;
    }


}