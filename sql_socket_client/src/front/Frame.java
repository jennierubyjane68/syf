package front;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Frame extends JFrame{
	private Image offScreenImage = null; 
    //����һ���µ�Image���󣬼��ڶ�����
    private Graphics gOffScreen = null;
    private Image img1;//���ر���ͼƬ
    
    private final int WIDTH=860;//���ô���Ŀ�
    private final int HEIGHT=600;//���ô���ĸ�
    
    public Frame(String str){
		// TODO Auto-generated constructor stub
	
		setSize(WIDTH,HEIGHT);//���ô���Ŀ��
		
		
		File d = new File("����ͼƬ.jpg");//�����ļ�����
		try {//�ļ��������ڴ��������
			img1 = ImageIO.read(d);//���ļ��ж�ȡͼ��
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		setVisible(true);
    }
    
    public void paint(Graphics g){
		//��һ��ʹ��offScreenImageʱ�����������ڶ����棬�����Ļ�������ȫ�������ڵڶ�������
        if(offScreenImage == null) {  
        	//��ȡ��������λ�õ�ͼƬ
            offScreenImage = this.createImage(WIDTH,HEIGHT); 
            //��ý�ȡͼƬ�Ļ���
            gOffScreen = offScreenImage.getGraphics();  
        }
        //�����Ļ   
        super.paint(gOffScreen); 
        Color c = gOffScreen.getColor();  
        gOffScreen.setColor(Color.BLACK);  
        gOffScreen.fillRect(0, 0, WIDTH, HEIGHT); 
        gOffScreen.setColor(c);
        // ���ø�����ػ淽������ֹ�ٴ���ײ����ػ�
        gOffScreen.drawImage(img1	, 0, 0, WIDTH, HEIGHT,0, 0,WIDTH, HEIGHT, null);
        g.drawImage(offScreenImage, 0, 0, null);
}
}
