package ttl.larku.demo;

import ttl.larku.dao.inmemory.InMemoryStudentDAO;
import ttl.larku.domain.Student;
import ttl.larku.service.StudentService;

import java.util.List;

/**
 * @author whynot
 */
public class Sorting {

    public static void main(String[] args) {
        new Sorting().go();
    }

    public void go() {
        StudentService ss = new StudentService();
        init(ss);

        List<Student> students = ss.getAllStudents();
    }


    public static void init(StudentService ss) {
        ((InMemoryStudentDAO) ss.getStudentDAO()).createStore();
        ss.createStudent("Manoj", "282 939 9944", Student.Status.FULL_TIME);
        ss.createStudent("Charlene", "282 898 2145", Student.Status.FULL_TIME);
        ss.createStudent("Firoze", "228 678 8765", Student.Status.HIBERNATING);
        ss.createStudent("Joe", "3838 678 3838", Student.Status.PART_TIME);
    }
}
