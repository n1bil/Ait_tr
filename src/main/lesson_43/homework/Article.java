package main.lesson_43.homework;

import java.util.function.Predicate;

public class Article {

    public enum State {
        DRAFT, ON_REVIEW, PUBLISHED, DECLINED, DELETED, ON_EDIT
    }
    private String article;
    private String content;
    private String author;
    private State state;

    public Article(String article, String content, String author, State state) {
        this.article = article;
        this.content = content;
        this.author = author;
        this.state = state;
    }

    public void sentToReview() {
        changeState(state -> isDraft() || isOnEdited(),
                State.ON_REVIEW,
                "Submit error for review.");
    }

    public void publish() {
        changeState(state -> isOnReviewed(),
                State.PUBLISHED,
                "Publishing error.");
    }

    public void decline() {
        changeState(state -> isOnReviewed(),
                State.DECLINED,
                "Not allowed to post.");
    }

    public void delete() {
        changeState(state -> isDeclined() || isOnEdited(),
                State.DELETED,
                "Deletion failed.");
    }

    public void edit() {
        changeState(state -> isDeclined(),
                State.ON_EDIT,
                "Editing failed.");
    }

    public boolean isDraft() {
        return state.equals(State.DRAFT);
    }

    public boolean isOnEdited() {
        return state.equals(State.ON_EDIT);
    }

    public boolean isOnReviewed() {
        return state.equals(State.ON_REVIEW);
    }

    public boolean isPublished() {
        return state.equals(State.PUBLISHED);
    }

    public boolean isDeclined() {
        return state.equals(State.DECLINED);
    }

    public boolean isDelete() {
        return state.equals(State.DELETED);
    }

    public void changeState(Predicate<State> predicate, State newState, String errorMessage) {
        if (predicate.test(this.state)) {
            this.state = newState;
        } else {
            throw new IllegalStateException(errorMessage + " Current state: " + state);
        }
    }

    public String getArticle() {
        return article;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}









