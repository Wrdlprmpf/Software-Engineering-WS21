package at.aau.ue4.bsp1;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class BaseTest {

    private RingBuffer<Integer> ringBuffer = new RingBuffer<>(5);
    private Iterator ringBufferIterator = ringBuffer.iterator();

    @Test
    public void shouldReturnTrue_whenEmpty(){
        assertTrue(ringBuffer.isEmpty());
    }

    @Test
    public void shouldReturnFalse_whenNotEmpty(){
        ringBuffer.push(1);
        assertFalse(ringBuffer.isEmpty());
    }

    @Test
    public void shouldReturnZero_whenBufferIsEmpty(){
        assertEquals(0, ringBuffer.size());
    }

    @Test
    public void shouldReturnFive_whenBufferHasFiveElements(){
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        assertEquals(5,ringBuffer.size());
    }

    @Test
    public void shouldIncreaseSize_whenItemsGetPushed(){
        assertEquals(0, ringBuffer.size());
        ringBuffer.push(0);
        assertEquals(1,ringBuffer.size());
        ringBuffer.push(0);
        assertEquals(2,ringBuffer.size());
    }

    @Test
    public void shouldThrow_whenPushedOverCapacity(){
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        assertThrows(RuntimeException.class, ()->ringBuffer.push(0));
    }

    @Test
    public void shouldDecreaseSize_whenItemsGetPopped(){
        ringBuffer.push(0);
        ringBuffer.push(0);
        ringBuffer.push(0);
        assertEquals(3,ringBuffer.size());
        ringBuffer.pop();
        assertEquals(2,ringBuffer.size());
        ringBuffer.pop();
        assertEquals(1,ringBuffer.size());
        ringBuffer.pop();
        assertEquals(0,ringBuffer.size());
    }

    @Test
    public void shouldThrow_whenEmptyPopped(){
        assertThrows(RuntimeException.class,()->ringBuffer.pop());
    }


    @Test
    public void shouldReturnItem_whenItemIsPopped(){
        ringBuffer.push(42);
        Integer item = ringBuffer.pop();
        assertEquals((Integer)42, item);
    }

    @Test
    public void shouldThrow_whenRemoveIsExecuted(){
        assertThrows(UnsupportedOperationException.class,()->ringBufferIterator.remove());
    }

    @Test
    public void shouldThrow_whenMethodRemoveIsLoaded(){
        assertThrows(UnsupportedOperationException.class, ()->{
           ringBuffer.push(0);
           ringBuffer.push(0);
           ringBuffer.push(0);
           ringBufferIterator.remove();
        });
    }

    @Test
    public void shouldReturnFalse_whenRingBufferHasNoNext(){
        assertFalse(ringBufferIterator.hasNext());
    }

    @Test
    public void shouldReturnTrue_whenRingBufferHasANextValue(){
        ringBuffer.push(0);
        assertTrue(ringBufferIterator.hasNext());
    }

    @Test
    public void shouldReturnNextElement_whenBufferIsLoaded(){
        ringBuffer.push(0);
        assertEquals(0, ringBufferIterator.next());
        ringBuffer.push(2);
        assertEquals(2, ringBufferIterator.next());
    }

    @Test
    public void shouldThrow_whenRingBufferIsEmpty(){
        assertThrows(NoSuchElementException.class, ()->ringBufferIterator.next());
    }





}
