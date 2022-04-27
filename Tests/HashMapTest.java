import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    private MapInterface mapInterface;

    @BeforeEach
    void setUp() {
        mapInterface = new HashMap();
        for (int i = 0; i < 100; i++) {
            CarOwner carOwner = new CarOwner(i, "Name"+i, "Lastname"+i);
            Car car = new Car("Brand" + i, i);
            mapInterface.put(carOwner, car);
        }
        assertEquals(100, mapInterface.size());
    }

    @Test
    void WhenPutOneSizeMustIncrease() {
        CarOwner jack = new CarOwner(101, "jack", "brown");
        Car car101 = new Car("BMW", 200);
        mapInterface.put(jack, car101);
        assertEquals(101, mapInterface.size());
    }

    @Test
    void WhenOneRemovedSizeMustDecrease() {
        CarOwner toRemove = new CarOwner(1, "Name1", "Lastname1");
        mapInterface.remove(toRemove);
        assertEquals(99, mapInterface.size());
    }

    @Test
    void WhenMapClearedSizeMustBe0() {
        mapInterface.clear();
        assertEquals(0, mapInterface.size());
    }

    @Test
    void WhenPut100ElementsWith10DifferentKeysSizeMustBe10() {
        mapInterface.clear();
        for (int i = 0; i < 100; i++) {
            int index = i % 10;
            CarOwner carOwner = new CarOwner(index, "Name" + index, "Lastname" + index);
            Car car = new Car("Brand" + index, index);
            mapInterface.put(carOwner, car);
        }
        assertEquals(10, mapInterface.size());
    }

    @Test
    void removeReturnTrueOnlyOnce() {
        CarOwner newOwner = new CarOwner(5, "Name5", "Lastname5");
        assertTrue(mapInterface.remove(newOwner));
        assertEquals(99, mapInterface.size());
        assertFalse(mapInterface.remove(newOwner));
    }

    @Test
    void getReturnRightValue() {
        CarOwner key = new CarOwner(5, "Name5", "Lastname5");
        Car value = mapInterface.get(key);
        String expectedCarBrand = "Brand5";
        assertEquals(expectedCarBrand, value.getBrand());
    }

}