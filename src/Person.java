public class Person {

    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters (optional but good practice)
    public String getName() { 
        return name; 
    }

    public int getAge() { 
        return age; 
    }

    // Readable representation of a Person
    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
}