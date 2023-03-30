public class LoopListner implements Runnable{
    private Controller controller;
    private CountdownView countDown;
    private boolean loopDone;
    public LoopListner(Controller controller){
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while(true){
            if(loopDone){
                break;
            }
        }
    }
}
