package socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)
    {
        try {
            ServerSocket server = new ServerSocket(8081 );


            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            Socket socket = server.accept();

            System.out.println("Client connected!");

            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

//            String result = in.readUTF();
//
//            System.out.println(result);

            byte[] result = in.readAllBytes();
//            for (byte b: result) {
//                result_word += ;
//            }


            System.out.println(new String(result));



            in.close();

            socket.close();

            server.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
