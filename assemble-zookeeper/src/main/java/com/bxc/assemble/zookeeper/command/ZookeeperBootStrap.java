package com.bxc.assemble.zookeeper.command;

import com.bxc.assemble.zookeeper.EmbeddedZooKeeper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Slf4j
@Component
public class ZookeeperBootStrap implements CommandLineRunner {


    @Value("${zookeeper.port:2181}")
    Integer zookeeperPort;


    public static void run(Integer zookeeperPort){
        new EmbeddedZooKeeper(Integer.parseInt(zookeeperPort+""),false).start();
    }

    @Override
    public void run(String... args) throws Exception {
        if(args.length > 0){
            String portStr = StringUtils.split(String.valueOf(args[0]),"=")[1];
            zookeeperPort = Integer.valueOf(portStr);
        }
        ZookeeperBootStrap.run(zookeeperPort);
        log.info("-------------zookeeper server is started:{}-------------",zookeeperPort);
    }
}
