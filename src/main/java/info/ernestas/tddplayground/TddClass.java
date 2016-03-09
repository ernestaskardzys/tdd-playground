package info.ernestas.tddplayground;

public class TddClass {

    public String testMethod() {
        return "Returning not null result :-)";
    }

    public int sum(String text) {
        if (text.contains(",")) {
            String[] parts = text.split(",");
            String part1 = parts[0];
            String part2 = parts[1];
            return Integer.parseInt(part1) + Integer.parseInt(part2);
        } else {
            return Integer.parseInt(text);
        }
    }
}
