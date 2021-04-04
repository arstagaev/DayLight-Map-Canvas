import enums.Direction;
import enums.StageOfYear;

import static enums.StageOfYear.*;

public class AnimationSeason extends BaseFigure {

    AnimationSeason(){
        System.out.println("Launch BaseFigure! ");
        //middlePointX = Fx-Bx;

    }

    public static StageOfYear stageOfYear;
    public static int minutes;

    public static void initTimeLine(){
        stageOfYear = FIRST;
        minutes = 0;
    }


    public void changerOfSeasons(int dayCoeff){
        if (dayCoeff<=200){
            //setAx();
        }else if (dayCoeff<=400){

        }

    }

    ///for Animation
    public static void dayDynamics(int days){

//        minutes = minutes+days;
        currentTime = days;
//        if (days>0){
//            currentTime++;
//        }else{
//            currentTime--;
//        }


    }
    //its works yep
    public static void seasonDynamics(int setDaysCoefficient){
        System.out.println("day coeff is "+ setDaysCoefficient);

        if (setDaysCoefficient > 800){
            BaseFigure.seasonPPCoeff = 0;
            setDaysCoefficient = 0;
        }
        if (setDaysCoefficient < 0){
            BaseFigure.seasonPPCoeff = 800;
            setDaysCoefficient = 800;
        }

        Ax =AxConst;
        Bx =BxConst;
        Cx =CxConst;
        Dx =DxConst;
        Fx =FxConst;
        Ex =ExConst;


        if (setDaysCoefficient<=200){
            stageOfYear = FIRST;
        }else if (setDaysCoefficient<=400){
            stageOfYear = SECOND;
        }else if(setDaysCoefficient<=600){
            stageOfYear = THIRD;
        }else if(setDaysCoefficient<=800){
            stageOfYear = FOURTH;
        }

        switch (stageOfYear){
            case FIRST -> {
                setAx(setDaysCoefficient,Direction.RIGHT);
                setEx(setDaysCoefficient, Direction.LEFT);

            }
            case SECOND -> {

                setDaysCoefficient = setDaysCoefficient-200;
                setAx(200,Direction.RIGHT);
                setEx(200, Direction.LEFT);


                setCx(setDaysCoefficient,Direction.LEFT);
                setDx(setDaysCoefficient,Direction.RIGHT);
            }
            case THIRD -> {
                setDaysCoefficient = setDaysCoefficient-400; //
                setDaysCoefficient = 200 - setDaysCoefficient;
                setAx(200,Direction.RIGHT);
                setEx(200, Direction.LEFT);

                setCx(setDaysCoefficient,Direction.LEFT);
                setDx(setDaysCoefficient,Direction.RIGHT);


            }
            case FOURTH -> {
                setDaysCoefficient = (setDaysCoefficient-600);
                setDaysCoefficient = 200 - setDaysCoefficient;

                setAx(setDaysCoefficient,Direction.RIGHT);
                setEx(setDaysCoefficient, Direction.LEFT);

            }

        }
        //setNewCoordinatesForSecondCurve();
        System.out.println("Result of Season: "+" stage of year= "+stageOfYear);
    }


    public static void setAx(int acceleration, Direction direction) {

        switch (direction){
            case RIGHT ->{Ax = Ax+acceleration;}
            case LEFT -> {Ax = Ax-acceleration;}
            case STOP -> {Ax = Ax;}
        }

//        switch (direction){
//            case RIGHT ->{An = (int) (Ax*1.2F+acceleration);}
//            case LEFT -> {An = (int) (Ax*1.2F-acceleration);}
//            case STOP -> {An = (int) (An);}
//        }

        //respect to Bx
        System.out.println("acc = "+ acceleration);
        int coeff = Math.abs(Math.abs(gravityPoint)-Math.abs(Ax));
        if (coeff > 50 & coeff < 250){

        }
    }



    public static void setCx(int acceleration, Direction direction) {
        //Cx = cx;
//        if (acceleration>199){
//            acceleration=199;
//        }
//        if (acceleration<1){
//            acceleration=1;
//        }
        switch (direction){
            case RIGHT ->{Cx = Cx+acceleration;}
            case LEFT -> {Cx = Cx-acceleration;}
            case STOP -> {Cx = Cx;}
        }
//        switch (direction){
//            case RIGHT ->{Cn = (int) (Cx*1.2F+acceleration);}
//            case LEFT -> {Cn = (int) (Cx*1.2F-acceleration);}
//            case STOP -> {Cn = Cn;}
//        }
    }

    public static void setDx(int acceleration, Direction direction) {
        //Dx = dx;
//        if (acceleration>199){
//            acceleration=199;
//        }
//        if (acceleration<1){
//            acceleration=1;
//        }
        switch (direction){
            case RIGHT ->{Dx = Dx+acceleration;}
            case LEFT -> {Dx = Dx-acceleration;}
            case STOP -> {Dx = Dx;}
        }

//        switch (direction){
//            case RIGHT ->{Dn = (int) (Dx*0.95F+acceleration);}
//            case LEFT -> {Dn = (int) (Dx*0.95F-acceleration);}
//            case STOP -> {Dn = Dn;}
//        }
    }

    public static void setEx(int acceleration, Direction direction2) {

//        if (acceleration>199){
//            acceleration=199;
//        }
//        if (acceleration<1){
//            acceleration=1;
//        }
        switch (direction2){
            case RIGHT ->{Ex = Ex+acceleration;}
            case LEFT -> {Ex = Ex-acceleration;}
            case STOP -> {Ex = Ex;}
        }

//        switch (direction2){
//            case RIGHT ->{En = (int) (Ex*0.95F+acceleration);}
//            case LEFT -> {En = (int) (Ex*0.95F-acceleration);}
//            case STOP -> {En = En;}
//        }

    }

    public static void setBx() {
        Bx = Bx+minutes;
    }

    public static void setFx() {
        Fx = Fx+minutes;
    }
}
