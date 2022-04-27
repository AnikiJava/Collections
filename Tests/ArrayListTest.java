import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    private ListInterface listInterface;

    @BeforeEach
    public void setUp() {
        listInterface = new ArrayList();
        for (int i = 0; i < 100; i++) {
            listInterface.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, listInterface.size());
    }

    @Test
    public void whenElementRemovedByIndexSizeMustBeDecreased() {
        assertTrue(listInterface.removeAt(10));
        assertEquals(99, listInterface.size());
    }

    @Test
    public void whenElementRemovedIndexSizeMustBeDecreased() {
        Car car = new Car("Toyota", 30);
        listInterface.add(car);
        assertEquals(101, listInterface.size());
        listInterface.remove(car);
        assertEquals(100, listInterface.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(listInterface.remove(car));
        assertEquals(100, listInterface.size());
    }

    @Test
    public void whenListClearedSizeMustBe0() {
        listInterface.clear();
        assertEquals(0, listInterface.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
          listInterface.get(100);
        });
    }

    @Test
    public void methodReturnedRightValue() {
        Car car = listInterface.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Toyota", 10);
        listInterface.add(car, 50);
        Car carFromList = listInterface.get(50);
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 20);
        listInterface.add(car, 0);
        Car carFromList = listInterface.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Mitsubishi", 30);
        listInterface.add(car, 99);
        Car carFromList = listInterface.get(99);
        assertEquals("Mitsubishi", carFromList.getBrand());
    }

    @Test
    public void contains() {
        assertTrue(listInterface.contains(new Car("Brand20", 20)));
        assertFalse(listInterface.contains(new Car("Brund", 10)));
    }

    @Test
    public void forEach() {
        int index = 0;
        for (Car car: listInterface) {
            index++;
        }
        assertEquals(100, index);
    }
}