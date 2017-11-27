package AverageGrades;

import java.util.*;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        int studentsCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < studentsCount; i++) {

            String[] studentInfo = scanner
                    .nextLine()
                    .split(" ");

            double[] studentGrades = new double[studentInfo.length - 1];

            for (int j = 1; j < studentInfo.length; j++) {
                studentGrades[j - 1] = Double.parseDouble(studentInfo[j]);
            }

            Student currentStudent = new Student();
            currentStudent.setName(studentInfo[0]);
            currentStudent.setGrades(studentGrades);

            studentsList.add(currentStudent);
        }

        List<Student> studentsListFiltered =  studentsList.stream()
                .filter(p -> p.getAverageGrade(p.getGrades()) >= 5.00)
                .collect(toList());

        studentsListFiltered.sort(Comparator.comparing(Student::getName).reversed()
                .thenComparing(Comparator.comparingDouble(a2 -> a2.getAverageGrade(a2.getGrades()))).reversed());

        for (Student student : studentsListFiltered) {
            System.out.println(student);
        }
    }
}