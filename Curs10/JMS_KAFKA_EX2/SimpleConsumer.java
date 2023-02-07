package JMS_KAFKA_EX2;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {
    public static void main(String[] args) {
        Properties consumerProperties = new Properties();

        consumerProperties.put("bootstrap.servers", "localhost:9092");
        consumerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("group.id", "myGroup");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProperties);

        String topicName = args[0].toString();
        consumer.subscribe(Arrays.asList(topicName));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
        }

        consumer.close();
    }
}