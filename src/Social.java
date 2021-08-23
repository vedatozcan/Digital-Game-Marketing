import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Social implements ISocial {

    private HashMap<String, User> userMap;

    public Social() {
        this.userMap = new HashMap<String, User>();
    }

    @Override
    public void addFriend(User active_user, User target_user) throws QueueEmpty {

        if (target_user == null) {
            System.out.println("There is no user named " + target_user.getNickname());
        }
        else {

            if (active_user.getFriendlist().contains(target_user))
                System.out.println("User is already your friend");
            else
                {
            		active_user.getFriendlist().add(target_user);
            		target_user.getFriendlist().add(active_user);
            		removePendingRequest(active_user, target_user);
                }
        }
       
    }

    @Override
    public void removeFriend(User active_user, User target_user) {

        if (target_user == null) {
            System.out.println("There is no user named " + target_user.getNickname());
        } else {

            if (!(active_user.getFriendlist().contains(target_user)))
                System.out.println("User is not your friend");
            else {
                active_user.getFriendlist().remove(target_user);
                target_user.getFriendlist().remove(active_user);
            }

        }

    }

    @Override
    public void displayFriend(String username) {

        User active_user = userMap.get(username);
        for (User friends : active_user.getFriendlist())
            System.out.println(friends.getUser_name());
    }

    @Override
    public void sendRequest(User active_user, User target_user) {

        
        if (target_user == null)
            System.out.println("There is no user named " + target_user.getNickname());
        else {
            
            if (active_user.getFriendlist().contains(target_user))
                System.out.println("User is already your friend");
            else if (active_user.getPendingRequest().contains(target_user))
                System.out.println("User is already your friend");
            else {
                target_user.getPendingRequest().enqueue(active_user);
            }
        }


    }
    
    public User searchUser(String nickName) 
    {   
    	User user = null;
    	for (HashMap.Entry<String, User> entry : userMap.entrySet())
    	{
    		if(entry.getValue().getNickname().equalsIgnoreCase(nickName))
    		{
    			user = entry.getValue();
    		}
    	}
    	return user;
	}

    public HashMap<String, User> getUserMap() {
        return userMap;
    }
    public void removePendingRequest(User user, User targetUser) throws QueueEmpty
    {
    	int size = user.getPendingRequest().size();
    	for(int i = 0; i < size; i++)
    	{
    		User tempUser = user.getPendingRequest().peek();
    		if(targetUser == tempUser)
    		{
    			user.getPendingRequest().dequeue();
    		}
    		else {
				user.getPendingRequest().enqueue(user.getPendingRequest().dequeue());
			}
    	}
    }
    public List<User> displayAllUsers() {
    	ArrayList<User> tempList = new ArrayList<User>();
    	for (HashMap.Entry<String, User> entry : userMap.entrySet())
    	{
    		tempList.add(entry.getValue());
    	}
    	
    	return tempList;
	}

	
}
