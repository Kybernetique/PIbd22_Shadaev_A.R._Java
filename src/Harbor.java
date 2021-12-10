import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Harbor<T extends ITransport, U extends InterAdd> extends JPanel
{
    // Массив объектов, которые храним
    private final ArrayList<T> _places;

    // Максимальный размер
    private final int _maxCount;

    // Ширина окна отрисовки
    private final int pictureWidth;

    // Высота окна отрисовки
    private final int pictureHeight;

    // Размер места гавани (ширина)
    private final int _placeSizeWidth = 220;

    // Размер места гавани (высота)
    private final int _placeSizeHeight = 80;

    // Имя гавани
    private String name;

    // Конструктор
    public Harbor(int picWidth, int picHeight)
    {
        pictureWidth = picWidth;
        pictureHeight = picHeight;
        _maxCount = (pictureWidth / _placeSizeWidth) * (picHeight / _placeSizeHeight);
        _places = new ArrayList<>();
    }

    public int add(Harbor<T, U> p, T boat)
    {
        if (p._maxCount <= p._places.size()) return -1;

        for (int i = 0; i < p._places.size() + 1; i++)
        {
            p._places.add(boat);
            return p._places.indexOf(boat);
        }
        return -1;
    }

    public T del(Harbor<T, U> p, int index)
    {
        T removedBoat;

        if (index > -1 && index < p._places.size() && p._places.get(index) != null)
        {
            removedBoat = p._places.get(index);
            p._places.remove(index);
            return removedBoat;
        }
        return null;
    }

    // Перегрузка оператора "<="
    public boolean lessOrEqual(Sailboat boat)
    {
        int minNum = Integer.MAX_VALUE;
        for (T place : _places)
        {
            if (place != null)
            {
                if (place.hashCode() <= minNum) minNum = place.hashCode();
            }
        }
        return boat.hashCode() <= minNum;
    }

    // Перегрузка оператора ">="
    public boolean moreOrEqual(Sailboat boat)
    {
        int maxNum = Integer.MIN_VALUE;
        for (T place : _places)
        {
            if (place != null)
            {
                if (place.hashCode() >= maxNum) maxNum = place.hashCode();
            }
        }
        return boat.hashCode() >= maxNum;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public ArrayList<T> get_places()
    {
        return _places;
    }

    // Метод отрисовки разметки парковочных мест
    public void draw(Graphics g)
    {
        g.clearRect(0, 75, 674, 525);
        for (int i = 0; i < _places.size(); i++)
        {
            if (_places.get(i) != null)
            {
                _places.get(i).setPosition(20 + i % 3 * _placeSizeWidth, i / 3 * _placeSizeHeight + 20, pictureWidth, pictureHeight);
                _places.get(i).drawTransport(g);
            }
        }
        drawMarking(g);
    }

    public void drawMarking(Graphics gr)
    {
        Graphics2D g = (Graphics2D) gr;
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLACK);
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            { // Линия разметки места
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i * _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth, (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }

    public T indexer(int index)
    {
        return _places.get(index);
    }
}

