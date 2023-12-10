package Tuan8;

import java.util.PriorityQueue;

class Student implements Comparable<Student> {

    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    int getID()      { return this.id; }
    String getName() { return this.name; }
    double getCGPA() { return this.cgpa; }

    public int compareTo(Student a){
        if (a.getCGPA() != this.getCGPA()) {
            return Double.compare(a.getCGPA(), this.getCGPA());
        } else if (a.getName().compareTo(this.getName()) != 0) {
            return this.getName().compareTo(a.getName());
        } else {
            return Integer.compare(this.getID(),a.getID());
        }
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        List<Student> list = new ArrayList<Student>();
        PriorityQueue<Student> que = new PriorityQueue<>();;
        for (int i = 0; i < events.size(); i++) {
            String[] ev = events.get(i).split(" ");
            if (ev.length > 1 && ev[0].equals("ENTER")) {
                int id = Integer.parseInt(ev[3]);
                String name = ev[1];
                double cgpa = Double.parseDouble(ev[2]);
                que.add(new Student(id, name, cgpa));
            } else if (ev.length == 1) {
                if (!que.isEmpty()) {
                    que.remove();
                }
            }
        }
        while(!que.isEmpty()) {
            list.add(que.remove());
        }
        return list;
    }
}
