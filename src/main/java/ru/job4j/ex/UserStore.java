package ru.job4j.ex;

import java.sql.SQLOutput;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User temp : users) {
            if (temp.getUserName().equals(login)) {
                return temp;
            }
        }
        throw new UserNotFoundException("User is not found");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUserName().length() < 3) {
            throw new UserInvalidException("User is not valid");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException e) {
            System.out.println("User not valid");
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
        }
    }
}
