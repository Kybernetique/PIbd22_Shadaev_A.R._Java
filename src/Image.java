import java.awt.*;
import javax.swing.*;

// Класс для отрисовки изображения на форме
public class Image extends JComponent
{
    private Graphics2D g2D;

    public Image()
    {
        super();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        g2D = (Graphics2D) g;

        g2D.setColor(Color.WHITE);
        g2D.fillRect(0, 0, getWidth(), getHeight());
    }
}
