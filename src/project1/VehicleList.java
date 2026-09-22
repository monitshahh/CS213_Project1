package project1;

/**
 * Maintains the list of registered vehicles
 *
 * @author Monit Shah & Hiya Savaliya
 */
public class VehicleList {

    private static final int LENGTH = 4;
    private static final int NOTFOUND = -1;

    private Vehicle[] vehicles;
    private  int numVehicles;

    public VehicleList(){
        vehicles = new Vehicle[LENGTH];
        numVehicles = 0;
    }

    private int find(Vehicle vehicle) {
        for (int i = 0; i < numVehicles; i++) {
            if (vehicles[i].equals(vehicle)) {
                return i;
            }
        }
        return NOTFOUND;
    }
    private void grow() {
        Vehicle[] newVehicle = new Vehicle[vehicles.length + LENGTH];

        for(int i = 0; i < numVehicles; i++) {
            newVehicle[i] = vehicles[i];
        }
        vehicles = newVehicle;
    }

    public void add(Vehicle vehicle){
        if(numVehicles == vehicles.length){
            grow();
        }
        vehicles[numVehicles] = vehicle;
        numVehicles++;
    }

    public void remove(Vehicle vehicle){
        int index = find(vehicle);
        if (index == NOTFOUND) {
            return;
        }


        vehicles[index] = vehicles[numVehicles - 1];
        vehicles[numVehicles - 1] = null;
        numVehicles--;
    }

    public boolean contains(Vehicle vehicle){
        return find(vehicle) != NOTFOUND;
    }

    private void sortByPlate() {
        for(int i = 0; i < numVehicles -1; i++){
            int minIndex = i;

            for(int j = i+1; j < numVehicles; j++){
                if(vehicles[j].toString().compareToIgnoreCase(vehicles[minIndex].toString()) < 0){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                Vehicle temp = vehicles[i];
                vehicles[i] = vehicles[minIndex];
                vehicles[minIndex] = temp;
            }
        }
    }
    public void printByPlate() {
        sortByPlate();

        for (int i = 0; i < numVehicles; i++) {
            System.out.println(vehicles[i]);
        }
    }

    public void printHistory() {
        sortByPlate();

        for (int i = 0; i < numVehicles; i++) {
            vehicles[i].printHistory();
        }
    }
}
