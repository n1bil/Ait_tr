package main.lesson_43.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleTest {

    private Article articleForTest;

    @BeforeEach
    void setUp() {
        articleForTest = new Article(
                "Football",
                "AC Milan vs Manchester United (2 - 0)",
                "David Thompson",
                Article.State.DRAFT
        );
    }

    @Test
    void sentToReview() {
        articleForTest.sentToReview();
        assertTrue(articleForTest.isOnReviewed());
        articleForTest.setState(Article.State.ON_EDIT);
        articleForTest.sentToReview();
        assertTrue(articleForTest.isOnReviewed());

        articleForTest.setState(Article.State.PUBLISHED);
        assertThrows(IllegalStateException.class, () -> articleForTest.sentToReview());
    }

    @Test
    void publish() {
        articleForTest.setState(Article.State.ON_REVIEW);
        articleForTest.publish();
        assertTrue(articleForTest.isPublished());

        articleForTest.setState(Article.State.DRAFT);
        assertThrows(IllegalStateException.class, () -> articleForTest.publish());
    }

    @Test
    void decline() {
        articleForTest.setState(Article.State.ON_REVIEW);
        articleForTest.decline();
        assertTrue(articleForTest.isDeclined());

        articleForTest.setState(Article.State.DRAFT);
        assertThrows(IllegalStateException.class, () -> articleForTest.decline());
    }

    @Test
    void delete() {
        articleForTest.setState(Article.State.DECLINED);
        articleForTest.delete();
        assertTrue(articleForTest.isDelete());
        articleForTest.setState(Article.State.ON_EDIT);
        articleForTest.delete();
        assertTrue(articleForTest.isDelete());

        articleForTest.setState(Article.State.DRAFT);
        assertThrows(IllegalStateException.class, () -> articleForTest.delete());
    }

    @Test
    void edit() {
        articleForTest.setState(Article.State.DECLINED);
        articleForTest.edit();
        assertTrue(articleForTest.isOnEdited());

        articleForTest.setState(Article.State.DRAFT);
        assertThrows(IllegalStateException.class, () -> articleForTest.edit());
    }
}