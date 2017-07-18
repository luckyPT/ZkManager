package top.letsgogo.rpc;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import top.letsgogo.rpc.Iservice.HelloWorld;

import java.util.List;

/**
 * @author panteng
 * @description
 * @date 17-7-8.
 */
public class Client {
    public static HelloWorld.Client client = null;
    private static TTransport transport = new TSocket("localhost", 9090);
    private static TProtocol protocol = new TBinaryProtocol(transport);

    static {
        client = new HelloWorld.Client(protocol);
        try {
            transport.open();
        } catch (Exception e) {
            System.out.println("RPC服务调用失败:" + e.getMessage());
        }
    }

    public static void main2(String[] args) {
        try {
            //System.out.println("ping:" + client.ping());
            List<String> a = client.splitSentence("今天天气好吗");
            System.out.println(a == null ? "null" : a);
            close();
        } catch (TException x) {
            x.printStackTrace();
        }
    }

    public static boolean close() {
        try {
            transport.close();
            return true;
        } catch (Exception e) {
            System.out.println("RPC服务关闭失败:" + e.getMessage());
        }
        return false;
    }
}
