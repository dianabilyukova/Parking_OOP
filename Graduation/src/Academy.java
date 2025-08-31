import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Academy {
    private final Map<String, Student> byName = new LinkedHashMap<>();

    public void add(String name, List<Double> grades) {
        Student s = new Student(name);
        s.addGrades(grades);
        byName.put(name, s);
    }

    public Iterable<Student> studentsInOrder() { return byName.values(); }
}
