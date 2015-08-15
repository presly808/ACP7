package week4.thread.file_search;

/**
 * Created by Джек on 22.07.2015.
 */
public class ConsumerThread implements Runnable{
    private ProducerConsumerPattern producer;

    public ConsumerThread (ProducerConsumerPattern producer) {
        this.producer = producer;
    }
    @Override
    public void run() {
        try {
            producer.compareFiles();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
