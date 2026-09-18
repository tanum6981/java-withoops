import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArrayList5 {
        public static void markAttendance(Set<Integer> attendance,
                                       int studentId) {
        // Write your code
        attendance.add(studentId);
    }

    public static boolean isPresent(Set<Integer> attendance,
                                    int studentId) {
        // Write your code
        return attendance.contains(studentId);
    }

    public static int getAttendanceCount(Set<Integer> attendance) {
        // Write your code

         return attendance.size();
    }

    public static void displayAttendance(Set<Integer> attendance) {
        // Write your code
        Iterator<Integer> it = attendance.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {

        Set<Integer> attendance = new LinkedHashSet<>();

        markAttendance(attendance, 105);
        markAttendance(attendance, 102);
        markAttendance(attendance, 108);
        markAttendance(attendance, 105);
        markAttendance(attendance, 101);

        displayAttendance(attendance);

        System.out.println("Student 108 present: "
                + isPresent(attendance, 108));

        System.out.println("Total Present: "
                + getAttendanceCount(attendance));
    }
    
}
