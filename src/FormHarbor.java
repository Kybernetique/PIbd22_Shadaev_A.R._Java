import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import sun.misc.Queue;


public class FormHarbor
{
    MyImage myImage;
    BufferedImage bufferedImage;
    Graphics g;
    private JList<Harbor<ITransport, InterAdd>> listBoxHarbor;
    private Harbor<ITransport, InterAdd> harbor;
    private HarborCollection harborCollection;
    private Queue<ITransport> removedStages;

    // Метод отрисовки лодки
    private void draw()
    {
        g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, myImage.getWidth(), myImage.getHeight());
        harbor.draw(g);
        myImage.image = bufferedImage;
        myImage.repaint();
    }

    // Конструктор
    public FormHarbor()
    {
        // Создание окна
        JFrame frame = new JFrame("Harbor");
        frame.setLayout(null);
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Окно, куда будет выводиться изображение
        myImage = new MyImage();
        myImage.setSize(674, 450);
        myImage.setLocation(0, 0);
        bufferedImage = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        // Инициализация коллекций
        harborCollection = new HarborCollection(myImage.getWidth(), myImage.getHeight());
        removedStages = new Queue<>();

        // Создание лейбла "Harbors"
        JLabel labelHarbors = new JLabel("Harbors:");
        labelHarbors.setBounds(680, 12, 53, 17);
        labelHarbors.setVisible(true);

        // Создание текстового поля (textField) "Harbors"
        JTextField textFieldHarbors = new JTextField();
        textFieldHarbors.setLocation(680, 32);
        textFieldHarbors.setSize(140, 22);
        textFieldHarbors.setVisible(true);

        // Создание списка "listBoxHarbor"
        listBoxHarbor = new JList<>();
        listBoxHarbor.setBounds(680, 90, 140, 140);
        listBoxHarbor.setVisibleRowCount(-1);
        listBoxHarbor.setModel(harborCollection.modelList);

        // Метод, позволяющий сохранять разные гавани
        listBoxHarbor.getSelectionModel().addListSelectionListener(e ->
        {
            harbor = listBoxHarbor.getSelectedValue();
            if (harbor == null) frame.getGraphics().clearRect(0, 0, myImage.getWidth(), myImage.getHeight());
            else draw();
        });

        // Создание кнопки "Add Harbor"
        JButton buttonAddHarbor = new JButton("Add Harbor");
        buttonAddHarbor.setBackground(Color.WHITE);
        buttonAddHarbor.setLocation(680, 60);
        buttonAddHarbor.setSize(140, 24);
        buttonAddHarbor.setVisible(true);

        // Обработка нажатия кнопки "Add Harbor"
        buttonAddHarbor.addActionListener(e ->
        {
            if (textFieldHarbors.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Enter A Harbor's Name First");
            } else
            {
                harbor = harborCollection.addHarbor(textFieldHarbors.getText());
                if (harbor != null)
                {
                    draw();
                } else
                {
                    JOptionPane.showMessageDialog(null, "Harbor With This Name Has Already Been Created");
                }
                textFieldHarbors.setText("");
            }
        });

        // Создание кнопки "Del Harbor"
        JButton buttonDelHarbor = new JButton("Del Harbor");
        buttonDelHarbor.setBackground(Color.WHITE);
        buttonDelHarbor.setLocation(680, 240);
        buttonDelHarbor.setSize(140, 24);
        buttonDelHarbor.setVisible(true);

        // Обработка нажатия кнопки "Del Harbor"
        buttonDelHarbor.addActionListener(e ->
        {
            if (harborCollection.modelList.indexOf(harbor) > -1)
            {
                harborCollection.delHarbor(harborCollection.modelList.get(harborCollection.modelList.indexOf(harbor)).getName());
                myImage.getGraphics().clearRect(0, 0, myImage.getWidth(), myImage.getHeight());
            } else
            {
                JOptionPane.showMessageDialog(null, "Harbor Collection Is Empty");
            }
        });

        // Создание кнопки "Set Boat"
        JButton buttonSetBoat = new JButton("Set Boat");
        buttonSetBoat.setBackground(Color.WHITE);
        buttonSetBoat.setLocation(680, 295);
        buttonSetBoat.setSize(140, 24);
        buttonSetBoat.setVisible(true);

        // Обработка нажатия кнопки "Set Boat", позволяющий создать и поставить лодку
        buttonSetBoat.addActionListener(e ->
        {
            Color mColor = JColorChooser.showDialog(frame, "Color Chooser", Color.green);
            if (mColor != null)
            {
                Boat boat = new Boat(100, 1000, mColor);
                int num = harbor.add(boat);
                if (num != -1)
                {
                    draw();
                } else
                {
                    JOptionPane.showMessageDialog(frame, "Harbor is Full!");
                }
            }
        });

        // Создание кнопки "Set Sailboat"
        JButton buttonSetSailboat = new JButton("Set Sailboat");
        buttonSetSailboat.setBackground(Color.WHITE);
        buttonSetSailboat.setLocation(680, 328);
        buttonSetSailboat.setSize(140, 24);
        buttonSetSailboat.setVisible(true);

        // Обработка нажатия кнопки "Set Sailboat", позволяющий создать и поставить лодку
        buttonSetSailboat.addActionListener(e ->
        {
            Color mainColor = JColorChooser.showDialog(frame, "Color Chooser", Color.green);
            Color secondaryColor = JColorChooser.showDialog(frame, "Color Chooser", Color.red);
            Random rnd = new Random();
            if (mainColor != null)
            {
                if (secondaryColor != null)
                {
                    Sailboat sailboat = new Sailboat(1000, rnd.nextInt(1000) + 1000,
                            mainColor, secondaryColor, true, true, true, true, 3, rnd.nextInt(2) + 1);
                    if (harbor.add(sailboat) != -1)
                    {
                        draw();
                    } else
                    {
                        JOptionPane.showMessageDialog(frame, "Harbor is Full!");
                    }
                }
            }
        });

        // Создание лейбла "Take Boat"
        JLabel labelTakeBoat = new JLabel("Take Boat");
        labelTakeBoat.setBounds(680, 355, 100, 17);
        labelTakeBoat.setVisible(true);

        // Создание лейбла "Place: "
        JLabel labelPlace = new JLabel("Place:");
        labelPlace.setBounds(680, 375, 53, 17);
        labelPlace.setVisible(true);

        // Создание текстового поля textFieldPlace
        JTextField textFieldPlace = new JTextField();
        textFieldPlace.setLocation(726, 375);
        textFieldPlace.setSize(94, 22);
        textFieldPlace.setVisible(true);

        // Создание кнопки "Take"
        JButton buttonTake = new JButton("Take");
        buttonTake.setBackground(Color.WHITE);
        buttonTake.setLocation(680, 405);
        buttonTake.setSize(140, 24);
        buttonTake.setVisible(true);

        // Обработка нажатия кнопки "Take"
        buttonTake.addActionListener(e ->
        {
            if (textFieldPlace.getText() != "")
            {
                int place;
                try
                {
                    place = Integer.parseInt(textFieldPlace.getText());
                } catch (NumberFormatException ex)
                {
                    return;
                }

                ITransport boat = harbor.del(place);
                if (boat != null)
                {
                    removedStages.enqueue(boat);
                }
                draw();
            }
        });

        // Создание кнопки "Removed Boat"
        JButton buttonRemovedBoat = new JButton("Removed Boat");
        buttonRemovedBoat.setBackground(Color.ORANGE);
        buttonRemovedBoat.setLocation(680, 426);
        buttonRemovedBoat.setSize(140, 24);
        buttonRemovedBoat.setVisible(true);

        // Обработка нажатия кнопки "Removed Boat"
        buttonRemovedBoat.addActionListener(e ->
        {
            ITransport boat = null;
            if (!removedStages.isEmpty())
            {
                try
                {
                    boat = removedStages.dequeue();
                } catch (InterruptedException interruptedException)
                {
                    interruptedException.printStackTrace();
                }
            }
            if (boat != null)
            {
                FormBoat removedBoat = new FormBoat();
                removedBoat.setBoat(boat);
            } else
            {
                JOptionPane.showMessageDialog(null, "Queue Of Taken Boats is empty");
            }
            draw();
        });

        // Добавление элементов в окно
        frame.add(labelHarbors);
        frame.add(textFieldHarbors);
        frame.add(buttonAddHarbor);
        frame.add(buttonDelHarbor);
        frame.add(listBoxHarbor);
        frame.add(buttonSetBoat);
        frame.add(buttonSetSailboat);
        frame.add(labelTakeBoat);
        frame.add(labelPlace);
        frame.add(textFieldPlace);
        frame.add(buttonTake);
        frame.add(buttonRemovedBoat);
        frame.add(myImage);

        // Отображение окна
        frame.setVisible(true);

        harbor = new Harbor<>(myImage.getWidth(), myImage.getHeight());
    }
}
