import java.util.Objects;

public class Car {
    private final String number;

    public Car(String number) {
        if (number == null || number.isBlank()){
            throw new IllegalArgumentException("Car number cannot be null or blank");
        }
        this.number = number.trim();
    }

    public String getNumber() {
        return number;
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return number.equals(car.number);
    }
    @Override public int hashCode() {
        return Objects.hash(number);
    }
    @Override public String toString() {
        return number;
    }
}
