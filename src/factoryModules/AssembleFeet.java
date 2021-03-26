package factoryModules;

import blackBoard.BlackBoard;
import blackBoard.KnowledgeSource;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssembleFeet implements KnowledgeSource {
    @Override
    public void updateBlackboard() {
        ArrayList<ChairInProgress> chairsInProgresses= BlackBoard.getChairsInProgress();
        for(ChairInProgress c: chairsInProgresses){
            if(c.getFeet()==null&&c.getSeat()!=null){
                c.setFeet("Feet successfully assembled");
            }
        }
        BlackBoard.setChairsInProgress(chairsInProgresses);
    }

    public void activateController(){

    }

}
