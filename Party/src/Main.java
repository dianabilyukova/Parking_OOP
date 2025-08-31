import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Patry party = new Patry();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if ("PARTY".equalsIgnoreCase(line)) break;
            if (!line.isBlank()) party.addReservation(line);
        }
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if ("END".equalsIgnoreCase(line)) break;
            if (!line.isBlank()) party.arrive(line);
        }
        System.out.println(party.absentCount());
        for (String code : party.absentVip()) System.out.println(code);
        for (String code : party.absentRegular()) System.out.println(code);
    }
}