package week4.thread.file_search;


public class ConsumerThreadTwoQueue implements Runnable{
    private ProducerConsumerPatternTwoQueue queue;

    public ConsumerThreadTwoQueue(ProducerConsumerPatternTwoQueue queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            queue.compareFiles(queue.getStart());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
