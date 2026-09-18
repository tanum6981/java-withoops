import java.util.*;

//custom exception
class NegativeMarksException extends Exception {
    public  NegativeMarksException(String msg){
        super(msg); 
    }
}

//student class
class Student {
    String name;
    int roll_no;
    ArrayList<Integer> marks;
    //Construtor
    public Student(String name, int roll_no){
        this.name = name;
        this.roll_no = roll_no;
        this.marks = new ArrayList<>();
    }
    //Add marks
    public void addMarks(int mark) throws  NegativeMarksException{
        if(mark < 0){
            throw new NegativeMarksException(
                "Marks cannot be negative: " + mark
            );
        }
        marks.add(mark);
    }
    //Display student details
    public void display() {
    
        System.out.println("Name: "+ name);
        System.out.println("Roll_no: "+ roll_no);
        System.out.println("Marks: "+ marks);
        System.out.println();
    }
}

public class Multithreading1 {

    public static void main(String[] args) {


ArrayList<Student> students = new ArrayList<>();

        Student s1 = new Student("Rahul", 101);

        try {
            s1.addMarks(85);
            s1.addMarks(90);
            s1.addMarks(-10);    // Exception
            s1.addMarks(78);
        }
        catch (NegativeMarksException e) {
System.out.println("Exception: " + e.getMessage());
        }

students.add(s1);

        for (Student s : students) {
s.display();
        }
    }
}



