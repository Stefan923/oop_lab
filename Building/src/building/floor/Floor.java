package building.floor;

import building.floor.room.Room;

public class Floor {
	
	private int roomsIndex = 0;
	public Room[] rooms = new Room[10];

	public void addRoom(Room room) {
		rooms[roomsIndex++] = room;
	}
}
