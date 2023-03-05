package BusinessLogic;

import Model.Server;
import Model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {

    private ArrayList<Server> servers;
    private int maxNoServers=0;
    private int maxTasksPerServer=0;

    public Scheduler(int maxNoServers, int maxTasksPerServer)
    {
       this.maxNoServers=maxNoServers;
       this.maxTasksPerServer=maxTasksPerServer;
       this.servers=new ArrayList<Server>(maxNoServers);
       //for maxNoServers
       //create server object
       //create thread with the objects
        for(int i=0; i<maxNoServers; i++)
        {
            Server serv=new Server(i+1,maxNoServers);
            servers.add(serv);
            Thread newTh=new Thread(servers.get(i));
            newTh.start();
        }
    }

    public ArrayList<Server> getServers()
    {
        return servers;
    }
    public int getMaxNoServers() {
        return maxNoServers;
    }
    public void setMaxNoServers(int maxNoServers) {
        this.maxNoServers = maxNoServers;
    }
    public int getMaxTasksPerServer() {
        return maxTasksPerServer;
    }
    public void setMaxTasksPerServer(int maxTasksPerServer) {
        this.maxTasksPerServer = maxTasksPerServer;
    }

    //Pentru a returna coada cu timpul cel mai scurt de asteptare
    public int addTaskTimeStrategy()
    {
        int min=800;
        int id=0;
        for(int i=0;i<maxNoServers;i++)
        {
            int r=servers.get(i).getWaitingPeriod().get();
            if( r< min)
            {
                min=r;
                id=i;
            }
        }
        return id;
    }

    //pune clientul la coada cu timpul cel mai scurt
    public void dispatchTask(Task tas)
    {
        int coadaScurta=addTaskTimeStrategy();  //returneaza id-ul cozii cu timp cel mai scurt
        //adaugam clientul la coada
        servers.get(coadaScurta).addTask(tas);
    }


    public String toString()
    {
        String rezultat="";
        for(Server s: servers)
        {
            rezultat=rezultat+ "Queue " + s.getIdQueue() +": "+s.toString() +"\n";
        }
        return rezultat;
    }


}
