package main.lesson_45.homework.television;

import java.util.List;

public class TV {

    private List<Channel> channels;

    public TV(List<Channel> channels) {
        this.channels = channels;
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
