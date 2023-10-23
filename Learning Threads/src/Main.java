// Using Thread class
class SideTask extends Thread{
    @Override
   public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Printing from two doc " + i);
        }
    }
}

// Using runnable interface
class RunnableSideTask implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Printing from three doc " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting main thread");
//        creating a thread
        SideTask task = new SideTask();
        Runnable r = new RunnableSideTask();
        Thread newTask = new Thread(r);
        newTask.start();
        task.start();
        for(int i=0;i<10;i++){
            System.out.println("Printing from one doc " + i);
        }
        System.out.println("Exiting Main thread");
    }
}