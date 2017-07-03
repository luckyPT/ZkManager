package top.letsgogo.util.kafka;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @author panteng
 * @description
 * @date 17-7-1.
 */
public class MyPartitioner implements Partitioner {
    public MyPartitioner() {
    }

    public MyPartitioner(VerifiableProperties props) {

    }

    @Override
    public int partition(Object o, int i) {
        int partition = 0;
        partition = Math.abs(o.hashCode()) % i;
        return partition;
    }
}
