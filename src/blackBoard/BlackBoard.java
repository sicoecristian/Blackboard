package blackBoard;

import objects.Chair;
import objects.ChairInProgress;

import java.util.ArrayList;

public class BlackBoard {
    private static ArrayList<ChairInProgress> chairsInProgress= new ArrayList<>();
    private static ArrayList<Chair> chairs= new ArrayList<>();

    public static ArrayList<ChairInProgress> getChairsInProgress() {
        return chairsInProgress;
    }

    public static void setChairsInProgress(ArrayList<ChairInProgress> chairsInProgress2){
        chairsInProgress=chairsInProgress2;
    }
    public static ArrayList<Chair> getChairs(){
        return chairs;
    }
    public static void setChairs(ArrayList<Chair> chairs1){
        chairs=chairs1;
    }
}
