import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.producer.KafkaConsumer;
import org.apache.kafka.clients.producer.ConsumerRecords;
import org.apache.kafka.clients.producer.ConsumerRecord;

public class SimpleProducer {
    public static void main(String args[]) throws Exception {
        Properties producerProperties = new Properties();
        producerProperties.put("bootstrap.servers", "localhost:9092");
        producerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        producerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProperties);

        String topicName = args[0].toString();

        producer.send(new ProducerRecord<>(topicName, "myKey", "Hello World"));
        producer.flush();

        producer.close();

    }
}