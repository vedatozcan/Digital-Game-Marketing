import java.util.HashMap;

public interface ISocial {

    public void addFriend(User active_user, User target_user) throws QueueEmpty;
    public void displayFriend(String username);
    public void sendRequest(User active_user, User target_user);
    public HashMap<String, User> getUserMap() ;
	void removeFriend(User active_user, User target_user);
}
