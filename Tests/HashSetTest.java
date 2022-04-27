import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HashSetTest {

    private SetInterface carSet;

    @BeforeEach
    public void setUp() throws Exception {
        carSet = new HashSet();
        for (int i = 0; i < 100; i++) {
            carSet.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdd3SimilarObjectsThenSizeIncreaseBy1() {
        assertEquals(100, carSet.size());
        assertTrue(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertFalse(carSet.add(new Car("BMW", 10)));
        assertEquals(101, carSet.size());
    }

    @Test
    public void whenSetClearedThenSize0() {
        carSet.clear();
        assertEquals(0, carSet.size());
    }

    @Test
    public void whenElementRemovedThenSizeDecreased() {
        assertTrue(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
        assertFalse(carSet.remove(new Car("Brand30", 30)));
        assertEquals(99, carSet.size());
    }

    @Test
    public void contains() {
        assertTrue(carSet.contains(new Car("Brand20", 20)));
        assertFalse(carSet.contains(new Car("Brund", 10)));
    }

    @Test
    public void forEach() {
        int index = 0;
        for (Car car: carSet) {
            index++;
        }
        assertEquals(100, index);
    }
}