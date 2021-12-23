package com.xk.controller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet(urlPatterns = "/selectcodeimg")
public class SelectCodeImgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image=new BufferedImage(80,30,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=image.getGraphics();

        Random random=new Random();

        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g.fillRect(0,0,80,30);
        Integer num=random.nextInt(8999)+1000;

        g.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g.setFont(new Font("微软雅黑",Font.BOLD,20));
        g.drawString(String.valueOf(num),18,22);

        HttpSession session=req.getSession();
        session.setAttribute("code",num);

        resp.setContentType("image/jpeg");

        ServletOutputStream outputStream=resp.getOutputStream();
        ImageIO.write(image,"jpeg",outputStream);
        outputStream.close();
    }
}
