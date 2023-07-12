package main.lesson_38_Exception.classworkAndHomework.forum.test;

import main.lesson_38_Exception.classworkAndHomework.forum.dao.Forum;
import main.lesson_38_Exception.classworkAndHomework.forum.dao.ForumImpl;
import main.lesson_38_Exception.classworkAndHomework.forum.model.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ForumTest {

    Forum forum;
    Post[] posts = new Post[6];

    @BeforeEach
    void setUp()  {
        forum = new ForumImpl();
        posts[0] = new Post(0, "author1", "title1", "content");
        posts[1] = new Post(1, "author2", "title2", "content");
        posts[2] = new Post(2, "author2", "title3", "content");
        posts[3] = new Post(3, "author1", "title4", "content");
        posts[4] = new Post(4, "author3", "title1", "content");
        posts[5] = new Post(5, "author1", "title2", "content");
        for (int i = 0; i < posts.length - 1; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void testAddPost() {
        assertThrows(RuntimeException.class, () -> forum.addPost(null));
        assertTrue(forum.addPost(posts[5]));
        assertEquals(6, forum.size());
//        assertThrows(RuntimeException.class, () -> forum.addPost(posts[5]));
        assertFalse(forum.addPost(posts[5]));
        assertEquals(6, forum.size());
    }
    //        assertFalse(forum.addPost(posts[5]));
    @Test
    void testRemovePost() {
        assertTrue(forum.removePost(2));
        assertEquals(4, forum.size());
        assertFalse(forum.removePost(2));
        assertEquals(4, forum.size());
    }

    @Test
    void testUpdatePost() {
        assertTrue(forum.updatePost(1, "new content"));
        assertEquals("new content", forum.getPostById(1).getContent());
    }

    @Test
    void testGetPostById() {
        assertEquals(posts[3], forum.getPostById(3));
        assertNull(forum.getPostById(5));
    }

    @Test
    void testGetPostsByAuthorString() {
        Post[] actual = forum.getPostsByAuthor("author1");
        Arrays.sort(actual);
        Post[] expected = { posts[0], posts[3] };
        assertArrayEquals(expected, actual);
    }

    @Test
    void testGetPostsByAuthorStringLocalDateLocalDate() {
        posts[0].setDate(LocalDateTime.now().minusDays(10));
        posts[1].setDate(LocalDateTime.now().minusDays(9));
        posts[2].setDate(LocalDateTime.now().minusDays(8));
        posts[3].setDate(LocalDateTime.now().minusDays(7));
        posts[4].setDate(LocalDateTime.now().minusDays(6));
        posts[5].setDate(LocalDateTime.now().minusDays(5));
        forum = new ForumImpl();
        for (int i = 0; i < posts.length; i++) {
            forum.addPost(posts[i]);
        }
        Post[] actual = forum.getPostsByAuthor("author1", LocalDate.now().minusDays(11), LocalDate.now().minusDays(6));
        Arrays.sort(actual);
        Post[] expected = { posts[0], posts[3] };
        assertArrayEquals(expected, actual);
    }

    @Test
    void testSize() {
        assertEquals(5, forum.size());
    }
}
