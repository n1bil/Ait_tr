package main.lesson_38_Exception.classworkAndHomework.forum.dao;

import main.lesson_38_Exception.classworkAndHomework.forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum {

    private static Comparator<Post> comparator = (p1, p2) -> {
        int res = p1.getAuthor().compareTo(p2.getAuthor());
        if (res != 0) {
            return res;
        }
        res = p1.getDate().compareTo(p2.getDate());
        if (res != 0) {
            return res;
        }
        return Integer.compare(p1.getPostId(), p2.getPostId());
    };
    private Post[] posts;
    private int size;

    public ForumImpl() {
        posts = new Post[0];
    }

    @Override
    public boolean addPost(Post post) {
        if(post == null){
            throw new RuntimeException();
        }
        if (getPostById(post.getPostId()) != null) {
            return false;
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
        pattern.setDate(LocalDateTime.MIN);
        int from = -Arrays.binarySearch(posts, pattern, comparator) - 1;
        pattern = new Post(Integer.MAX_VALUE, author, null, null);
        pattern.setDate(LocalDateTime.MAX);
        int to = -Arrays.binarySearch(posts, pattern, comparator) - 1;

        return Arrays.copyOfRange(posts, from, to);
    }

    @Override
    public Post[] getPostsByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post patternFrom = new Post(Integer.MIN_VALUE, author, null, null);
        patternFrom.setDate(LocalDateTime.of(dateFrom, LocalTime.MIN));
        int from = -Arrays.binarySearch(posts, patternFrom, comparator) - 1;

        Post patternTo = new Post(Integer.MAX_VALUE, author, null, null);
        patternTo.setDate(LocalDateTime.of(dateTo, LocalTime.MAX));
        int to = -Arrays.binarySearch(posts, from, size, patternTo, comparator) - 1;

        return Arrays.copyOfRange(posts, from, to);

//        Arrays.sort(filteredPosts, comparator);
//
//        return filteredPosts;
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
