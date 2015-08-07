package week4.thread.file_search;

/**
 * Created by Джек on 22.07.2015.
 */
public class ConsThread implements Runnable {
    private ProdConsTwoQueue prodConsTwoQueue;

    public ConsThread(ProdConsTwoQueue prodConsTwoQueue) {
        this.prodConsTwoQueue = prodConsTwoQueue;
    }

    @Override
    public void run() {
        try {
            prodConsTwoQueue.compareFiles(prodConsTwoQueue.getFiles(), prodConsTwoQueue.start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
