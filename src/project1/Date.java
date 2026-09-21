package project1;

/**
 * for calendar date
 *
 * @author Monit Shah and Hiya Savaliya
 */
public class Date implements Comparable<Date>  {
    private int year;
    private int month;
    private int day;
    private static final int JAN = 1;
    private static final int FEB = 2;
    private static final int MAR = 3;
    private static final int APR = 4;
    private static final int MAY = 5;
    private static final int JUN = 6;
    private static final int JUL = 7;
    private static final int AUG = 8;
    private static final int SEP = 9;
    private static final int OCT = 10;
    private static final int NOV = 11;
    private static final int DEC = 12;

    private static final int DAYS_30 = 30;
    private static final int DAYS_31 = 31;
    private static final int DAYS_FEB = 28;
    private static final int DAYS_LEAP_FEB = 29;

    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUATERCENTENNIAL = 400;

    public Date(int year,int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isValid(){
        int daysInMonth;
        if(month < JAN || month > DEC){
            return false;
        }
        if( day < 1){
            return false;
        }
        if(month == FEB) {
            if (isLeap()) {
                daysInMonth = DAYS_LEAP_FEB;
            } else {
                daysInMonth = DAYS_FEB;
            }
        }
        else if(month == APR || month == JUN || month == SEP || month == NOV){
            daysInMonth = DAYS_30;
        }
        else{
            daysInMonth = DAYS_31;
        }
        return day <= daysInMonth;
    }

    private boolean isLeap(){

        if(year% QUATERCENTENNIAL  == 0){
            return true;
        }
        if(year% CENTENNIAL  == 0){
            return false;
        }

        return year % QUADRENNIAL == 0;
    }


    @Override
    public int compareTo(Date other){
        int LESS  = -1;
        int GREATER  = 1;
        int EQUAL = 0;
        if(year < other.year){
            return LESS;
        }
        if(year > other.year){
            return GREATER;
        }
        if(month < other.month){
            return LESS;
        }
        if(month > other.month){
            return GREATER;
        }
        if(day < other.day){
            return LESS;
        }
        if(day > other.day){
            return GREATER;
        }
        return EQUAL;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Date other)) {
            return false;
        }

        return year == other.year && month == other.month && day == other.day;
    }

    @Override
    public String toString(){
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    public static void main(String[] args) {

        Date test1 = new Date(2025, 2, 29);
        System.out.println("Test 1: " + test1 + " -> " + test1.isValid());

        Date test2 = new Date(2026, 4, 31);
        System.out.println("Test 2: " + test2 + " -> " + test2.isValid());

        Date test3 = new Date(2026, 13, 10);
        System.out.println("Test 3: " + test3 + " -> " + test3.isValid());

        Date test4 = new Date(2026, 5, 0);
        System.out.println("Test 4: " + test4 + " -> " + test4.isValid());

        Date test5 = new Date(2024, 2, 29);
        System.out.println("Test 5: " + test5 + " -> " + test5.isValid());

        Date test6 = new Date(2026, 12, 31);
        System.out.println("Test 6: " + test6 + " -> " + test6.isValid());
    }
}
