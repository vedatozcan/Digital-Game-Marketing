import java.util.*;
public class Market implements IMarket{
    private List<Game> games;

    public Market() {

        this.games = new ArrayList<Game>();
    }

    @Override
    public String displayMarket() {
        String strlist = "";
        for (Game i:games){
            strlist += i.getName() + " ";
        }

        return strlist;
    }

    @Override
    public String displayMarket(String genre) {
        String strlist = "";
        for (Game i:games){
            if (i.getGenre().equals(genre)) {
                strlist += i.getName() + " " + i.getPrice() + "TL" + "\n";
            }
        }

        return strlist;
    }

    @Override
    public void sortMarketPrice() {
        games.sort(Comparator.comparing(Game::getPrice));
    }

    @Override
    public void sortMarketRating() {
    	
    	int size = games.size();

        for (int i = size / 2 - 1; i >= 0; i--)
        	heapifyRating(games, size, i);

        for (int i=size-1; i>=0; i--) {
        	Collections.swap(games, i, 0);
        	heapifyRating(games, i, 0);
        }
    }

    @Override
    public void sortMarketPurchaseCount() {
    	int size = games.size();

        for (int i = size / 2 - 1; i >= 0; i--)
        	heapifyTopSell(games, size, i);

        for (int i=size-1; i>=0; i--) {
        	Collections.swap(games, i, 0);
        	heapifyTopSell(games, i, 0);
        }
    }

    @Override
    public List<Game> searchGame(String name) {
        List<Game> search_res = new ArrayList<Game>();
        for(Game i : this.games) {
            if (i.getName().toLowerCase().contains(name.toLowerCase())) {
                search_res.add(i);
            }
        }

        return search_res;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public void addGame(Game game){
        games.add(game);
    }
  
    
     private void heapifyTopSell(List<Game> games, int heapSize, int i) 
        {
            int largest = i; 
            int leftChildIdx  = 2*i + 1; 
            int rightChildIdx  = 2*i + 2;

            if (leftChildIdx  < heapSize && games.get(leftChildIdx).getPurchase_count() < games.get(largest).getPurchase_count())
                largest = leftChildIdx ;

            if (rightChildIdx  < heapSize && games.get(rightChildIdx).getPurchase_count() < games.get(largest).getPurchase_count())
                largest = rightChildIdx ;

            if (largest != i) {
            	Collections.swap(games, i, largest);
            	heapifyTopSell(games, heapSize, largest);
            }
        }
     private void heapifyRating(List<Game> games, int heapSize, int i) 
     {
         int largest = i; 
         int leftChildIdx  = 2*i + 1; 
         int rightChildIdx  = 2*i + 2;

         if (leftChildIdx  < heapSize && games.get(leftChildIdx).getRating() < games.get(largest).getRating())
             largest = leftChildIdx ;

         if (rightChildIdx  < heapSize && games.get(rightChildIdx).getRating() < games.get(largest).getRating())
             largest = rightChildIdx ;

         if (largest != i) {
         	Collections.swap(games, i, largest);
         	heapifyRating(games, heapSize, largest);
         }
     }
    
}