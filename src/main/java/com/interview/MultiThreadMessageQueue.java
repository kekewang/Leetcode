package com.interview;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

class Message {

}

public class MultiThreadMessageQueue implements Cloneable {
    private Queue<Message> messageQueue = new LinkedBlockingDeque();

    public synchronized void push(Message message) {
        if (messageQueue.size() > 10) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        messageQueue.add(message);
        this.notifyAll();
    }

    public synchronized Message pull() {
        if (messageQueue.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Message message = messageQueue.poll();
        this.notifyAll();

        return message;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
