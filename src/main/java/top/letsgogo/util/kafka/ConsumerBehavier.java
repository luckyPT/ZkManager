package top.letsgogo.util.kafka;

import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;

/**
 * @author panteng
 * @description 消费者行为定义，即消息的处理方式
 * @date 17-7-1.
 */
public class ConsumerBehavier implements Runnable {
    private KafkaStream m_stream;
    private int m_threadNumber;

    public ConsumerBehavier(KafkaStream a_stream, int a_threadNumber) {
        m_threadNumber = a_threadNumber;
        m_stream = a_stream;
    }

    @Override
    public void run() {
        ConsumerIterator<byte[], byte[]> it = m_stream.iterator();
        while (it.hasNext())
            System.out.println("Thread " + m_threadNumber + ": MSG = " + new String(it.next().message()));
        System.out.println("Shutting down Thread: " + m_threadNumber);
    }
}
