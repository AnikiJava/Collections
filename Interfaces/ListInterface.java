public interface ListInterface extends Collections {
    Car get(int index);

    boolean add(Car car);

    void add(Car  car, int index);

    boolean remove(Car car);

    boolean removeAt(int index);

    int size();

    void clear();

    boolean contains(Car car);
}
