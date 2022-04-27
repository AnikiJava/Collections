import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList carList;

    @BeforeEach
    public void setUp() {
        carList = new LinkedList();
        for (int i = 0; i < 100; i++) {
            carList.add(new Car("Brand" + i, i));
        }
    }

    @Test
    public void whenAdded100ElementsThenSizeMustBe100() {
        assertEquals(100, carList.size());
    }

    @Test
    public void whenElementRemovedByIndexSizeMustBeDecreased() {
        assertTrue(carList.removeAt(10));
        assertEquals(99, carList.size());
    }

    @Test
    public void whenElementRemovedIndexSizeMustBeDecreased() {
        Car car = new Car("Toyota", 30);
        carList.add(car);
        assertEquals(101, carList.size());
        carList.remove(car);
        assertEquals(100, carList.size());
    }

    @Test
    public void whenNonExistentElementRemovedThenFalse() {
        Car car = new Car("Toyota", 15);
        assertFalse(carList.remove(car));
        assertEquals(100, carList.size());
    }

    @Test
    public void whenListClearedSizeMustBe0() {
        carList.clear();
        assertEquals(0, carList.size());
    }

    @Test
    public void whenIndexOutOfBoundsThenThrownException() {
        IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            carList.get(100);
        });
    }

    @Test
    public void methodReturnedRightValue() {
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void insertIntoMiddle() {
        Car car = new Car("Toyota", 10);
        carList.add(car, 50);
        Car carFromList = carList.get(50);
        assertEquals("Toyota", carFromList.getBrand());
    }

    @Test
    public void insertIntoFirstPosition() {
        Car car = new Car("BMW", 20);
        carList.add(car, 0);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertIntoLastPosition() {
        Car car = new Car("Mitsubishi", 30);
        carList.add(car, 99);
        Car carFromList = carList.get(99);
        assertEquals("Mitsubishi", carFromList.getBrand());
    }

    @Test
    public void contains() {
        assertTrue(carList.contains(new Car("Brand20", 20)));
        assertFalse(carList.contains(new Car("Brund", 10)));
    }

    @Test
    public void forEach() {
        int index = 0;
        for (Car car: carList) {
            index++;
        }
        assertEquals(100, index);
    }
}