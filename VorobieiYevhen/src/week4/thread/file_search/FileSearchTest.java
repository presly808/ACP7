package week4.thread.file_search;

import java.io.*;

/**
 * Created by Джек on 22.07.2015.
 */
public class FileSearchTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        File textFile = new File("C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\resources\\results.txt");
        PrintWriter os = new PrintWriter(new OutputStreamWriter(new FileOutputStream(textFile,true)));
        String path = "C:\\Users\\Джек\\GIT_SIMPLE\\ACP7\\VorobieiYevhen\\";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Write file/directory name: ");
        String fileName = br.readLine();
        new QueueSearch(fileName, path, os).searchFileQueue();
        ProducerConsumerPattern producerConsumerPattern = new ProducerConsumerPattern(fileName, path, os);
        Thread producer = new Thread(new ProducerThread(producerConsumerPattern));
        Thread consumer = new Thread(new ConsumerThread(producerConsumerPattern));
        producer.start();
        consumer.start();
        consumer.join();
        ProducerConsumerPatternTwoQueue producerConsumerPatternTwoQueue = new ProducerConsumerPatternTwoQueue(fileName, path, os);
        Thread producer2 = new Thread(new ProducerThreadTwoQueue(producerConsumerPatternTwoQueue));
        Thread consumer2 = new Thread(new ConsumerThreadTwoQueue(producerConsumerPatternTwoQueue));
        producer2.start();
        consumer2.start();
        consumer2.join();
        os.close();


    }
}
