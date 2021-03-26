package factoryModules;

import blackBoard.BlackBoard;
import blackBoard.KnowledgeSource;
import objects.Chair;
import objects.ChairInProgress;

import java.util.ArrayList;

public class PackageChair implements KnowledgeSource {
    @Override
    public void updateBlackboard() {



        ArrayList<ChairInProgress> chairsInProgresses= BlackBoard.getChairsInProgress();

        int temp[] = new int[chairsInProgresses.size()];
        int temmpsize=0;


        ArrayList<Chair> chairs=BlackBoard.getChairs();

        for(int i=0;i<chairsInProgresses.size();i++){
            ChairInProgress c= chairsInProgresses.get(i);
            if(c.getFeet()!=null && c.getStabilizerBar()!=null && c.getSeat()!=null && c.getBackrest()!=null){
                temp[temmpsize]=i;
                temmpsize++;
            }
        }
        for(ChairInProgress c: chairsInProgresses){
            if(c.getFeet()!=null && c.getStabilizerBar()!=null && c.getSeat()!=null && c.getBackrest()!=null){
                chairs.add(new Chair(c.getSeat(),c.getFeet(),c.getBackrest(),c.getStabilizerBar()));
            }
        }
        for(int i=0;i<temmpsize;i++){
            chairsInProgresses.remove(temp[i]);
        }
        BlackBoard.setChairs(chairs);
        BlackBoard.setChairsInProgress(chairsInProgresses);
    }

    public void activateController(){

    }
}
