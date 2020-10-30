package stock;

import org.junit.jupiter.api.Test;
import stock.Industry;
import stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockTest {

    /**
     * Test for stock creation
     */
    @Test
    public void stockCreationTest() {
        Stock stock = new Stock();
        List<Integer> members = new ArrayList<>();
        members.add(1);
        stock.addBasicSecurityInfo(Industry.HEALTHCARE, "A very good company", members);
        System.out.println(stock.toString());
    }
}