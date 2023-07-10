package main.lesson_37.classwork.album.test;

import main.lesson_37.classwork.album.dao.Album;
import main.lesson_37.classwork.album.dao.AlbumImpl;
import main.lesson_37.classwork.album.model.Photo;
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
        album = new AlbumImpl(7);
        photos = new Photo[]{
                new Photo(1, 1, "title1", "url1", now.minusDays(7)),
                new Photo(1, 2, "title2", "url2", now.minusDays(7)),
                new Photo(1, 3, "title3", "url3", now.minusDays(5)),
                new Photo(2, 1, "title1", "url1", now.minusDays(7)),
                new Photo(2, 4, "title4", "url4", now.minusDays(2)),
                new Photo(1, 4, "title4", "url1", now.minusDays(2))
        };

        for (int i = 0; i < photos.length; ++i) {
            album.addPhoto(photos[i]);
        }

    }

    @Test
    void addPhoto() {
        assertFalse(album.addPhoto(null));
        assertFalse(album.addPhoto(photos[1]));
        Photo photo = new Photo(1, 5, "title5", "url5", now.minusDays(3));
        assertTrue(album.addPhoto(photo));
        assertEquals(7, album.size());
        photo = new Photo(1, 6, "title6", "url6", now.minusDays(3));
        assertFalse(album.addPhoto(photo));
    }

    @Test
    void removePhoto() {
        assertFalse(album.removePhoto(5, 1));
        assertTrue(album.removePhoto(1, 1));
        assertEquals(5, album.size());
        assertNull(album.getPhotoFromAlbum(1, 1));
    }

    @Test
    void updatePhoto() {
        assertTrue(album.updatePhoto(1, 1, "New Url"));
        assertEquals("New Url", album.getPhotoFromAlbum(1, 1).getUrl());
    }

    @Test
    void getPhotoFromAlbum() {
        assertEquals(photos[0], album.getPhotoFromAlbum(1, 1));
        assertNull(album.getPhotoFromAlbum(3, 2));
    }

    @Test
    void getAllPhotoFromAlbum() {
        Photo[] actual = album.getAllPhotoFromAlbum(2);
        Arrays.sort(actual);
        Photo[] expected = {photos[3], photos[4]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getPhotoBetweenDate() {
        LocalDate localDate = now.toLocalDate();
        Photo[] actual = album.getPhotoBetweenDate(localDate.minusDays(5), localDate.minusDays(2));
        Arrays.sort(actual);
        Photo[] expected = {photos[2], photos[5], photos[4]};
        assertArrayEquals(expected, actual);
    }

    @Test
    void size() {
        assertEquals(6, album.size());
    }

    @Test
    void sortPhotosByCreation() {
        Arrays.sort(photos);
        for (int i = 0; i < photos.length; ++i) {
            System.out.println(photos[i]);
        }
    }
}