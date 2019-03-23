package lab8.doc;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class UnitTests
{

    @SuppressWarnings("deprecation")
    @Test
    public void testColorGetters()
    {
        Assert.assertEquals("Color getR method returns incorrect value",  255, Color.RED.getR());
        Assert.assertEquals("Color getG method returns incorrect value",  0, Color.RED.getG());
        Assert.assertEquals("Color getB method returns incorrect value",  0, Color.RED.getB());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testGamePieceGetters()
    {
        Assert.assertEquals("GamePiece getColor method returns incorrect value",  Color.BLUE, GamePiece.BLUE_RACER.getColor());
        Assert.assertEquals("GamePiece getShape method returns incorrect value",  Shape.RACECAR, GamePiece.BLUE_RACER.getShape());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testGamePieceMoveFirst()
    {
        Assert.assertEquals("GamePiece movesFirst method returns incorrect value",  GamePiece.BLUE_BOOT, GamePiece.movesFirst(GamePiece.RED_THIMBLE, GamePiece.BLUE_BOOT));
        Assert.assertEquals("GamePiece movesFirst method returns incorrect value",  GamePiece.BLUE_BOOT, GamePiece.movesFirst(GamePiece.BLUE_BOOT, GamePiece.RED_THIMBLE));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testGamePieceToString()
    {
        Assert.assertEquals("GamePiece toString method returns incorrect value",  "YELLOW_BOOT: a YELLOW BOOT with priority 7", GamePiece.YELLOW_BOOT.toString());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testGamePieceAppearanceGetters()
    {
        GamePieceAppearance test = new GamePieceAppearance(Color.MAGENTA, Shape.THIMBLE);
        Assert.assertEquals("GamePieceAppearance getColor method returns incorrect value",  Color.MAGENTA, test.getColor());
        Assert.assertEquals("GamePieceAppearance getColor method returns incorrect value",  Shape.THIMBLE, test.getShape());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testShapeToString()
    {
        Assert.assertEquals("Shape toString method returns incorrect value",  "BOOT", Shape.BOOT.toString());
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testBoardGameConstructorAndAddPlayer()
    {
        BoardGame bg = new BoardGame();
        Assert.assertEquals("BoardGame addPlayer method returns incorrect value",  true, bg.addPlayer("joe", GamePiece.MAGENTA_RACER, Location.BALLROOM));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testBoardGameGetters()
    {
        BoardGame bg = new BoardGame();
        bg.addPlayer("joe", GamePiece.MAGENTA_RACER, Location.BALLROOM);
        bg.addPlayer("bill", GamePiece.BLUE_RACER, Location.STUDY);
        Assert.assertEquals("BoardGame getPlayerGamePiece method returns incorrect value",  GamePiece.BLUE_RACER, bg.getPlayerGamePiece("bill"));
        Assert.assertEquals("BoardGame getPlayerWithGamePiece method returns incorrect value",  "joe", bg.getPlayerWithGamePiece(GamePiece.MAGENTA_RACER));
        Assert.assertEquals("BoardGame getPlayerLocation method returns incorrect value",  Location.BALLROOM, bg.getPlayerLocation("joe"));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testBoardGameMove()
    {
        BoardGame bg = new BoardGame();
        bg.addPlayer("joe", GamePiece.BLUE_BOOT, Location.CONSERVATORY);
        bg.addPlayer("bill", GamePiece.RED_RACER, Location.DINING_ROOM);
        bg.addPlayer("bob", GamePiece.YELLOW_BOOT, Location.HALL);
        bg.movePlayer("bill", Location.BILLIARD_ROOM);
        
        String[] test = new String[2];
        test[0] = "bob";
        test[1] = "joe";
        String[] test1 = new String[2];
        test1[0] = "joe";
        test1[1] = "bob";
        Location[] loc = new Location[2];
        loc[0] = Location.HALL;
        loc[1] = Location.KITCHEN;
        
        Assert.assertEquals("BoardGame movePlayer method returns incorrect value",  Location.BILLIARD_ROOM, bg.getPlayerLocation("bill"));
        Assert.assertEquals("BoardGame moveTwoPlayers method returns incorrect value",  test1[0], bg.moveTwoPlayers(test, loc)[0]);
        Assert.assertEquals("BoardGame moveTwoPlayers method returns incorrect value",  test1[1], bg.moveTwoPlayers(test, loc)[1]);
        Assert.assertEquals("BoardGame moveTwoPlayers method returns incorrect value",  test1[1], bg.moveTwoPlayers(test1, loc)[1]);
        Assert.assertEquals("BoardGame moveTwoPlayers method returns incorrect value",  test1[0], bg.moveTwoPlayers(test1, loc)[0]);
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testBoardGameGetThingsAtLocation()
    {
        BoardGame bg = new BoardGame();
        bg.addPlayer("alice", GamePiece.GREEN_BOOT, Location.KITCHEN);
        bg.addPlayer("bo", GamePiece.BLUE_BOOT, Location.LIBRARY);
        bg.addPlayer("carol", GamePiece.RED_THIMBLE, Location.LIBRARY);
        bg.addPlayer("dan", GamePiece.YELLOW_BOOT, Location.LIBRARY);
        
        ArrayList<String> a = new ArrayList<>();
        a.add("bo");
        a.add("carol");
        a.add("dan");
        
        ArrayList<GamePiece> b = new ArrayList<>();
        b.add(GamePiece.BLUE_BOOT);
        b.add(GamePiece.RED_THIMBLE);
        b.add(GamePiece.YELLOW_BOOT);
        
        Assert.assertEquals("BoardGame getPlayerNamesAtLocation method returns incorrect value", a, bg.getPlayersAtLocation(Location.LIBRARY));
        Assert.assertEquals("BoardGame getGamePiecesAtLocation method returns incorrect value", b, bg.getGamePiecesAtLocation(Location.LIBRARY));
    }
    
    @SuppressWarnings("deprecation")
    @Test
    public void testBoardGameSets()
    {
        BoardGame bg = new BoardGame();
        bg.addPlayer("ewing", GamePiece.RED_RACER, Location.DINING_ROOM);
        bg.addPlayer("errol", GamePiece.RED_THIMBLE, Location.LIBRARY);
        bg.addPlayer("big boi", GamePiece.MAGENTA_RACER, Location.LOUNGE);
        bg.addPlayer("bubbles", GamePiece.BLUE_RACER, Location.LIBRARY);
        
        Set<String> a = new HashSet<>();
        a.add("ewing");
        a.add("errol");
        a.add("big boi");
        a.add("bubbles");
        
        Set<Location> b = new HashSet<>();
        b.add(Location.DINING_ROOM);
        b.add(Location.LIBRARY);
        b.add(Location.LOUNGE);
        
        Set<GamePiece> c = new HashSet<>();
        c.add(GamePiece.RED_RACER);
        c.add(GamePiece.RED_THIMBLE);
        c.add(GamePiece.MAGENTA_RACER);
        c.add(GamePiece.BLUE_RACER);
        
        Assert.assertEquals("BoardGame getPlayers method returns incorrect value", a, bg.getPlayers());
        Assert.assertEquals("BoardGame getPlayerLocations method returns incorrect value", b, bg.getPlayerLocations());
        Assert.assertEquals("BoardGame getPlayerPieces method returns incorrect value", c, bg.getPlayerPieces());
    }
}
