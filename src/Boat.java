import java.awt.*;

// Класс "Лодка"
public class Boat
{
    // Дополнительный класс для отрисовки парусов (усложн.)
    SailsAdd sailsAdd = new SailsAdd();

    // Левая координата отрисовки лодки
    private int _startPosX;

    // Правая координата отрисовки лодки
    private int _startPosY;

    // Ширина окна отрисовки
    private int _pictureWidth;

    // Высота окна отрисовки
    private int _pictureHeight;

    // Ширина отрисовки лодки
    private final int boatWidth = 200;

    // Высота отрисовки лодки
    private final int boatHeight = 40;

    // Максимальная скорость
    private int MaxSpeed;

    // Сеттер для поля "MaxSpeed"
    public void setMaxSpeed(int MaxSpeed)
    {
        this.MaxSpeed = MaxSpeed;
    }

    // Геттер для поля "MaxSpeed"
    public int getMaxSpeed()
    {
        return this.MaxSpeed;
    }

    // Вес лодки
    private float Weight;

    // Сеттер для поля "Weight"
    public void setWeight(float Weight)
    {
        this.Weight = Weight;
    }

    // Геттер для поля "Weight"
    public float getWeight()
    {
        return this.Weight;
    }

    // Основной цвет
    private Color MainColor;

    // Сеттер для поля "MainColor"
    public void setMainColor(Color MainColor)
    {
        this.MainColor = MainColor;
    }

    // Геттер для поля "MainColor"
    public Color getMainColor()
    {
        return this.MainColor;
    }

    // Дополнительный цвет
    private Color SecondaryColor;

    // Сеттер для поля "SecondaryColor"
    public void setSecondaryColor(Color SecondaryColor)
    {
        this.SecondaryColor = SecondaryColor;
    }

    // Геттер для поля "SecondaryColor"
    public Color getSecondaryColor()
    {
        return this.SecondaryColor;
    }

    // Признак наличия передней части
    private boolean Front;

    // Сеттер для поля "Front"
    public void setFront(boolean Front)
    {
        this.Front = Front;
    }

    // Геттер для поля "Front"
    public boolean getFront()
    {
        return this.Front;
    }

    // Признак наличия задней части
    private boolean Back;

    // Сеттер для поля "Back"
    public void setBack(boolean Back)
    {
        this.Back = Back;
    }

    // Геттер для поля "Back"
    public boolean getBack()
    {
        return this.Back;
    }

    // Признак наличия якоря
    private boolean Anchor;

    // Сеттер для поля "Anchor"
    public void setAnchor(boolean Anchor)
    {
        this.Anchor = Anchor;
    }

    // Геттер для поля "Anchor"
    public boolean getAnchor()
    {
        return this.Anchor;
    }

    // Признак наличия паруса
    private boolean Sails;

    // Сеттер для поля "Sails"
    public void setSails(boolean sails)
    {
        this.Sails = sails;
    }

    // Геттер для поля "Sails"
    public boolean getSails()
    {
        return this.Sails;
    }

    // Инициализация свойств
    public void init(int maxSpeed, float weight, Color mainColor, Color secondaryColor, boolean front, boolean back,
                     boolean anchor, boolean sails, int sailsNum)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        SecondaryColor = secondaryColor;
        Front = front;
        Back = back;
        Anchor = anchor;

        Sails = sails;
        sailsAdd.setSails(sailsNum); // Установить количество парусов (1, 2, 3) (усложн.)
    }

    // Установка позиции лодки
    public void setPosition(int x, int y, int width, int height)
    {
        _startPosX = x;
        _startPosY = y;
        _pictureWidth = width;
        _pictureHeight = height;
    }

    // Изменение направления перемещения
    public void moveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // Вправо
            case Right:
                if (_startPosX + step < _pictureWidth - boatWidth)
                {
                    _startPosX += step;
                }
                break;

            // Влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;

            // Вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;

            // Вниз
            case Down:
                if (_startPosY + step < _pictureHeight - boatHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }

    // Отрисовка лодки
    public void drawTransport(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;

        // Отрисовка границ лодки
        g2D.setColor(Color.BLACK);
        g2D.drawLine(_startPosX, _startPosY, _startPosX + 100, _startPosY);
        g2D.drawLine(_startPosX + 100, _startPosY, _startPosX + 160, _startPosY + 20);
        g2D.drawLine(_startPosX + 160, _startPosY + 20, _startPosX + 100, _startPosY + 40);
        g2D.drawLine(_startPosX + 100, _startPosY + 40, _startPosX, _startPosY + 40);
        g2D.drawLine(_startPosX, _startPosY + 40, _startPosX, _startPosY);
        g2D.drawLine(_startPosX + 25, _startPosY + 10, _startPosX + 25, _startPosY + 30);
        g2D.drawLine(_startPosX + 90, _startPosY + 10, _startPosX + 90, _startPosY + 30);
        g2D.drawOval(_startPosX + 10, _startPosY + 10, 20, 20);
        g2D.drawOval(_startPosX + 80, _startPosY + 10, 20, 20);
        g2D.drawRect(_startPosX + 20, _startPosY + 10, 70, 20);

        // Заливка границ лодки
        g2D.setColor(new Color(139, 69, 19)); // Saddle Brown
        int[] ptsX = {
                _startPosX + 100, _startPosX + 160, _startPosX + 100
        };
        int[] ptsY = {
                _startPosY, _startPosY + 20, _startPosY + 40
        };
        g2D.fillPolygon(ptsX, ptsY, 3);
        g2D.fillRect(_startPosX, _startPosY, 100, 40);

        g2D.setColor(MainColor);
        g2D.fillOval(_startPosX + 80, _startPosY + 10, 20, 20);
        g2D.fillOval(_startPosX + 10, _startPosY + 10, 20,
                20);
        g2D.fillRect(_startPosX + 25, _startPosY +
                10, 65, 20);

        // Передняя часть лодки
        if (Front)
        {
            g2D.setColor(Color.BLACK);
            g2D.setStroke(new BasicStroke(1));

            // Массив точек для заливки границ передней части
            int[] ptsFrontX = {
                    _startPosX + 200, _startPosX + 150, _startPosX + 160, _startPosX + 150
            };
            int[] ptsFrontY = {
                    _startPosY + 20, _startPosY + 15, _startPosY + 20, _startPosY + 25
            };

            g2D.setColor(MainColor);
            g2D.fillPolygon(ptsFrontX, ptsFrontY, 4);

            // Отрисовка границ передней части
            g2D.setColor(Color.BLACK);
            g2D.drawLine(_startPosX + 160, _startPosY + 20, _startPosX + 200, _startPosY + 20);
            g2D.drawLine(_startPosX + 200, _startPosY + 20, _startPosX + 150, _startPosY + 15);
            g2D.drawLine(_startPosX + 200, _startPosY + 20, _startPosX + 150, _startPosY + 25);
        }

        // Задняя часть лодки
        if (Back)
        {
            g2D.setColor(MainColor);
            g2D.setStroke(new BasicStroke(2));

            // Отрисовка задней части
            g2D.drawLine(_startPosX, _startPosY, _startPosX - 20, _startPosY);
            g2D.drawLine(_startPosX, _startPosY + 40, _startPosX - 20, _startPosY + 40);
        }

        // Якорь
        if (Anchor)
        {
            g2D.setColor(SecondaryColor);
            g2D.setStroke(new BasicStroke(2));

            // Отрисовка якоря
            g2D.drawLine(_startPosX + 160, _startPosY + 20, _startPosX + 160, _startPosY + 40);
            g2D.drawLine(_startPosX + 160, _startPosY + 25, _startPosX + 162, _startPosY + 25);
            g2D.drawLine(_startPosX + 160, _startPosY + 25, _startPosX + 158, _startPosY + 25);
            g2D.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 165, _startPosY + 35);
            g2D.drawLine(_startPosX + 160, _startPosY + 40, _startPosX + 155, _startPosY + 35);
        }

        // Паруса
        if (Sails)
        {
            sailsAdd.draw(g2D, SecondaryColor, _startPosX, _startPosY);
        }
    }
}
