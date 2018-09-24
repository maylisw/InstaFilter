/**
 *
 */
import java.awt.image.BufferedImage;
import java.awt.Color;
public class Blur
{
    private SimplePicture picture;
    private SimplePicture p;
    public Blur(SimplePicture pi)
    {
        picture = pi;
        p = pi;
    }

    public SimplePicture blurMe(int amount)
    {
        double redSum = 0;
        double greenSum = 0;
        double blueSum = 0;
        int redAverage = 0;
        int greenAverage = 0;
        int blueAverage = 0;
        // blurs the image by averaging rgb values around every pixel
        for(int row = 0; row < p.getWidth(); row ++)
        {
            for (int col = 0; col < p.getHeight(); col ++)
            {
                int count = 0;
                for (int r = row - amount; r < row + amount; r ++)
                {
                    for(int c = col - amount; c < col + amount; c++)
                    {
                        if(row + amount > p.getWidth() || row - amount < 0 || col + amount > p.getHeight() || col - amount < 0)
                        {
                            if(count == 0){count = 1;}
                            continue;
                        }
                        else
                        {
                            Color color = new Color(p.getBasicPixel(r, c));
                            redSum += color.getRed();
                            greenSum += color.getGreen();
                            blueSum += color.getBlue();
                            count ++;
                        }
                    }
                }
                redAverage = (int) redSum/count;
                greenAverage = (int) greenSum/count;
                blueAverage = (int) blueSum/count;
                //System.out.println(redAverage + " " + greenAverage + " "+ blueAverage);
                Color color = new Color(redAverage, greenAverage, blueAverage);
                redAverage = 0;
                greenAverage = 0;
                blueAverage = 0;
                redSum = 0;
                greenSum = 0;
                blueSum = 0;
                picture.setBasicPixel(row, col, color.getRGB());
            }
        }
        return picture;
    }
}
