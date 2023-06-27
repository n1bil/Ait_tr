package main.lesson_24.classwork.user.model;

import java.util.Objects;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        setPassword(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println(email + " isn't valid");
        }
    }

    /*
    1) @ - exists and only one (done)
    2) dot must be after @
    3) after last dot must be min 2 symbols
    4) alphabetic, digits, _ , - , . , @
     */
    private boolean validateEmail(String email) {
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) {
            return false;
        }
        if (email.indexOf('.', indexAt) == -1) {
            return false;
        }
        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '_' || c == '-' || c == '.' || c == '@')) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.out.println(password + " isn't valid");
        }
    }

    /*
    1) min 8 symbols
    2) min one symbols of uppercase
    3) min one symbols of lowercase
    4) min one digit
    5) min one special symbol (!, %, @, *, &)
     */
    private boolean validatePassword(String password) {
        // TODO
        boolean[] check = new boolean[5];
        if (password.length() >= 8) {
            check[0] = true;
            for (int i = 0; i < password.length(); i++) {
                char symbol = password.charAt(i);
                if (symbol >= 'a' && symbol <= 'z') {
                    check[1] = true;
                }
                if (symbol >= 'A' && symbol <= 'Z') {
                    check[2] = true;
                }
                if (symbol >= 48 && symbol <= 57) {
                    check[3] = true;
                }
//                if (symbol == '!' || symbol == '%' || symbol == '@' || symbol == '*' || symbol == '&') {
//                    check[4] = true;
//                }
                if ("!%@*&".indexOf(symbol) >= 0) { // задать вопрос
                    check[4] = true;
                }
            }
        }
        return check[0] && check[1] && check[2] && check[3] && check[4];
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
