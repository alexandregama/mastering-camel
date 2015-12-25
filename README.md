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
