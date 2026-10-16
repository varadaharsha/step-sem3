
class Locker {
    private final int lockerNumber;
    private String code;

    Locker(int lockerNumber, String code) {
        this.lockerNumber = lockerNumber;
        this.code = code;
    }

    void changeCode(String oldCode, String newCode) {
        if (code.equals(oldCode)) {
            code = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Incorrect current code. Change rejected");
        }
    }
}

public class LockerDemo {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");

        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}
