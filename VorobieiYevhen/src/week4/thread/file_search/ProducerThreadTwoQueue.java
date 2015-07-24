package week4.thread.file_search;

public class ProducerThreadTwoQueue implements Runnable{

    private ProducerConsumerPatternTwoQueue queue;

    public ProducerThreadTwoQueue(ProducerConsumerPatternTwoQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            queue.iterFiles();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
