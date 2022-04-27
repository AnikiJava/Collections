import java.util.Objects;

public class Car {
    private String brand;
    private int number;
    Car(String b, int n) {
        this.brand = b;
        this.number = n;
    }

    public int getNumber() {
        return number;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Car) {
            Car car = (Car) o;
            return car.getBrand().equals(this.brand) && car.getNumber() == this.number;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, number);
    }
}
