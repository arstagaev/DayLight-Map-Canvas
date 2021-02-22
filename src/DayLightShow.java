import enums.StageOfYear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.TimeZone;

public class DayLightShow extends DrawerMain {
    private JFrame frame;
    private DrawerMain drawerMain = new DrawerMain();
    public static Image map;


    public DayLightShow() {
        timeMachine();

    }

    public void timeMachine(){
        /**
         * if minutes = 0 then Ax = 0
         * curves moves to left
         * [hours in London * 21 (coeff)]
         */
        Calendar timeNow = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));
        System.out.println("old java "+ timeNow.get(Calendar.HOUR_OF_DAY) + ":" + timeNow.get(Calendar.MINUTE));

        TimeMover.minutes = -((timeNow.get(Calendar.HOUR_OF_DAY))*21); // UTC
        System.out.println("Current minutes " + LocalDateTime.now().getHour());
        System.out.println("minutes coord: "+ TimeMover.minutes);


        BaseFigure.dayDynamics();
        //BaseFigure.seasonDynamics(timeNow.get(Calendar.DAY_OF_MONTH)*2,7);
        //BaseFigure.setMoveSpeed(200);

    }

    public static void main(String... args)
    {
        new DayLightShow().go();
    }

    private void go() {

        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                        //up
                        //TimeMover.timeline++;
                        //BaseFigure.seasonDynamics(200,1);
                        BaseFigure.seasonDynamics(200,1);
                    }
                    case 40 -> {
                        //down
                        //TimeMover.timeline--;
                        BaseFigure.seasonDynamics(10,12);

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
        System.out.println("LOG timeline "+TimeMover.timeline+" min "+TimeMover.minutes+"\n"
                +" stageyear "+TimeMover.stageOfYear);
    }
}
