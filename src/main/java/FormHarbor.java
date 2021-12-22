import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import sun.misc.Queue;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

public class FormHarbor extends JPanel
{
    private JButton buttonCreateBoat, buttonTakeBoat, buttonAddHarbor, buttonDelHarbor, buttonRemovedBoat, buttonSortBoats;
    private JFrame frame;
    private JPanel mainPanel;
    private Container panelElements;
    private JFormattedTextField textFieldPlace;
    private JTextField textFieldHarborName;
    private JList<Harbor<ITransport, InterAdd>> listBoxHarbor;
    private Harbor<ITransport, InterAdd> harbor;
    private HarborCollection harborCollection;
    private Queue<ITransport> removedStages;
    private JMenuBar menuBar;
    private JMenu fileAllHarbors, fileThisHarbor;
    private JMenuItem save, load, saveHarbor, loadHarbor;
    private static final Logger logger = Logger.getLogger(FormHarbor.class);

    public FormHarbor()
    {
        // Инициализация окна
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Harbor");
        frame.setSize(900, 625);

        // Панель меню
        // Инициализация меню
        menuBar = new JMenuBar();
        // Инициализация пунктов меню
        fileAllHarbors = new JMenu("All Harbors");
        fileThisHarbor = new JMenu("This Harbor");
        // Сохранить и загрузить все гавани
        save = new JMenuItem("Save");
        save.setActionCommand("Save");
        load = new JMenuItem("Load");
        load.setActionCommand("Load");
        // Сохранить и загрузить отдельную гавань
        saveHarbor = new JMenuItem("Save");
        saveHarbor.setActionCommand("SaveHarbor");
        loadHarbor = new JMenuItem("Load");
        loadHarbor.setActionCommand("LoadHarbor");
        // Добавление элементов
        fileAllHarbors.add(save);
        fileAllHarbors.add(load);
        fileThisHarbor.add(saveHarbor);
        fileThisHarbor.add(loadHarbor);
        menuBar.add(fileAllHarbors);
        menuBar.add(fileThisHarbor);

        frame.setJMenuBar(menuBar);

        // Создание объекта от класса-коллекции
        harborCollection = new HarborCollection(674, 450);
        // Коллекция удалённых лодок
        removedStages = new Queue<>();

        panelElements = frame.getContentPane();
        panelElements.setLayout(null);

        // Создание лейбла "Harbors"
        JLabel labelHarbors = new JLabel("Harbors:");
        labelHarbors.setBounds(680, 12, 53, 17);
        panelElements.add(labelHarbors);

        // Поле ввода
        textFieldHarborName = new JTextField();
        textFieldHarborName.setBounds(680, 32, 140, 22);
        panelElements.add(textFieldHarborName);

        // Список
        listBoxHarbor = new JList<>();
        listBoxHarbor.setModel(harborCollection.modelList);
        listBoxHarbor.setBounds(680, 90, 140, 140);
        listBoxHarbor.setVisibleRowCount(-1);
        panelElements.add(listBoxHarbor);

        // Обработчик списка
        listBoxHarbor.getSelectionModel().addListSelectionListener(e ->
                                                                   {
                                                                       harbor = listBoxHarbor.getSelectedValue();
                                                                       if (harbor == null)
                                                                       {
                                                                           frame.getGraphics().clearRect(0, 75, 674,
                                                                                                         525);
                                                                       }
                                                                       else
                                                                       {
                                                                           frame.getGraphics().clearRect(0, 75, 674,
                                                                                                         525);
                                                                           harbor.setBounds(0, 75, 674, 525);
                                                                           harbor.setBackground(new Color(0, 0, 0, 0));
                                                                           panelElements.add(harbor);
                                                                           harbor.setLayout(null);
                                                                           logger.log(Level.INFO,
                                                                                      "Moving on to harbor: " + harbor.getName());
                                                                           draw();
                                                                       }
                                                                   });

        // Создание кнопки "Add Harbor"
        buttonAddHarbor = new JButton("Add Harbor");
        buttonAddHarbor.setBackground(Color.WHITE);
        buttonAddHarbor.setActionCommand("AddHarbor");
        buttonAddHarbor.setBounds(680, 60, 140, 24);
        panelElements.add(buttonAddHarbor);

        // Создание кнопки "Del Harbor"
        buttonDelHarbor = new JButton("Del Harbor");
        buttonDelHarbor.setBackground(Color.WHITE);
        buttonDelHarbor.setActionCommand("DelHarbor");
        buttonDelHarbor.setBounds(680, 240, 140, 24);
        panelElements.add(buttonDelHarbor);

        // Создание кнопки "Create Boat"
        buttonCreateBoat = new JButton("Create Boat");
        buttonCreateBoat.setBackground(Color.WHITE);
        buttonCreateBoat.setActionCommand("CreateBoat");
        buttonCreateBoat.setBounds(680, 321, 140, 24);
        panelElements.add(buttonCreateBoat);

        // Создание кнопки "Take Boat"
        buttonTakeBoat = new JButton("Take Boat");
        buttonTakeBoat.setBackground(Color.WHITE);
        buttonTakeBoat.setActionCommand("TakeBoat");
        buttonTakeBoat.setBounds(680, 405, 140, 24);
        panelElements.add(buttonTakeBoat);

        // Создание кнопки "Removed Boat"
        buttonRemovedBoat = new JButton("Removed Boat");
        buttonRemovedBoat.setBackground(Color.ORANGE);
        buttonRemovedBoat.setActionCommand("RemovedBoat");
        buttonRemovedBoat.setBounds(680, 426, 140, 24);
        panelElements.add(buttonRemovedBoat);

        buttonSortBoats = new JButton("Sort Boats");
        buttonSortBoats.setBackground(Color.WHITE);
        buttonSortBoats.setActionCommand("SortBoats");
        buttonSortBoats.setBounds(680, 295, 140, 24);
        panelElements.add(buttonSortBoats);

        // Создание лейбла "Place: "
        JLabel labelPlace = new JLabel("Place: ");
        labelPlace.setBounds(680, 375, 53, 17);
        panelElements.add(labelPlace);

        // Поле ввода
        textFieldPlace = new JFormattedTextField();
        textFieldPlace.setBounds(726, 375, 94, 22);
        panelElements.add(textFieldPlace);

        ActionListener actionListener = new FormHarbor.ButtonActions();
        buttonCreateBoat.addActionListener(actionListener);
        buttonTakeBoat.addActionListener(actionListener);
        buttonAddHarbor.addActionListener(actionListener);
        buttonDelHarbor.addActionListener(actionListener);
        buttonRemovedBoat.addActionListener(actionListener);
        buttonSortBoats.addActionListener(actionListener);
        save.addActionListener(actionListener);
        load.addActionListener(actionListener);
        saveHarbor.addActionListener(actionListener);
        loadHarbor.addActionListener(actionListener);
        frame.setVisible(true);
        super.repaint();
    }

    public void createConfigWindow()
    {
        FormBoatConfig form = new FormBoatConfig(this);
    }

    public class ButtonActions extends JPanel implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser dialog = new JFileChooser("C:\\Users\\Tony\\Desktop");
            FileFilter filter = new FileNameExtensionFilter("TXT file", "txt");
            dialog.setFileFilter(filter);
            switch (e.getActionCommand())
            {
                case "CreateBoat":
                    if (harbor != null)
                    {
                        createConfigWindow();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Create harbor at first.");
                    }
                    break;
                case "TakeBoat":
                    ITransport boat;
                    try
                    {
                        boat = harbor.del(harbor, Integer.parseInt(textFieldPlace.getText()));
                        removedStages.enqueue(boat);
                        logger.info("Removing boat: " + boat.toString());
                        draw();
                    }
                    catch (HarborNotFoundException harborNotFoundException)
                    {
                        logger.log(Level.WARN, "Harbor is not found: " + Integer.parseInt(textFieldPlace.getText()));
                        JOptionPane.showMessageDialog(null, "Harbor is not found", "Warning!",
                                                      JOptionPane.WARNING_MESSAGE);
                    }
                    catch (NumberFormatException numberFormatException)
                    {
                        logger.log(Level.ERROR, "Wrong number format");
                        JOptionPane.showMessageDialog(null, "Wrong number format", "Warning!",
                                                      JOptionPane.WARNING_MESSAGE);
                    }
                    catch (Exception exception)
                    {
                        logger.log(Level.FATAL, "Fatal unexpected error");
                    }
                    break;
                case "AddHarbor":
                    if (textFieldHarborName.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null, "Enter a harbor's name first.");
                    }
                    else
                    {
                        harbor = harborCollection.addHarbor(textFieldHarborName.getText());
                        if (harbor != null)
                        {
                            logger.log(Level.INFO, "Harbor was created: " + harbor.getName());
                            harbor.setBounds(0, 75, 674, 525);
                            harbor.setBackground(new Color(0, 0, 0, 0));
                            panelElements.add(harbor);
                            harbor.setLayout(null);
                            draw();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "The harbor with this name has already been created.");
                        }
                        textFieldHarborName.setText("");
                    }


                    harbor = harborCollection.addHarbor(textFieldHarborName.getText());

                    textFieldHarborName.setText("");
                    break;
                case "DelHarbor":
                    if (harborCollection.modelList.indexOf(harbor) > -1)
                    {
                        logger.log(Level.INFO, "Harbor was removed: " + harbor.getName());
                        harborCollection.delHarbor(
                                harborCollection.modelList.get(harborCollection.modelList.indexOf(harbor)).getName());
                        frame.getGraphics().clearRect(0, 75, 674, 525);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The collection of harbors is empty.");
                    }
                    break;
                case "RemovedBoat":
                    boat = null;
                    if (!removedStages.isEmpty())
                    {
                        try
                        {
                            boat = removedStages.dequeue();
                            logger.log(Level.INFO, "Boat was dequeued: " + boat.toString());
                        }
                        catch (InterruptedException interruptedException)
                        {
                            interruptedException.printStackTrace();
                            logger.log(Level.ERROR, "Interrupted Exception");
                        }
                        draw();
                    }
                    if (boat != null)
                    {
                        FormBoat removedBoat = new FormBoat();
                        removedBoat.setBoat((Vehicle) boat);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The collection of removed boats is empty.");
                    }
                    draw();
                    break;
                case "Save":
                    if (dialog.showDialog(null, "Save File") == JFileChooser.APPROVE_OPTION)
                    {
                        File file = dialog.getSelectedFile();
                        try
                        {
                            if (harborCollection.saveData(file.getAbsolutePath()))
                            {
                                JOptionPane.showMessageDialog(null, "Collection saved successfully.");
                            }
                        }
                        catch (Exception exception)
                        {
                            logger.log(Level.FATAL, "Fatal unexpected error");
                        }
                    }
                    break;
                case "Load":
                    if (dialog.showDialog(null, "Load File") == JFileChooser.APPROVE_OPTION)
                    {
                        File file = dialog.getSelectedFile();
                        try
                        {
                            if (harborCollection.loadData(file.getAbsolutePath()))
                            {
                                JOptionPane.showMessageDialog(null, "Collection loaded successfully.");
                            }
                        }
                        catch (HarborOverflowException harborOverflowException)
                        {
                            logger.log(Level.WARN, "Harbor overflow exception");
                            JOptionPane.showMessageDialog(null, "Harbor overflow", "Waring",
                                                          JOptionPane.WARNING_MESSAGE);
                        }
                        catch (FileNotFoundException fileNotFoundException)
                        {
                            logger.log(Level.ERROR, "File was not found");
                            JOptionPane.showMessageDialog(null, "File was not found", "Error",
                                                          JOptionPane.ERROR_MESSAGE);
                        }
                        catch (Exception exception)
                        {
                            logger.log(Level.FATAL, "Fatal unexpected error");
                        }
                    }
                    try
                    {
                        harbor.draw(harbor.getGraphics());
                    }
                    catch (NullPointerException ex)
                    {
                        return;
                    }
                    break;
                case "SaveHarbor":
                    if (dialog.showDialog(null, "Save File") == JFileChooser.APPROVE_OPTION)
                    {
                        File file = dialog.getSelectedFile();
                        try
                        {
                            if (harborCollection.saveDataFromHarbor(file.getAbsolutePath(), harbor))
                            {
                                JOptionPane.showMessageDialog(null, "Harbor saved successfully.");
                            }
                        }
                        catch (Exception exception)
                        {
                            logger.log(Level.FATAL, "Fatal unexpected error");
                        }
                    }
                    break;
                case "LoadHarbor":
                    if (dialog.showDialog(null, "Load File") == JFileChooser.APPROVE_OPTION)
                    {
                        File file = dialog.getSelectedFile();
                        try
                        {
                            if (harborCollection.loadDataFromHarbor(file.getAbsolutePath()))
                            {
                                JOptionPane.showMessageDialog(null, "Harbor loaded successfully");
                            }
                            harbor.draw(harbor.getGraphics());
                        }
                        catch (HarborOverflowException harborOverflowException)
                        {
                            logger.log(Level.WARN, "Harbor overflow exception");
                            JOptionPane.showMessageDialog(null, "Harbor overflow", "Waring",
                                                          JOptionPane.WARNING_MESSAGE);
                        }
                        catch (FileNotFoundException fileNotFoundException)
                        {
                            logger.log(Level.ERROR, "File not found");
                            JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        catch (Exception exception)
                        {
                            logger.log(Level.FATAL, "Fatal unexpected error");
                        }
                    }
                    break;
                case "SortBoats":
                    if (harbor != null)
                    {
                        harbor.sort();
                    }
                    draw();
                    break;
            }
        }
    }

    public void addBoat(Vehicle boat) throws HarborOverflowException
    {
        if (boat != null)
        {
            try
            {
                harbor.add(harbor, boat);
                harbor.draw(harbor.getGraphics());
            }
            catch (HarborOverflowException harborOverflowException)
            {
                logger.log(Level.WARN, "Harbor overflow exception");
                JOptionPane.showMessageDialog(null, "Harbor is full", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            catch (NullPointerException nullPointerException)
            {
                logger.log(Level.ERROR, "Harbor has already been created or chosen");
                JOptionPane.showMessageDialog(null, "Harbor is not created or chosen", "Error",
                                              JOptionPane.ERROR_MESSAGE);
            }
            catch (HarborAlreadyHaveException e)
            {
                e.printStackTrace();
            }
            catch (Exception exception)
            {
                logger.log(Level.FATAL, "Fatal unexpected error");
            }
        }
    }

    public void draw()
    {
        harbor.draw(harbor.getGraphics());
        repaint();
    }
}

