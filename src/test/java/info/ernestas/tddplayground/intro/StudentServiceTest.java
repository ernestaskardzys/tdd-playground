package info.ernestas.tddplayground.intro;

import info.ernestas.tddplayground.model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentServiceTest {

    private StudentService studentService;

    @Before
    public void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testGetFullName_withStudentsName_returnFullName() {
        Student student = new Student();
        student.setName("Ernestas");
        student.setSurname("Kardzys");

        String result = studentService.getFullName(student);
        Assert.assertEquals("Ernestas Kardzys", result);
    }

    @Test
    public void testGetFullName_withNull_returnAnEmptyString() {
        String result2 = studentService.getFullName(null);
        Assert.assertEquals("", result2);
    }

    @Test
    public void testGetScholarship_withAverageLessThan5_return0() {
        Student student = new Student();
        student.setAverage(4.5);

        double result = studentService.getScholarship(student);
        Assert.assertEquals(0.0, result, 0.01);
    }

    @Test
    public void testGetScholarship_withAverageOf85_return2() {
        Student student = new Student();
        student.setAverage(8.5);

        double result = studentService.getScholarship(student);
        Assert.assertEquals(2.0, result, 0.01);
    }

}