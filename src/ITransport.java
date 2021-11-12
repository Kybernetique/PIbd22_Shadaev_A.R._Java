import java.awt.*;

// Интерфейс "Транспорт"
public interface ITransport
{
    // Установка позиции
    void setPosition(int x, int y, int width, int height);

    // Изменение направления перемещения
    void moveTransport(Direction direction);

    // Отрисовка
    void drawTransport(Graphics g);

}
