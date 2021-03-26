package activator;

public class ChairInProgressSender implements Runnable {

    private int sendingInterval;

    public  ChairInProgressSender(int sendingInterval){
        this.sendingInterval=sendingInterval;
    }


    public void sendChairInProgress(){
        long currentTime=System.currentTimeMillis();
        ChairInProgressReceiver.updateTime(currentTime);
    }


    @Override
    public void run() {
            while (true){
                try {
                    sendChairInProgress();
                    Thread.sleep(sendingInterval);
                }catch (InterruptedException e){
                    System.out.println("The system crashed");
                }
            }
    }
}
