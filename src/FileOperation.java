import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class FileOperation {


    public void readMarket(Market market) throws IOException {

        try {
            File file = new File("games.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext()) {
                String[] line = (scn.nextLine()).split(";");
                String[] date_temp = line[8].split("/");
                Date date = new Date(Integer.valueOf(date_temp[0]), Integer.valueOf(date_temp[1]), Integer.valueOf(date_temp[2]));
                Game game = new Game(line[0], line[1], line[2], Integer.valueOf(line[3]), Integer.valueOf(line[4]),
                        Integer.valueOf(line[5]), Double.valueOf(line[6]), Double.valueOf(line[7]), date);

                market.addGame(game);
            }
            scn.close();
        } catch (FileNotFoundException e) {
            FileWriter file = new FileWriter("games.csv");
            file.write("NAME;DESCRIPTION;GENRE;PURCHASE_COUNT;STOCK;AGE_LIMIT;PRICE;RATING;RELEASE_DATE\n");
            file.close();
        }
    }

    public void readUser(HashMap<String, User> userMap) throws IOException {
        try {
            File file = new File("users.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext()) {
                String[] line = (scn.nextLine()).split(";");
                String[] add_temp = line[6].split("/");
                String[] phone_temp = line[7].split("/");
                String[] temp_date = line[8].split("/");
                Address address = new Address(add_temp[0], add_temp[1], add_temp[2], add_temp[3]);
                Phone phone = new Phone(phone_temp[0], phone_temp[1], phone_temp[2], phone_temp[3]);
                Date date = new Date(Integer.valueOf(temp_date[0]), Integer.valueOf(temp_date[1]), Integer.valueOf(temp_date[2]));
                User user = new User(line[0], line[1], line[2], line[3], line[4], line[5], address, phone, date);
                userMap.put(line[0], user);
            }
            scn.close();
        } catch (FileNotFoundException e) {
            FileWriter file = new FileWriter("users.csv");
            file.write("USERNAME;NAME;LASTNAME;NICKNAME;PASSWORD;EMAIL;ADDRESS;PHONE;BIRTHDATE\n");
            file.close();
        }

    }

    public void readLibrary(HashMap<String, User> userMap, Market market) throws IOException, CloneNotSupportedException {
        try {
            File file = new File("library.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext()) {
                String[] line = (scn.nextLine()).split(";");
                for (Game game : market.getGames()) {
                    if (game.getName().equals(line[1])) {
                        User user = userMap.get(line[0]);
                        Game cloned_game = (Game) game.clone();
                        cloned_game.setStatus(line[2]);
                        String[] formatted_date = line[3].split("/");
                        Date rent_date = new Date(Integer.valueOf(formatted_date[0]),Integer.valueOf(formatted_date[1]),
                                Integer.valueOf(formatted_date[2]));
                        cloned_game.setRent_date(rent_date);
                        cloned_game.setRental_period(Integer.valueOf(line[4]));
                        user.getLibrary().addGame(cloned_game);
                    }
                }
            }

            scn.close();
        } catch (FileNotFoundException e) {
            FileWriter file = new FileWriter("library.csv");
            file.write("USER_NAME;GAME;STATUS;RENT_DATE;RENTAL_PERIOD\n");
            file.close();
        }
    }

    public void readSocial(HashMap<String, User> userMap) throws IOException {
        try {
            File file = new File("social.csv");
            Scanner scn = new Scanner(file);
            scn.nextLine();
            while (scn.hasNext()) {
            	String temp = scn.nextLine().replaceAll("\\p{C}","");
                String[] line = temp.trim().split(";", -1);
                if (line[1] != "" && line[2] != null) {
                    String[] friend_list = line[1].split(",");
                    for (String user : friend_list) {
                    	if(userMap.get(user) != null)
                        userMap.get(line[0]).getFriendlist().add(userMap.get(user));
                    }
                }
                if (line[2] != "" && line[2] != null) {
                    String[] requests = line[2].split(",");
                    for (String user : requests) {
                    	if(userMap.get(user) != null)
                        userMap.get(line[0]).getPendingRequest().enqueue(userMap.get(user));
                    }
                }
            }
            scn.close();
        } catch (FileNotFoundException e) {
            FileWriter file = new FileWriter("social.csv");
            file.write("USER_NAME;FRIENDS;PENDING_REQUESTS\n");
            file.close();
        }
    }

    public void appendGame(Game game) throws IOException {
        FileWriter file_writer = new FileWriter("games.csv");
        String date_str = game.getRelease_date().getDay() + "/" + game.getRelease_date().getMonth() + "/" +
                game.getRelease_date().getYear();
        file_writer.write(game.getName() + ";" + game.getDescription() + ";" + game.getGenre() + ";" + game.getPurchase_count() +
                ";" + game.getStock() + ";" + game.getAge_limit() + ";" + game.getPrice() + ";" + game.getRating() + ";" + date_str + "\n");

        file_writer.close();
    }

    public void updateLibrary (HashMap<String, User> userMap) throws IOException { // update game for library file

        FileWriter file_writer = new FileWriter("library.csv", false);
        file_writer.write("USER_NAME;GAME;STATUS;RENT_DATE\n");
        for (HashMap.Entry<String, User> entry : userMap.entrySet()) {
            for (Game games : entry.getValue().getLibrary().getgames()){
                String date_str = games.getRent_date().getDay() + "/" + games.getRent_date().getMonth() + "/" +
                        games.getRent_date().getYear();
                file_writer.write(entry.getKey() + ";" + games.getName() + ";" + games.getStatus()
                        + ";" + date_str + ";" + games.getRental_period() + "\n");
            }
        }
        file_writer.close();
    }

    public void updateMarket(Market market) throws IOException {


        FileWriter file_writer = new FileWriter("games.csv", false);
        file_writer.write("NAME;DESCRIPTION;GENRE;PURCHASE_COUNT;STOCK;AGE_LIMIT;PRICE;RATING;RELEASE_DATE\n");
        for (Game game : market.getGames()) {
            String date_str = game.getRelease_date().getDay() + "/" + game.getRelease_date().getMonth() + "/" +
                    game.getRelease_date().getYear();
            file_writer.write(game.getName() + ";" + game.getDescription() + ";" + game.getGenre() + ";" + game.getPurchase_count() +
                    ";" + game.getStock() + ";" + game.getAge_limit() + ";" + game.getPrice() + ";" + game.getRating() + ";" + date_str + "\n");
        }
        file_writer.close();
    }

    public void updateUser(HashMap<String, User> userMap) throws IOException {

        FileWriter file_writer = new FileWriter("users.csv");
        file_writer.write("USERNAME;NAME;LASTNAME;NICKNAME;PASSWORD;EMAIL;ADDRESS;PHONE;BIRTHDATE\n");
        for (HashMap.Entry<String, User> entry : userMap.entrySet()) {
            User user = entry.getValue();
            String address = user.getAddress().getStreetname() + "/" + user.getAddress().getTown() + "/" + user.getAddress().getCity() + "/" + user.getAddress().getCountry();
            String phone = user.getPhone().getCountrycode() + "/" + user.getPhone().getCode() + "/" + user.getPhone().getNumber() + "/" + user.getPhone().getType();
            String birth_date = user.getBirthdate().getDay() + "/" + user.getBirthdate().getMonth() + "/" + user.getBirthdate().getYear();
            file_writer.write(user.getUser_name() + ";" + user.getName() + ";" + user.getLastname() + ";" + user.getNickname() + ";" + user.getPassword()
                    + ";" + user.getEmail() + ";" + address + ";" + phone + ";" + birth_date + "\n");
        }
        
        file_writer.close();
    }

    public void updateSocial(HashMap<String, User> userMap) throws IOException, QueueEmpty {

        FileWriter file = new FileWriter("social.csv");
        file.write("USER_NAME;FRIENDS;PENDING_REQUESTS\n");
        for (HashMap.Entry<String, User> entry : userMap.entrySet()) {
            String line = entry.getKey() + ";";
            int size = entry.getValue().getFriendlist().size();
            for (int i = 0; i < size - 1; i++)
                line += entry.getValue().getFriendlist().get(i).getUser_name() + ",";
            if(size > 0)
            	{
            		line += entry.getValue().getFriendlist().get(size - 1).getUser_name();
            	}
             line += ";";

            size = entry.getValue().getPendingRequest().size();
            for (int i = 0; i < size - 1; i++) {
                line += entry.getValue().getPendingRequest().peek().getUser_name() + ",";
                
                entry.getValue().getPendingRequest().enqueue(entry.getValue().getPendingRequest().dequeue());
            }
            if(entry.getValue().getPendingRequest().size() > 0)
            {
            	if(entry.getValue().getPendingRequest().peek() != null)
            	{
            		line += entry.getValue().getPendingRequest().peek().getUser_name();
            		entry.getValue().getPendingRequest().enqueue(entry.getValue().getPendingRequest().dequeue());
            	}
            	
            }
           
            
            file.write(line + "\n");
        }
        file.close();
    }

}
