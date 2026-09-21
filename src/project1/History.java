package project1;

/**
 * Represents a node in a vehicle's parking history.
 *
 * @author Monit Shah & Hiya Savaliya
 */
public class History {

    private Parking parking;
    private History next;

    public History(Parking parking, History next){
        this.parking = parking;
        this.next = next;
    }

    public Parking getParking() {
        return parking;
    }
    public History getNext(){
        return next;
    }
}