import java.util.ArrayList;
import java.util.Scanner;
class Student {
    private String name;
    private ArrayList<Integer> marks;
    public Student(String name,ArrayList<Integer> marks) {
        this.name = name;
        this.marks = marks;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getMarks() {
        return marks;
    }
   public int getTotal() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }
    public double getAverage() {
        return (double) getTotal() / marks.size();
    }

    public int getHighest() {
        int max = Integer.MIN_VALUE;
        for (int mark : marks) {
            if (mark > max) max = mark;
        }
        return max;
    }
    public int getLowest() {
        int min = Integer.MAX_VALUE;
        for (int mark : marks) {
            if (mark < min) min = mark;
        }
        return min;
    }
}
public class StudentGradeTracker {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.println("Welcome to Student Grade Tracker!");
        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < studentCount; i++) {
            System.out.print("\nEnter student name: ");
            String name = scanner.nextLine();
            ArrayList<Integer> marks = new ArrayList<>();
            System.out.print("Enter number of subjects: ");
            int subjectCount = scanner.nextInt();
            for (int j = 0; j < subjectCount; j++) {
                System.out.print("Enter mark for Subject " + (j + 1) + ": ");
                marks.add(scanner.nextInt());
            }
            scanner.nextLine(); 
            students.add(new Student(name, marks));
        }
        System.out.println("\nSummary Report:");
        double overallHighest = Integer.MIN_VALUE;
        double overallLowest = Integer.MAX_VALUE;
        for (Student s : students) {
            System.out.println("\nStudent: " +s.getName());
            System.out.println("Marks: " +s.getMarks());
            System.out.println("Total: " + s.getTotal());
            System.out.printf("Average: %.2f\n", s.getAverage());
            System.out.println("Highest: " +s.getHighest());
            System.out.println("Lowest: " +s.getLowest());
            if (s.getHighest() > overallHighest) overallHighest = s.getHighest();
            if (s.getLowest() < overallLowest) overallLowest = s.getLowest();
        }
        System.out.println("\nOverall Stats:");
        System.out.println("Highest score among all students: "+(int)overallHighest);
        System.out.println("Lowest score among all students: "+(int)overallLowest);
        scanner.close();
    }
}
