FROM openjdk:8-jre-slim

MAINTAINER 171779852@qq.com

ENV PARAMS=""

ENV TZ=PRC

ENV JAVA_OPTS="-Xms256m -Xmx256m -Xmn128m -Xloggc:./gc/server_gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M"

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ADD target/assemble-generateCode-1.0.0.jar /assemble-generateCode.jar

EXPOSE 8899

ENTRYPOINT ["sh","-c","java -jar $JAVA_OPTS /assemble-generateCode.jar $PARAMS"]