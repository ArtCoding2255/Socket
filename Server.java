import java.net.*;
import java.io.*;
import java.io.IOException;  
import java.io.InputStream;  

public class Server {

   
   
    //display
	static String display(int not)
	{  
        String message;
        if(not == 1)
        {
           message = "Your result is :  Words are not Anagram";	
        }
        else
        {
           message = "Your result is :  Words are  Anagram";	
        }
        return message;
	}
    

    //anagram method
    public static int anagram(String wrd1,String wrd2){
        
        char[] ch1 = wrd1.toCharArray();
        char[] ch2 = wrd2.toCharArray();
        int found=0,not_sound=0; 
        int not = 0;
        
        
        //Convert
        for(int i=0;i<wrd1.length();i++){
            ch1[i] = Character.toUpperCase(ch1[i]); 

        }
        for(int i=0;i< wrd2.length();i++){
            ch2[i] = Character.toUpperCase(ch2[i]);
        }

     
        //Check equalvalent of number of String
        if(wrd1.length()==wrd2.length()){
            for(int  i=0;i<wrd1.length();i++){
               
                found = 0; 
                for(int j=0;i<wrd2.length();j++){
                    if(ch1[i] == ch2[j])
                    {
                        found = 1;
                        break;
                    }

                }
                if(found == 0)
                {
                    not_sound = 1;
                    break;
                }
                if(not_sound == 1){
                    not = 1;
                }
                else{
                    not = 0;
                }
            }
        }
        else {
             not = 1;
        }

    return not;

    }
   
    /* anagram(String str){ */
    public static void main(String[] args){
		try {

            // create a socket at port # 6789
            ServerSocket ss = new ServerSocket(6789);  // create a socket
            System.out.println("A socket is created and now waiting for connection.");

            // establish and wait for an incoming connection
            Socket s = ss.accept();
            System.out.println("A client has made a connection in.");

            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // wait for input message and display it
            //send to client
            System.out.println("I will send the message to receive words from CLient");
            
            //send to client fill 1 st word
            String str1 = "Please,fill 1 st word :  ";   
            dout.writeUTF(str1);
            //receive 1 st word form client
            String wrd1 = (String)din.readUTF();  

            //send to client fill 2 nd word
            String str2 = "Please,fill 2 nd word :  ";   
            dout.writeUTF(str2);
            //receive 2 nd word form client
            String wrd2 = (String)din.readUTF();
            
            String  message  = display(anagram(wrd1,wrd2));
            System.out.println("Now server is going to sent the result");
            dout.writeUTF(message);

        } 
		catch (IOException e) { 
            System.out.println(e);
        }
	
	}
}
    
       

