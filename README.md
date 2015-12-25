# Mastering Camel

### What is Apache Camel? ###

- Apache Camel is a mediation framework
- Apache Camel allows you to integrate Systems and that comes with a lot of connectors
- Apache Camel has a lot of **Enterprise Integration Patterns** (EIP) out of the box
- Apache Camel originated Apache ServiceMix
- JBI specification works with: 
  - Endpoints are transportedin the **Normalized Messages Router** (NMR)
  - NRM has a standard XML format (problem with performance -> marshal and unmarshal)
  - You can transport any kind of messages in Camel (payload-agnostic)
  - JBI is not very flexible
  
### Components and bean support ###

- A lot of connectivity components: FTP, HTTP, JMX, JMS, WebServices, etc
- Components applying **transformation** or **validation**
- Camel supports IoC frameworks as Spring or Blueprint

### Predicates and Expressions ###

- The rule for mediation (transformation or validation) is called **expression**
- An expression returns any kind of value
- A Predicate returns true or false only
- For instance, Camel supports xpath, mven, ognl, python, ruby, PHP, JavaScript, SpEL, Groovy and so on as expression languages

### Data formats and type conversions ###

- Camel can marshal and unmarshal a message in a given format
- Supports JVM standard serialization
- Supports Avro, JSON, protobuf, JAX-B, XmlBeans, XStream, JiBX, SOAP and so on
- Allows a transformation from one format to another
- We can just write our own converter. IT's a simple POJO to implement

### Lightweight and differente deployments topologies ###

- Camel itself is very light. The Camel core is only around 2MB and contains everything required to run Camel
- You can install and use only what you need
- Moreover, Camel is not tied with an container for deployment. You can use:
  - Server Applications as JBoss, WebSphere, WebLogic and son on
  - Web Container, such as Apache Tomcat
  - An OSGi container, such as Apache Karaf
  - A standalone application using frameworks as Spring
  
### Quick prototyping and testing support ###

- Camel supports mock for another system or endpoint
- Mocking support is directly part of the Camel core
- We can use a continuous integration plataform with Camel
