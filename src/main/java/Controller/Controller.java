package Controller;

import BusinessLogic.SimulationManager;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private View view;

    public Controller(View view)
    {
        this.view=view;
        view.validareListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationManager man=new SimulationManager(view);
                Thread simulation=new Thread(man);
                simulation.start();
                view.setVisible(true);

            }
        });
    }

}
