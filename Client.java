import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
   
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        try {
            // create a socket to a local host with port # 6789
            Socket s = new Socket("172.19.96.1", 6789);
            
            System.out.println("A connection is established and I'll now send a message");

            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());

            //Thread.sleep(5000);
            
            String str = (String) din.readUTF();
            System.out.println(str);
            //inout 1
            String input1 = input.nextLine();
            dout.writeUTF(input1);

            String str2 = (String) din.readUTF();
            System.out.println(str2);
            //inout 2
            String input2 = input.nextLine();
            dout.writeUTF(input2);


            //result
            String result = (String) din.readUTF();
            System.out.println(result);  
            
            
            dout.flush();
            dout.close();
            s.close();

        } 
        catch (IOException e) 
        { System.out.println(e); 
        }
    }
}
