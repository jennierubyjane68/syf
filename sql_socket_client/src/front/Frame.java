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
    //声明一个新的Image对象，即第二缓存
    private Graphics gOffScreen = null;
    private Image img1;//加载背景图片
    
    private final int WIDTH=860;//设置窗体的宽
    private final int HEIGHT=600;//设置窗体的高
    
    public Frame(String str){
		// TODO Auto-generated constructor stub
	
		setSize(WIDTH,HEIGHT);//设置窗体的宽和
		
		
		File d = new File("封面图片.jpg");//建立文件对象
		try {//文件操作放在错误处理块中
			img1 = ImageIO.read(d);//从文件中读取图像
		} catch (IOException e) {
			e.printStackTrace();
		}	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			
		setVisible(true);
    }
    
    public void paint(Graphics g){
		//第一次使用offScreenImage时创建它，即第二缓存，后续的绘制内容全部绘制在第二缓存中
        if(offScreenImage == null) {  
        	//截取窗体所在位置的图片
            offScreenImage = this.createImage(WIDTH,HEIGHT); 
            //获得截取图片的画布
            gOffScreen = offScreenImage.getGraphics();  
        }
        //清除屏幕   
        super.paint(gOffScreen); 
        Color c = gOffScreen.getColor();  
        gOffScreen.setColor(Color.BLACK);  
        gOffScreen.fillRect(0, 0, WIDTH, HEIGHT); 
        gOffScreen.setColor(c);
        // 调用父类的重绘方法，防止再从最底层来重绘
        gOffScreen.drawImage(img1	, 0, 0, WIDTH, HEIGHT,0, 0,WIDTH, HEIGHT, null);
        g.drawImage(offScreenImage, 0, 0, null);
}
}
