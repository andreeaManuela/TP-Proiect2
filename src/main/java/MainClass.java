import BusinessLogic.Scheduler;
import BusinessLogic.SimulationManager;
import Controller.Controller;
import Model.Server;
import Model.Task;
import View.View;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MainClass {

    public static void main(String[] args){
        View view=new View();
        Controller controller=new Controller(view);
        view.setVisible(true);


    }
}
