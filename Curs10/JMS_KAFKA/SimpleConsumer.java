import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public class SimpleConsumer {
    public static void main(String args[]) throws Exception {
        Properties consumerProperties = new Properties();
        consumerProperties.put("bootstrap.servers", "localhost:9092");
        consumerProperties.put("key.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("value.serializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProperties.put("group.id", "myGroup");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(consumerProperties);

        String topicName = args[0].toString();
        consumer.subscribe(Arrays.asList(topicName));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Key: " + record.key() + ", Value: " + record.value());
            }
        }

        consumer.close();

    }
}