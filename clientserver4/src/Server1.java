import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//create a server by using serversocket class
//at potnumber 5000
//all client request comming to port number 5000
//read data from client over port
//again echo back
//until client enter exit
  //problem in exixting code in server
//does not show if multiple the client connected
//we have to input sting in both client
//one solution is delay the one client

public class Server1 {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {


            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client Connected");
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                String echoString = input.readLine();
                try {
                    Thread.sleep(15000);
                }catch (Exception r){
                    System.out.println(r.getMessage());
                }
                if(echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}


//output
//Client Connected
