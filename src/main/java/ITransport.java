import java.awt.*;

public interface ITransport
{
    // Установка позиции
    void setPosition(int x, int y, int width, int height);

    // Изменение направления пермещения
    void moveTransport(Direction direction);

    // Метод отрисовки
    void drawTransport(Graphics g);
}

