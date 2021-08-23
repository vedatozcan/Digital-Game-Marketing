public class Admin extends Person{

    private String user_name;
    private String password;


    public Admin(String user_name, String password)
    {
        super(password);
        this.user_name = user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

  
}
