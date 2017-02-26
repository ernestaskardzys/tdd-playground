package info.ernestas.tddplayground.intro;

import info.ernestas.tddplayground.model.Student;

public class StudentService {

    public String getFullName(Student student) {
        return student.getName() + " " + student.getSurname();
    }

    // Note: What should we do with ScholarshipService? :/
    public double getScholarship(Student student) {
        if (student.getAverage() < 5.0) {
            return 0.0;
        }

        ScholarshipService scholarshipService = new ScholarshipService();
        return scholarshipService.getScholarship(student.getAverage());
    }

}
