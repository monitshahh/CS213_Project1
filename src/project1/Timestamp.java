package project1;

/**
 * Respresent a date and time for parking activity
 *
 * @author Monit Shah & Hiya Savaliya
 */
public class Timestamp implements Comparable<Timestamp>{
    private Date date;
    private byte hour;
    private byte minute;
    private static final int LESS = -1;
    private static final int EQUAL = 0;
    private static final int GREATER = 1;

    public Timestamp(Date date, byte hour, byte minute){
        this.date = date;
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public int compareTo(Timestamp other){
        int dateComparison = date.compareTo(other.date);

        if (dateComparison != EQUAL) {
            return dateComparison;
        }

        if (hour < other.hour) {
            return LESS;
        }

        if (hour > other.hour) {
            return GREATER;
        }

        if (minute < other.minute) {
            return LESS;
        }

        if (minute > other.minute) {
            return GREATER;
        }

        return EQUAL;
    }

    @Override
    public String toString(){
        return String.format("%s %02d:%02d", date, hour, minute);
    }

    public static void main(String[] args) {

        Timestamp t1 = new Timestamp(new Date(2026, 9, 20), (byte) 10, (byte) 30);
        Timestamp t2 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 1: " + t1.compareTo(t2));

        Timestamp t3 = new Timestamp(new Date(2026, 9, 21), (byte) 9, (byte) 30);
        Timestamp t4 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 2: " + t3.compareTo(t4));

        Timestamp t5 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 15);
        Timestamp t6 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 3: " + t5.compareTo(t6));

        Timestamp t7 = new Timestamp(new Date(2026, 9, 22), (byte) 10, (byte) 30);
        Timestamp t8 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 4: " + t7.compareTo(t8));

        Timestamp t9 = new Timestamp(new Date(2026, 9, 21), (byte) 11, (byte) 30);
        Timestamp t10 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 5: " + t9.compareTo(t10));

        Timestamp t11 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 45);
        Timestamp t12 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 6: " + t11.compareTo(t12));

        Timestamp t13 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        Timestamp t14 = new Timestamp(new Date(2026, 9, 21), (byte) 10, (byte) 30);
        System.out.println("Test 7: " + t13.compareTo(t14));
    }
}
