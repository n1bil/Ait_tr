package main.lesson_65.classwork.messages.model;

public class MessageBoxB implements MessageBox {

    String message;

    @Override
    public synchronized void post(String message) {
        while (this.message != null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.message = message;
        this.notify();
    }

    @Override
    public synchronized String get() {
        while (message == null) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String result = message;
        message = null;
        this.notifyAll();
        return result;
    }
}
