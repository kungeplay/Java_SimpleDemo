package com.jiakun.fresh;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 简单的zookeeper例子
 * @Author: liujiakun
 * @Date: Created in 下午9:23 2018/2/26
 * @Description:
 */
public class Master  implements Watcher{
    private ZooKeeper zk;
    private String hostPort;

    public Master(String hostPort) {
        this.hostPort = hostPort;
    }

    public void startZK() throws IOException {
        zk = new ZooKeeper(hostPort, 15000, this);
    }

    public void process(WatchedEvent watchedEvent) {

        System.out.println(watchedEvent);
    }

    public void stopZK() throws InterruptedException {
        if (zk != null) {
            zk.close();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        String zkAddress="127.0.0.1:2181,127.0.0.1:2183,127.0.0.1:2185";
        Master master=new Master(zkAddress);
        master.startZK();
        while (true) {
            TimeUnit.SECONDS.sleep(6);
        }
    }
}
