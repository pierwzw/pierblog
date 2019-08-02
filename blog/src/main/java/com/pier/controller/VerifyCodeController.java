package com.pier.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @auther zhongweiwu
 * @date 2019/8/1 14:03
 */
@Slf4j
@Controller
public class VerifyCodeController {

    static Random r = new Random();

    @RequestMapping("/getVerifyCode")
    public void getVerifyCode(HttpServletRequest request, HttpServletResponse response){
        // 创建一个宽100,高50,且不带透明色的image对象 100 50
        int width = 120;
        int height = 40;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.getGraphics();
        //RGB色彩
        Color c = new Color(r.nextInt(100)+155, r.nextInt(100)+155, r.nextInt(100)+155);
        // 框中的背景色
        g.setColor(c);
        // 颜色填充像素
        g.fillRect(0, 0, width, height);
        // 随机画干扰的蛋蛋
        for(int i=0;i<15;i++){
            c = color(150, 250);
            g.setColor(c);
            g.drawOval(num(width), num(height), 5+num(10), 5+num(10));// 画蛋蛋，有蛋的生活才精彩
        }
        // 定义验证码字符数组
        char[] ch = "abcdefghijklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ0123456798".toCharArray();
        int len = ch.length;
        int index;
        StringBuffer sb = new StringBuffer();
        // 取出四个数字
        for (int i = 0; i < 6; i++) {
            // 循环四次随机取长度定义为索引
            index = r.nextInt(len);
            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt(255)));
            Font font = new Font("Times New Roman", Font.ITALIC, 18);
            g.setFont(font);
            g.drawString(ch[index] + "", (i * 18) + 10, 30);
            sb.append(ch[index]);
        }
        //放入Session中
        request.getSession().setAttribute("piccode", sb.toString());
        try {
            ImageIO.write(bi, "JPG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 产生两个数之间的随机数
     * @param min 小数
     * @param max 比min大的数
     * @return int 随机数字
     */
    public static int num(int min, int max) {
        return min + r.nextInt(max - min);
    }

    /**
     * 产生0--num的随机数,不包括num
     * @param num 数字
     * @return int 随机数字
     */
     private static int num(int num)
     {
        return r.nextInt(num);
     }

    /**
     * 给定范围获得随机颜色
     * @return Color 随机颜色
     */
     protected Color color(int fc, int bc) {
       if (fc > 255) {
           fc = 255;
       }
       if (bc > 255) {
           bc = 255;
       }
       int r = fc + num(bc - fc);
       int g = fc + num(bc - fc);
       int b = fc + num(bc - fc);
       return new Color(r, g, b);
     }
}
