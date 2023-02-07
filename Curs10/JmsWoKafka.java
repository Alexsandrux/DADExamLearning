import javax.jms.*;
import javax.naming.InitialContext;

public class JmsWoKafka {
    public static void main(String[] args) {
        try {
            // Step 1: Create a JNDI Initial Context to lookup the JMS Connection Factory
            // and Destination
            InitialContext context = new InitialContext();
            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("myConnectionFactory");
            Destination destination = (Destination) context.lookup("myDestination");

            // Step 2: Create a JMS Connection
            Connection connection = connectionFactory.createConnection();

            // Step 3: Create a JMS Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Step 4: Create a JMS Message Producer
            MessageProducer producer = session.createProducer(destination);

            // Step 5: Create a Text Message
            TextMessage message = session.createTextMessage("Hello World");

            // Step 6: Send the Message
            producer.send(message);

            // Step 7: Close the JMS Connection
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}