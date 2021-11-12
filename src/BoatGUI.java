import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

// Создание формы
public class BoatGUI
{
    private ITransport boat;
    private JPanel picture;
    private Graphics g;

    private void Draw()
    {
        boat.drawTransport(g);
    }

    public BoatGUI()
    {
        // Создание окна
        JFrame frame = new JFrame("Boat");
        frame.setLayout(null);
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание окна, где будет рисоваться изображение
        picture = new JPanel();
        picture.setSize(674, 450);
        picture.setBackground(Color.WHITE);
        picture.setLocation(0, 0);
        picture.setVisible(true);

        // Создание кнопки "Boat"
        JButton buttonBoat = new JButton("Boat");
        buttonBoat.setBackground(Color.WHITE);
        buttonBoat.setLocation(680, 19);
        buttonBoat.setSize(123, 24);
        buttonBoat.setVisible(true);

        // Обработка нажатия кнопки "Boat"
        buttonBoat.addActionListener(e ->
        {
            g = picture.getGraphics();
            picture.update(g);
            Random rnd = new Random();
            boat = new Boat(1000, rnd.nextInt(1000) + 1000,
                    Color.CYAN);
            boat.setPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10,
                    picture.getWidth(), picture.getHeight());
            Draw();
        });

        // Создание кнопки "Sailboat"
        JButton buttonSailboat = new JButton("Sailboat");
        buttonSailboat.setBackground(Color.WHITE);
        buttonSailboat.setLocation(680, 55);
        buttonSailboat.setSize(123, 24);
        buttonSailboat.setVisible(true);

        // Обработка нажатия кнопки "Sailboat"
        buttonSailboat.addActionListener(e ->
        {
            g = picture.getGraphics();
            picture.update(g);
            Random rnd = new Random();
            boat = new Sailboat(1000, rnd.nextInt(1000) + 1000,
                    new Color(0, 191, 255), new Color(0, 255, 255), true, true, true, true, rnd.nextInt(3) + 1, rnd.nextInt(2) + 1);
            boat.setPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10,
                    picture.getWidth(), picture.getHeight());
            Draw();
        });

        // Создание стрелки вверх
        JButton buttonMoveUp = new JButton();
        buttonMoveUp.setLocation(716, 390);
        buttonMoveUp.setSize(30, 30);
        buttonMoveUp.setVisible(true);
        buttonMoveUp.setIcon(new ImageIcon(new ImageIcon("src/img/Up.png")
                .getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вверх
        buttonMoveUp.addActionListener(e ->
        {
            try
            {
                picture.update(g);
                boat.moveTransport(Direction.Up);
                Draw();
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Try to click \"Create\" button at first!");
            }
        });

        // Создание стрелки вниз
        JButton buttonMoveDown = new JButton();
        buttonMoveDown.setLocation(716, 420);
        buttonMoveDown.setSize(30, 30);
        buttonMoveDown.setBackground(Color.WHITE);
        buttonMoveDown.setVisible(true);
        buttonMoveDown.setIcon(new ImageIcon(new ImageIcon("src/img/Down.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вниз
        buttonMoveDown.addActionListener(e ->
        {
            try
            {
                picture.update(g);
                boat.moveTransport(Direction.Down);
                Draw();
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Try to click \"Create\" button at first!");
            }
        });

        // Создание стрелки вправо
        JButton buttonMoveRight = new JButton();
        buttonMoveRight.setLocation(752, 420);
        buttonMoveRight.setSize(30, 30);
        buttonMoveRight.setBackground(Color.WHITE);
        buttonMoveRight.setVisible(true);
        buttonMoveRight.setIcon(new ImageIcon(new ImageIcon("src/img/Right.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вправо
        buttonMoveRight.addActionListener(e ->
        {
            try
            {
                picture.update(g);
                boat.moveTransport(Direction.Right);
                Draw();
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Try to click \"Create\" button at first!");
            }
        });

        // Создание стрелки влево
        JButton buttonMoveLeft = new JButton();
        buttonMoveLeft.setLocation(680, 420);
        buttonMoveLeft.setSize(30, 30);
        buttonMoveLeft.setBackground(Color.WHITE);
        buttonMoveLeft.setVisible(true);
        buttonMoveLeft.setIcon(new ImageIcon(new ImageIcon("src/img/Left.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки влево
        buttonMoveLeft.addActionListener(e ->
        {
            try
            {
                picture.update(g);
                boat.moveTransport(Direction.Left);
                Draw();
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Try to click \"Create\" button at first!");
            }
        });

        // Добавление кнопок и изображения на панель
        frame.add(buttonBoat);
        frame.add(buttonSailboat);
        frame.add(buttonMoveUp);
        frame.add(buttonMoveDown);
        frame.add(buttonMoveRight);
        frame.add(buttonMoveLeft);
        frame.add(picture);

        frame.setVisible(true);
    }

}
