

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Final
{
    //puts everything together shows it as a JFrame
    public static void main(String[] args)
    {
        SimplePicture p = new SimplePicture("src/imagesrc/sign.jpg");
        p.show();
        SimplePicture pic = new SimplePicture(p);
        SimplePicture pic2 = new SimplePicture(p);
        SimplePicture pic3 = new SimplePicture(p);

        ColorChange c = new ColorChange(pic);
        pic = c.changeMe();
        //pic.show();

        Blur b = new Blur(pic);
        pic = b.blurMe(2);
        //pic.show();

        Edge e = new Edge(pic3);
        pic3 = e.edgeize();

        pic.load(pic3.getBufferedImage());


        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(pic.getBufferedImage())));
        //frame.getContentPane().add(new JLabel(new ImageIcon(pic2.getBufferedImage())));
        frame.pack();
        frame.setVisible(true);

    }
}