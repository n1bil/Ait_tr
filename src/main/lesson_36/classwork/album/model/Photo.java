package main.lesson_36.classwork.album.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Photo implements Comparable<Photo> {

    private int albumId;
    private int photoId;
    private String title;
    private String url;
    private LocalDateTime localDateTime;

    public Photo(int photoId ,int albumId, String title, String url, LocalDateTime localDateTime) {
        this.photoId = photoId;
        this.albumId = albumId;
        this.title = title;
        this.url = url;
        this.localDateTime = localDateTime;
    }

    @Override
    public int compareTo(Photo o) {
        return localDateTime.compareTo(o.localDateTime);
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "albumId=" + albumId +
                ", photoId=" + photoId +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", localDate=" + localDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return albumId == photo.albumId && photoId == photo.photoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(albumId, photoId);
    }

}
