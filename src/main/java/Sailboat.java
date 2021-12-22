import java.awt.*;
import java.util.Iterator;

public class Sailboat extends Boat implements Iterator<String>
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

    private int SailsNumAndShape = 3;

    private final int sailsCount = 0;

    private int current = -1, sailsID = -1;

    public int getSailsID() {
        return this.sailsID;
    }

    public int getSailsCount() {
        return this.sailsCount;
    }

    // Конструктор
    public Sailboat(int maxSpeed, float weight, Color mainColor, Color secondaryColor, boolean front, boolean back,
                    boolean anchor, boolean sails, int ID, int sailsNumAndShape)
    {
        super(maxSpeed, weight, mainColor, 200, 40);
        this.SecondaryColor = secondaryColor;
        this.Front = front;
        this.Back = back;
        this.Anchor = anchor;
        this.Sails = sails;
        this.SailsNumAndShape = sailsNumAndShape;
        // Идентификатор

        switch (ID)
        {
            case 1: // Number
                interAdd = new SailsNum();
                sailsID = 1;
                interAdd.setSailsNumAndShape(sailsNumAndShape);
                break;
            case 2: // Vertical
                interAdd = new SailsShapeVertical();
                sailsID = 2;
                interAdd.setSailsNumAndShape(sailsNumAndShape);
                break;
            case 3: // Horizontal
                interAdd = new SailsShapeHorizontal();
                sailsID = 3;
                interAdd.setSailsNumAndShape(sailsNumAndShape);
                break;
        }
    }

    // Конструктор
    public Sailboat(String info)
    {
        super(info);
        String[] strs = info.split(String.valueOf(separator));
        if (strs.length == 9)
        {
            MaxSpeed = Integer.parseInt(strs[0]);
            Weight = Float.parseFloat(strs[1]);
            MainColor = Color.decode(strs[2]);
            SecondaryColor = Color.decode(strs[3]);
            Front = Boolean.parseBoolean(strs[4]);
            Back = Boolean.parseBoolean(strs[5]);
            Anchor = Boolean.parseBoolean(strs[6]);
            Sails = Boolean.parseBoolean(strs[7]);
            interAdd = new SailsNum();
            interAdd.setSailsNumAndShape(SailsNumAndShape);
        }
    }

    // Метод отрисовки парусника
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
            int[] ptsFrontX = { _startPosX + 190, _startPosX + 150, _startPosX + 150, _startPosX + 150 };
            int[] ptsFrontY = { _startPosY + 20, _startPosY + 15, _startPosY + 20, _startPosY + 25 };

            g2D.setColor(MainColor);
            g2D.fillPolygon(ptsFrontX, ptsFrontY, 4);

            // Отрисовка границ передней части
            g2D.setColor(Color.BLACK);
            g2D.drawLine(_startPosX + 150, _startPosY + 20, _startPosX + 190, _startPosY + 20);
            g2D.drawLine(_startPosX + 190, _startPosY + 20, _startPosX + 140, _startPosY + 15);
            g2D.drawLine(_startPosX + 190, _startPosY + 20, _startPosX + 140, _startPosY + 25);
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

    // Перегрузка метода toString()
    @Override
    public String toString()
    {
        String res = super.toString();
        return res + separator + super.toHexString(
                SecondaryColor) + separator + Front + separator + Back + separator + Anchor + separator + Sails + separator + SailsNumAndShape;
    }

    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Sailboat))
        {
            return false;
        }
        else
        {
            return equals((Sailboat) obj);
        }
    }

    public boolean equals(Sailboat other)
    {
        if (MaxSpeed != other.MaxSpeed)
        {
            return false;
        }
        else if (Weight != other.Weight)
        {
            return false;
        }
        else if (MainColor != other.MainColor)
        {
            return false;
        }
        else if (Front != other.Front)
        {
            return false;
        }
        else if (Back != other.Back)
        {
            return false;
        }
        else if (Anchor != other.Anchor)
        {
            return false;
        }
        else if (sailsID != other.sailsID)
        {
            return false;
        }
        else if (sailsCount != other.sailsCount)
        {
            return false;
        }
        return true;
    }

    @Override
    public boolean hasNext()
    {
        int specsCounter = 9;
        if (current <= specsCounter - 1)
        {
            current++;
            return true;
        }
        return false;
    }

    @Override
    public String next()
    {
        if (current == 0)
        {
            return "Weight: " + Weight;
        }
        else if (current == 1)
        {
            return "MaxSpeed: " + MaxSpeed;
        }
        else if (current == 2)
        {
            return "MainColor: " + MainColor;
        }
        else if (current == 3)
        {
            return "SecondaryColor: " + SecondaryColor;
        }
        else if (current == 4)
        {
            return "Front: " + Front;
        }
        else if (current == 5)
        {
            return "Back: " + Back;
        }
        else if (current == 6)
        {
            return "Anchor: " + Anchor;
        }
        else if (current == 7)
        {
            return "sailsID: " + sailsID;
        }
        return "sailsCount: " + sailsCount;
    }

    @Override
    public void remove()
    {
        current = -1;
    }
}