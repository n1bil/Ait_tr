package main.lesson_37.homework.forum.test;

import main.lesson_37.homework.forum.dao.Forum;
import main.lesson_37.homework.forum.dao.ForumImpl;
import main.lesson_37.homework.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    Forum forum;
    Post[] posts;

    @BeforeEach
    void setUp() {
        forum = new ForumImpl();
        posts = new Post[]{
                new Post(1, "Sport", "Andrew", "Football"),
                new Post(2, "Politics", "Daniel", "War"),
                new Post(3, "Traveling", "Randy", "New Zealand"),
                new Post(4, "Sport", "Steve", "Hockey"),
                new Post(5, "Traveling", "Daniel", "Greece")
        };
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void addPost() {
        assertFalse(forum.addPost(null));
        assertFalse(forum.addPost(posts[2]));
        assertTrue(forum.addPost(new Post(6, "Fashion", "Tommy", "New clothes")));
        assertEquals(6, forum.size());
        assertTrue(forum.addPost(new Post(7, "Traveling", "Wayne", "Jamaica")));
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
        Post[] actual = {posts[1], posts[4]};
        assertArrayEquals(actual ,forum.getPostsBtAuthor("Daniel"));
    }

    @Test
    void getPostsByAuthor() {

    }

    @Test
    void size() {
        assertEquals(5, posts.length);
    }
}