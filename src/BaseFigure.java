import enums.Direction;
import enums.StageOfYear;

public class BaseFigure extends TimeMover {

    BaseFigure(){
        System.out.println("Launch BaseFigure! ");
        middlePointX = Fx-Bx;

    }

    //public static int timeline = 0;
    //public static int acceleration = 0;
    public static int Ax = 0;
    public static int Bx = 100; // ><
    public static int Cx = 200;
    public static int Dx = 300;
    public static int Fx = 400; // ><
    public static int Ex = 500;

    public static int middlePointX = 0;

    /**
     *
     * @param accelerationINPUT [max = 200, min = 0]
     */
    public static void setMoveSpeed(int accelerationINPUT){

        System.out.println("Time Period: "+ stageOfYear.toString() +" timeline "+timeline);
        //accelerationINPUT = 0;

        switch (stageOfYear){
            case FIRST -> {
                setAx(accelerationINPUT,Direction.RIGHT);
                setEx(accelerationINPUT, Direction.LEFT);
            }
            case SECOND -> {
                setCx(accelerationINPUT,Direction.LEFT);
                setDx(accelerationINPUT,Direction.RIGHT);
            }
            case THIRD -> {
                setCx(accelerationINPUT,Direction.RIGHT);
                setDx(accelerationINPUT,Direction.LEFT);
            }
            case FOURTH -> {
                setAx(accelerationINPUT,Direction.LEFT);
                setEx(accelerationINPUT, Direction.RIGHT);
            }
        }
    }

    public static void dayDynamics(){
        Ax = Ax+minutes;
        setBx();
        Cx= Cx+minutes;
        Dx= Dx+minutes;
        setFx();
        Ex = Ex+minutes;
    }

    public static void seasonDynamics(int setDaysCoefficient,int month){
        //////////////////////// month settings /////////////////////////////////////////// 1~12
        if (month<=3){
            stageOfYear = StageOfYear.FIRST;
        }else if (month<=6){
            stageOfYear = StageOfYear.SECOND;
        }else if (month<=9){
            stageOfYear = StageOfYear.THIRD;
        }else if (month<=12){
            stageOfYear = StageOfYear.FOURTH;
        }
        //////////////////////////////////// set DaysCoefficient ////////////////////////// 0~200
        // 1 day == 2.2 setDaysCoefficients
        switch (stageOfYear){
            case FIRST -> {
                setAx(setDaysCoefficient,Direction.RIGHT);
                setEx(setDaysCoefficient, Direction.LEFT);
            }
            case SECOND -> {
                setCx(setDaysCoefficient,Direction.LEFT);
                setDx(setDaysCoefficient,Direction.RIGHT);
            }
            case THIRD -> {

                setCx(setDaysCoefficient,Direction.RIGHT);
                setDx(setDaysCoefficient,Direction.LEFT);
            }
            case FOURTH -> {
                setAx(setDaysCoefficient,Direction.LEFT);
                setEx(setDaysCoefficient, Direction.RIGHT);
            }
        }

//        switch (stageOfYear){
//            case FIRST -> {
//                setAx(setDaysCoefficient,Direction.RIGHT);
//                setEx(setDaysCoefficient, Direction.LEFT);
//                setCx(setDaysCoefficient,Direction.LEFT);
//                setDx(setDaysCoefficient,Direction.RIGHT);
//            }
//            case SECOND -> {
//
//            }
//            case THIRD -> {
//
//                setCx(setDaysCoefficient,Direction.RIGHT);
//                setDx(setDaysCoefficient,Direction.LEFT);
//            }
//            case FOURTH -> {
//                setAx(setDaysCoefficient,Direction.LEFT);
//                setEx(setDaysCoefficient, Direction.RIGHT);
//            }
//        }
        System.out.println("Result of Season: "+month+" stage of year= "+stageOfYear);
    }


    public static void setAx(int acceleration, Direction direction) {

        //respect to Bx
        System.out.println("acc = "+ acceleration);
//        if (middlePointX-Ax>50){
//            acceleration=180;
//        }
//        if (middlePointX-Ax>250){
//            acceleration=12;
//        }


        switch (direction){
            case RIGHT ->{Ax = Ax+acceleration;}
            case LEFT -> {Ax = Ax-acceleration;}
            case STOP -> {Ax = Ax;}
        }


    }

    public static void setEx(int acceleration, Direction direction2) {

//        if (Ex<=300){
//            direction2 = enums.Direction.RIGHT;
//        }else if (Ex>=500){
//            direction2 = enums.Direction.LEFT;
//        }
        if (acceleration>199){
            acceleration=199;
        }
        if (acceleration<1){
            acceleration=1;
        }
        switch (direction2){
            case RIGHT ->{Ex = Ex+acceleration;}
            case LEFT -> {Ex = Ex-acceleration;}
            case STOP -> {Ex = Ex;}
        }

    }

    public static void setCx(int acceleration, Direction direction) {
        //Cx = cx;
        if (acceleration>199){
            acceleration=199;
        }
        if (acceleration<1){
            acceleration=1;
        }
        switch (direction){
            case RIGHT ->{Cx = Cx+acceleration;}
            case LEFT -> {Cx = Cx-acceleration;}
            case STOP -> {Cx = Cx;}
        }
    }

    public static void setDx(int acceleration, Direction direction) {
        //Dx = dx;
        if (acceleration>199){
            acceleration=199;
        }
        if (acceleration<1){
            acceleration=1;
        }
        switch (direction){
            case RIGHT ->{Dx = Dx+acceleration;}
            case LEFT -> {Dx = Dx-acceleration;}
            case STOP -> {Dx = Dx;}
        }
    }

    public static void setBx() {
        Bx = Bx+minutes;
    }

    public static void setFx() {
        Fx = Fx+minutes;
    }
}
