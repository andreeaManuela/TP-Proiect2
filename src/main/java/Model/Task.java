package Model;

public class Task {
    private int ID;
    private int arrivalTime;
    private int serviceTime;

    public Task(int ID, int arrivalTime, int serviceTime)
    {
        this.ID=ID;
        this.arrivalTime=arrivalTime;
        this.serviceTime=serviceTime;
    }

    public int getID() {
        return this.ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return this.serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
  public String toString()
  {
      return "("+ this.ID +","+ this.arrivalTime + "," + this.serviceTime + ")";
  }

}
