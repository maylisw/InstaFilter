/**
 * c
 */
import java.awt.Color;
public class ColorChange
{
    private SimplePicture picture;
    private Pixel[][] pixels;
    public ColorChange(SimplePicture p)
    {
        picture = p;
    }
    //changes saturation by 200% and makes it more transparent
    public SimplePicture changeMe()
    {
        for (int row = 0; row < picture.getWidth(); row ++)
        {
            for (int col = 0; col < picture.getHeight(); col ++)
            {
                int clr = picture.getBasicPixel(row, col);
                Color c = new Color(clr, true);

                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                int alpha = c.getAlpha();

                float[] hsb = Color.RGBtoHSB(red, green, blue, null);
                float hue = hsb[0];
                float saturation = hsb[1];
                float brightness = hsb[2];
                if(red > 240 && green > 240 && blue > 240)
                    saturation =  saturation*(float)2.0;

                int rgb = Color.HSBtoRGB(hue, saturation, brightness);
                Color c2 = new Color(rgb, true);
                Color color = c2;
                //change alpha in rgb here
                if(alpha > 50)
                    color = new Color(c2.getRed(), c2.getGreen(), c2.getBlue(), c2.getAlpha() - 50);
                rgb = color.getRGB();
                picture.setBasicPixel(row, col, rgb);
            }
        }
        return picture;
    }
}

/*

float[] hsb = Color.RGBtoHSB(red, green, blue, null);

float hue = hsb[0];
float saturation = hsb[1];
float brightness = hsb[2];

/* then change the saturation... *//*

int rgb = Color.HSBtoRGB(hue, saturation, brightness);

red = (rgb>>16)&0xFF;
green = (rgb>>8)&0xFF;
blue = rgb&0xFF;*/