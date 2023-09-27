package com.bxc.assemble.sharding.install;

import cn.hutool.core.net.NetUtil;
import org.apache.shardingsphere.api.config.sharding.KeyGeneratorConfiguration;

import java.lang.management.ManagementFactory;
import java.util.Properties;

public interface ShardingLogicTableIntaller<P1,P2,R> {

    /**
     * 安装数据
     */
    R install(P1 param, P2 param2);

    /**
     * 卸载数据
     */
    R unInstall(P1 param, P2 param2);


    /**
     * 主键生成策略机制
     * @return
     */
    static KeyGeneratorConfiguration getKeyGeneratorConfigurationForLogicTable(String type, String column, Properties keyGeneratorProp) {
        return new KeyGeneratorConfiguration(type, column, keyGeneratorProp);
    }

    /**
     * 主键生成策略机制
     * @return
     */
    static KeyGeneratorConfiguration getKeyGeneratorConfigurationForLogicTable(String type, String column) {
        return getKeyGeneratorConfigurationForLogicTable(type, column, getKeyGeneratorProperties());
    }

    /**
     * 主键生成策略机制
     * @return
     */
    static KeyGeneratorConfiguration getKeyGeneratorConfigurationForLogicTable(String column) {
        return getKeyGeneratorConfigurationForLogicTable("SNOWFLAKE", column, getKeyGeneratorProperties());
    }

    /**
     * 主键操作的生成策略
     * @return
     */
    static KeyGeneratorConfiguration getKeyGeneratorConfigurationForDefault() {
        Properties keyGeneratorProp = getKeyGeneratorProperties();
        return getKeyGeneratorConfigurationForLogicTable("SNOWFLAKE", "id", keyGeneratorProp);
    }


    /**
     * 生成键值相关的generator的配置信息控制
     * @return
     */
    static Properties getKeyGeneratorProperties() {
        Properties keyGeneratorProp = new Properties();
        String distributeProcessIdentify = NetUtil.getLocalhost() + ":" + getProcessId();
        String workId = String.valueOf(convertString2Long(distributeProcessIdentify));
        keyGeneratorProp.setProperty("worker.id", workId);
        //log.info("shardingsphere init", "shardingsphere work id raw string is {}, work id is {}", distributeProcessIdentify, workId);
        return keyGeneratorProp;
    }


    /**
     * 常见相关的workerid和dataid对应相关的进程id
     * @return
     */
    static String getProcessId(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];
        return pid;
    }

    /**
     * 转换字符串成为相关的long类型
     * @param str
     * @return
     */
    static Long convertString2Long(String str){
        long hashCode = str.hashCode() + System.currentTimeMillis();
        if(hashCode < 0){
            hashCode = -hashCode;
        }
        return hashCode % (1L << 10);
    }

}
