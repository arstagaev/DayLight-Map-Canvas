package map2;


public class BaseFigure extends TimeMover {

    BaseFigure(){
        System.out.println("Launch BaseFigure! ");

    }

    //public static int timeline = 0;
    //public static int acceleration = 0;

    public static int Ax = 0;
    public static int Bx = 100; // ><
    public static int Cx = 200;
    public static int Dx = 300;
    public static int Fx = 400; // ><
    public static int Ex = 500;

    //static StageOfYear stageOfYear = StageOfYear.FIRST;
    public static void setMoveSpeed(int accelerationINPUT){
        //acceleration = accelerationINPUT;
        //System.out.println("Time Period: "+ stageOfYear.toString() +" timeline "+timeline);

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


//        if (timeline<150){
//
//            setAx(accelerationINPUT,Direction.RIGHT);
//            setEx(accelerationINPUT, Direction.LEFT);
//        }else if(timeline>150){
//            setCx(accelerationINPUT,Direction.LEFT);
//            setDx(accelerationINPUT,Direction.RIGHT);
//        }



    }

    public static void dayDynamics(){
        Ax = Ax+minutes;
        setBx();
        Cx= Cx+minutes;
        Dx= Dx+minutes;
        setFx();
        Ex = Ex+minutes;
    }

//    static Direction direction = Direction.STOP;
//    static Direction direction2 = Direction.STOP;

    public static void setAx(int acceleration, Direction direction) {

        //respect to Bx

//        if (Ax<=1){
//            direction = Direction.RIGHT;
//        }else if (Ax>=200){
//            direction = Direction.LEFT;
//        }
        switch (direction){
            case RIGHT ->{Ax = Ax+acceleration;}
            case LEFT -> {Ax = Ax-acceleration;}
            case STOP -> {Ax = Ax;}
        }


    }

    public static void setEx(int acceleration, Direction direction2) {

//        if (Ex<=300){
//            direction2 = Direction.RIGHT;
//        }else if (Ex>=500){
//            direction2 = Direction.LEFT;
//        }
        switch (direction2){
            case RIGHT ->{Ex = Ex+acceleration;}
            case LEFT -> {Ex = Ex-acceleration;}
            case STOP -> {Ex = Ex;}
        }

    }

    public static void setCx(int acceleration, Direction direction) {
        //Cx = cx;
        switch (direction){
            case RIGHT ->{Cx = Cx+acceleration;}
            case LEFT -> {Cx = Cx-acceleration;}
            case STOP -> {Cx = Cx;}
        }
    }

    public static void setDx(int acceleration, Direction direction) {
        //Dx = dx;
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
