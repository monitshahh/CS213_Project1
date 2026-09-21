package project1;


/**
 * Represents a parking Activity
 *
 * @author Monit Shah & Hiya Savaliya
 */
public class Parking {
    private Vehicle vehicle;
    private Timestamp enter;
    private Timestamp exit;

    public Parking(Vehicle vehicle, Timestamp enter){
        this.vehicle = vehicle;
        this.enter = enter;
        this.exit = null;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }

    public Timestamp getEnter(){
        return enter;
    }

    public Timestamp getExit() {
        return exit;
    }

    @Override
    public String toString(){
        return vehicle + " [entered: " + enter  + "][exited: " + exit + "]";
    }
}
