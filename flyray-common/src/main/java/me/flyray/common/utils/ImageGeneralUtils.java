package me.flyray.common.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

/** 
* @author: bolei
* @date：Jul 7, 2017 8:39:09 AM 
* @description：柏拉图性格标签生成器
*/

public class ImageGeneralUtils {

	private Font font = null;// 添加字体的属性设置  
	  
    private Graphics2D g = null;  
  
    private int fontsize = 0;  
  
    private int x = 0;  
  
    private int y = 0;  
    
    private static Font getSelfDefinedFont(String filepath){  
        Font font = null;  
        //配置字体路径
        File file = new File(filepath);  
        try  
        {
            FileInputStream fi = new FileInputStream(file);  
            BufferedInputStream fb = new BufferedInputStream(fi);  
            font = Font.createFont(Font.TRUETYPE_FONT, fb);  
        }catch (FontFormatException e){
            return null;  
        }catch (FileNotFoundException e){  
            return null;  
        }catch (IOException e){  
            return null;  
        }
        font = font.deriveFont(Font.PLAIN, 48);  
        return font;  
    }  
  
    /** 
     * 导入本地图片到缓冲区 
     */  
    public BufferedImage loadImageLocal(String imgName) {  
        try {
        	File imgF = new File(imgName);
        	if (!imgF.getParentFile().exists()) {
        		imgF.setWritable(true, false);
        		imgF.getParentFile().mkdirs();
        	}
            return ImageIO.read(imgF);  
        } catch (IOException e) {  
            System.out.println(e.getMessage());  
        }
        return null;
    }  
  
    /** 
     * 导入网络图片到缓冲区 
     */  
    public BufferedImage loadImageUrl(String imgName) {  
        try {  
            URL url = new URL(imgName);  
            return ImageIO.read(url);  
        } catch (IOException e) {  
            System.out.println(e.getMessage());  
        }  
        return null;  
    }  
  
    /** 
     * 生成新图片到本地 
     */  
    public void writeImageLocal(String newImage, BufferedImage img) {  
        if (newImage != null && img != null) {  
            try {
            	File outputfile = new File(newImage);
            	if (!outputfile.getParentFile().exists()) {
            		outputfile.setWritable(true, false);
            		outputfile.getParentFile().mkdirs();
            	}
                ImageIO.write(img, "jpg", outputfile);  
            } catch (IOException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
    }  
  
    /** 
     * 设定文字的字体等 
     */  
    public void setFont(String fontStyle, int fontSize) {  
        this.fontsize = fontSize;  
        this.font = getSelfDefinedFont(fontStyle);  
    }  
  
    /** 
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本） 
     */  
    public BufferedImage modifyImage(BufferedImage img, Object content, int x,int y,String fontPath) {  
  
        try {  
            int w = img.getWidth();  
            int h = img.getHeight();  
            g = img.createGraphics();  
            g.setBackground(Color.WHITE);  
            g.setColor(Color.black);//设置字体颜色  
            if (this.font == null)  
            	setFont(fontPath,100);
            g.setFont(this.font);  
            // 验证输出位置的纵坐标和横坐标  
            if (x >= h || y >= w) {  
                this.x = h - this.fontsize + 2;  
                this.y = w;  
            } else {  
                this.x = x;  
                this.y = y;  
            }  
            if (content != null) {  
                g.drawString(content.toString(), this.x, this.y);  
            }  
            g.dispose();  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
  
        return img;  
    }  
  
    /** 
     * 修改图片,返回修改后的图片缓冲区（输出多个文本段） xory：true表示将内容在一行中输出；false表示将内容多行输出 
     */  
    public BufferedImage modifyImage(BufferedImage img, Object[] contentArr,  
            int x, int y, boolean xory) {  
        try {  
            int w = img.getWidth();  
            int h = img.getHeight();  
            g = img.createGraphics();  
            g.setBackground(Color.WHITE);  
            g.setColor(Color.RED);  
            if (this.font != null)  
                g.setFont(this.font);  
            // 验证输出位置的纵坐标和横坐标  
            if (x >= h || y >= w) {  
                this.x = h - this.fontsize + 2;  
                this.y = w;  
            } else {  
                this.x = x;  
                this.y = y;  
            }  
            if (contentArr != null) {  
                int arrlen = contentArr.length;  
                if (xory) {  
                    for (int i = 0; i < arrlen; i++) {  
                        g.drawString(contentArr[i].toString(), this.x, this.y);  
                        this.x += contentArr[i].toString().length()  
                                * this.fontsize / 2 + 5;// 重新计算文本输出位置  
                    }  
                } else {  
                    for (int i = 0; i < arrlen; i++) {  
                        g.drawString(contentArr[i].toString(), this.x, this.y);  
                        this.y += this.fontsize + 2;// 重新计算文本输出位置  
                    }  
                }  
            }  
            g.dispose();  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
  
        return img;  
    }  
  
    /** 
     * 修改图片,返回修改后的图片缓冲区（只输出一行文本） 
     *  
     * 时间:2007-10-8 
     *  
     * @param img 
     * @return 
     */  
    public BufferedImage modifyImageYe(BufferedImage img) {  
  
        try {  
            int w = img.getWidth();  
            int h = img.getHeight();  
            g = img.createGraphics();  
            g.setBackground(Color.WHITE);  
            g.setColor(Color.blue);//设置字体颜色  
            if (this.font != null)  
                g.setFont(this.font);  
            g.drawString("www.hi.baidu.com?xia_mingjian", w - 85, h - 5);  
            g.dispose();  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }  
  
        return img;  
    }  
    
    //d 主图片
    public BufferedImage modifyImagetogeter(BufferedImage b, BufferedImage d, int x, int y) {  
  
        try {  
            int w = b.getWidth();  
            int h = b.getHeight();  
            g = d.createGraphics(); 
            //合并图片未知
            //Image img, int x, int y,int width, int height,ImageObserver observer 300, 410
            g.drawImage(b, x, y, w, h, null); 
            g.dispose();  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }
        return d;  
    }
  
    public static void main(String[] args) {  
  
    	ImageGeneralUtils tt = new ImageGeneralUtils();  
  
        BufferedImage d = tt.loadImageLocal("F:/assets/4.jpg");  
//      
         tt.writeImageLocal("F:/assets/test/flyray333.jpg",tt.modifyImage(d,"我是博羸兄弟",120,320,"assets/font1.ttf")  
        //往图片上写文件  
         );
         
         BufferedImage b = tt.loadImageLocal("F:/assets/test/flyray333.jpg");  
         BufferedImage c = tt.loadImageLocal("F:/assets/22.jpg");  
       //将多张图片合在一起  
        tt.writeImageLocal("F:/assets/test/flyray444.jpg", tt.modifyImagetogeter(c, b,300,410));  
        System.out.println("success");  
    }
}
