FROM openjdk:8-jre-slim

MAINTAINER 171779852@qq.com

ENV PARAMS=""

ENV TZ=PRC

ENV MINIO_ADDRESS="172.17.0.1"

ENV MYSQL_ADDRESS="172.17.0.2"

ENV NACOS_ADDRESS="172.17.0.3"

ENV GATEWAY_ADDRESS="172.17.0.4:8001"

ENV REDIS_ADDRESS="172.17.0.5"

ENV JAVA_OPTS="-Xms256m -Xmx256m -Xmn128m -Xloggc:./gc/server_gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/assemble-deskConsole.jar /assemble-deskConsole.jar

EXPOSE 8002

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /assemble-deskConsole.jar $PARAMS"]