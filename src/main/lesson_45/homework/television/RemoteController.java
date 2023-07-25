package main.lesson_45.homework.television;

public class RemoteController {

    private TV tv;

    public RemoteController(TV tv) {
        this.tv = tv;
    }

    public void turnOnChannel(int numberOfChannel) {
        tv.turnOnChannel(numberOfChannel);
    }
}
