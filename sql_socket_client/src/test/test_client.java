package test;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class test_client {
	private static Socket client;
	
	public static void main(String[] args) throws IOException{
		client= new Socket("127.0.0.1", 1100);

		System.out.println("���ӷ������ɹ�");

		InputStream in= client.getInputStream();//�ӿͻ����������������������ڽ�����������

		OutputStream out = client.getOutputStream();//�ӿͻ������������������������������
		
	

		out.write("h,h,h".getBytes());//�ͻ������ݷ���
		
		
		System.out.println("���Է���������Ϣ��" +"hhh");

		byte[] bt = new byte[1024];//����һ���ֽ����飬�����洢��������

		int len = in.read(bt);//����������д���ֽ�����

		String data = new String(bt, 0 ,len);//����������ת��Ϊ�ַ�������

		System.out.println("���Է���������Ϣ��" +data);

		client.close();//�ر��׽���
		
	
		
	}
}