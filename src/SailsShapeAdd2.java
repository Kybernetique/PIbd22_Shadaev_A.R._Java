import java.awt.*;

public class SailsShapeAdd2 implements InterAdd
{
    Sails sails;

    @Override
    public void setSails(int num)
    {
        switch (num)
        {
            case 1:
                sails = Sails.One;
                break;
            case 2:
                sails = Sails.Two;
                break;
            case 3:
                sails = Sails.Three;
                break;
        }
    }

    @Override
    public void draw(Graphics2D g2D, Color color, int x, int y)
    {
        g2D.setColor(Color.BLACK);
        switch (sails)
        {
            case One:
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);

                g2D.drawLine(x + 20, y + 15, x + 90, y + 15);
                g2D.drawLine(x + 20, y + 20, x + 90, y + 20);
                g2D.drawLine(x + 20, y + 25, x + 90, y + 25);
                g2D.drawLine(x + 20, y + 30, x + 90, y + 30);

                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);
                break;
            case Two:
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);

                g2D.drawLine(x + 13, y + 13, x + 19, y + 13);
                g2D.drawLine(x + 11, y + 16, x + 19, y + 16);
                g2D.drawLine(x + 11, y + 19, x + 19, y + 19);
                g2D.drawLine(x + 11, y + 22, x + 19, y + 22);
                g2D.drawLine(x + 11, y + 25, x + 19, y + 25);


                g2D.drawLine(x + 91, y + 13, x + 97, y + 13);
                g2D.drawLine(x + 91, y + 16, x + 99, y + 16);
                g2D.drawLine(x + 91, y + 19, x + 99, y + 19);
                g2D.drawLine(x + 91, y + 22, x + 99, y + 22);
                g2D.drawLine(x + 91, y + 25, x + 99, y + 25);


                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);

                break;
            case Three:
                g2D.setColor(color);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);
                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);

                g2D.setColor(Color.BLACK);
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 15, x + 90, y + 15);
                g2D.drawLine(x + 20, y + 20, x + 90, y + 20);
                g2D.drawLine(x + 20, y + 25, x + 90, y + 25);
                g2D.drawLine(x + 20, y + 30, x + 90, y + 30);

                g2D.drawLine(x + 11, y + 25, x + 19, y + 25);
                g2D.drawLine(x + 10, y + 20, x + 20, y + 20);
                g2D.drawLine(x + 11, y + 15, x + 19, y + 15);

                g2D.drawLine(x + 91, y + 25, x + 99, y + 25);
                g2D.drawLine(x + 90, y + 20, x + 100, y + 20);
                g2D.drawLine(x + 91, y + 15, x + 99, y + 15);
                break;

        }
    }
}
