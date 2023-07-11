package main.lesson_37.homework.forum.test;

import main.lesson_37.homework.forum.dao.Forum;
import main.lesson_37.homework.forum.dao.ForumImpl;
import main.lesson_37.homework.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    Forum forum;
    Post[] posts;

    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[]{
                new Post(1, "Sport", "Andrew", "Football", LocalDateTime.of(2023, 6, 3, 4, 44)),
                new Post(2, "Politics", "Daniel", "War", LocalDateTime.of(2023, 3, 5, 5, 55)),
                new Post(3, "Traveling", "Randy", "New Zealand", LocalDateTime.of(2023, 5, 4, 21, 12)),
                new Post(4, "Sport", "Daniel", "Hockey", LocalDateTime.of(2023, 10, 10, 10, 32)),
                new Post(5, "Traveling", "Daniel", "Greece", LocalDateTime.of(2023, 11, 6, 7, 1))
        };
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[2]));
        assertTrue(forum.addPost(new Post(6, "Fashion", "Tommy", "New clothes", LocalDateTime.of(2023, 6, 25, 2, 2))));
        assertEquals(6, forum.size());
        assertTrue(forum.addPost(new Post(7, "Traveling", "Wayne", "Jamaica", LocalDateTime.of(2023, 8, 1, 5, 6))));
    }

    @Test
    void removePost() {
        assertTrue(forum.removePost(4));
        assertEquals(4, forum.size());
        assertFalse(forum.removePost(4));
        assertFalse(forum.removePost(6));
    }

    @Test
    void updatePost() {
        assertTrue(forum.updatePost(3, "Tennis"));
        assertFalse(forum.updatePost(6, "Java"));
    }

    @Test
    void getPostById() {
        assertNull(forum.getPostById(6));
        assertEquals(posts[0], forum.getPostById(1));
        assertNotEquals(posts[0], forum.getPostById(3));

    }

    @Test
    void getPostsBtAuthor() {
        Post[] actual = {posts[1], posts[3] ,posts[4]};
        assertArrayEquals(actual, forum.getPostsBtAuthor("Daniel"));
    }

    @Test
    void getPostsByAuthor() {
        Post[] expect = {posts[3], posts[4]};
        Post[] actual = forum.getPostsByAuthor("Daniel", LocalDate.of(2023, 5, 1), LocalDate.of(2023, 12, 1));
        assertArrayEquals(expect, actual);
    }

    @Test
    void size() {
        assertEquals(5, posts.length);
    }
}