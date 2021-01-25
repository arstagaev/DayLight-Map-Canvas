package map;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Curve {

    static int roundControl = 1;
    int x200 = 0;
    int x300 = 0;


    public GeneralPath curve(int x, int y, GeneralPath filledPolygon,int days, Graphics2D g2){
//        if (x<-500){
//            x= 500+x;
//        }
        x200 = x+200;
        x300 = x+300;


        int rectWidth = 100;
        int rectHeight = 100;
        Direction direction;
        // fill and stroke GeneralPath
        int x3Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y3Points[] = {y, y+rectHeight, y+rectHeight, y};

        filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, x3Points.length);

//        filledPolygon.moveTo(xAxisRouter(x,0), y);
//        filledPolygon.curveTo(xAxisRouter(x,0),y,xAxisRouter(x,100),y,xAxisRouter(x,100),y+100);
//        filledPolygon.curveTo(xAxisRouter(x,100),y+100,xAxisRouter(x,100),y+200,xAxisRouter(x,200),y+200);
//        filledPolygon.lineTo(xAxisRouter(x,300),y+200);
//        filledPolygon.curveTo(xAxisRouter(x,300),y+200,xAxisRouter(x,400),y+200,xAxisRouter(x,400),y+100);
//        filledPolygon.curveTo(xAxisRouter(x,400),y+100,xAxisRouter(x,400),y,xAxisRouter(x,500),y);
//        filledPolygon.lineTo(xAxisRouter(x,0),y);


        filledPolygon.moveTo(days(days,x,Figure.FIRST),y);
        filledPolygon.curveTo(days(days,x,Figure.FIRST),y,x+100,y,x+100,y+100);
        filledPolygon.curveTo(x+100,y+100,x+100,y+200,x+200,y+200);
        filledPolygon.lineTo(x+300,y+200);
        filledPolygon.curveTo(x+300,y+200,x+400,y+200,x+400,y+100);
        filledPolygon.curveTo(x+400,y+100,x+400,y,x+500,y);
        filledPolygon.lineTo(days(days,x,Figure.FIRST),y);

        if (x<0){

        }else if (x>0){

        }

        filledPolygon.closePath();
        g2.setPaint(Color.RED);
        g2.fill(filledPolygon);

        return filledPolygon;
    }
    Direction direction = Direction.STOP;

    public int days(int days,int x,Figure quarter){
        int xend = 0;
        if (days<=1){
            direction = Direction.RIGHT;
        }else if (days>=x200){
            direction = Direction.LEFT;
        }

        if (days<=1){
            direction = Direction.RIGHT;
        }else if (days>=x200){
            direction = Direction.LEFT;
        }

        switch (direction){
            case LEFT -> {
                days = days-1;
                break;
            }
            case RIGHT -> {
                days = days+1;
                break;
            }
            case STOP -> {
                days = x;
                break;
            }
        }
        System.out.println("GG "+days);
        return days;
    }

    public static int xAxisRouter(int x, int adj){
        int mainOutput = 0;
        if (x+adj<0){
            mainOutput = 500;
        }else {
            mainOutput = x+adj;
        }
        return mainOutput;
    }

    public static int xRoundToRight(int x){
        int newX =x;
        if (x<0){
            newX = x/2;
        }else {
            newX = x*2;
        }

        return x;
    }

    public static int xRoundToLeft(int x){

        int newX =x;
        if (x<0){
            newX = x*2;
        }else {
            newX = x/2;
        }

        System.out.println("### "+newX);
        return x;
    }
}
