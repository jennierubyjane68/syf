package front;

import java.io.*;
import java.net.*;

public class client  implements Serializable {

	private static Socket client;
	
	public  String client(String str) throws UnknownHostException, IOException {
		client= new Socket("127.0.0.1", 1100);

		System.out.println("连接服务器成功");

		InputStream in= client.getInputStream();//从客户端生成网络输入流，用于接收网络数据

		OutputStream out = client.getOutputStream();//从客户端生成网络输出流，用来发送数据
		
	

		out.write(str.getBytes());//客户端数据发送
		
		
		System.out.println("来自服务器的消息：" +str);

		byte[] bt = new byte[1024];//定义一个字节数组，用来存储网络数据

		int len = in.read(bt);//将网络数据写入字节数组

		String data = new String(bt, 0 ,len);//将网络数据转换为字符串数据

		System.out.println("来自服务器的消息：" +data);

		client.close();//关闭套接字
		
		return data;
		
	}
	
	public void communicate() {
		
	}
}
