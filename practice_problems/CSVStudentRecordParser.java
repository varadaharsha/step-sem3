
public class CSVStudentRecordParser {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3 ||
            fields[0].trim().isEmpty() ||
            fields[1].trim().isEmpty() ||
            fields[2].trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Name: " + fields[0].trim() +
                           " | Roll No: " + fields[1].trim() +
                           " | Dept: " + fields[2].trim());
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
