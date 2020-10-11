package building;

import building.floor.Floor;
import building.floor.room.Room;

public class BuildingCreator {

	public static void main(String[] args) {
		Room room = new Room(10);

		Floor floor = new Floor();
		floor.addRoom(room);

		Building building = new Building();
		building.addFloor(floor);
		building.setAddress(new Address("Nicolae Iorga", "Bucuresti", 10));
		
		room.setNumber(200);
		
		System.out.println(building.getFloors().get(0).rooms[0].getNumber());
		
		// building.toString();
		System.out.println(building);
	}
}
