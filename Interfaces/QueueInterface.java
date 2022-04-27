public interface QueueInterface extends Collections {
    boolean add(Car car);

    Car peek();

    Car poll();
}
