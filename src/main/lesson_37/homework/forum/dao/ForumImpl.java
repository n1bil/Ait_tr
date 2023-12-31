package main.lesson_37.homework.forum.dao;

import main.lesson_37.homework.forum.model.Post;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum {

    static Comparator<Post> comparator = (p1, p2) -> p1.getLocalDateTime().compareTo(p2.getLocalDateTime());
    private Post[] posts;
    private int size;

    public ForumImpl() {
        posts = new Post[1];
    }

    @Override
    public boolean addPost(Post post) {
        if (post != null && getPostById(post.getPostId()) == null) {
            int index = Arrays.binarySearch(posts, 0, size, post, comparator);
            index = index >= 0 ? index : -index - 1;

            if (size == posts.length) {
                Post[] newPosts = new Post[size + 1];
                System.arraycopy(posts, 0, newPosts, 0, index);
                newPosts[index] = post;
                System.arraycopy(posts, index, newPosts, index + 1, size - index);
                posts = newPosts;
            } else {
                System.arraycopy(posts, index, posts, index + 1, size - index);
                posts[index] = post;
            }
            size++;
            return true;
        }
        return false;
    }


    @Override
    public boolean removePost(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                System.arraycopy(posts, i + 1, posts, i, size - i - 1);
                size--;
                posts[size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                posts[i].setContent(content);
                return true;
            }
        }
        return false;
    }

    @Override
    public Post getPostById(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostsBtAuthor(String author) {
        return findByPredicate(post -> post.getAuthor().equals(author));
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        return findByPredicate(post -> post.getAuthor().equals(author)
                && post.getLocalDateTime().toLocalDate().isAfter(dateFrom)
                && post.getLocalDateTime().toLocalDate().isBefore(dateTo));
    }

    @Override
    public int size() {
        return size;
    }

    private Post[] findByPredicate(Predicate<Post> predicate) {
        Post[] newPosts = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                newPosts[j] = posts[i];
                j++;
            }
        }
        return Arrays.copyOf(newPosts, j);
    }
}