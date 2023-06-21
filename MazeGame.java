
class MazeGame{
    public static Maze CreateMaze(MazeFactory factory){
        Maze aMaze = factory.MakeMaze();
        Room r1 = factory.MakeRoom(1);
        Room r2 = factory.MakeRoom(2);
        Door aDoor = factory.MakeDoor(r1, r2);

        aMaze.addRoom(r1);
        

        r1.setSide("NORTH", factory.MakeWall());
        r1.setSide("EAST", aDoor);
        r1.setSide("South", factory.MakeWall());
        r1.setSide("West", factory.MakeWall());
        r1.Enter();
        aDoor.Enter();
        System.out.println("----------------------------------------");
        aMaze.addRoom(r2);
        r2.setSide("NORTH", factory.MakeWall());
        r2.setSide("EAST", factory.MakeWall());
        r2.setSide("South", factory.MakeWall());
        r2.setSide("West", aDoor);
        r2.Enter();
        aDoor.Enter();
        return aMaze;
    }
    public static void main(String[] args){
        //Setting environment Variables
        String mazeStyle = "MAZESTYLE";
        String bombed = "bombed";
        //String enchanted = "enchanted";

        // Set the value of the environment variable
        System.setProperty(mazeStyle, bombed);
        //System.setProperty(mazeStyle, enchanted);

        // Print the updated value
        //String updatedValue = System.getProperty(variableName);
        //System.out.println("Updated value of " + variableName + ": " + updatedValue);
        //------------------------------------------------------

        MazeFactory factory = new MazeFactory();
        MazeFactory factoryStyle = factory.Instance();

        CreateMaze(factoryStyle);
        CreateMaze(factoryStyle);
    }
}

