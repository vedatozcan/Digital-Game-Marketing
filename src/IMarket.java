import java.util.List;

public interface IMarket {
    String displayMarket();
    String displayMarket(String genre);
    void sortMarketPrice();
    void sortMarketRating();
    void sortMarketPurchaseCount();
    List<Game> searchGame(String name);
    void addGame(Game game);
}