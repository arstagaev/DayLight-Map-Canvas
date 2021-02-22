import enums.StageOfYear;

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

    public void seasonsMover(){

    }


    public static void Ticker(){

        BaseFigure.setMoveSpeed(1);

        if (stageOfYear == StageOfYear.FIRST | stageOfYear == StageOfYear.SECOND){
            timeline++;
        }else if (stageOfYear == StageOfYear.THIRD | stageOfYear == StageOfYear.FOURTH){
            timeline--;
        }else if (stageOfYear == StageOfYear.STOPIT){
        }



        if (timeline>=0 & timeline<150){
            //1
            if (timeline==0){
                stageOfYear = StageOfYear.FIRST;
            }
            //4
            if (stageOfYear== StageOfYear.THIRD & timeline==149){
                stageOfYear=StageOfYear.FOURTH;
            }

        } else if(timeline>=150 & timeline<=360 ){
            //2
            if (timeline==150 & stageOfYear == StageOfYear.FIRST){
                stageOfYear = StageOfYear.SECOND;
            }
            //3
            if (timeline==360){
                stageOfYear = StageOfYear.THIRD;
            }
        }
    }
}
