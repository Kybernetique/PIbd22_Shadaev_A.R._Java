import java.awt.*;
import java.util.*;

public class Harbor<T extends ITransport, U extends InterAdd>
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
        _places = new ArrayList<T>();
    }

    // Перегрузка оператора сложения
    // Логика действия: на место добавляется лодка
    public int add(T boat)
    {
        int i = 0;
        int j = 0;

        while (i < (pictureHeight / _placeSizeHeight))
        {
            j = 0;
            while (j < (pictureWidth / _placeSizeWidth))
            {
                if (i * (pictureWidth / _placeSizeWidth) + j == _places.size() && _places.size() <= _maxCount)
                {
                    boat.setPosition(20 + j * _placeSizeWidth, 20 + i * _placeSizeHeight, pictureWidth, pictureHeight);
                    _places.add(boat);
                    return (i * (pictureWidth / _placeSizeWidth) + j);
                } else if (i * (pictureWidth / _placeSizeWidth) + j < _places.size() &&
                        _places.get(i * (pictureWidth / _placeSizeWidth) + j) == null)
                {
                    boat.setPosition(20 + j * _placeSizeWidth, 20 + i * _placeSizeHeight, pictureWidth, pictureHeight);
                    _places.set(i * (pictureWidth / _placeSizeWidth) + j, boat);
                    return (i * (pictureWidth / _placeSizeWidth) + j);
                }
                j++;
            }
            i++;
        }
        return -1;
    }

    // Перегрузка оператора вычитания
    // Логика действия: с места забираем судно
    public T del(int index)
    {
        if (index >= _places.size() || index < 0) return null;
        if (_places.get(index) != null)
        {
            T boat = _places.get(index);
            _places.set(index, null);
            return boat;
        } else return null;
    }

    // Перегрузка оператора "<="
    public boolean lessOrEqual(Sailboat boat)
    {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < _places.size(); i++)
        {
            if (_places.get(i) != null)
            {
                if (_places.get(i).hashCode() <= minNum) minNum = _places.get(i).hashCode();
            }
        }
        return boat.hashCode() <= minNum;
    }

    // Перегрузка оператора ">="
    public boolean moreOrEqual(Sailboat boat)
    {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < _places.size(); i++)
        {
            if (_places.get(i) != null)
            {
                if (_places.get(i).hashCode() >= maxNum) maxNum = _places.get(i).hashCode();
            }
        }
        return boat.hashCode() >= maxNum;
    }

    // Геттер для имени гавани
    public String getName()
    {
        return name;
    }

    // Сеттер для имени гавани
    public void setName(String name)
    {
        this.name = name;
    }

    // Метод, позволяющий корректно отображать название гавани
    public String toString()
    {
        return name;
    }

    // Метод отрисовки
    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        drawMarking(g2D);
        for (int i = 0; i < _places.size(); i++)
        {
            if (_places.get(i) != null)
            {
                _places.get(i).drawTransport(g);
            }
        }
    }

    // Метод отрисовки границ мест гавани
    private void drawMarking(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.BLACK);
        g2D.setStroke(new BasicStroke(3));
        for (int i = 0; i < pictureWidth / _placeSizeWidth; i++)
        {
            for (int j = 0; j < pictureHeight / _placeSizeHeight + 1; ++j)
            {
                g.drawLine(i * _placeSizeWidth, j * _placeSizeHeight, i *
                        _placeSizeWidth + _placeSizeWidth / 2, j * _placeSizeHeight);
            }
            g.drawLine(i * _placeSizeWidth, 0, i * _placeSizeWidth,
                    (pictureHeight / _placeSizeHeight) * _placeSizeHeight);
        }
    }

    // Индексатор
    public T indexer(int ind)
    {
        if (ind > -1 && ind < _places.size()) return _places.get(ind);
        else return null;
    }
}
