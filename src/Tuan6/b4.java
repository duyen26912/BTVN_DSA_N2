package Tuan6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String firstName;
    private double cgpa;

    public Student(int id, String firstName, double cgpa) {
        this.id = id;
        this.firstName = firstName;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class b4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < total; i++) {
            int id = sc.nextInt();
            String firstName = sc.next();
            double cgpa = sc.nextDouble();
            Student student = new Student(id, firstName, cgpa);
            list.add(student);
        }

        Collections.sort(list, new Comparator<Student>() {

            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() != s2.getCgpa()) {

                    return Double.compare(s2.getCgpa(), s1.getCgpa());
                } else if (!s1.getFirstName().equals(s2.getFirstName())) {
                    return s1.getFirstName().compareTo(s2.getFirstName());
                } else {

                    return Integer.compare(s1.getId(), s2.getId());
                }
            }
        });


        for (Student studentList : list) {
            System.out.println(studentList.getFirstName());
        }
    }
}