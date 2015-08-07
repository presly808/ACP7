package week4.thread.file_search;

/**
 * Created by Джек on 22.07.2015.
 */
public class ProdThread implements Runnable {
    private ProdConsTwoQueue prodConsTwoQueue;

    public ProdThread(ProdConsTwoQueue prodConsTwoQueue) {
        this.prodConsTwoQueue = prodConsTwoQueue;
    }

    @Override
    public void run() {
        try {
            prodConsTwoQueue.iterFiles(prodConsTwoQueue.getDirectories(), prodConsTwoQueue.getFiles());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
