import java.awt.*;
import javax.swing.*;

// Класс для отрисовки изображения на форме
public class MyImage extends JComponent
{
    private Graphics2D g2D;
    Image image;
    public MyImage() { super(); }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g2D = (Graphics2D) g;
        g2D.drawImage(image, 0, 0, this);
    }
}
