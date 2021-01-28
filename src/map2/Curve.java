package map2;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Curve extends BaseFigure {
    //int daysx = 0;
    public static int x = 0;
    public static int y = 0;



    public static GeneralPath curve(GeneralPath filledPolygon, Graphics2D g2){
        //System.out.println("CURVE: "+ daysx);

        int rectWidth = 100;
        int rectHeight = 100;
        //Direction direction;
        // fill and stroke GeneralPath


        filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

//        filledPolygon.moveTo(Ax,y);
//        filledPolygon.curveTo(Ax,y,x+100,y,x+100,y+100);
//        filledPolygon.curveTo(x+100,y+100,x+100,y+200,Cx,y+200);
//        filledPolygon.lineTo(Dx,y+200);
//        filledPolygon.curveTo(Dx,y+200,x+400,y+200,x+400,y+100);
//        filledPolygon.curveTo(x+400,y+100,x+400,y, Ex,y);
//        filledPolygon.lineTo(Ax,y);
        //daysx = Ticker();
        //System.out.println("in Curve "+ Ax);

        filledPolygon.moveTo(Ax,y);
        filledPolygon.curveTo(Ax,y,Bx,y,Bx,y+100);
        filledPolygon.curveTo(Bx,y+100,Bx,y+200,Cx,y+200);
        filledPolygon.lineTo(Dx,y+200);
        filledPolygon.curveTo(Dx,y+200,Fx,y+200,Fx,y+100);
        filledPolygon.curveTo(Fx,y+100,Fx,y, Ex,y);
        filledPolygon.lineTo(Ax,y);


        filledPolygon.closePath();
        g2.setPaint(Color.BLUE);
        g2.fill(filledPolygon);

        return filledPolygon;
    }

}
