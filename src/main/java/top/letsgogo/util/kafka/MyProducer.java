package top.letsgogo.util.kafka;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;

/**
 * @author panteng
 * @description
 * @date 17-7-1.
 */
public class MyProducer {
    private static Properties props = new Properties();
    private static ProducerConfig config = null;//kafka配置
    //第一个string 指的是partitionKey的Type 第二个是消息的type
    private static Producer<String, String> producer = null;

    static {
        props.put("metadata.broker.list", "host:port,host:port,host:port,host:port,host:port");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "top.letsgogo.util.kafka.MyPartitioner");
        props.put("request.required.acks", "1");//kafka接收到消息后，给生产者一个回应
        config = new ProducerConfig(props);
        producer = new Producer<String, String>(config);
    }

    public static boolean produceMsg(String topic, String partitionKey, String msg) {
        try {
            KeyedMessage<String, String> data = new KeyedMessage<String, String>(topic, partitionKey, msg);
            producer.send(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void close() {
        producer.close();
    }

}
