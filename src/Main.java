
import org.omg.CORBA.portable.UnknownException;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Main {
    private static final int sendingInterval = 10000;

    public static void main(String[] args) {
        int portNumber = 4444;
        String hostName = "localhost";
       while(true){
           try (
               Socket socket=new Socket("127.0.0.1",portNumber);
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);){

               try {

                   Thread.sleep(sendingInterval);

               } catch (InterruptedException e) {
                   System.out.println(e);
                   e.printStackTrace();
               }

           }catch (UnknownHostException e){
               System.err.println("Don't know about host " + hostName);
           }
           catch (IOException e){
               e.printStackTrace();
               System.out.println("Couldn't get I/O for the connection to " + hostName + ". Retrying...");
           }

       }

    }


}
