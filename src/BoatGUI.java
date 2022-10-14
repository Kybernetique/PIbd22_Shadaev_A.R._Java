import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

// Создание формы
public class BoatGUI
{
    private Boat boat = new Boat();
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
        frame.setSize(1100, 647);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание окна, где будет рисоваться изображение
        picture = new JPanel();
        picture.setSize(675, 488);
        picture.setBackground(Color.WHITE);
        picture.setLocation(0, 0);
        picture.setVisible(true);

        // Создание кнопки "Create"
        JButton buttonCreate = new JButton("Create");
        buttonCreate.setBackground(Color.WHITE);
        buttonCreate.setLocation(680, 19);
        buttonCreate.setSize(123, 24);
        buttonCreate.setVisible(true);

        // Обработка нажатия кнопки "Create"
        buttonCreate.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                g = picture.getGraphics();
                picture.update(g);
                Random rnd = new Random();
                boat.init(rnd.nextInt(200) + 100, rnd.nextInt(1000) + 1000,
                        new Color(240, 230, 140), new Color(0, 191, 255), true, true, true, true, 1);
                boat.setPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10,
                        picture.getWidth(), picture.getHeight());
                Draw();
            }
        });

        // Создание стрелки вверх
        JButton buttonMoveUp = new JButton();
        buttonMoveUp.setLocation(716, 383);
        buttonMoveUp.setSize(30, 30);
        buttonMoveUp.setVisible(true);
        buttonMoveUp.setIcon(new ImageIcon(new ImageIcon("src/img/Up.png")
                .getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вверх
        buttonMoveUp.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        // Создание стрелки вниз
        JButton buttonMoveDown = new JButton();
        buttonMoveDown.setLocation(716, 419);
        buttonMoveDown.setSize(30, 30);
        buttonMoveDown.setBackground(Color.WHITE);
        buttonMoveDown.setVisible(true);
        buttonMoveDown.setIcon(new ImageIcon(new ImageIcon("src/img/Down.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вниз
        buttonMoveDown.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        // Создание стрелки вправо
        JButton buttonMoveRight = new JButton();
        buttonMoveRight.setLocation(752, 419);
        buttonMoveRight.setSize(30, 30);
        buttonMoveRight.setBackground(Color.WHITE);
        buttonMoveRight.setVisible(true);
        buttonMoveRight.setIcon(new ImageIcon(new ImageIcon("src/img/Right.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки вправо
        buttonMoveRight.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        // Создание стрелки влево
        JButton buttonMoveLeft = new JButton();
        buttonMoveLeft.setLocation(680, 419);
        buttonMoveLeft.setSize(30, 30);
        buttonMoveLeft.setBackground(Color.WHITE);
        buttonMoveLeft.setVisible(true);
        buttonMoveLeft.setIcon(new ImageIcon(new ImageIcon("src/img/Left.png").
                getImage().getScaledInstance(30, 30, 16)));

        // Обработка нажатия стрелки влево
        buttonMoveLeft.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        // Добавление кнопок и изображения на панель
        frame.add(buttonCreate);
        frame.add(buttonMoveUp);
        frame.add(buttonMoveDown);
        frame.add(buttonMoveRight);
        frame.add(buttonMoveLeft);
        frame.add(picture);

        frame.setVisible(true);
    }

}
