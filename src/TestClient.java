import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
e
//http://blog.csdn.net/yejin191258966/article/details/17468423
public class TestClient {
	public static void main(String[] args) throws Exception{     
		try {  
			Socket so = new Socket("127.0.0.1",8080);     
	        OutputStream os = so.getOutputStream();  
	        InputStream is = so.getInputStream();
	        PrintStream ps = new PrintStream(os);
	        BufferedReader br = //�ͻ���server��������     
        	        new BufferedReader(new InputStreamReader(is));
	        InputStreamReader isr =      
	            new InputStreamReader(System.in);     
	        BufferedReader key = //�Ӽ��̵�������     
	            new BufferedReader(isr);     
            while(true){  
                //��ȡ���������ص���Ϣ����  
                String data = br.readLine();
                while(true){
                	if(is.available() > 0){
                    	data += br.readLine();
                    }else{
                    	break;
                    }
            	}
                System.out.println(so.getInetAddress().getLocalHost()+":"+so.getPort()+">>"+data);  
                String temp = key.readLine();
                ps.println(temp);//��Ϊserver�õ���readline,������println
            }  
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }     
}
