import enums.StageOfYear;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class Curve extends BaseFigure {


    static Color color = new Color(0, 0, 255,50);



    public static GeneralPath curve(GeneralPath filledPolygon,int timeOfDay, Graphics2D g2){
        // fill and stroke GeneralPath

        timeOfDay = timeOfDay+ currentTime;
        gravityPoint = Ex-150;
        filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

        filledPolygon.moveTo(Ax+timeOfDay,y);
        filledPolygon.curveTo(
                Ax+timeOfDay,y,
                Bx+timeOfDay,y,
                Bx+timeOfDay,y+100);
        filledPolygon.curveTo(
                Bx+timeOfDay,y+100,
                Bx+timeOfDay,y+250,
                Cx+timeOfDay,y+250);
        filledPolygon.lineTo(Dx+timeOfDay,y+250);
        filledPolygon.curveTo(
                Dx+timeOfDay,y+250,
                Fx+timeOfDay,y+250,
                Fx+timeOfDay,y+100);
        filledPolygon.curveTo(
                Fx+timeOfDay,y+100,
                Fx+timeOfDay,y,
                Ex+timeOfDay,y);
        filledPolygon.lineTo(Ax+timeOfDay,y);


        filledPolygon.closePath();
        g2.setPaint(color);
        g2.fill(filledPolygon);

        return filledPolygon;
    }

    public static GeneralPath curveDarkShadow(GeneralPath filledPolygon, int timeOfDay, Graphics2D g2){
        // fill and stroke GeneralPath

        timeOfDay = timeOfDay+ BaseFigure.currentTime;
        filledPolygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD);

        //System.out.println(AnimationSeason.stageOfYear);
        if (AnimationSeason.stageOfYear == StageOfYear.FIRST) {

            filledPolygon.moveTo(Ax+20+timeOfDay,y);
            filledPolygon.curveTo(
                    Ax+20+timeOfDay,y,
                    Bx+20+timeOfDay,y,
                    Bx+20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Bx+20+timeOfDay,y+100,
                    Bx+20+timeOfDay,y+250,
                    Cx+40+timeOfDay,y+250-20);              //
            filledPolygon.lineTo(Dx-40+timeOfDay,y+250-20);  //
            filledPolygon.curveTo(                                 //
                    Dx-40+timeOfDay,y+250-20,              //
                    Fx-20+timeOfDay,y+250,
                    Fx-20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Fx-20+timeOfDay,y+100,
                    Fx-20+timeOfDay,y,
                    Ex-20+timeOfDay,y);
            filledPolygon.lineTo(Ax+20+timeOfDay,y);

        }else if(AnimationSeason.stageOfYear ==StageOfYear.SECOND){


            filledPolygon.moveTo(
                    Ax+20+timeOfDay,y+20);
            filledPolygon.curveTo(
                    Ax+20+timeOfDay,y+20,
                    Bx+20+timeOfDay,y+20,
                    Bx+20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Bx+20+timeOfDay,y+100,
                    Bx+20+timeOfDay,y+250,
                    Cx+40+timeOfDay,y+250);              //
            filledPolygon.lineTo(Dx-40+timeOfDay,y+250);  //
            filledPolygon.curveTo(                              //
                    Dx-40+timeOfDay,y+250,              //
                    Fx-20+timeOfDay,y+250+20,
                    Fx-20+timeOfDay,y+100+20);
            filledPolygon.curveTo(
                    Fx-20+timeOfDay,y+100+20,
                    Fx-20+timeOfDay,y+20,
                    Ex-20+timeOfDay,y+20);
            filledPolygon.lineTo(Ax+20+timeOfDay,y+20);




        } else if (AnimationSeason.stageOfYear == StageOfYear.THIRD) {

            filledPolygon.moveTo(
                    Ax+20+timeOfDay,y+20);
            filledPolygon.curveTo(
                    Ax+20+timeOfDay,y+20,
                    Bx+20+timeOfDay,y+20,
                    Bx+20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Bx+20+timeOfDay,y+100,
                    Bx+20+timeOfDay,y+250,
                    Cx+40+timeOfDay,y+250);              //
            filledPolygon.lineTo(Dx-40+timeOfDay,y+250);  //
            filledPolygon.curveTo(                              //
                    Dx-40+timeOfDay,y+250,              //
                    Fx-20+timeOfDay,y+250+20,
                    Fx-20+timeOfDay,y+100+20);
            filledPolygon.curveTo(
                    Fx-20+timeOfDay,y+100+20,
                    Fx-20+timeOfDay,y+20,
                    Ex-20+timeOfDay,y+20);
            filledPolygon.lineTo(Ax+20+timeOfDay,y+20);

        }else if (AnimationSeason.stageOfYear == StageOfYear.FOURTH){
            filledPolygon.moveTo(Ax+20+timeOfDay,y);
            filledPolygon.curveTo(
                    Ax+20+timeOfDay,y,
                    Bx+20+timeOfDay,y,
                    Bx+20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Bx+20+timeOfDay,y+100,
                    Bx+20+timeOfDay,y+250,
                    Cx+40+timeOfDay,y+250-20);              //
            filledPolygon.lineTo(Dx-40+timeOfDay,y+250-20);  //
            filledPolygon.curveTo(                                 //
                    Dx-40+timeOfDay,y+250-20,              //
                    Fx-20+timeOfDay,y+250,
                    Fx-20+timeOfDay,y+100);
            filledPolygon.curveTo(
                    Fx-20+timeOfDay,y+100,
                    Fx-20+timeOfDay,y,
                    Ex-20+timeOfDay,y);
            filledPolygon.lineTo(Ax+20+timeOfDay,y);
        }


        filledPolygon.closePath();
        g2.setPaint(new Color(255, 0, 0, 138));
        g2.fill(filledPolygon);

        return filledPolygon;
    }
}
