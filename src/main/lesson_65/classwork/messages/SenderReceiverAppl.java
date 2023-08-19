package main.lesson_65.classwork.messages;

import main.lesson_65.classwork.messages.model.MessageBox;
import main.lesson_65.classwork.messages.model.MessageBoxC;
import main.lesson_65.classwork.messages.task.Receiver;
import main.lesson_65.classwork.messages.task.Sender;

public class SenderReceiverAppl {
    private static final int N_MESSAGES = 20;
    private static final int N_RECEIVER = 5;

    public static void main(String[] args) throws InterruptedException {
        MessageBox messageBox = new MessageBoxC();
        Sender sender = new Sender(messageBox, N_MESSAGES);
        for (int i = 0; i < N_RECEIVER; i++) {
            new Receiver(messageBox).start();
        }
        Thread.sleep(100);
        sender.start();
        sender.join();
        Thread.sleep(100);
    }
}
