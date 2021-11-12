import java.awt.*;

public class SailsShapeAdd1 implements InterAdd
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
        switch (sails)
        {
            case One:
                g2D.setColor(color.BLACK);
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);

                g2D.drawLine(x + 25, y + 10, x + 25, y + 30);
                g2D.drawLine(x + 30, y + 10, x + 30, y + 30);
                g2D.drawLine(x + 35, y + 10, x + 35, y + 30);
                g2D.drawLine(x + 40, y + 10, x + 40, y + 30);
                g2D.drawLine(x + 45, y + 10, x + 45, y + 30);
                g2D.drawLine(x + 50, y + 10, x + 50, y + 30);
                g2D.drawLine(x + 55, y + 10, x + 55, y + 30);
                g2D.drawLine(x + 60, y + 10, x + 60, y + 30);
                g2D.drawLine(x + 65, y + 10, x + 65, y + 30);
                g2D.drawLine(x + 70, y + 10, x + 70, y + 30);
                g2D.drawLine(x + 75, y + 10, x + 75, y + 30);
                g2D.drawLine(x + 80, y + 10, x + 80, y + 30);
                g2D.drawLine(x + 85, y + 10, x + 85, y + 30);

                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);
                break;
            case Two:
                g2D.setColor(Color.BLACK);
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);

                g2D.drawLine(x + 12, y + 13, x + 12, y + 27);
                g2D.drawLine(x + 15, y + 12, x + 15, y + 28);
                g2D.drawLine(x + 18, y + 10, x + 18, y + 30);

                g2D.drawLine(x + 92, y + 10, x + 92, y + 30);
                g2D.drawLine(x + 95, y + 12, x + 95, y + 28);
                g2D.drawLine(x + 98, y + 13, x + 98, y + 27);

                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);
                break;
            case Three:
                g2D.setColor(Color.BLACK);
                g2D.drawLine(x + 20, y + 10, x + 90, y + 10);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);

                g2D.drawLine(x + 15, y + 12, x + 15, y + 28);
                g2D.drawLine(x + 20, y + 10, x + 20, y + 30);
                g2D.drawLine(x + 25, y + 10, x + 25, y + 30);
                g2D.drawLine(x + 30, y + 10, x + 30, y + 30);
                g2D.drawLine(x + 35, y + 10, x + 35, y + 30);
                g2D.drawLine(x + 40, y + 10, x + 40, y + 30);
                g2D.drawLine(x + 45, y + 10, x + 45, y + 30);
                g2D.drawLine(x + 50, y + 10, x + 50, y + 30);
                g2D.drawLine(x + 55, y + 10, x + 55, y + 30);
                g2D.drawLine(x + 60, y + 10, x + 60, y + 30);
                g2D.drawLine(x + 65, y + 10, x + 65, y + 30);
                g2D.drawLine(x + 70, y + 10, x + 70, y + 30);
                g2D.drawLine(x + 75, y + 10, x + 75, y + 30);
                g2D.drawLine(x + 80, y + 10, x + 80, y + 30);
                g2D.drawLine(x + 85, y + 10, x + 85, y + 30);
                g2D.drawLine(x + 95, y + 12, x + 95, y + 28);

                g2D.drawLine(x + 90, y + 10, x + 90, y + 30);
                break;

        }
    }
}
