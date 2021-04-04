

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DayLightShow extends DrawerMain {
    private JFrame frame;
    private DrawerMain drawerMain = new DrawerMain();
    public static Image map;


    public DayLightShow() {
        long timestampUTC = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("HH");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        int hr = Integer.parseInt(sdf.format(new Date(timestampUTC)));

        SimpleDateFormat sdf2 = new SimpleDateFormat("mm");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        int min = Integer.parseInt((sdf2.format(new Date(timestampUTC))));

        System.out.println("777 "+hr + min);

        //timeMachine(hr,min);
        timeMachine(0,0);

    }

    public void timeMachine(int hr, int min){
//        val sdf = java.text.SimpleDateFormat("MM-dd HH:mm ZZZZ")
//        sdf.timeZone = TimeZone.getTimeZone(PreferenceMaestro.chosenTimeZone)
//        var hr : String = sdf.format(java.util.Date(timestamp * 1000))


        BaseFigure.currentTime = -(int) (0.34*min+0.34*60*hr);
    }

    public static void main(String... args)
    {
        new DayLightShow().go();
    }
//    int a = 1;
    private void go() {

        frame = new JFrame("Map");
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
        initTimeLine();

//        int a =1;
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.out.println("Button clicked" +e.getKeyCode());
                switch (e.getKeyCode()) {
                    case 39 -> {
                        //right
//                        Point.setY(Point.y);
                        //TimeMover.minutes = 1;
                        //a++;
                        //AnimationSeason.dayDynamics(1);
                        AnimationSeason.dayDynamics((-60*12)/3);

                    }
                    case 37 -> {
                        //left
                        //a--;
                        AnimationSeason.dayDynamics(-1);
                    }
                    case 38 -> {
                        //up
                        BaseFigure.seasonPPCoeff++;
                        AnimationSeason.seasonDynamics((int) (BaseFigure.seasonPPCoeff));

                    }
                    case 40 -> {
                        //down

                        BaseFigure.seasonPPCoeff--;
                        AnimationSeason.seasonDynamics((int) (BaseFigure.seasonPPCoeff));
                        // 1 day = 2.191780
                    }
                    case 32 ->{

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

    private void initTimeLine() {
        AnimationSeason.initTimeLine();
    }

    private void showVars() {
//        System.out.println("LOG timeline "+TimeMover.timeline+" min "+TimeMover.minutes+"\n"
//                +" stageyear "+TimeMover.stageOfYear);
    }
}
