package practice08;

import practice08.model.Auto;
import practice08.model.User;
import practice08.services.UserService;
import practice08.services.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static final String BLUE = "\u001B[34m";
    public static final String RESET = "\u001B[0m";

    public static void main(String[] args) throws SQLException {
        UserService userService = new UserServiceImpl();
        User userA = new User("Bethany McMillan", 48);
        userService.saveUser(userA);
        Auto[] autos = new Auto[] {
                new Auto("Bronco", "Blue"),
                new Auto("Cadillac", "Black"),
                new Auto("Bike", "White")};
        for (Auto auto : autos) {
            auto.setUser(userA);
            userA.addAuto(auto);
        }
        userService.updateUser(userA);

        System.out.print(BLUE + "Last created user's ID is: " + RESET);
        System.out.println(userService.findUser(userA.getId()).getId());
        System.out.print(BLUE + "User's Data: " + RESET);
        System.out.println(userService.findUser(userA.getId()));
        System.out.println(BLUE + "List of the last User's Autos:" + RESET);
        List<Auto> findAutos = userService.findUser(userA.getId()).getAutos();
        for (Auto auto : findAutos) {
            System.out.println(auto);
        }
    }
}
