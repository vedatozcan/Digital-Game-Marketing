import java.util.ArrayList;
import java.util.List;

public class User extends Person{
    private static int ID;
    private String user_name;
    private String nickname;
    private Library library;
    private List<User> friendlist;
    private DynamicQueue pending_request;

    public User(String user_name, String name, String lastname, String nickname, String password, String email, Address address,
               Phone phone, Date date) {
        super(name, lastname, email, password, address, phone, date);
        this.user_name = user_name;
        this.nickname = nickname;
        this.library = new Library();
        this.friendlist = new ArrayList<User>();
        this.pending_request = new DynamicQueue();
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        User.ID = ID;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public DynamicQueue getPendingRequest() {
        return pending_request;
    }

  
    public List<User> getFriendlist() {
        return friendlist;
    }



}