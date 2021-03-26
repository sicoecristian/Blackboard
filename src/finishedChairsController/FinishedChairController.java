package finishedChairsController;

import objects.Chair;

import java.util.ArrayList;

public class FinishedChairController {
    private static ArrayList<Chair> finishedChairs=new ArrayList<>();
    private static int numberOfFinishedChairs=0;
    private static int curentIndex=0;

    public static ArrayList<Chair> getFinishedChairs() {
        return finishedChairs;
    }

    public static void setFinishedChairs(ArrayList<Chair> finishedChairs,int number) {
        numberOfFinishedChairs+=number;
        FinishedChairController.finishedChairs = finishedChairs;
    }
    public static void displayFinishedChairs(){
        for(int i=curentIndex;i<finishedChairs.size();i++){
            System.out.println(finishedChairs.get(i).toString());
        }
        curentIndex=numberOfFinishedChairs;
    }
}
