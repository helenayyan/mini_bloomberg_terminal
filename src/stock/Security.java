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
     * @param industry
     * @param description
     * @param listOfBoardMembers
     */
    public Security(Industry industry, String description, List<Integer> listOfBoardMembers) {
        this.description = description;
        this.industry = industry;
        this.listOfBoardMembers = listOfBoardMembers;
        priceList = new TreeMap<LocalDate, Float>();
    }

    public Map<LocalDate, Float> getPriceList() {
        return priceList;
    }

    /**
     * Get highest price in map
     *
     * @return
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

    public float getLowestPrice() {
        float lowestPrice = 999999;
        for (Map.Entry<LocalDate, Float> entry : priceList.entrySet()) {
            if (lowestPrice == 0 || entry.getValue() < lowestPrice) {
                lowestPrice = entry.getValue();
            }
        }
        return lowestPrice;
    }

    public Map<LocalDate, Float> getAllPriceHistory(LocalDate startTime, LocalDate endTime) {
        TreeMap<LocalDate, Float> result = new TreeMap<>();
        return priceList.subMap(startTime, endTime);
    }


}
