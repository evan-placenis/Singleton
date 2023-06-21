import java.lang.System;

public class MazeFactory {
    public Maze MakeMaze(){
        return new Maze();
    }
    public Wall MakeWall(){
        return new Wall();
    }
    public Room MakeRoom(int n){
        return new Room(n);
    }
    public Door MakeDoor(Room r1, Room r2){
        return new Door(r1, r2);
    }
    private static MazeFactory instance = null;
    public MazeFactory Instance(){
        if (instance == null){
            String mazeStyle = System.getProperty("MAZESTYLE");
            //subclasses
            if(mazeStyle.compareTo("bombed") == 0){
                instance = new BombedMazeFactory();
            }else if (mazeStyle.compareTo("enchanted") == 0){
                instance = new EnchantedMazeFactory();
            }

        }
        return instance;
    }
}

class BombedMazeFactory extends MazeFactory{
    public Wall MakeWall(){
        return new BombedWall();
    }

    public Room MakeRoom(int n){
        return new RoomWithABomb(n);
    }
}

class EnchantedMazeFactory extends MazeFactory{

   public Room MakeRoom(int n){
        return new EnchantedRoom(n);
   }
   public Door MakeDoor(Room r1, Room r2){
        return new EnchantedDoor(r1, r2);
   }

   protected void CastSpell(){
        System.out.println("Spell has been casted in the maze");
   }
}
