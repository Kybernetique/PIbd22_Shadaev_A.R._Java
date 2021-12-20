import javax.swing.*;
import java.awt.*;

public abstract class Vehicle extends JPanel implements ITransport
{
    // Левая координата отрисовки лодки
    protected int _startPosX;

    // Правая координата отрисовки лодки
    protected int _startPosY;

    // Ширина окна отрисовки
    protected int _pictureWidth;

    // Высота окна отрисовки
    protected int _pictureHeight;

    public void setPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    public abstract void moveTransport(Direction direction);

    public abstract void drawTransport(Graphics g);
}

