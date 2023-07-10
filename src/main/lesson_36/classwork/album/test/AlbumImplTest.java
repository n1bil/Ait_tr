package main.lesson_36.classwork.album.test;

import main.lesson_36.classwork.album.dao.Album;
import main.lesson_36.classwork.album.dao.AlbumImpl;
import main.lesson_36.classwork.album.model.Photo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AlbumImplTest {
    Album album;
    LocalDateTime now = LocalDateTime.now();
    Photo[] photos;

    @BeforeEach
    void setUp() {
        this.album = new AlbumImpl(5);
        this.photos = new Photo[]{
                new Photo(1, 1, "title1", "url1", LocalDateTime.of(2023, 12, 3, 4, 2)),
                new Photo(1, 2, "title2", "url2", LocalDateTime.of(2021, 6, 22, 3, 33)),
                new Photo(1, 3, "title3", "url3", LocalDateTime.of(2022, 3, 12, 12, 12)),
                new Photo(2, 1, "title4", "url4", LocalDateTime.of(2022, 9, 3, 2, 44))};

        for(int i = 0; i < photos.length; ++i) {
            this.album.addPhoto(photos[i]);
        }

    }

    @Test
    void addPhoto() {
        assertFalse(album.addPhoto(null));
        assertFalse(album.addPhoto(photos[0]));
        assertTrue(album.addPhoto(new Photo(6, 7, "Tiger", "tiger1", LocalDateTime.of(2023, 7, 7, 14, 0))));
        assertEquals(5, album.size());
        assertFalse(album.addPhoto(new Photo(1, 5, "Tiger", "tiger1", LocalDateTime.of(2023, 7, 7, 14, 0))));
    }

    @Test
    void removePhoto() {
        assertTrue(album.removePhoto(1, 2));
        assertEquals(3, album.size());
        assertFalse(album.removePhoto(2, 2));
        assertFalse(album.removePhoto(1, 2));
    }

    @Test
    void updatePhoto() {
        assertTrue(album.updatePhoto(1, 2, "url22"));
        assertFalse(album.updatePhoto(1, 4, "url222"));
    }

    @Test
    void getPhotoFromAlbum() {
        assertEquals(photos[2], album.getPhotoFromAlbum(1, 3));
        assertNotEquals(photos[2], album.getPhotoFromAlbum(4, 4));
        assertNull(album.getPhotoFromAlbum(3, 3));
    }

    @Test
    void getAllPhotoFromAlbum() {
        Photo[] expected = new Photo[]{photos[0], photos[3]};
        Photo[] actual = album.getAllPhotoFromAlbum(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    void getPhotoBetweenDate() {
        Photo[] expected = new Photo[]{photos[2], photos[3]};
        Photo[] actual = album.getPhotoBetweenDate(LocalDate.of(2021, 12, 1), LocalDate.of(2023, 12, 1));
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(4, album.size());
    }

    @Test
    void sortPhotosByCreation() {
        Arrays.sort(photos);

        for(int i = 0; i < this.photos.length; ++i) {
            System.out.println(photos[i]);
        }

    }
}