
class AttendanceSheet {
    private final String[] names;
    private int count = 0;

    AttendanceSheet(int capacity) {
        names = new String[capacity];
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            return;
        }

        if (count < names.length) {
            names[count] = name;
            count++;
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                return true;
            }
        }

        return false;
    }
}

public class AttendanceSheetDemo {
    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}
