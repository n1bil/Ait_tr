package main.lesson_43.classwork;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User userForTest;

    @BeforeEach
    void setUp() {
        userForTest = new User(
                UUID.randomUUID().toString(),
                "Roman",
                "Popov",
                "roman@gmail.com",
                "qwert007",
                User.Role.MANAGER,
                User.State.NOT_CONFIRMED
        );
    }

    @Test
    void correctConfirm() {
        userForTest.setState(User.State.NOT_CONFIRMED);
        userForTest.confirm();
        assertTrue(userForTest.isConfirmed());
    }

    @Test
    void notCorrectConfirm() {
        userForTest.setState(User.State.VERIFIED);
        assertThrows(IllegalStateException.class, () -> userForTest.confirm());
    }
}