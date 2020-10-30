package stock;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Security {
    private Industry industry;
    private String description;
    private List<Integer> listOfBoardMembers;
    private SortedMap<LocalDate, Float> priceList;

    private float allTimeHighPrice;
    private float allTimeLowPrice;

    public Security() {
    }

    /**
     * Parametrized constructor
     *
     * @param industry           - industry of the Security
     * @param description        - string description of Security
     * @param listOfBoardMembers - list of user IDs for the board members
     */
    public Security(Industry industry, String description, List<Integer> listOfBoardMembers) {
        this.description = description;
        this.industry = industry;
        this.listOfBoardMembers = listOfBoardMembers;
        priceList = new TreeMap<LocalDate, Float>();
        allTimeHighPrice = Integer.MIN_VALUE;
        allTimeLowPrice = Integer.MAX_VALUE;
    }

    public Map<LocalDate, Float> getPriceList() {
        return priceList;
    }

    /**
     * Insert a price in the priceList of the security
     *
     * @param price
     * @param timeStamp
     */
    public void insertPrice(float price, LocalDate timeStamp) {
        if (price > this.allTimeHighPrice)
            allTimeHighPrice = price;
        if (price < this.allTimeLowPrice)
            allTimeLowPrice = price;
        this.priceList.put(timeStamp, price);
    }

    /**
     * Get highest price in map
     *
     * @return highest price
     */
    public float getHighestPrice() {
        float highestPrice = 0;
        for (Map.Entry<LocalDate, Float> entry : priceList.entrySet()) {
            if (highestPrice == 0 || entry.getValue() > highestPrice) {
                highestPrice = entry.getValue();
            }
        }
        return highestPrice;
    }

    /**
     * Get lowest price in map
     *
     * @return lowest price
     */
    public float getLowestPrice() {
        return allTimeLowPrice != Integer.MAX_VALUE ? allTimeLowPrice : 0;
    }

    /**
     * Get price history for a period of time
     *
     * @param startTime - starting timestamp
     * @param endTime   - ending timestamp
     * @return - sorted map of prices with key=timestamp and value=price
     */
    public Map<LocalDate, Float> getAllPriceHistory(LocalDate startTime, LocalDate endTime) {
        TreeMap<LocalDate, Float> result = new TreeMap<>();
        return priceList.subMap(startTime, endTime);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Security{" +
                "industry=" + industry +
                ", description='" + description + '\'' +
                ", listOfBoardMembers=" + listOfBoardMembers +
                ", priceList=" + priceList +
                ", allTimeHighPrice=" + allTimeHighPrice +
                ", allTimeLowPrice=" + allTimeLowPrice +
                '}';
    }
}
