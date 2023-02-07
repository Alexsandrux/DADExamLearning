package socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args)
    {
        try {
            Socket socket = new Socket("127.0.0.1", 8081);

            DataOutputStream out = new DataOutputStream(
                    socket.getOutputStream());

//            out.writeUTF("Hello!");
            out.writeBytes("Hello!");

            out.close();

            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
