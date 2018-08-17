# Overview

This is a simple poc using jms with [activeMq] and an abstraction provided by [spring].

# Start

* Run `docker run --name='activemq' -d -P webcenter/activemq:latest`
* Run `mvn spring-boot:run`

[activeMq]: http://activemq.apache.org
[spring]: https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-messaging.html