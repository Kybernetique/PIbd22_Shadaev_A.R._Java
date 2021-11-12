import java.awt.*;

public class Sailboat extends Boat
{
    // Дополнительный класс для отрисовки парусов (усложн.)
    InterAdd interAdd;

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
    public Sailboat(int maxSpeed, float weight, Color mainColor, Color secondaryColor, boolean front, boolean back,
                    boolean anchor, boolean sails, int sailsNum, int sailsShape)
    {
        super(maxSpeed, weight, mainColor, 200, 40);
        switch (sailsShape)
        {
            case 1: // Vertical
                interAdd = new SailsShapeAdd1();
                break;
            case 2: // Horizontal
                interAdd = new SailsShapeAdd2();
                break;
            case 3:
                interAdd = new SailsAdd();
                break;
        }
        interAdd.setSails(sailsNum);

        this.SecondaryColor = secondaryColor;
        this.Front = front;
        this.Back = back;
        this.Anchor = anchor;
        this.Sails = sails;
    }

    @Override
    public void drawTransport(Graphics g)
    {
        super.drawTransport(g);
        Graphics2D g2D = (Graphics2D) g;

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
            interAdd.draw(g2D, SecondaryColor, _startPosX, _startPosY);
        }
    }
}
