package project1;

/**
 * Represents a vehicle registered in parking system
 *
 * @author Monit Shah & Hiya Savaliya
 */
public class Vehicle {
    private String plate;
    private History history;
    private static final int PLATE_LENGTH = 7;
    private static final int FIRST_LETTER = 0;
    private static final int FIRST_DIGIT = 1;
    private static final int SECOND_DIGIT = 2;
    private static final int DASH = 3;
    private static final int SECOND_LETTER = 4;
    private static final int THIRD_LETTER = 5;
    private static final int FOURTH_LETTER = 6;

    public Vehicle(String plate){
        this.plate = plate.toUpperCase();
        this.history = null;
    }

    public void printHistory() {
        History current = history;

        while (current != null){
            System.out.println(current.getParking());
            current = current.getNext();
        }

    }

    public static boolean isValidPlate(String plate){
        if(plate == null || plate.length() != PLATE_LENGTH){
            return false;
        }
        return Character.isLetter(plate.charAt(FIRST_LETTER))
                && Character.isDigit(plate.charAt(FIRST_DIGIT))
                && Character.isDigit(plate.charAt(SECOND_DIGIT))
                && plate.charAt(DASH) == '-'
                && Character.isLetter(SECOND_LETTER)
                && Character.isLetter(plate.charAt(THIRD_LETTER))
                && Character.isLetter(plate.charAt(FOURTH_LETTER));
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }

        if (!(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle other = (Vehicle) obj;

        return plate.equals(other.plate);
    }

    @Override
    public String toString() {
        return plate;
    }
}