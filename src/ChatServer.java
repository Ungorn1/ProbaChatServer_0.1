import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private static Socket clientSocket1;
    private static Socket clientSocket2;
    private static ServerSocket serverSocket;
    private static BufferedReader in1;
    private static BufferedWriter outt1;
    private static BufferedReader in2;
    private static BufferedWriter outt2;
    static boolean i = false;
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Сервер запущен!");
            clientSocket1 = serverSocket.accept();

            in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
            outt1 = new BufferedWriter(new OutputStreamWriter(clientSocket1.getOutputStream()));
            String word;
            for(; i == false; ){
                //System.out.println("/-----------");
                word = in1.readLine();
                System.out.println(word);
                if(word.equals("exit")){
                    System.out.println("Сервер выключен");
                    serverSocket.close();
                    clientSocket1.close();
                    in1.close();
                    outt1.close();
                }else {
                    outt1.write(word + "\n");
                    outt1.flush();
                }
            }
        }catch (IOException ex){
            System.out.println("ERROR");
        }
    }
}
