import java.util.ArrayList;
import java.util.List;

public class Student {
    private final String name;
    private final List<Double> grades = new ArrayList<>();

    public Student(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name required");
        this.name = name.trim();
    }

    public String getName() { return name; }
    public void addGrades(List<Double> g) { grades.addAll(g); }

    public double average() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double d : grades) sum += d;
        return sum / grades.size();
    }
}
