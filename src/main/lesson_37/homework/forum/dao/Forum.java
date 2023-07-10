package main.lesson_37.homework.forum.dao;

import main.lesson_37.homework.forum.model.Post;

import java.time.LocalDate;

public interface Forum {

    boolean addPost(Post post);

    boolean removePost(int postId);

    boolean updatePost(int postId, String content);

    Post getPostById(int postId);

    Post[] getPostsBtAuthor(String author);

    Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo);

    int size();
}
