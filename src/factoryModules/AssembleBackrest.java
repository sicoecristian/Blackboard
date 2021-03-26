package factoryModules;

import blackBoard.BlackBoard;
import blackBoard.KnowledgeSource;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssembleBackrest implements KnowledgeSource {
    @Override
    public void updateBlackboard() {
        ArrayList<ChairInProgress> chairsInProgresses= BlackBoard.getChairsInProgress();
        for(ChairInProgress c: chairsInProgresses){
            if(c.getBackrest()==null&&c.getSeat()!=null){
                c.setBackrest("Backrest successfully assembled");
            }
        }
        BlackBoard.setChairsInProgress(chairsInProgresses);
    }

    public void activateController(){

    }
}
