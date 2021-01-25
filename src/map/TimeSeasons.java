package map;

public class TimeSeasons {

    boolean directionToLeft = false;

    public int seasonsMotion(int days){

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
