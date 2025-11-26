import java.util.HashMap;

public class Students {

    // Key = Student's B-Number (String), Value = Person object
    private HashMap<String, Person> students;

    // Constructor: Create the HashMap
    public Students() {
        students = new HashMap<>();
    }

    // Method: Add a student to the HashMap
    public void addStudent(String bNumber, Person person) {
        students.put(bNumber, person);
    }

    // Method: Retrieve a Person by B-Number
    public Person findStudent(String bNumber) {
        return students.get(bNumber);
    }

    // Demonstration
    public static void main(String[] args) {

        Students group = new Students();

        // Add entries
        group.addStudent("B00123456", new Person("Malaika", 20));
        group.addStudent("B00123457", new Person("Akib", 22));
        group.addStudent("B00123458", new Person("Mustafa", 19));

        // Demonstrate retrieval without an array
        System.out.println(group.findStudent("B00123456")); // Serif
        System.out.println(group.findStudent("B00123457")); // Anwar
        System.out.println(group.findStudent("B00123458")); // Omar
        System.out.println(group.findStudent("B00959595")); // null (not found)
    }
}