package stock;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTest {

    /**
     * Test for stock creation
     */
    @Test
    public void stockCreationTest() {
        Stock stock = new Stock();

        System.out.println(stock.toString());
    }

    @Test
    public void addSecurityTest() {
        Stock stock = new Stock();
        List<Integer> members = new ArrayList<>();
        members.add(1);
        String id = UUID.randomUUID().toString();
        stock.addBasicSecurityInfo(id, Industry.HEALTHCARE, "A very good company", members);
        System.out.println(stock.toString());
    }

    @Test
    public void addTickTest() {
        Stock stock = new Stock();
        List<Integer> members = new ArrayList<>();
        members.add(1);
        String id = UUID.randomUUID().toString();
        stock.addBasicSecurityInfo(id, Industry.HEALTHCARE, "A very good company", members);
        stock.addTick(id, (float) 3.14, LocalDate.now());
        stock.addTick(id, (float) 3.12, LocalDate.now());
        System.out.println(stock.toString());
    }

    @Test
    public void allTimeHighLowTest() {
        Stock stock = new Stock();
        List<Integer> members = new ArrayList<>();
        members.add(1);
        String id = UUID.randomUUID().toString();
        stock.addBasicSecurityInfo(id, Industry.HEALTHCARE, "A very good company", members);
        assertEquals(stock.allTimeHigh(id), 0.0);
        stock.addTick(id, 3.14, LocalDate.now());
        assertEquals(stock.allTimeHigh(id), 3.14);
        stock.addTick(id, 3.12, LocalDate.now());
        assertEquals(stock.allTimeHigh(id), 3.14);
        assertEquals(stock.allTimeLow(id), 3.12);
    }

    @Test
    public void historyTest() {
        Stock stock = new Stock();
        List<Integer> members = new ArrayList<>();
        members.add(1);
        String id = UUID.randomUUID().toString();
        stock.addBasicSecurityInfo(id, Industry.HEALTHCARE, "A very good company", members);
        stock.addTick(id, 3.14, LocalDate.now().minusMonths(2));
        stock.addTick(id, 3.12, LocalDate.now().minusMonths(1));
        stock.addTick(id, 3.12, LocalDate.now().minusMonths(3));
        Map<LocalDate, Double> localStockHistory = new TreeMap<>();
        localStockHistory.put(LocalDate.now().minusMonths(2),3.14);
        localStockHistory.put(LocalDate.now().minusMonths(1),3.12);
        Map<LocalDate, Double> stockHistory = stock.getAllPriceHistory(id, LocalDate.now().minusMonths(2), LocalDate.now());
        assertEquals(stockHistory,localStockHistory);

    }
}