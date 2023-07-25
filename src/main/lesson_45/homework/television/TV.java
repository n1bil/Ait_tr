package main.lesson_45.homework.television;

import java.util.List;
import java.util.Random;

public class TV {

    private List<Channel> channels;

    public TV(List<Channel> channels) {
        this.channels = channels;
    }

    void turnOnChannel(int numberOfChannel) {
        boolean foundChannel = false;
        for (Channel channel : channels) {
            if (channel.getNumber() == numberOfChannel) {
                List<Programmes> programmes = channel.getProgrammes();
                if (!programmes.isEmpty()) {
                    int randomIndex = new Random().nextInt(programmes.size());
                    System.out.println("Current program on channel " + numberOfChannel + ": " + programmes.get(randomIndex));
                }
                foundChannel = true;
                break;
            }
        }
        if (!foundChannel) {
            System.out.println("No program on channel " + numberOfChannel);
        }
    }
}
