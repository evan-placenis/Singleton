import java.util.ArrayList;

abstract class MapSite {
    public abstract void Enter();
}
class Room extends MapSite{
    int roomNo;
    Room(int roomNo){
        this.roomNo = roomNo;
    }    
    
    public void Enter(){
        System.out.println("Entering room "+ Integer.toString(roomNo));
    }

    public void getSide(String direction){
        direction = direction.toLowerCase();
        System.out.println(direction + " direction");
    }

    public void setSide(String direction, MapSite mapsite){
        direction = direction.toLowerCase();
        if(mapsite instanceof Door){
            System.out.print("Door ");
        }else if (mapsite instanceof Wall){
            System.out.print("Wall ");
        }
        System.out.println("is being built on the " + direction + " side");
    }

}

class Wall extends MapSite{
    public void Enter(){
        System.out.println("Walked into a wall and hurt your nose");
    }
}

class Door extends MapSite {
    Room room1;
    Room room2;
    boolean isOpen;
    Door(Room r1, Room r2){
        this.room1 = r1;
        this.room2 = r2;
        this.isOpen = false;
    }
    public void Enter(){
        if (isOpen){
            System.out.println("Opened the door");
        }else{
            System.out.println("Door is locked");
        }
    }
}

class Maze{
    ArrayList<Room> rooms;
    Maze(){
        rooms = new ArrayList<Room>();
    }

    public void addRoom(Room room){
        System.out.println("Room "+ Integer.toString(room.roomNo) + " constructing");
        rooms.add(room);
    }

    public Room RoomNo(int r){
        for(Room currentRoom : rooms){
            if (currentRoom.roomNo == r){
                return currentRoom;
            }
        }
        return null;

    }
}




class EnchantedDoor extends Door {
    Room room1;
    Room room2;
    boolean haveSpell;
    EnchantedDoor(Room r1, Room r2){
        super(r1, r2);
        this.room1 = r1;
        this.room2 = r2;
        this.haveSpell = false;
    }
    public void Enter(){
        if (haveSpell){
            System.out.println("Opened the door");
        }else{
            System.out.println("Need the spell to open the door");
        }
    }
}

//-----------------------------------------------------
class EnchantedRoom extends Room{
    int roomNum;
    EnchantedRoom(int roomNum){
        super(roomNum);
        this.roomNum = roomNum;
    }

    public void Enter(){
        System.out.println("Entering enchanted room "+ Integer.toString(roomNum));
    }

    public void setSide(String direction, MapSite mapsite){
        direction = direction.toLowerCase();
        if(mapsite instanceof Door){
            System.out.print("Enchanted Door ");
        }else if (mapsite instanceof Wall){
            System.out.print("Wall ");
        }
        System.out.println("is being built on the " + direction + " side");
    }
}

//-----------------------------------------------------

class BombedWall extends Wall{
    public void Enter(){
        System.out.println("Walked into a bombed wall and hurt your nose");
    }
}
//-----------------------------------------------------
class RoomWithABomb extends Room{
    int roomNum;
    RoomWithABomb(int roomNum){
        super(roomNum);
        this.roomNum = roomNum;
    }

    public void Enter(){
        System.out.println("Entering Bombed room "+ Integer.toString(roomNum));
    }

    public void setSide(String direction, MapSite mapsite){
        direction = direction.toLowerCase();
        if(mapsite instanceof Door){
            System.out.print("Door ");
        }else if (mapsite instanceof BombedWall){
            System.out.print("Bombed Wall ");
        }
        System.out.println("is being built on the " + direction + " side");
    }
}
