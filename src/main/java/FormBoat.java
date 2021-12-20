import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FormBoat extends JPanel
{
    private Vehicle boat;
    private JButton buttonMoveUp, buttonMoveDown, buttonMoveRight, buttonMoveLeft, buttonBoat, buttonSailboat;
    private JFrame frame;
    private JPanel buttons;
    private Container elementsPanel;
    ActionListener actionListener;
    Random rnd;

    public FormBoat()
    {
        // Инициализация окна
        frame = new JFrame("Boat");
        frame.setSize(900, 625);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        elementsPanel = frame.getContentPane();
        buttons = new JPanel();

        // Создание кнопки "Boat"
        buttonBoat = new JButton("Boat");
        buttonBoat.setBackground(Color.WHITE);
        buttonBoat.setLocation(680, 19);
        buttonBoat.setSize(123, 24);
        buttonBoat.setActionCommand("Boat");
        buttons.add(buttonBoat);

        // Создание кнопки "Sailboat"
        buttonSailboat = new JButton("Sailboat");
        buttonSailboat.setBackground(Color.WHITE);
        buttonSailboat.setLocation(680, 55);
        buttonSailboat.setSize(123, 24);
        buttonSailboat.setActionCommand("Sailboat");
        buttons.add(buttonSailboat);

        // Создание стрелки вверх
        buttonMoveUp = new JButton();
        buttonMoveUp.setLocation(716, 390);
        buttonMoveUp.setSize(30, 30);
        buttonMoveUp.setBackground(Color.WHITE);
        buttonMoveUp.setIcon(new ImageIcon(new ImageIcon("src/main/java/img/Up.png").
                getImage().getScaledInstance(30, 30, 16)));
        buttonMoveUp.setActionCommand("Up");
        buttons.add(buttonMoveUp);

        // Создание стрелки вниз
        buttonMoveDown = new JButton();
        buttonMoveDown.setLocation(716, 420);
        buttonMoveDown.setSize(30, 30);
        buttonMoveDown.setIcon(new ImageIcon(new ImageIcon("src/main/java/img/Down.png")
                .getImage().getScaledInstance(30, 30, 16)));
        buttonMoveDown.setActionCommand("Down");
        buttons.add(buttonMoveDown);

        // Создание стрелки вправо
        buttonMoveRight = new JButton();
        buttonMoveRight.setLocation(752, 420);
        buttonMoveRight.setSize(30, 30);
        buttonMoveRight.setBackground(Color.WHITE);
        buttonMoveRight.setIcon(new ImageIcon(new ImageIcon("src/main/java/img/Right.png").
                getImage().getScaledInstance(30, 30, 16)));
        buttonMoveRight.setActionCommand("Right");
        buttons.add(buttonMoveRight);

        // Создание стрелки влево
        buttonMoveLeft = new JButton();
        buttonMoveLeft.setLocation(680, 420);
        buttonMoveLeft.setSize(30, 30);
        buttonMoveLeft.setBackground(Color.WHITE);
        buttonMoveLeft.setIcon(new ImageIcon(new ImageIcon("src/main/java/img/Left.png").
                getImage().getScaledInstance(30, 30, 16)));
        buttonMoveLeft.setActionCommand("Left");
        buttons.add(buttonMoveLeft);

        buttons.setLayout(null);
        elementsPanel.add(buttons);

        actionListener = new ButtonActions();
        buttonBoat.addActionListener(actionListener);
        buttonSailboat.addActionListener(actionListener);
        buttonMoveUp.addActionListener(actionListener);
        buttonMoveDown.addActionListener(actionListener);
        buttonMoveRight.addActionListener(actionListener);
        buttonMoveLeft.addActionListener(actionListener);
        frame.setVisible(true);
    }

    // Установка позиции лодки
    public void setBoat(Vehicle boat)
    {
        this.boat = boat;
        this.boat.setBounds(0, 0, 674, 450);
        this.boat.setLayout(null);
        this.boat.setPosition(25, 25, 674, 450);
        elementsPanel.add(this.boat);
        draw();
    }

    // Обработка нажатий клавиш
    public class ButtonActions extends JPanel implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            switch (e.getActionCommand())
            {
                case "Up":
                    if (boat != null)
                    {
                        boat.moveTransport(Direction.Up);
                        draw();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Create a Boat or a Sailboat at first!");
                    }
                    break;
                case "Down":
                    if (boat != null)
                    {
                        boat.moveTransport(Direction.Down);
                        draw();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Create a Boat or a Sailboat at first!");
                    }
                    break;
                case "Right":
                    if (boat != null)
                    {
                        boat.moveTransport(Direction.Right);
                        draw();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Create a Boat or a Sailboat at first!");
                    }
                    break;
                case "Left":
                    if (boat != null)
                    {
                        boat.moveTransport(Direction.Left);
                        draw();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Create a Boat or a Sailboat at first!");
                    }
                    break;
                case "Boat":
                    rnd = new Random();
                    boat = new Boat(rnd.nextInt(200) + 100, rnd.nextFloat() * 200.0f + 100.0f, Color.CYAN, 200, 40);
                    boat.setBounds(0, 0, 674, 450);
                    boat.setPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10,
                            frame.getWidth() - boat._startPosX - 200, frame.getHeight() - 130);
                    elementsPanel.add(boat);
                    draw();
                    break;
                case "Sailboat":
                    rnd = new Random();
                    boat = new Sailboat(rnd.nextInt(200) + 100, rnd.nextFloat() * 200.0f + 100.0f,
                            new Color(0, 191, 255), new Color(0, 255, 255), true, true, true, true, rnd.nextInt(3) + 1, rnd.nextInt(2) + 1);
                    boat.setBounds(0, 0, 674, 450);
                    boat.setPosition(rnd.nextInt(90) + 10, rnd.nextInt(90) + 10,
                            frame.getWidth() - boat._startPosX - 200, frame.getHeight() - 130);
                    elementsPanel.add(boat);
                    draw();
                    break;
            }
        }
    }

    // Метод отрисовки
    public void draw()
    {
        boat.getGraphics().clearRect(0, 0, 674, 450);
        boat.drawTransport(boat.getGraphics());
    }
}