package main.lesson_24.classwork.user.test;

import main.lesson_24.classwork.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    final String email = "nabil@gmail.com";
    final String password = "ax4tDA!0";

    @BeforeEach
    void setUp() {
        user = new User(email, password);
    }

    @Test
    void testValidPassword() {
        String validPassword = "qwertY1@";
        user.setPassword(validPassword);
        assertEquals(validPassword, user.getPassword());
    }

    @Test
    void testPasswordLength() {
        String invalidPassword = "wertY1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordUpperCase() {
        String invalidPassword = "qwerty1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordLowerCase() {
        String invalidPassword = "QWERTY1@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordDigits() {
        String invalidPassword = "QweRTY!@";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testPasswordSpecialSymbols() {
        String invalidPassword = "QweRTY12";
        user.setPassword(invalidPassword);
        assertEquals(password, user.getPassword());
    }

    @Test
    void testValidEmail() {
        String validEmail = "Nabil@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testEmailValidAtSymbol() {
        String invalidEmail = "nabilgmail.com";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());

        invalidEmail = "nabil@@gmail.com";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());
    }

    @Test
    void testEmailValidDotSymbol() {
        String invalidEmail = "nabil@gmailcom";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());

        invalidEmail = "nab.il@gmailcom";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());
    }

    @Test
    void testEmailValidDotSymbolAfterTwoSymbols() {
        String invalidEmail = "nabil@gmailco.m";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());
    }

    @Test
    void testEmailValidDigits() {
        String validEmail = "nabil94@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testEmailValidUpperCase() {
        String validEmail = "NABIL@GMAIL.COM";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testEmailValidLowerCase() {
        String validEmail = "nabil@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());
    }

    @Test
    void testEmailValidSpecialSymbols() {
        String validEmail = "nab-il_@gmail.com";
        user.setEmail(validEmail);
        assertEquals(validEmail, user.getEmail());

        String invalidEmail = "nab-i%l_@gmail.com";
        user.setEmail(invalidEmail);
        assertNotEquals(invalidEmail, user.getEmail());
    }
}

















