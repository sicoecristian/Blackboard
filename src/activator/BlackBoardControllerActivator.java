package activator;

import blackBoard.BlackBoard;
import blackBoard.BlackBoardController;
import blackBoard.KnowledgeSource;
import finishedChairsController.FinishedChairController;
import objects.Chair;
import objects.ChairInProgress;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class BlackBoardControllerActivator extends Thread implements KnowledgeSource {
    private static int  workingPort = 8080;
    private static int  sendingInterval = 10000;//miliseconds

    protected static long getSendingInterval(){
        return (long)sendingInterval;
    }

    public void run(){
        Thread chairInProgressSender=new Thread(new ChairInProgressSender(sendingInterval));
        chairInProgressSender.start();
        try (
            ServerSocket serverSocket =new ServerSocket(workingPort,1);
        ) {
            while (true) {
                try (
                    Socket clientSocket = serverSocket.accept();
                ){
                    ArrayList<ChairInProgress> chairsInProgress=new ArrayList<>();
                    chairsInProgress= BlackBoard.getChairsInProgress();
                    chairsInProgress.add(new ChairInProgress());
                    BlackBoard.setChairsInProgress(chairsInProgress);
                    ArrayList<Chair> finishedChairs=new ArrayList<>();
                    finishedChairs=BlackBoard.getChairs();
                    FinishedChairController.setFinishedChairs(finishedChairs,finishedChairs.size());
                    finishedChairs.clear();
                    BlackBoard.setChairs(finishedChairs);
                    FinishedChairController.displayFinishedChairs();
                    updateBlackboard();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }catch (IOException e){
            System.err.println(e.getMessage());
        }catch (ArithmeticException e){
            System.err.println("Caught the injected math error.");
        }finally {
            System.err.println("BBControllerActivaor crash");
            chairInProgressSender.interrupt();
        }

    }

    @Override
    public void updateBlackboard() {
        activateController();
    }

    @Override
    public void activateController() {
        BlackBoardController.loop();
    }
}
