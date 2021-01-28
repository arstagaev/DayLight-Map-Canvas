package map2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

public class DrawerMain extends JPanel {

    //private static final long serialVersionUID = 1L;
    //TimeMover timeMover = new TimeMover();
    Curve curve = new Curve();

    int er = 0;

    //int days = 0;
//    int x = 0;
//    int y = 0;

    GeneralPath filledPolygon = null;
    //GeneralPath filledPolygon2 = null;

    public DrawerMain() {
        ActionListener animate = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {


                //er++;
//                x = timeMover.hours(x);
//                days = timeMover.days(days);
                //curve
                TimeMover.Ticker();

            }

        };
        Timer timer = new Timer(10,animate);
        timer.setRepeats(true);
        timer.start();
        //timeMover.TimeMAchine(animate);

    }

    public void Refresh(){
        repaint();
    }



    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // set backroundcolor
//        g.setColor(Color.BLACK);
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());


        Graphics2D g2 = (Graphics2D) g;
        Curve.curve(filledPolygon,g2);
        Curve.curve(filledPolygon,g2);



        g.setColor(Color.GREEN);
        g.fillRect(10,10,100,350);
        repaint();
    }


}
