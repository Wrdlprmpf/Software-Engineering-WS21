package at.aau.ue4.bsp2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class MyCollectionTest {
    private MyCollection c;

    @BeforeEach
    public void setup() {
        c = new MyCollection(5);
        c.add("1");
        c.add("2");
        c.add("3");
    }

    @Test
    public void testSizeSimple() {
        assertEquals(3, c.size());
    }

    @Test
    public void shouldIncrease_whenAddAddsNewItem(){
        c.add("4");
        assertEquals(4,c.size());
    }

    @Test
    public void shouldThrow_whenListIsFull(){
        c.add("4");
        c.add("5");
        assertThrows(IllegalArgumentException.class, ()->c.add("Full"));
    }

    @Test
    public void shouldDecrease_whenItemIsRemoved(){
        assertEquals(3,c.size());
        c.remove("1");
        assertEquals(2,c.size());
    }

    @Test
    public void shouldThrow_whenAttemptingToRemoveItemFromEmptyCollection(){
        c.empty();
        assertThrows(IllegalArgumentException.class, ()->c.remove("1"));
    }

    @Test
    public void shouldThrow_whenAttemptingToRemoveNonExistentItem(){
        assertThrows(IllegalArgumentException.class, ()->c.remove("gibsNit"));
    }

    @Test
    public void shouldBeSizeZero_whenEmptied(){
        assertEquals(3,c.size());
        c.empty();
        assertEquals(0, c.size());
    }

    @Test
    public void shouldThrow_whenAttemptingToRemoveFromNewEmptyCollection(){
        c = new MyCollection(5);
        Exception e = assertThrows(IllegalArgumentException.class, ()->c.remove("1"));
        assertEquals(e.getMessage(), "Liste bereits leer");
    }
}
