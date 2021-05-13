package gartley;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LeakyStackTest {

	@Test
    void canCreateEmptyLeakyStack() {
        LeakyStack ls = new LeakyStack(10);
        assertEquals(true, ls.isEmpty());
    }

    @Test
    void canHaveCapacity() {
    	LeakyStack ls = new LeakyStack(10);
    	assertEquals(10, ls.capacity());
    }

    @Test
    void canPushToLeakyStack() {
    	LeakyStack ls = new LeakyStack(10);
    	ls.push("mystringvalue");
    	assertEquals(1, ls.size());
    }

    @Test
    void canPushToFullLeakyStack() {
    	LeakyStack ls = new LeakyStack(3);
    	ls.push("mystringvalue1");
    	ls.push("mystringvalue2");
    	ls.push("mystringvalue3");
    	assertEquals(3, ls.size());
    	ls.push("mystringvalue4");
    	assertEquals(3, ls.size());
    }

    @Test
    void canGetTopFromLeakyStack() {
    	LeakyStack ls = new LeakyStack(3);
    	ls.push("mystringvalue1");
    	ls.push("mystringvalue2");
    	assertEquals("mystringvalue2", ls.top());
    }

    @Test
    void canPopFromLeakyStack() {
    	LeakyStack ls = new LeakyStack(10);
    	ls.push("mystringvalue1");
    	ls.push("mystringvalue2");
    	ls.push("mystringvalue3");
    	assertEquals("mystringvalue3", ls.pop());
    	assertEquals(2, ls.size());
    }

    @Test
    void canLeakyStackBeFull() {
    	LeakyStack ls = new LeakyStack(2);
    	ls.push("mystringvalue1");
    	ls.push("mystringvalue2");
    	assertEquals(true, ls.isFull());
    }

}
