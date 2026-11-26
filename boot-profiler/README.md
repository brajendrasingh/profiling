A web-based System i.e. REST Services


In IntelliJ: add this in VM Options: -Xms64m -Xmx128m

Using Java -jar: java -Xms64m -Xmx128m -jar build/libs/boot-profiler-0.0.1-SNAPSHOT.jar

Automatically capture heap dump on OutOfMemoryError:
java -Xms64m -Xmx128m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/heapdump.hprof -jar boot-profiler-0.0.1-SNAPSHOT.jar

Capture a heap dump manually using jcmd:

jmap vs jcmd: jmap is used in old java while jcmd in latest jdk


Remote JVM: Add JMX connection: 192.168.0.105:9010



docker inspect boot-profiler --format "{{.HostConfig.Memory}}"

docker compose exec app jcmd

Note: we can set in setting our package to scan/monitor visualvm

Capture thread dumps using Spring Boot Actuator: curl -H "Accept: text/plain" http://localhost:8080/actuator/threaddump