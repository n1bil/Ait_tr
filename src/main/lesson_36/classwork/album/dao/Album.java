package main.lesson_36.classwork.album.dao;

import main.lesson_36.classwork.album.model.Photo;

import java.time.LocalDate;

public interface Album {

    boolean addPhoto(Photo photo);

    boolean removePhoto(int photoId, int albumId);

    boolean updatePhoto(int photoId, int albumId, String url);

    Photo getPhotoFromAlbum(int photoId, int albumId);

    Photo[] getAllPhotoFromAlbum(int albumId);

    Photo[] getPhotoBetweenDate(LocalDate dateFrom, LocalDate dateTo);

    int size();
}
