package JMS_KAFKA_EX2;

import java.util.Properties;

public class SimpleProducer {
    public static void main(String[] args) {
        Properties producerProperties = new Properties();

        producerProperties.put("bootstrap.servers", "localhost:9092");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaProducer<String, String> producer = new KafkaProducer(producerProperties);

        String topicName = args[0].toString();

        producer.send(new ProducerRecord<>(topicName, "myKey", "Message"));
        producer.flush();

        producer.close();
    }
}
