
//package AverageAgeAllListPerson;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;
    private int salary;
    private String department;

    public Person(String name, int age, int salary, String department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }
}


public class AverageAgeAllListPerson {
    
    public static double calculateAverageAge(List<Person> persons) {
        return persons.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }   
    
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("Alice", 30, 50000, "HR"),
            new Person("Bob", 25, 60000, "IT"),
            new Person("Charlie", 35, 70000, "Finance"),
            new Person("Diana", 28, 80000, "Marketing"),
            new Person("Ethan", 40, 90000, "IT")
        );
        double averageAge = calculateAverageAge(persons);
        System.out.println("Average age: " + averageAge);
        double averageAgeByDepartment = calculateAverageAgeByDepartment(persons);
        System.out.println("Average age by department: " + averageAgeByDepartment);

        Map<String, Double> averageAgesByDepartment = calculateAverageAgeByDepartmentV2(persons);
        System.out.println("Average age by department (V2): " + averageAgesByDepartment);

        Map<String, Double> namesWithFirstCharacterLowerCase = convertFirstCharacterNameInLowerCase(persons);
        System.out.println("Names with first character in lower case: " + namesWithFirstCharacterLowerCase);
    }

    public static double calculateAverageAgeByDepartment(List<Person> persons) {
        return persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.averagingInt(Person::getAge)))
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static Map<String, Double> calculateAverageAgeByDepartmentV2(List<Person> persons) {
        return  persons.stream()
                .collect(Collectors.groupingBy(Person::getDepartment, Collectors.averagingInt(Person::getAge)));
    }

    public static Map<String, Double> convertFirstCharacterNameInLowerCase(List<Person> persons) {
        return  persons.stream()
                .collect(Collectors.groupingBy(
                    p -> p.getName().substring(0, 1).toLowerCase() + p.getName().substring(1),
                    Collectors.averagingInt(Person::getAge)));
    }

    public static List<String> convertFirstCharacterNameInLowerCaseV2(List<Person> persons) {
        return  persons.stream()
                .map(p -> p.getName().substring(0, 1).toLowerCase() + p.getName().substring(1))
                .toList();
    }
}