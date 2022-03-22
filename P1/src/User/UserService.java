package User;

import Train.Train;
import TrainServices.TrainService;

import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users = new ArrayList<>();

    private static UserService instance;

    public static UserService getInstance(){
        if(instance == null){
            instance = new UserService();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> usersCopy = new ArrayList<>();
        usersCopy.addAll(this.users);
        return usersCopy;
    }

    public User getUserById(int index){
        User user = new User();
        for(int i = 0; i < this.users.size(); ++i){
            if(this.users.get(i).getId() == index){
                user = this.users.get(i);
            }
        }
        return user;
    }

    public void updateUser(int index, User user){
        for(int i = 0; i < this.users.size(); ++i){
            if(this.users.get(i).getId() == index){
                this.users.remove(i);
                this.users.add(index, user);
                break;
            }
        }
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void deteleUser(int index){
        for(int i = 0; i < this.users.size(); ++i){
            if(this.users.get(i).getId() == index) {
                this.users.remove(i);
                break;
            }
        }
    }
}
