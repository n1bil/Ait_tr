package main.lesson_36.classwork.album.dao;

import main.lesson_36.classwork.album.model.Photo;

import java.time.LocalDate;
import java.util.function.Predicate;

public class AlbumImpl implements Album {

    private Photo[] photos;
    private int size;

    public AlbumImpl(int capacity) {
        photos = new Photo[capacity];
    }

    @Override
    public boolean addPhoto(Photo photo) {
        if (photo != null && photos.length != size && getPhotoFromAlbum(photo.getPhotoId(), photo.getAlbumId()) == null) {
            photos[size] = photo;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean removePhoto(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i] != null && photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                System.arraycopy(photos, i + 1, photos, i, size - i - 1);
                size--;
                photos[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatePhoto(int photoId, int albumId, String url) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                photos[i].setUrl(url);
                return true;
            }
        }
        return false;
    }

    @Override
    public Photo getPhotoFromAlbum(int photoId, int albumId) {
        for (int i = 0; i < size; i++) {
            if (photos[i].getPhotoId() == photoId && photos[i].getAlbumId() == albumId) {
                return photos[i];
            }
        }
        return null;
    }

    @Override
    public Photo[] getAllPhotoFromAlbum(int albumId) {
        return findByPredicate(photo -> photo.getAlbumId() == albumId);
    }

    @Override
    public Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo) {
        return findByPredicate(photo -> photo.getLocalDateTime().toLocalDate().isAfter(dateFrom) &&
                photo.getLocalDateTime().toLocalDate().isBefore(dateTo));
    }

    @Override
    public int size() {
        return size;
    }

    private Photo[] findByPredicate(Predicate<Photo> predicate) {
        Photo[] photosArray = new Photo[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(photos[i])) {
                photosArray[count] = photos[i];
                count++;
            }
        }
        Photo[] result = new Photo[count];
        System.arraycopy(photosArray, 0, result, 0, count);
        return result;
    }
}
