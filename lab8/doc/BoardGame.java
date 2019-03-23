package lab8.doc;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BoardGame
{
    protected LinkedHashMap<String, GamePiece> playerPieces;
    protected LinkedHashMap<String, Location> playerLocations;
    
    public BoardGame()
    {
        playerPieces = new LinkedHashMap<>();
        playerLocations = new LinkedHashMap<>();
    }
    
    //not sure why this returns a boolean
    public boolean addPlayer(String playerName, GamePiece piece, Location initialLocation)
    {
        playerPieces.put(playerName, piece);
        playerLocations.put(playerName, initialLocation);
        return true;
    }
    
    public GamePiece getPlayerGamePiece(String playerName)
    {
        return playerPieces.get(playerName);
    }
    
    public String getPlayerWithGamePiece(GamePiece gamePiece)
    {
        for(Map.Entry<String, GamePiece> entry: playerPieces.entrySet())
        {
            if (gamePiece.equals(entry.getValue()))
            {
                return entry.getKey();
            }
        }
        return null;
    }
    
    public void movePlayer(String playerName, Location newLocation)
    {
        playerLocations.replace(playerName, newLocation);
    }
    
    public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations)
    {
        GamePiece a = playerPieces.get(playerNames[0]);
        GamePiece b = playerPieces.get(playerNames[1]);
        
        //sorts game pieces
        GamePiece moveFirst = GamePiece.movesFirst(a, b);
        
        //puts the first player at the beginning of the array
        String[] orderedMove = new String[2];
        orderedMove[0] = getPlayerWithGamePiece(moveFirst);
        
        //adds the second player
        if(a.equals(moveFirst))
        {
            orderedMove[1] = getPlayerWithGamePiece(b);
        }else
        {
            orderedMove[1] = getPlayerWithGamePiece(a);
        }
        
        return orderedMove;
    }
    
    public Location getPlayerLocation(String player)
    {
        return playerLocations.get(player);
    }
    
    public ArrayList<String> getPlayersAtLocation(Location loc)
    { 
        ArrayList<String> toReturn = new ArrayList<>();
        
        //iterates through the hashmap
        for(Map.Entry<String, Location> entry: playerLocations.entrySet())
        {
            //if the location equals the proper location, add the entry key to the arraylist
            if (loc.equals(entry.getValue()))
            {
                toReturn.add(entry.getKey());
            }
        }
        
        return toReturn;
    }
    
    public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc)
    {
        ArrayList<String> listOfPlayers = getPlayersAtLocation(loc);
        ArrayList<GamePiece> listOfGamePieces = new ArrayList<>();
        
        //searches through the game pieces to add the ones that correspond to the proper player at the certain location
        for(String playerName: listOfPlayers)
        {
            listOfGamePieces.add(getPlayerGamePiece(playerName));
        }
        
        return listOfGamePieces;
    }
    
    public Set<String> getPlayers()
    {
        return playerPieces.keySet();
    }
    
    public Set<Location> getPlayerLocations()
    {
        HashSet<Location> toReturn = new HashSet<>();
        
        //iterates through the hashmap
        for(Map.Entry<String, Location> entry: playerLocations.entrySet())
        {
            toReturn.add(entry.getValue());
        }
        
        return toReturn;
    }
    
    public Set<GamePiece> getPlayerPieces()
    {
        HashSet<GamePiece> toReturn = new HashSet<>();
        
        //iterates through the hashmap
        for(Map.Entry<String, GamePiece> entry: playerPieces.entrySet())
        {
            toReturn.add(entry.getValue());
        }
        
        return toReturn;
    }
}