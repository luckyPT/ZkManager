package top.letsgogo.util.kafka;

import org.junit.Test;

/**
 * @author panteng
 * @description
 * @date 17-7-1.
 */
public class KafkaTest {
    @Test
    public void sendMsg() {
        System.out.println("---------kafka------");
        MyProducer.produceMsg("topic-test", "1010101", "hello");
    }

    @Test
    public void consumerMsg() {
        MyGroupConsumer consumerGroup = new MyGroupConsumer("host:port,host:port,host:port/kafka/cluster-name",
                "panteng", "topic-test");
        consumerGroup.run(4);
        try {
            Thread.sleep(1000 * 20);
        } catch (Exception e) {
            e.printStackTrace();
        }
        consumerGroup.shutdownAndWait();
    }
}
