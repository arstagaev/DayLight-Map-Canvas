package map2;

public class TimeMover   {


    boolean directionToLeft = true;
    // minutes 1-4-4-0-  now is 500 / 21
    public static int minutes = 0;

    // min 0, max 360
    public static int timeline = 0;


    public static StageOfYear stageOfYear = StageOfYear.FIRST;
    public static StageOfYear lastStageOfYear = null;

    //public static int days;

//    public int getDays() {
//        return days;
//    }
    //Curve curve = new Curve();
    //DrawerMain drawerMain = new DrawerMain();

    public TimeMover(){}


    public static void Ticker(){
        BaseFigure.setMoveSpeed(+1);


        if (stageOfYear == StageOfYear.FIRST | stageOfYear == StageOfYear.SECOND){
            timeline++;
        }else if (stageOfYear == StageOfYear.THIRD | stageOfYear == StageOfYear.FOURTH){
            timeline--;
        }else if (stageOfYear == StageOfYear.STOPIT){
        }



        if (timeline>=0 & timeline<150){
            if (timeline==0){
                stageOfYear = StageOfYear.FIRST;
            }

            if (stageOfYear==StageOfYear.THIRD & timeline==149){
                stageOfYear=StageOfYear.FOURTH;
            }


        }else if(timeline>=150 & timeline<=360 ){
            if (timeline==150 & stageOfYear == StageOfYear.FIRST){
                stageOfYear = StageOfYear.SECOND;
            }

            if (timeline==360){
                stageOfYear = StageOfYear.THIRD;
            }
        }
    }

    public int hours(int x){

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

        return x;
    }

    public int days(int days){



        if (days>=200){
            directionToLeft=true;
        }else if(days<=0) {
            directionToLeft=false;
        }

        if (directionToLeft){
            days--;
        }else {
            days++;
        }
        System.out.println("season "+days);
        return days;
    }
}
