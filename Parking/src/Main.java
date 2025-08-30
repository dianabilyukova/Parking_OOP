import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot lot = new ParkingLot();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if ("END".equalsIgnoreCase(line)) break;
            if (line.isBlank()) continue;

            String[] parts = line.split(",\\s*");
            if (parts.length !=2) continue;

            String direction = parts[0].trim();
            String number = parts[1].trim();

            if ("IN".equalsIgnoreCase(direction)) {
                lot.enter(new Car(number));
            } else if ("OUT".equalsIgnoreCase(direction)) {
                lot.exit(number);
            }
        }

        if (lot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String num : lot.carNumbers()) {
                System.out.println(num);
            }
        }
    }
}