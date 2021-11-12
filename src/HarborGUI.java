import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

public class HarborGUI
{
    private Harbor<Boat, InterAdd> harbor;
    MyImage myImage;
    BufferedImage bufferedImage;
    Graphics g;

    private void draw()
    {
        g = bufferedImage.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, myImage.getWidth(), myImage.getHeight());
        harbor.draw(g);
        myImage.image = bufferedImage;
        myImage.repaint();
    }

    public HarborGUI()
    {
        JFrame frame = new JFrame("Harbor");
        frame.setLayout(null);
        frame.setSize(900, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        myImage = new MyImage();
        myImage.setSize(674, 450);
        myImage.setLocation(0, 0);

        bufferedImage = new BufferedImage(myImage.getWidth(), myImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        JButton buttonSetBoat = new JButton("Set Boat");
        buttonSetBoat.setBackground(Color.WHITE);
        buttonSetBoat.setLocation(680, 12);
        buttonSetBoat.setSize(140, 24);
        buttonSetBoat.setVisible(true);

        buttonSetBoat.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        JButton buttonSetSailboat = new JButton("Set Sailboat");
        buttonSetSailboat.setBackground(Color.WHITE);
        buttonSetSailboat.setLocation(680, 42);
        buttonSetSailboat.setSize(140, 24);
        buttonSetSailboat.setVisible(true);

        buttonSetSailboat.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
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
            }
        });

        JLabel labelTakeBoat = new JLabel("Take Boat");
        labelTakeBoat.setBounds(680, 81, 100, 17);
        labelTakeBoat.setVisible(true);

        JLabel labelPlace = new JLabel("Place:");
        labelPlace.setBounds(680, 101, 53, 17);
        labelPlace.setVisible(true);

        JTextField textFieldPlace = new JTextField();
        textFieldPlace.setLocation(726, 101);
        textFieldPlace.setSize(94, 22);
        textFieldPlace.setVisible(true);

        JButton buttonTake = new JButton("Take");
        buttonTake.setBackground(Color.WHITE);
        buttonTake.setLocation(680, 131);
        buttonTake.setSize(140, 45);
        buttonTake.setVisible(true);

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
                    BoatGUI form = new BoatGUI();
                    form.SetBoat(boat);
                }
                draw();
            }
        });


        frame.add(buttonSetBoat);
        frame.add(buttonSetSailboat);
        frame.add(labelTakeBoat);
        frame.add(labelPlace);
        frame.add(textFieldPlace);
        frame.add(buttonTake);
        frame.add(myImage);

        frame.setVisible(true);

        harbor = new Harbor<>(myImage.getWidth(), myImage.getHeight());

        draw();
    }
}
