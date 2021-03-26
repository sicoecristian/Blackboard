package factoryModules;

import blackBoard.BlackBoard;
import blackBoard.KnowledgeSource;
import objects.ChairInProgress;

import java.util.ArrayList;

public class CutSeat implements KnowledgeSource {

    @Override
    public void updateBlackboard() {
        ArrayList<ChairInProgress> chairsInProgresses= BlackBoard.getChairsInProgress();
        for(ChairInProgress c: chairsInProgresses){
            if(c.getSeat()==null){
                c.setSeat("Seat successfully assembled");
            }
        }
        BlackBoard.setChairsInProgress(chairsInProgresses);
    }

    public void activateController(){

    }
}
