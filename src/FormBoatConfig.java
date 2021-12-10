import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;


public class FormBoatConfig extends JFrame
{
    private JFrame formConfig;
    private FormHarbor parentFrame;
    private JLabel pictureMask, boat, sailboat, mainColor, secondaryColor, speedLabel, weightLabel, labelSailsNum, labelSailsShapeVertical, labelSailsShapeHorizontal;
    private MouseReaction mouseType, mouseColor;
    private ITransport pictureBoat;
    private JPanel confPanel, orangeColorPanel, redColorPanel, pinkColorPanel, blueColorPanel, purpleColorPanel, cyanColorPanel, greenColorPanel, yellowColorPanel, underGround;
    private FormBoatConfig.drawPanel drawPanel;
    private JSpinner spinnerChooseSpeed, spinnerChooseWeight, spinnerSailsNum;
    private JCheckBox checkBoxFront, checkBoxBack, checkBoxAnchor, checkBoxSail;
    private JButton buttonAppend, buttonCancel;

    public FormBoatConfig(FormHarbor parentFrame)
    {
        this.parentFrame = parentFrame;
        formConfig = new JFrame("Choose Configuration");
        Init();
    }

    public void Init()
    {
        mouseType = new MouseReaction();
        MouseReaction mouseType = new MouseReaction();
        mouseColor = new MouseReaction();
        formConfig.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        formConfig.setSize(900, 550);

        confPanel = new JPanel();
        confPanel.setLayout(null);
        confPanel.setBounds(0, 0, formConfig.getWidth(), formConfig.getHeight());

        // Граница изображения
        pictureMask = new JLabel();
        pictureMask.setBounds(150, 10, 200, 150);
        pictureMask.setBorder(new LineBorder(new Color(0, 0, 0)));
        pictureMask.setTransferHandler(new TransferHandler("text"));
        confPanel.add(pictureMask);

        // Здесь выводится изображение
        drawPanel = new drawPanel();
        drawPanel.setLayout(null);
        drawPanel.setBounds(150, 10, 200, 150);
        drawPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
        confPanel.add(drawPanel);

        boat = new JLabel("Boat");
        boat.setBounds(10, 10, 100, 50);
        boat.setBorder(new BevelBorder(BevelBorder.RAISED));
        boat.setTransferHandler(new TransferHandler("text"));
        boat.setHorizontalAlignment(SwingConstants.CENTER);
        boat.setVerticalAlignment(SwingConstants.CENTER);
        boat.addMouseListener(mouseType);
        boat.setDropTarget(null);
        confPanel.add(boat);

        // Создание лейбла "Sailboat" с механизмом Drag & Drop
        sailboat = new JLabel("Sailboat");
        sailboat.setBounds(10, 70, 100, 50);
        sailboat.setBorder(new BevelBorder(BevelBorder.RAISED));
        sailboat.setTransferHandler(new TransferHandler("text"));
        sailboat.setHorizontalAlignment(SwingConstants.CENTER);
        sailboat.setVerticalAlignment(SwingConstants.CENTER);
        sailboat.addMouseListener(mouseType);
        sailboat.setDropTarget(null);
        confPanel.add(sailboat);

        // Меню цветов
        // Основной Цвет
        mainColor = new JLabel("Main Color");
        mainColor.setBounds(390, 10, 118, 23);
        mainColor.setBorder(new LineBorder(Color.BLACK));
        mainColor.setHorizontalAlignment(JLabel.CENTER);
        mainColor.setBackground(Color.GRAY);
        mainColor.setTransferHandler(new TransferHandler("background"));
        confPanel.add(mainColor);

        // Дополнительный цвет
        secondaryColor = new JLabel("Secondary Color");
        secondaryColor.setBounds(390, 45, 118, 23);
        secondaryColor.setBorder(new LineBorder(Color.BLACK));
        secondaryColor.setHorizontalAlignment(JLabel.CENTER);
        secondaryColor.setBackground(Color.CYAN);
        secondaryColor.setTransferHandler(new TransferHandler("background"));
        confPanel.add(secondaryColor);

        // Жёлтый
        yellowColorPanel = new JPanel();
        yellowColorPanel.setLayout(null);
        yellowColorPanel.setBounds(390, 76, 25, 25);
        yellowColorPanel.setBorder(new LineBorder(Color.BLACK));
        yellowColorPanel.setBackground(Color.YELLOW);
        yellowColorPanel.setTransferHandler(new TransferHandler("background"));
        yellowColorPanel.addMouseListener(mouseColor);
        yellowColorPanel.setDropTarget(null);
        confPanel.add(yellowColorPanel);

        // Оранжевый
        orangeColorPanel = new JPanel();
        orangeColorPanel.setLayout(null);
        orangeColorPanel.setBounds(421, 76, 25, 25);
        orangeColorPanel.setBorder(new LineBorder(Color.BLACK));
        orangeColorPanel.setBackground(Color.ORANGE);
        orangeColorPanel.setTransferHandler(new TransferHandler("background"));
        orangeColorPanel.addMouseListener(mouseColor);
        orangeColorPanel.setDropTarget(null);
        confPanel.add(orangeColorPanel);

        // Красный
        redColorPanel = new JPanel();
        redColorPanel.setLayout(null);
        redColorPanel.setBounds(452, 76, 25, 25);
        redColorPanel.setBorder(new LineBorder(Color.BLACK));
        redColorPanel.setBackground(Color.RED);
        redColorPanel.setTransferHandler(new TransferHandler("background"));
        redColorPanel.addMouseListener(mouseColor);
        redColorPanel.setDropTarget(null);
        confPanel.add(redColorPanel);

        // Розовый
        pinkColorPanel = new JPanel();
        pinkColorPanel.setLayout(null);
        pinkColorPanel.setBounds(483, 76, 25, 25);
        pinkColorPanel.setBorder(new LineBorder(Color.BLACK));
        pinkColorPanel.setBackground(Color.PINK);
        pinkColorPanel.setTransferHandler(new TransferHandler("background"));
        pinkColorPanel.addMouseListener(mouseColor);
        pinkColorPanel.setDropTarget(null);
        confPanel.add(pinkColorPanel);

        // Бирюзовый
        cyanColorPanel = new JPanel();
        cyanColorPanel.setLayout(null);
        cyanColorPanel.setBounds(390, 107, 25, 25);
        cyanColorPanel.setBorder(new LineBorder(Color.BLACK));
        cyanColorPanel.setBackground(Color.CYAN);
        cyanColorPanel.setTransferHandler(new TransferHandler("background"));
        cyanColorPanel.addMouseListener(mouseColor);
        cyanColorPanel.setDropTarget(null);
        confPanel.add(cyanColorPanel);

        // Зелёный
        greenColorPanel = new JPanel();
        greenColorPanel.setLayout(null);
        greenColorPanel.setBounds(421, 107, 25, 25);
        greenColorPanel.setBorder(new LineBorder(Color.BLACK));
        greenColorPanel.setBackground(Color.GREEN);
        greenColorPanel.setTransferHandler(new TransferHandler("background"));
        greenColorPanel.addMouseListener(mouseColor);
        greenColorPanel.setDropTarget(null);
        confPanel.add(greenColorPanel);

        // Фиолетовый
        purpleColorPanel = new JPanel();
        purpleColorPanel.setLayout(null);
        purpleColorPanel.setBounds(452, 107, 25, 25);
        purpleColorPanel.setBorder(new LineBorder(Color.BLACK));
        purpleColorPanel.setBackground(new Color(124, 82, 227));
        purpleColorPanel.setTransferHandler(new TransferHandler("background"));
        purpleColorPanel.addMouseListener(mouseColor);
        purpleColorPanel.setDropTarget(null);
        confPanel.add(purpleColorPanel);

        // Синий
        blueColorPanel = new JPanel();
        blueColorPanel.setLayout(null);
        blueColorPanel.setBounds(483, 107, 25, 25);
        blueColorPanel.setBorder(new LineBorder(Color.BLACK));
        blueColorPanel.setBackground(Color.BLUE);
        blueColorPanel.setTransferHandler(new TransferHandler("background"));
        blueColorPanel.addMouseListener(mouseColor);
        blueColorPanel.setDropTarget(null);
        confPanel.add(blueColorPanel);

        // Кнопка "Append"
        buttonAppend = new JButton("Append");
        buttonAppend.setBackground(Color.WHITE);
        buttonAppend.setBounds(390, 167, 118, 23);
        confPanel.add(buttonAppend);

        // Кнопка "Cancel"
        buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(Color.WHITE);
        buttonCancel.setBounds(390, 198, 118, 23);
        confPanel.add(buttonCancel);

        // Лейбл "Speed"
        speedLabel = new JLabel("Speed:");
        speedLabel.setBounds(30, 270, 60, 20);
        confPanel.add(speedLabel);

        // Переключатель скорости лодки
        spinnerChooseSpeed = new JSpinner();
        spinnerChooseSpeed.setBounds(30, 290, 60, 20);
        spinnerChooseSpeed.setModel(new SpinnerNumberModel(100, 1, 200, 1));
        confPanel.add(spinnerChooseSpeed);

        // Лейбл "Weight"
        weightLabel = new JLabel("Weight:");
        weightLabel.setBounds(30, 320, 60, 20);
        confPanel.add(weightLabel);

        // Переключатель веса лодки
        spinnerChooseWeight = new JSpinner();
        spinnerChooseWeight.setBounds(30, 340, 60, 20);
        spinnerChooseWeight.setModel(new SpinnerNumberModel(100, 1, 200, 1));
        confPanel.add(spinnerChooseWeight);

        // Признак наличия передней части корабля
        checkBoxFront = new JCheckBox("Front");
        checkBoxFront.setSelected(true);
        checkBoxFront.setBounds(180, 280, 120, 30);
        confPanel.add(checkBoxFront);

        // Признак наличия задней части корабля
        checkBoxBack = new JCheckBox("Back");
        checkBoxBack.setSelected(true);
        checkBoxBack.setBounds(180, 310, 150, 30);
        confPanel.add(checkBoxBack);

        // Признак наличия якоря
        checkBoxAnchor = new JCheckBox("Anchor");
        checkBoxAnchor.setSelected(true);
        checkBoxAnchor.setBounds(180, 340, 120, 30);
        confPanel.add(checkBoxAnchor);

        // Признак наличия паруса
        checkBoxSail = new JCheckBox("Sail");
        checkBoxSail.setSelected(true);
        checkBoxSail.setBounds(180, 370, 120, 30);
        confPanel.add(checkBoxSail);

        // Создание лейбла "Number of Sails" с механизмом Drag & Drop
        labelSailsNum = new JLabel("Number of Sails");
        labelSailsNum.setBounds(400, 220, 100, 50);
        labelSailsNum.setBorder(new BevelBorder(BevelBorder.RAISED));
        labelSailsNum.setTransferHandler(new TransferHandler("text"));
        labelSailsNum.addMouseListener(mouseType);
        labelSailsNum.setDropTarget(null);
        confPanel.add(labelSailsNum);

        // Создание лейбла "Vertical Shape" с механизмом Drag & Drop
        labelSailsShapeVertical = new JLabel("Vertical Shape");
        labelSailsShapeVertical.setBounds(400, 280, 100, 50);
        labelSailsShapeVertical.setBorder(new BevelBorder(BevelBorder.RAISED));
        labelSailsShapeVertical.setTransferHandler(new TransferHandler("text"));
        labelSailsShapeVertical.addMouseListener(mouseType);
        labelSailsShapeVertical.setDropTarget(null);
        confPanel.add(labelSailsShapeVertical);

        // Создание лейбла "Horizontal Shape" с механизмом Drag & Drop
        labelSailsShapeHorizontal = new JLabel("Horizontal Shape");
        labelSailsShapeHorizontal.setBounds(400, 340, 100, 50);
        labelSailsShapeHorizontal.setBorder(new BevelBorder(BevelBorder.RAISED));
        labelSailsShapeHorizontal.setTransferHandler(new TransferHandler("text"));
        labelSailsShapeHorizontal.addMouseListener(mouseType);
        labelSailsShapeHorizontal.setDropTarget(null);
        confPanel.add(labelSailsShapeHorizontal);

        // Переключатель числа парусов
        spinnerSailsNum = new JSpinner();
        spinnerSailsNum.setBounds(400, 410, 60, 20);
        spinnerSailsNum.setModel(new SpinnerNumberModel(1, 1, 3, 1));
        confPanel.add(spinnerSailsNum);

        // Событие переключения цвета
        PropertyChangeListener colorChangeListener = PropertyChangeEvent ->
        {
            if (pictureBoat == null) return;
            if (pictureBoat.getClass().equals(Boat.class) || pictureBoat.getClass().equals(Sailboat.class))
            {
                setMainColor();
            }
            if (pictureBoat.getClass().equals(Sailboat.class))
            {
                setSecondaryColor();
            }
        };

        // Событие переключения типа лодки
        PropertyChangeListener typeChangeListener = PropertyChangeEvent ->
        {
            if (pictureMask.getText().equals("Boat"))
            {
                setBoat();
            } else if (pictureMask.getText().equals("Sailboat"))
            {
                setSailboat();
            }
            if (pictureBoat != null && pictureBoat.getClass().equals(Sailboat.class))
            {
                switch (pictureMask.getText())
                {
                    case "Number of Sails":
                        setSailsNumAndShape(1);
                        break;
                    case "Vertical Shape":
                        setSailsNumAndShape(2);
                        break;
                    case "Horizontal Shape":
                        setSailsNumAndShape(3);
                        break;
                }
            }
            pictureMask.setText("");
        };


        // Обработка нажатия кнопки "Append"
        buttonAppend.addActionListener(ActionEvent ->
        {
            parentFrame.addBoat((Vehicle) pictureBoat);
            formConfig.setVisible(false);
            formConfig.dispose();
        });

        // Обработка нажатия кнопки "Cancel"
        buttonCancel.addActionListener(ActionEvent ->
        {
            formConfig.setVisible(false);
            formConfig.dispose();
        });

        // Добавление событий элементам
        mainColor.addPropertyChangeListener(colorChangeListener);
        secondaryColor.addPropertyChangeListener(colorChangeListener);
        pictureMask.addPropertyChangeListener(typeChangeListener);
        pictureMask.addPropertyChangeListener(colorChangeListener);
        formConfig.add(confPanel);
        formConfig.setVisible(true);
    }

    // Механизм Drag & Drop
    public class MouseReaction extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            if (e.getSource().getClass().equals(JLabel.class))
            {
                JLabel element = (JLabel) e.getSource();
                TransferHandler handler = element.getTransferHandler();
                handler.exportAsDrag(element, e, TransferHandler.COPY);
            } else if (e.getSource().getClass().equals(JPanel.class))
            {
                JPanel element = (JPanel) e.getSource();
                TransferHandler handler = element.getTransferHandler();
                handler.exportAsDrag(element, e, TransferHandler.COPY);
            }
        }
    }

    // Метод создания лодки
    public void setBoat()
    {
        pictureBoat = new Boat((int) spinnerChooseSpeed.getValue(), (int) spinnerChooseWeight.getValue(), Color.GRAY, 180, 60);
        pictureBoat.setPosition(20, 25, formConfig.getWidth(), formConfig.getHeight());
        drawPanel.setBoat(pictureBoat);
        drawPanel.repaint();
    }

    // Метод создания парусника
    public void setSailboat()
    {
        pictureBoat = new Sailboat((int) spinnerChooseSpeed.getValue(), (int) spinnerChooseWeight.getValue(), Color.GRAY, Color.CYAN, checkBoxFront.isSelected(), checkBoxBack.isSelected(), checkBoxAnchor.isSelected(), checkBoxSail.isSelected(), 1, 1);
        pictureBoat.setPosition(20, 25, confPanel.getWidth(), confPanel.getHeight());
        drawPanel.setBoat(pictureBoat);
        drawPanel.repaint();
    }

    // Метод, позволяющий установить число или форму парусов
    public void setSailsNumAndShape(int ID)
    {
        pictureBoat = new Sailboat((int) spinnerChooseSpeed.getValue(), (int) spinnerChooseWeight.getValue(), Color.GRAY, Color.CYAN, checkBoxFront.isSelected(), checkBoxBack.isSelected(), checkBoxAnchor.isSelected(), checkBoxSail.isSelected(), ID, (int) spinnerSailsNum.getValue());
        pictureBoat.setPosition(20, 50, confPanel.getWidth(), confPanel.getHeight());
        drawPanel.setBoat(pictureBoat);
        drawPanel.repaint();
    }

    // Метод отрисовки главного цвета
    public void setMainColor()
    {
        Boat boat = (Boat) pictureBoat;
        boat.setMainColor(mainColor.getBackground());
        drawPanel.setBoat(pictureBoat);
        drawPanel.repaint();
        pictureMask.repaint();
    }

    // Метод установки дополнительного цвета
    public void setSecondaryColor()
    {
        Sailboat sailboat = (Sailboat) pictureBoat;
        sailboat.setSecondaryColor(secondaryColor.getBackground());
        drawPanel.setBoat(pictureBoat);
        drawPanel.repaint();
        pictureMask.repaint();
    }

    // Метод отрисовки
    public class drawPanel extends JPanel
    {
        private ITransport boat;

        public void setBoat(ITransport boat)
        {
            this.boat = boat;
        }

        public void paintComponent(Graphics gr)
        {
            if (boat != null)
            {
                boat.drawTransport(gr);
            }
        }
    }
}
