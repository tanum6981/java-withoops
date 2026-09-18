import java.util.*;


public class ArrayList4 {
        public static void registerCourse(Set<String> courses,
                                       String course) {
        // Write your code
        courses.add(course);
    }

    public static boolean isRegistered(Set<String> courses,
                                       String course) {
        // Write your code
        return courses.contains(course);
    }

    public static void dropCourse(Set<String> courses,
                                   String course) {
        // Write your code
         courses.remove(course);
    }

    public static void displayCourses(Set<String> courses) {
        // Write your code
        Iterator<String> it = courses.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public static void main(String[] args) {

        Set<String> courses = new HashSet<>();

        registerCourse(courses, "Java");
        registerCourse(courses, "Python");
        registerCourse(courses, "DBMS");
        registerCourse(courses, "Java");

        System.out.println("Courses:");
        displayCourses(courses);

        System.out.println("Python registered: "
                + isRegistered(courses, "Python"));

        dropCourse(courses, "DBMS");

        System.out.println("After dropping DBMS:");
        displayCourses(courses);
    }
}

    

