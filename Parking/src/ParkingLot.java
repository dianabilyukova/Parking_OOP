import java.util.LinkedHashSet;
import java.util.Set;

public class ParkingLot {
    private final Set<Car> cars = new LinkedHashSet<>();

    public void enter(Car car) {
        cars.add(car);
    }
    public void exit(String number) {
        cars.remove(new Car(number));
    }
    public boolean isEmpty() {
        return cars.isEmpty();
    }

    public Iterable<String> carNumbers() {
        return cars.stream().map(Car::getNumber)::iterator;
    }
}
