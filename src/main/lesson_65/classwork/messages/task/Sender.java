package main.lesson_65.classwork.messages.task;

import main.lesson_65.classwork.messages.model.MessageBox;

public class Sender extends Thread {

    MessageBox messageBox;

    int nMessages;

    public Sender(MessageBox messageBox, int nMessages) {
        this.messageBox = messageBox;
        this.nMessages = nMessages;
    }

    @Override
    public void run() {
        for (int i = 0; i < nMessages; i++) {
            messageBox.post("message#" + i);
        }
    }
}
