package map;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Curve {


    public GeneralPath curve(int x, int y, GeneralPath filledPolygon, Graphics2D g2){
        if (x<-500){
            x= 500+x;
        }


        int rectWidth = 100;
        int rectHeight = 100;
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

        filledPolygon.moveTo(x, y);
        filledPolygon.curveTo(x,y,x+100,y,x+100,y+100);
        filledPolygon.curveTo(x+100,y+100,x+100,y+200,x+200,y+200);
        filledPolygon.lineTo(x+300,y+200);
        filledPolygon.curveTo(x+300,y+200,x+400,y+200,x+400,y+100);
        filledPolygon.curveTo(x+400,y+100,x+400,y,x+500,y);
        filledPolygon.lineTo(x,y);

        if (x<0){

        }else if (x>0){

        }




//            for (int index = 1; index < x3Points.length; index++) {
//
//                filledPolygon.lineTo(x3Points[index], y3Points[index]);
//                //filledPolygon.curveTo();
//
//            }

        filledPolygon.closePath();
        g2.setPaint(Color.RED);
        g2.fill(filledPolygon);

        return filledPolygon;
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


}
