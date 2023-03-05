package Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements  Runnable{

    //Server -> casier
    private BlockingQueue<Task> tasks;  // clientii care asteapta la casier
    private AtomicInteger waitingPeriod=new AtomicInteger(0); //durata cozii (cat asteapta ultimul client)
    private boolean isOpen=true;  //este deschisa coada
    private int idQueue;

    public Server(int idQueue, int maxNrServ)
    {
        this.idQueue=idQueue;
        this.tasks=new ArrayBlockingQueue<Task>(maxNrServ);
        this.isOpen=true;
    }

    public int getIdQueue(){ return idQueue;}

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void addTask(Task newTask)
    {
        //add task to queue
        tasks.add(newTask);
        //increment waiting period
        waitingPeriod.addAndGet(newTask.getServiceTime());
    }

    public boolean isQueueOpen(){   return isOpen;  }

    public void setOpen(boolean isOpen)  {  this.isOpen=isOpen;  }

    @Override
    public synchronized void run() {
        while(isOpen) {
               try {
                if(tasks.peek()!= null)
                {
                    //take task from queue
                    if(tasks.peek().getServiceTime()>0)
                        Thread.sleep(1000);
                    tasks.peek().setServiceTime(tasks.peek().getServiceTime()-1);
                    //decerment waiting period
                    if(this.waitingPeriod.get()>0) {
                        this.waitingPeriod.decrementAndGet();
                    }
                    if(tasks.peek().getServiceTime()==0) tasks.poll();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   public String toString()
   {
       String rez=" ";
       if(tasks.isEmpty() || tasks.peek()==null) //daca coada este goala
       {
           return rez=" closed";
       }
      for(Task t: tasks)
      {
          rez=rez+t;
      }
       return rez;
   }

}
