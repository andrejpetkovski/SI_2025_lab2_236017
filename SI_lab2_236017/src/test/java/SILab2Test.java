import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyStatement() {
        // TEST CASE 1
        RuntimeException exception1;
        exception1 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "12345"));
        assertTrue(exception1.getMessage().contains("allItems list can't be null!"));


        // TEST CASE 2
        RuntimeException exception2;
        List<Item> items = new ArrayList<Item>();
        Item item = new Item("", 5, 6, 7);
        items.add(item);

        exception2 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items, "12345"));
        assertTrue(exception2.getMessage().contains("Invalid item!"));


        // TEST CASE 3
        RuntimeException exception3;
        List<Item> items2 = new ArrayList<Item>();
        Item item2 = new Item("Bread", 5, 100, 10);
        items2.add(item2);

        exception3 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, null));
        assertTrue(exception3.getMessage().contains("Invalid card number!"));


        // TEST CASE 4
        RuntimeException exception4;
        List<Item> items3 = new ArrayList<Item>();
        Item item3 = new Item("Bread", 20, 100, 0);
        items3.add(item3);

        exception4 = assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "01z3456789012345"));
        assertTrue(exception4.getMessage().contains("Invalid character in card number!"));



        // TEST CASE 5
        List<Item> items4 = new ArrayList<Item>();
        Item item4 = new Item("Bread", 20, 100, 0);
        items4.add(item4);

        assertEquals(1970, SILab2.checkCart(items4, "0123456789012345"));
    }

    @Test
    public void multipleCondition() {
        // TEST CASE 1
        List<Item> items = new ArrayList<Item>();
        Item item = new Item("Bread", 5, 700, 0);
        items.add(item);
        assertEquals(3470, SILab2.checkCart(items, "0123456789012345"));


        // TEST CASE 2
        List<Item> items2 = new ArrayList<Item>();
        Item item2 = new Item("Bread", 5, 200, 7);
        items2.add(item2);
        assertEquals(-6030, SILab2.checkCart(items2, "0123456789012345"));


        // TEST CASE 3
        List<Item> items3 = new ArrayList<Item>();
        Item item3 = new Item("Bread", 15, 200, 0);
        items3.add(item3);
        assertEquals(2970, SILab2.checkCart(items3, "0123456789012345"));


        // TEST CASE 4
        List<Item> items4 = new ArrayList<Item>();
        Item item4 = new Item("Bread", 3, 200, 0);
        items.add(item4);
        assertEquals(0, SILab2.checkCart(items4, "0123456789012345"));
    }
}
