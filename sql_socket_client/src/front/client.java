package front;

import java.io.*;
import java.net.*;

public class client  implements Serializable {

	private static Socket client;
	
	public  String client(String str) throws UnknownHostException, IOException {
		client= new Socket("127.0.0.1", 1100);

		System.out.println("���ӷ������ɹ�");

		InputStream in= client.getInputStream();//�ӿͻ����������������������ڽ�����������

		OutputStream out = client.getOutputStream();//�ӿͻ������������������������������
		
	

		out.write(str.getBytes());//�ͻ������ݷ���
		
		
		System.out.println("���Է���������Ϣ��" +str);

		byte[] bt = new byte[1024];//����һ���ֽ����飬�����洢��������

		int len = in.read(bt);//����������д���ֽ�����

		String data = new String(bt, 0 ,len);//����������ת��Ϊ�ַ�������

		System.out.println("���Է���������Ϣ��" +data);

		client.close();//�ر��׽���
		
		return data;
		
	}
	
	public void communicate() {
		
	}
}
