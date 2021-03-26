package blackBoard;

import factoryModules.*;

public class BlackBoardController {
    private static AssembleFeet feetAssembler=new AssembleFeet();
    private static AssembleBackrest backrestAssembler=new AssembleBackrest();
    private static AssembleStabilizerBar stabilizerBarAssembler=new AssembleStabilizerBar();
    private static CutSeat seatCutter=new CutSeat();
    private static PackageChair chairPackager=new PackageChair();

    public static void loop(){
        feetAssembler.updateBlackboard();
        backrestAssembler.updateBlackboard();
        stabilizerBarAssembler.updateBlackboard();
        seatCutter.updateBlackboard();
        chairPackager.updateBlackboard();
    }

}
