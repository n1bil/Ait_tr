package main.lesson_38_Exception.classworkAndHomework.forum.dao;

import main.lesson_38_Exception.classworkAndHomework.forum.model.Post;

import java.time.LocalDate;

public interface Forum {
    boolean addPost(Post post);

    boolean removePost(int postId);

    boolean updatePost(int postId, String newContent);

    Post getPostById(int postId);

    Post[] getPostsByAuthor(String author);

    Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo);

    int size();
}
