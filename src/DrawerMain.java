import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class DrawerMain extends JPanel {

    GeneralPath filledPolygon = null;
    GeneralPath filledPolygon2 = null;

    public DrawerMain() {
        ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {

                TimeMover.Ticker();

            }

        };
        Timer timer = new Timer(10,animate);
        timer.setRepeats(true);
        timer.start();
        //timeMover.TimeMAchine(animate);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // for background
        g.setColor(Color.GRAY);
        g.fillRect(0,0,500,500);
        g.drawImage(DayLightShow.map,0,0,500,250,this);


        g.setColor(Color.RED);
        g.fillRect(0,0,2,2);
        //g.setColor(Color.BLUE);

        // scale 1:2
        Graphics2D g2 = (Graphics2D) g;
        Curve.curve(filledPolygon,0,g2);
        Curve.curve(filledPolygon2,480,g2);
        g.setColor(Color.RED);
        g.drawLine(250,0,250,500);

        repaint();
    }
}
