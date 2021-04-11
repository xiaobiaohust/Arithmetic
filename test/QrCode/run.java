package QrCode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Base64;
public class run {
    public static void overlapImage(String backgroundPath, String qrCodePath, String message, String outPutPath) throws IOException {

        // 设置背景图片大小
        BufferedImage backgroundImage = resizeImage(566, 230, ImageIO.read(new File(backgroundPath)));
        // 设置二维码图片大小
        BufferedImage qrCodeImage = resizeImage(150, 150, ImageIO.read(new File(qrCodePath)));

        Graphics2D graphics = backgroundImage.createGraphics();

        // 在背景图片上添加文字
        graphics.setColor(Color.white);
        graphics.setFont(new Font("微软雅黑", Font.BOLD, 20));
        graphics.drawString(message, 100, 40);

        // 在背景图片上添加二维码图片
        graphics.drawImage(qrCodeImage, 210, 60, qrCodeImage.getWidth(), qrCodeImage.getHeight(), null);
        graphics.dispose();

        // 输出新的图片
        ImageIO.write(backgroundImage, "png", new File(outPutPath));
    }

    private static BufferedImage resizeImage(int width, int height, BufferedImage bufferedImage) {
        BufferedImage newBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        newBufferedImage.getGraphics().drawImage(bufferedImage.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        return newBufferedImage;
    }

    /**
     * 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
     */
    public static String imageToBase64(String path) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(path);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码 JDK8以上
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(data);// 返回Base64编码过的字节数组字符串
    }

    /**
     * 对字节数组字符串进行Base64解码并生成图片
     */
    public static boolean base64ToImage(String base64, String path) {// 对字节数组字符串进行Base64解码并生成图片
        if (base64 == null) { // 图像数据为空
            return false;
        }
        // JDK8以上
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] bytes = decoder.decode(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {// 调整异常数据
                    bytes[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(path);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void main(String[] args) {
        String backgroundPath = "C:\\Users\\xiaobiao\\Desktop\\背景.png";
        String QRcodePath = "C:\\Users\\xiaobiao\\Desktop\\二维码.png";
        String message = "我是小标";
        String outPutPath = "C:\\Users\\xiaobiao\\Desktop\\合成.png";
        try {
            // 生成二维码图片
            String text = "https://cn.bing.com/?ensearch=1";
            QRcode.encode(text, "C:\\Users\\xiaobiao\\Desktop\\必应.png", "C:\\Users\\xiaobiao\\Desktop\\二维码.png", true);
            //指定二维码图片，解析返回数据
            //System.out.println(QRcode.decode("D:/WPS/75040887.jpg"));

            // 将二维码，头像文字等合成最终的图像
            overlapImage(backgroundPath, QRcodePath, message, outPutPath);

            // 将图像进行base64编码解码
            String encodeStr = imageToBase64(outPutPath);
            System.out.println("Base64:" + encodeStr);
            System.out.println(base64ToImage(encodeStr, "C:\\Users\\xiaobiao\\Desktop\\合成1.png"));

        } catch (IOException exception) {
            System.out.println("IO 读取异常");
        } catch (Exception exception) {
            System.out.println("exception异常");
        }


    }

}
