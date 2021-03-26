package activator;

public class ChairInProgressReceiver implements Runnable {

    private static long checkingInterval;
    private static long expireTime;
    private static long lastUpdatedTime;
    private static long checkingTime;

    public ChairInProgressReceiver(long checkingInterval,long expireTime){
        ChairInProgressReceiver.checkingInterval=checkingInterval;
        ChairInProgressReceiver.expireTime=expireTime;
    }
    private boolean checkIfFactoryStillWorks(){
        try {
            Thread.sleep(checkingInterval);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        checkingTime=System.currentTimeMillis();
        if(checkingTime-lastUpdatedTime>expireTime){
            return false;
        }
            return true;
    }

    public static void updateTime(long updateTime) {
        lastUpdatedTime = updateTime;
    }
    @Override
    public void run() {
        while (true){
            if(!checkIfFactoryStillWorks()){
                System.out.println("The system has stopped");
            }
        }
    }
}
