package map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;

/*
Made by @arstagaev in 2020
 */
public class DrawWaveTrying {

    JFrame frame;
    private DrawPanel4 drawPanel4 = new DrawPanel4();

    private int oneX = 7;
    private int oneY = 7;

    private int ovalX = 60;
    private int ovalY = 120;

    private int sizeoval = 1;
    private int antisize = -1;
    private boolean increase = true;

    boolean goToRight = true;



    //int a = 0;

    public static void main(String... args)
    {
        new DrawWaveTrying().go();
    }

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //drawPanel = new CircleAndCubic().DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, drawPanel4);

        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        //heartanim();
    }



    class DrawPanel4 extends JPanel
    {
        //private static final long serialVersionUID = 1L;
        int er = 0;

        int days = 0;
        int x = 0;
        int y = 0;
        boolean directionToLeft = true;

        GeneralPath filledPolygon = null;
        GeneralPath filledPolygon2 = null;
        Curve curveDraw = new Curve();
        TimeSeasons timeSeasons = new TimeSeasons();

        public DrawPanel4() {
            ActionListener animate = new ActionListener() {
                public void actionPerformed(ActionEvent ae) {

                    moveIt();
                    repaint();
                    //er++;
                    x = mover(x);
                    days = timeSeasons.seasonsMotion(days);


                }

            };
            Timer timer = new Timer(10,animate);
            timer.setRepeats(true);
            timer.start();
        }
         int mover(int x){
            if (x<-499){
                directionToLeft=false;
            }else if(x==0) {
                directionToLeft=true;
            }
            if (directionToLeft){
                x--;
            }else {
                x++;
            }

            return x = 0;
        }

        public void paintComponent(Graphics g)
        {
           /*
           Parameters:
              x - the x coordinate of the rectangle to be filled.
              y - the y coordinate of the rectangle to be filled.
              width - the width of the rectangle to be filled.
              height - the height of the rectangle to be filled.
            */
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
//            g.setColor(Color.RED);
//            g.fillRect(3, 3, this.getWidth() - 6, this.getHeight() - 6);
//            g.setColor(Color.WHITE);
//            g.fillRect(6, 6, this.getWidth() - 12, this.getHeight() - 12);
            Graphics2D g2 = (Graphics2D) g;


            // Black is cubic
            g.setColor(Color.BLUE);
            // fill and stroke GeneralPath

            // draw main curve
            curveDraw.curve(x,y,filledPolygon,days, g2);


            g.setColor(Color.GREEN);
            g.fillRect(xControl(x)+10,300,xControl(x)+100,350);

//            if (x<-499){
//                curveDraw.curve(x+999,y,filledPolygon, g2);
//
//            }
            if (x<0){

                curveDraw.curve(x+500,y,filledPolygon,days, g2);
            }

            System.out.println(x);

/////////////////////////////////////////////////////////
            g.setColor(Color.BLACK);
            Polygon p2 = new Polygon();
            for (int i = 0; i < 5; i++) p2.addPoint(
                    (int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
                    (int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

            g.drawPolygon(p2);

            g.setColor(Color.RED);
            g.fillOval(ovalX-sizeoval/2,ovalY-sizeoval/2,1+sizeoval,1+sizeoval);



            //repaint();
        }
        public int xControl(int x){
            if (x<0){
                x = 500-(x*-1);
            }
            return x;
        }


    }

    public static int [] xCoord(){
        int [] xCoord = {0,0,50,50};
        return xCoord;
    }

    public static int [] yCoord(){
        int [] yCoord = {0,50,50,4};
        return yCoord;
    }


    private void increaseOval(){
        if (sizeoval<60){
            sizeoval++;
            antisize = sizeoval*(-1);
        }else{
            increase = false;
        }
        //System.out.println(sizeoval);
    }

    private void decreaseOval(){
        if (sizeoval>1){
            sizeoval--;
            antisize = sizeoval*(-1);
        }else{
            increase = true;
        }
        System.out.println(sizeoval);
    }



    private void moveIt() {

        if (increase){
            increaseOval();
        }else{
            decreaseOval();
        }

        if (oneX==230){
            goToRight = false;
            // a = 0;
        } else if(oneX == 0){
            goToRight = true;
            // a = 0;
        }

        if (goToRight){
            toRight();
        }else {
            toLeft();
        }


    }

    private void toRight(){
        oneX++;
        //ovalX++;
    }
    private void toLeft(){
        oneX--;
        //ovalX--;
    }
}
