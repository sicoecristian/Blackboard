package factoryModules;

import blackBoard.BlackBoard;
import blackBoard.KnowledgeSource;
import objects.ChairInProgress;

import java.util.ArrayList;

public class AssembleStabilizerBar implements KnowledgeSource {
    @Override
    public void updateBlackboard() {
        ArrayList<ChairInProgress> chairsInProgresses= BlackBoard.getChairsInProgress();
        for(ChairInProgress c: chairsInProgresses){
            if(c.getStabilizerBar()==null&&c.getFeet()!=null){
                c.setStabilizerBar("Stabilizer bar successfully assembled");
            }
        }
        BlackBoard.setChairsInProgress(chairsInProgresses);
    }

    public void activateController(){

    }
}
