package map2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;

public class DayLightShow extends DrawerMain {
    private JFrame frame;
    private DrawerMain drawerMain = new DrawerMain();
    public static Image map;


    public DayLightShow() {
        timeMachine();

    }

    public void timeMachine(){
        TimeMover.minutes = -((7)*21); // UTC
        System.out.println("Current minutes " + LocalDateTime.now().getHour());
        System.out.println("minutes coord: "+ TimeMover.minutes);
        BaseFigure.dayDynamics();

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
        //zenith == 12:00
        // 500 / 24 = 20.8
        // for 3 minutes
        /**
         * to 24 <--from 0
         */
        ImageIcon iia = new ImageIcon("Blank_Map_Equirectangular_states.svg.png");
        map = iia.getImage();

        frame.getContentPane()
                .add(BorderLayout.CENTER, drawerMain)
                .setBackground(Color.WHITE);
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Button clicked" +e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 39 -> {
                        //right
//                        Point.setY(Point.y);
                        TimeMover.minutes = 1;
                        BaseFigure.dayDynamics();
                    }
                    case 37 -> {
                        //left
                        TimeMover.minutes = -1;
                        BaseFigure.dayDynamics();
                    }
                    case 38 -> {
                        //down
                    }
                    case 32 ->{

                        if (TimeMover.stageOfYear != StageOfYear.STOPIT){
                            TimeMover.lastStageOfYear = TimeMover.stageOfYear;
                            TimeMover.stageOfYear = StageOfYear.STOPIT;
                        }else {
                            TimeMover.stageOfYear = TimeMover.lastStageOfYear;
                        }


                    }
                }

                showVars();

            }
        });

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);



        //heartanim();
    }

    private void showVars() {
        System.out.println("LOG timeline "+ TimeMover.timeline+" min "+ TimeMover.minutes+"\n"
                +" stageyear "+ TimeMover.stageOfYear);
    }

//    private void showButtonDemo(){
//
//        JButton okButton = new JButton("OK");
//        okButton.setSize(100,100);
//        okButton.setLocation(300,300);
//        okButton.setBackground(Color.BLACK);
//        okButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//
//        frame.setVisible(true);
//    }


}
