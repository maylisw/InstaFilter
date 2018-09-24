/*
 Calculates color difference between pixelss
 stores the ones with a distance of 50 in an array
 Changes those to grey and everyting else to clear transparent
*/
import java.io.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.util.ArrayList;

public class Edge extends Final
{
    private SimplePicture picture;
    private HelperClass[] values;
    private ArrayList<HelperClass> h;
    private final Color BLACK = new Color(0, 0, 0, 125);
    private final Color CLEAR = new Color(255, 255, 255, 0);
    /*
     * Calculates color difference between pixelss
     * stores the ones with a distance of 50 in an array
     * Changes those to grey and everyting else to clear transparent
     */
    public Edge(SimplePicture p)
    {
        picture = p;
        h = new ArrayList<>();
        for(int r = 0; r < picture.getWidth(); r ++)
        {
            for(int c = 0; c < picture.getHeight(); c++)
            {
                if(r < 2)
                {
                    //:)
                }
                else if(colorDistance(r, c, r-2, c) > 75)
                {
                    HelperClass n = new HelperClass(r, c);
                    h.add(n);
                }
            }
        }
        values = new HelperClass[h.size()];
        for(int i = 0; i < h.size(); i++ )
        {
            values[i] = h.get(i);
        }

    }

    public SimplePicture edgeize()
    {
        if(values.length > 0){
            for(int r = 0; r < picture.getWidth(); r ++)
            {
                for(int c = 0; c < picture.getHeight(); c++)
                {
                    picture.setBasicPixel(r, c, CLEAR.getRGB());
                }
            }
            for(HelperClass h : values)
            {
                picture.setBasicPixel(h.getX(), h.getY(), BLACK.getRGB());
            }
        }
        return picture;
    }

    /**
     * x1 and y1 are the positions of the first pixel
     * x2 and y2 are the positions of the second pixel
     */
    public double colorDistance(int x1, int y1, int x2, int y2) //fix wih alpha
    {
        int clr1 = picture.getBasicPixel(x1,y1);
        Color c1 = new Color(clr1, true);
        int red1 = c1.getRed();
        int green1 = c1.getGreen();
        int blue1 = c1.getBlue();
        int alpha1 = c1.getAlpha();
        //System.out.println(red1 + " " + green1 + " " + blue1);


        int clr2 = picture.getBasicPixel(x2,y2);
        Color c2 = new Color(clr2, true);
        int red2 = c2.getRed();
        int green2 = c2.getGreen();
        int blue2 = c2.getBlue();
        int alpha2 = c2.getAlpha();
        //System.out.println(red2 + " " + green2 + " " + blue2);

        double redDistance = red1 - red2;
        double greenDistance = green1 - green2;
        double blueDistance = blue1 - blue2;
        double distance = Math.sqrt(redDistance * redDistance +
                greenDistance * greenDistance +
                blueDistance * blueDistance);
        return distance;
    }
}