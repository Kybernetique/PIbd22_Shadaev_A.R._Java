import java.awt.*;
import javax.swing.*;

// Дополнительный класс для отрисовки парусов (усложн.)
public class SailsAdd
{
    private Sails sails;

    public void setSails(int num)
    {
        if (num == 1)
        {
            sails = Sails.One;
        } else if (num == 2)
        {
            sails = Sails.Two;
        } else if (num == 3)
        {
            sails = Sails.Three;
        } else
        {
            JOptionPane.showMessageDialog(null, "Number of sails are greater than 3.\n" +
                    "Number of sails are set to 3 by default.");
            sails = Sails.Three;
        }
    }

    public Sails getSails()
    {
        return this.sails;
    }

    public void draw(Graphics2D g2D, Color color, int x, int y)
    {

        switch (sails)
        {
            case One:
                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));

                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);
                g2D.drawRect(x + 20, y + 10, 70, 20);

                g2D.setColor(color);
                g2D.fillRect(x + 20, y + 10, 70, 20);
                break;
            case Two:
                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));

                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);
                g2D.drawRect(x + 20, y + 10, 70, 20);

                g2D.setColor(color);
                g2D.fillOval(x + 80, y + 10, 20, 20);
                g2D.fillOval(x + 10, y + 10, 20, 20);
                g2D.setColor(new Color(240, 230, 140));
                g2D.fillRect(x + 25, y + 10, 65, 20);
                break;
            case Three:
                g2D.setColor(Color.black);
                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);

                g2D.setColor(color);
                g2D.fillRect(x + 25, y + 10, 65, 20);
                g2D.fillOval(x + 80, y + 10, 20, 20);
                g2D.fillOval(x + 10, y + 10, 20, 20);

                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));

                g2D.drawRect(x + 20, y + 10, 70, 20);
                break;
        }

    }
}
