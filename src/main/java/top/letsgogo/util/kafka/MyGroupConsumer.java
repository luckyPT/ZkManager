package top.letsgogo.util.kafka;

import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author panteng
 * @description 消费者组
 * @date 17-7-1.
 */
public class MyGroupConsumer {
    private final String topic;
    private final ConsumerConnector consumer;
    private ExecutorService executor;


    public MyGroupConsumer(String zookeeper, String groupId, String topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig(zookeeper, groupId));
        this.topic = topic;
    }

    /**
     * 消费者组的配置信息
     *
     * @param a_zookeeper
     * @param a_groupId
     * @return
     */
    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        props.put("zookeeper.connect", a_zookeeper);//zk上存有offset的信息
        props.put("group.id", a_groupId);
        props.put("zookeeper.session.timeout.ms", "400");//等待zk响应的超时时间
        props.put("zookeeper.sync.time.ms", "200");
        //zk上offset的更新频率，这个频率是基于时间的，而不是基于消费情况的，所以这种情况下有可能重复消费
        props.put("auto.commit.interval.ms", "1000");
        return new ConsumerConfig(props);
    }

    public void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(a_numThreads));//消费者线程数目
        //将消费者组的信息传递给kafka（包括一共有几个线程），返回可供接收数据的kafka流
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        //可以同时监听多个topic
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);


        // now launch all the threads
        executor = Executors.newFixedThreadPool(a_numThreads);

        // 这里只是将stream和consumer对应的过程
        int threadNumber = 0;
        for (final KafkaStream stream : streams) {
            executor.execute(new ConsumerBehavier(stream, threadNumber));
            System.out.println(threadNumber++);
        }
    }

    /**
     * 阻塞10秒，然后手动关闭，防止消费未同步到ZK 出现重复消费的情况
     */
    public void shutdownAndWait() {
        if (executor != null) executor.shutdown();
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (consumer != null) consumer.shutdown();//处理消息的线程退出后，必须调用consumer.shutdown()，否则整个程序无法退出。
    }
}
