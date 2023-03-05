package BusinessLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import Model.Server;
import Model.Task;
import View.View;

import javax.swing.*;

public class SimulationManager implements Runnable {

    //pool of tasks (client shopping in the store)
    private List<Task> tasks=new ArrayList<Task>();
    private int nrClienti=0;
    private int numberOfServers=0;  //nr de cozi
    private int minArr=0;
    private int maxArr=0;
    private int minServ=0;  //minProcessingTime
    private int maxServ=0;  //maxProcessingTime
    private int maxSimulationTime=0;
    private Scheduler scheduler;
    private View view;
    private FileWriter fileOut;


   public SimulationManager(View view)
    {
      this.view=view;
        try {
            fileOut = new FileWriter("LogOfEvents4.txt");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try{
            this.nrClienti=Integer.parseInt(view.inputClienti());
            this.numberOfServers=Integer.parseInt(view.inputCozi());
            this.minArr=Integer.parseInt(view.minArTime());
            this.maxArr=Integer.parseInt(view.maxArTime());
            this.minServ=Integer.parseInt(view.minSerTime());
            this.maxServ=Integer.parseInt(view.maxSerTime());
            this.maxSimulationTime=Integer.parseInt(view.simInterval());
            view.setVisible(false);
        } catch (Exception e){}
        generateRandomTasks();
        //initialize the scheduler
       scheduler=new Scheduler(numberOfServers, nrClienti);

 }

    //------------RANDOM GENERATOR-------------------
   public void generateRandomTasks()
    {
        tasks=new ArrayList<Task>(nrClienti);
        for(int i=1; i<=nrClienti; i++)
        {
            Random ran= new Random();
            int randomArrivalTime=ran.nextInt(maxArr-minArr)+minArr;
            int randomServiceTime=ran.nextInt(maxServ-minServ)+minServ;
            Task t=new Task(i,randomArrivalTime, randomServiceTime);
            tasks.add(t);
         //   System.out.println(t.toString());
        }
       Collections.sort(tasks, new Comparator<Task>() {
           @Override
           public int compare(Task o1, Task o2) {
               return o1.getArrivalTime()-o2.getArrivalTime();
           }
       });
    }

   @Override
    public synchronized void run() {
        int currentTime=0;
        view.textField("You have "+ nrClienti+ " clients and "+ numberOfServers + " servers.");

            while (currentTime < maxSimulationTime) {
                //tasks that have the arrivalTime equal with the currentTime
                while (!tasks.isEmpty() && tasks.get(0).getArrivalTime() == currentTime) {
                        //send task to queue using dispatch method
                        scheduler.dispatchTask(tasks.get(0));
                    //delete client from list
                        tasks.remove(0);
                        //clientul a fost servit
                }
                try {
                    fileOut.write(toString(currentTime));
                 } catch (IOException e) {
               e.printStackTrace();
           }
                view.textField(toString(currentTime));
                currentTime++;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
       try{
           fileOut.close();
       }catch(Exception ex) {}

   }

    public String toString(int currentTime)
    {
        String result="\nTime: "+ currentTime +"\n";
        result += "Waiting clients: ";
        for(Task i: tasks)
        {
            result += i.toString();
        }
        result=result+"\n"+scheduler.toString();
        return result;
    }
}
