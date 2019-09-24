<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page import="javax.imageio.ImageIO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    //随机产生颜色值
    public Color getColor(){
        Random ran = new Random();
        int r = ran.nextInt(256);
        int g = ran.nextInt(256);
        int b = ran.nextInt(256);

        return new Color(r,g,b);//res green blue 三原色
    }

    public String getNum(){
        int ran = (int)(Math.random()*9000)+1000;
        return String.valueOf(ran);
    }
%>

<%
    //禁止缓存防止验证码过期
    response.setHeader("Pragma","no-cache");
    response.setHeader("Cache-control","no-cache");
    response.setHeader("Expires","0");
    //绘制验证码
    BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_BGR);
    //画笔
    Graphics graphics = image.getGraphics();
    graphics.fillRect(0,0,80,30);
    //绘制干扰线条
    for(int i = 0; i<60;i++){
        Random ran = new Random();
       int xBegin = ran.nextInt(80);
       int yBegin = ran.nextInt(30);
       int xEnd = ran.nextInt(xBegin+10);
       int yEnd = ran.nextInt(yBegin+10);
       //线条颜色
       graphics.setColor(getColor());
       //绘制线条
       graphics.drawLine(xBegin,yBegin,xEnd,yEnd);
    }
	graphics.setFont(new Font("seif",Font.BOLD,20));
    //绘制验证码
    graphics.setColor(Color.BLACK);
    String checkCode = getNum();
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i<checkCode.length();i++){
        sb.append(checkCode.charAt(i));
    }
    //绘制验证码
    graphics.drawString(sb.toString(),15,20);
    //将验证码真实值 保存session中
    session.setAttribute("CKECKCODE",checkCode);
    //真实产生图片
    ImageIO.write(image,"jpeg",response.getOutputStream());
    //关闭
    out.clear();
    out=pageContext.pushBody();



%>
