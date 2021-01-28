package map2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DayLightShow extends DrawerMain {
    private JFrame frame;
    private DrawerMain drawerMain = new DrawerMain();

    public DayLightShow() {

    }

    public static void main(String... args)
    {
        new DayLightShow().go();
    }

    private void go() {

        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        JPanel p = new JPanel();
//        JButton button = new JButton("Button");
//        p.setLayout(null);
//        button.setBounds(40, 100, 100, 60);
//        p.add(button);

        //drawPanel = new CircleAndCubic().DrawPanel();

        frame.getContentPane()
                .add(BorderLayout.CENTER, drawerMain)
                .setBackground(Color.GRAY);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Button clicked" +e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 39 -> {
                        //right
//                        Point.setY(Point.y);
                        TimeMover.minutes++;
                    }
                    case 37 -> {
                        //left
                        TimeMover.minutes--;
                    }
                    case 38 -> {
                        //down
                    }
                    case 32 ->{
                        TimeMover.stageOfYear = StageOfYear.STOPIT;
                    }
                }
                BaseFigure.dayDynamics();

            }
        });

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);



        //heartanim();
    }
    private void showButtonDemo(){

        JButton okButton = new JButton("OK");
        okButton.setSize(100,100);
        okButton.setLocation(300,300);
        okButton.setBackground(Color.BLACK);
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        frame.setVisible(true);
    }


}
