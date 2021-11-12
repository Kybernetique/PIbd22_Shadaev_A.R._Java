import java.awt.*;

public class Harbor<T extends ITransport, U extends InterAdd>
{
    // Массив объектов, которые храним
    private final T[] _places;

    // Ширина окна отрисовки
    private final int pictureWidth;

    // Высота окна отрисовки
    private final int pictureHeight;

    // Размер места гавани (ширина)
    private final int _placeSizeWidth = 220;

    // Размер места гавани (высота)
    private final int _placeSizeHeight = 80;

    private int width;
    private int height;

    // Конструктор
    public Harbor(int picWidth, int picHeight)
    {
        width = picWidth / _placeSizeWidth;
        height = picHeight / _placeSizeHeight;
        _places = (T[]) new ITransport[width * height];
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    // Перегрузка оператора сложения
    // Логика действия: на место добавляется лодка
    public int add(T boat)
    {
        int i = 0;
        int j = 0;
        while (i < height)
        {
            j = 0;
            while (j < width)
            {
                if (_places[i * width + j] == null)
                {
                    _places[i * width + j] = boat;
                    boat.setPosition(25 + j * _placeSizeWidth, 20 + i * _placeSizeHeight, pictureWidth, pictureHeight);
                    return i * width + j;
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
        if ((index >= width * height) || (_places[index] == null))
        {
            return null;
        }
        if (_places[index] != null)
        {
            T obj = _places[index];
            _places[index] = null;
            return obj;
        } else
        {
            return null;
        }
    }

    public boolean lessOrEqual(Sailboat boat)
    {
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < _places.length; i++)
        {
            if (_places[i] != null)
            {
                if (_places[i].hashCode() <= minNum) minNum = _places[i].hashCode();
            }
        }
        return  boat.hashCode() <= minNum;
    }

    public boolean moreOrEqual(Sailboat boat)
    {
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < _places.length; i++)
        {
            if (_places[i] != null)
            {
                if (_places[i].hashCode() >= maxNum) maxNum = _places[i].hashCode();
            }
        }
        return boat.hashCode() >= maxNum;
    }


    public void draw(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;
        drawMarking(g2D);
        for (int i = 0; i < _places.length; i++)
        {
            if (_places[i] != null)
            {
                _places[i].drawTransport(g);
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
}
