package main.lesson_45.homework;

import main.lesson_45.homework.television.Channel;
import main.lesson_45.homework.television.Programmes;
import main.lesson_45.homework.television.RemoteController;
import main.lesson_45.homework.television.TV;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Programmes> sportsProgrammes = List.of(new Programmes("Tennis"), new Programmes("Football"), new Programmes("Hockey"), new Programmes("Cycling"));
        List<Programmes> discoveriesProgrammes = List.of(new Programmes("Survive in the wilderness"), new Programmes("Lion life"), new Programmes("Excavations"), new Programmes("Guji tribe"));

        Channel sport = new Channel("Sport", 1, sportsProgrammes);
        Channel discovery = new Channel("Discovery", 2, discoveriesProgrammes);
        List<Channel> channels = List.of(sport, discovery);

        TV panasonic = new TV(channels);

        RemoteController rc = new RemoteController(panasonic);



        rc.turnOnChannel(1);

    }
}