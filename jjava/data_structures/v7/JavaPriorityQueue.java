package jjava.data_structures.v7;

import java.util.*;

// https://www.hackerrank.com/challenges/java-priority-queue/problem
public class JavaPriorityQueue {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }

}

class Student implements Comparable<Student> {
    public final Integer id;
    public final String name;
    public final Double CGPA;

    public Student(int id, String name, double cgpa) {
        this.id=id;
        this.name=name;
        this.CGPA=cgpa;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Student other) {

        if(!this.CGPA.equals(other.CGPA)) return this.CGPA.compareTo(other.CGPA) * -1;

        if(this.name.equals(other.name)) return this.id.compareTo(other.id);

        return this.name.compareTo(other.name);

    }
}

class Priorities {

    private static final String ENTER = "ENTER";
    private static final String SERVERD = "SERVED";

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>();

        for(String event : events) {
            String[] arr = event.split(" ");

            String eventType = arr[0];

            if(ENTER.equals(eventType)) {

                String studentName = arr[1];
                double studentCgpa = Double.parseDouble(arr[2]);
                int studentId = Integer.parseInt(arr[3]);

                Student student = new Student(studentId, studentName, studentCgpa);

                queue.add(student);
                continue;
            }

            if(SERVERD.equals(eventType)) {
                queue.poll();
            }

        }

        List<Student> students = new ArrayList<>(queue);

        Collections.sort(students);

        return students;

    }

}
