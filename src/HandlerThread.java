import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class HandlerThread{
	public static final String IP_ADDR = "localhost";//��������ַ   
    public static final int PORT = 8080; //�������˿ں�    
    
    public static void main(String[] args) throws UnknownHostException, IOException { 
    	//����һ�����׽��ֲ��������ӵ�ָ�������ϵ�ָ���˿ں�  
    	 Socket socket = new Socket(IP_ADDR, PORT);
    	while (true) {    
            
            try {  
                //��ȡ������������    
                DataInputStream input = new DataInputStream(socket.getInputStream());    
                //��������˷�������    
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());    
                System.out.print("������: \t");    
                String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
                out.writeUTF(str);    
                    
                String ret = input.readUTF();     
                System.out.println("�������˷��ع�������: " + ret);    
                // ����յ� "OK" ��Ͽ�����    
                if ("OK".equals(ret)) {    
                    System.out.println("�ͻ��˽��ر�����");    
                    Thread.sleep(500);    
                    break;    
                }    
                  
                  
            } catch (Exception e) {  
                System.out.println("�ͻ����쳣:" + e.getMessage());   
            } finally {  
                if (socket != null) {  
                    try {  
                        socket.close();  
                    } catch (IOException e) {  
                        socket = null;   
                        System.out.println("�ͻ��� finally �쳣:" + e.getMessage());   
                    }  
                }  
            }  
        }    
    }

}
