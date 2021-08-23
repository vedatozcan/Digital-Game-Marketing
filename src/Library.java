import java.util.ArrayList;
import java.util.List;


public class Library {
    private List<Game> games;
    
    
    public Library() {
        this.games = new ArrayList<Game>();
    }

    public List<Game> getgames() {
        return games;
    }

    public String displayLibrary(){
        String output = "";
        for (Game i : games) {
            output += i.getName() + i.getStatus() +"\n" ;
        }

        return output;
    }

    public String displayLibrary(String genre) {
        String output = "";
        for (Game i : games) {
            if (i.getGenre().equals(genre)) {
                output += i.getName() + i.getStatus() +"\n";
            }
        }
        return output;
    }

    public void addGame(Game game) {

      games.add(game);
         
    }

    public void removeGame(Game game) {
        if(games.contains(game))
            games.remove(game);

    }
    public List<Game> rentGame() {
    	
    	List<Game> list = new ArrayList<Game>();
		for(Game game : games)
		{
			if(game.getStatus().equals("rent"))
				list.add(game);
		}
    	
    	
    	return list;
	}
    public List<Game> purchasedGame() {
    	
    	List<Game> list = new ArrayList<Game>();
		for(Game game : games)
		{
			if(game.getStatus().equals("purchased"))
				list.add(game);
		}
    	return list;
	}
    
    public Game getGame(String game_name)
    {   Game tempGame = null;
    	
    	for(Game game : games)
    	{
    		if(game.getName().equals(game_name))
    			tempGame = game;
    	}
   
    	return tempGame;
    			
    }
  
}