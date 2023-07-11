package main.lesson_37.homework.forum.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Post{
    private int postId;
    private String title;
    private String author;
    private String content;
    private LocalDateTime localDateTime;
    private int likes;

    public Post(int postId, String title, String author, String content, LocalDateTime localDateTime) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.content = content;
        this.localDateTime = localDateTime;
    }

    public int getPostId() {
        return postId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public int getLikes() {
        return likes;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", localDateTime=" + localDateTime +
                ", likes=" + likes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return postId == post.postId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId);
    }

}
