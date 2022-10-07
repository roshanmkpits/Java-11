import java.io.IOException;
import java.net.ServerSocket;

//create a server by using serversocket class
//at potnumber 5000
//all client request comming to port number 5000
//read data from client over port
//again echo back
//until client enter exit
  //problem in exixting code in server
//all this problem occur because  everything handled with single main thread
//for every request we created ne thread

public class Server1 {
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(5000)) {
            while(true) {
                new Echoer(serverSocket.accept()).start();
//                Socket socket = serverSocket.accept();
//                Echoer echoer = new Echoer(socket);
//                echoer.start();
            }


        } catch(IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}


//output
//Client Connected
