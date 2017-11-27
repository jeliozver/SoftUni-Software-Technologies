package AverageGrades;

import java.util.stream.DoubleStream;

public class Student {
    private String Name;
    private double[] Grades;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double[] getGrades() {
        return Grades;
    }

    public void setGrades(double[] grades) {
        Grades = grades;
    }

    public double getAverageGrade(double[] grades) {
        double averageGrade = DoubleStream.of(grades).sum();
        return averageGrade / grades.length;
    }

    @Override
    public String toString() {

        String name = this.getName();
        double averageGrade = this.getAverageGrade(getGrades());
        String format = String.format("%.2f", averageGrade);
        return name + " -> " + format;
    }
}