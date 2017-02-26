package info.ernestas.tddplayground.intro;

public class ScholarshipService {

    // Note: what if my average is 9.0 :]
    public double getScholarship(double average) {
        if (average < 5.0) {
            return 0.0;
        } else if (average > 5.0 && average < 8.0) {
            return 1.0;
        } else if (average > 8.0 && average < 9.0) {
            return 2.0;
        } else if (average > 9.0) {
            return 10.0;
        }

        throw new RuntimeException("Are you joking? :)");
    }

}
