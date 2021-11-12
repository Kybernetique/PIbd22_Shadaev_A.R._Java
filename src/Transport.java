import java.awt.*;

public abstract class Transport implements ITransport
{
    // Левая координата отрисовки
    protected int _startPosX;

    // Правая координата отрисовки
    protected int _startPosY;

    // Ширина окна отрисовки
    protected int _pictureWidth;

    // Высота окна отрисовки
    protected int _pictureHeight;

    // Максимальная скорость
    public int MaxSpeed;

    protected void setMaxSpeed(int MaxSpeed)
    {
        this.MaxSpeed = MaxSpeed;
    }

    protected int getMaxSpeed()
    {
        return this.MaxSpeed;
    }

    // Вес
    public float Weight;

    protected void setWeight(float Weight)
    {
        this.Weight = Weight;
    }

    protected float getWeight()
    {
        return this.Weight;
    }

    // Основной цвет
    public Color MainColor;

    protected void setMainColor(Color MainColor)
    {
        this.MainColor = MainColor;
    }

    protected Color getMainColor()
    {
        return this.MainColor;
    }

    // Установка позиции
    public void setPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    // Отрисовка
    public abstract void drawTransport(Graphics g);

    // Изменение направления перемещения
    public abstract void moveTransport(Direction direction);

}
