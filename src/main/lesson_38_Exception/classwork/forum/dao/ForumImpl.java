package main.lesson_38_Exception.classwork.forum.dao;

import main.lesson_38_Exception.classwork.forum.model.Post;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum {

    private static Comparator<Post> comparator = (p1, p2) -> {
        int res = p1.getAuthor().compareTo(p2.getAuthor());
        return res != 0 ? res : p1.compareTo(p2);
    };
    private static Comparator<Post> comparator2 = (p1, p2) -> p1.getDate().compareTo(p2.getDate());
    private Post[] posts;
    private int size;

    public ForumImpl() {
        posts = new Post[0];
    }

    @Override
    public boolean addPost(Post post) {
        if (post == null || getPostById(post.getPostId()) != null) {
            throw new RuntimeException();
        }
        posts = Arrays.copyOf(posts, posts.length + 1);
        int index = Arrays.binarySearch(posts, 0, size, post, comparator);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(posts, index, posts, index + 1, size - index);
        posts[index] = post;
        size++;
        return true;
    }

    @Override
    public boolean removePost(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        System.arraycopy(posts, index + 1, posts, index, size - index - 1);
        posts = Arrays.copyOf(posts, posts.length - 1);
        size--;
        return true;
    }

    @Override
    public boolean updatePost(int postId, String newContent) {
        int index = searchById(postId);
        if (index < 0) {
            return false;
        }
        posts[index].setContent(newContent);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
        int index = searchById(postId);
        if (index < 0) {
            return null;
        }
        return posts[index];
    }

    @Override
    public Post[] getPostsByAuthor(String author) {
        Post pattern = new Post(Integer.MIN_VALUE, author, null, null);
        int from = -Arrays.binarySearch(posts, pattern, comparator) - 1;
        pattern = new Post(Integer.MAX_VALUE, author, null, null);
        int to = -Arrays.binarySearch(posts, pattern, comparator) - 1;

        return Arrays.copyOfRange(posts, from, to);
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        //FIXME increase performance. Hint: use binary search. Upgrade comparator
        Post pattern = new Post(Integer.MIN_VALUE, author, null, null);
        int from = -Arrays.binarySearch(posts, pattern, comparator) - 1;

        pattern = new Post(Integer.MAX_VALUE, author, null, null);
        int to = -Arrays.binarySearch(posts, from, size, pattern, comparator) - 1;

        Post[] result = Arrays.copyOfRange(posts, from, to);
        Arrays.sort(result, comparator2);
        return result;

//        return findByPredicate(post -> post.getAuthor().equals(author)
//                && post.getDate().toLocalDate().compareTo(dateFrom) >= 0
//                && post.getDate().toLocalDate().compareTo(dateTo) <= 0);

    }

    @Override
    public int size() {
        return size;
    }

    private int searchById(int postId) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getPostId() == postId) {
                return i;
            }
        }
        return -1;
    }

    private Post[] findByPredicate(Predicate<Post> predicate) {
        Post[] res = new Post[size];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(posts[i])) {
                res[j++] = posts[i];
            }
        }
        return Arrays.copyOf(res, j);
    }
}
