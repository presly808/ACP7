package week4.thread.file_search;

public class ProducerThread implements Runnable{

    private ProducerConsumerPattern producer;

    public ProducerThread (ProducerConsumerPattern producer) {
        this.producer = producer;
    }
    @Override
    public void run() {
        try {
            producer.iterFiles(producer.getDirectories());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
