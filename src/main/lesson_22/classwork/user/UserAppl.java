package main.lesson_22.classwork.user;

import main.lesson_22.classwork.user.model.User;

public class UserAppl {
    public static void main(String[] args) {
        User user = new User("peter@gmail.com", "ax4tDA!0");
        System.out.println(user);
//        user.setEmail("peter@gmail.com");
//        System.out.println(user);
    }
}
