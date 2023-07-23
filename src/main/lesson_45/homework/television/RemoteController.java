package main.lesson_45.homework.television;

import java.util.List;
import java.util.Random;

public class RemoteController {

    private TV tv;

    public RemoteController(TV tv) {
        this.tv = tv;
    }

    public void turnOnChannel(int numberOfChannel) {
        boolean foundChannel = false;
        for (Channel channel : tv.getChannels()) {
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
