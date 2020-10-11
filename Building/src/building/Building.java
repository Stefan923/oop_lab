package building;

import building.floor.Floor;

import java.util.ArrayList;
import java.util.List;

public class Building {

    private int floorsIndex = 0;
    private Address address;
    private List<Floor> floors = new ArrayList<>();

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    private String describeYourself() {
        return "Adresa este: " + address + "\nNumarul etajelor: " + floors.size();
    }

    public String toString() {
        return describeYourself();
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Floor> getFloors() {
        return floors;
    }

}
