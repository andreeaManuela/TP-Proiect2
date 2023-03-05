package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JFrame frame;
    private JPanel panel;
    private JTextField nrClients;
    private JTextField nrQueue;
    private JTextField simulationInt;
    private JTextField minArrTime;
    private JTextField maxArrTime;
    private JTextField minServiceTime;
    private JTextField maxServiceTime;
    private JLabel titlu;
    private JLabel clients;
    private JLabel queue;
    private JLabel simulationInterval;
    private JLabel minArrivalTime;
    private JLabel maxArrivalTime;
    private JLabel minServTime;
    private JLabel maxServTime;
    private JButton input;
    private JTextArea rezultat;
    private JScrollPane scroll;


    public View()
    {
        setTitle("Queue Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600,600,600,550);

        panel=new JPanel();
        panel.setBorder(new EmptyBorder(10, 10, 10,10));
        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(Color.orange);

        titlu=new JLabel("QUEUE MANAGEMENT");
        titlu.setBounds(200,0,150,80);
        titlu.setForeground(Color.BLACK);
        panel.add(titlu);

        clients=new JLabel("Number of Clients");
        clients.setBounds(40,40,120,80);
        clients.setForeground(Color.BLACK);
        panel.add(clients);

        nrClients=new JTextField();
        nrClients.setBounds(150,65,80,25);
        panel.add(nrClients);

        queue=new JLabel("Number of Queues");
        queue.setBounds(40,75,120,80);
        queue.setForeground(Color.BLACK);
        panel.add(queue);

        nrQueue=new JTextField();
        nrQueue.setBounds(150,100,80,25);
        panel.add(nrQueue);

        simulationInterval=new JLabel("Simulation Interval");
        simulationInterval.setBounds(40,110,120,80);
        simulationInterval.setForeground(Color.BLACK);
        panel.add(simulationInterval);

        simulationInt=new JTextField();
        simulationInt.setBounds(150,135,80,25);
        panel.add(simulationInt);

        minArrivalTime=new JLabel("Min Arrival Time");
        minArrivalTime.setBounds(40,141,120,80);
        minArrivalTime.setForeground(Color.BLACK);
        panel.add(minArrivalTime);

        minArrTime=new JTextField();
        minArrTime.setBounds(150,170,80,25);
        panel.add(minArrTime);

        maxArrivalTime=new JLabel("Max Arrival Time");
        maxArrivalTime.setBounds(40,170,120,80);
        maxArrivalTime.setForeground(Color.BLACK);
        panel.add(maxArrivalTime);

        maxArrTime=new JTextField();
        maxArrTime.setBounds(150,200,80,25);
        panel.add(maxArrTime);

        minServTime=new JLabel("Min Service Time");
        minServTime.setBounds(40, 200, 120, 80);
        minServTime.setForeground(Color.BLACK);
        panel.add(minServTime);

        minServiceTime=new JTextField();
        minServiceTime.setBounds(150,228,80,25);
        panel.add(minServiceTime);

        maxServTime=new JLabel("Max Service Time");
        maxServTime.setBounds(40,230,120,80);
        maxServTime.setForeground(Color.BLACK);
        panel.add(maxServTime);

        maxServiceTime=new JTextField();
        maxServiceTime.setBounds(150,258,80,25);
        panel.add(maxServiceTime);

        rezultat=new JTextArea("Results:",20,50);
        rezultat.setBounds(270,65,300,300);
        panel.add(rezultat);

        scroll=new JScrollPane(rezultat,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(270,65,300,300);
        panel.add(scroll);

        input= new JButton("Validare");
        input.setBounds(120,290,80,30 );
        panel.add(input);

        setVisible(true);
    }

    public void validareListener(ActionListener actionListener)
    {
        this.input.addActionListener(actionListener);
    }

    public String inputClienti()
    {

        return this.nrClients.getText();
    }

    public String inputCozi()
    {
        return this.nrQueue.getText();
    }

    public String simInterval()
    {
        return this.simulationInt.getText();
    }

    public String minArTime()
    {
        return this.minArrTime.getText();
    }

    public String maxArTime()
    {
      return this.maxArrTime.getText();
    }

    public String minSerTime()
    {
        return this.minServiceTime.getText();
    }

    public String maxSerTime()
    {
        return this.maxServiceTime.getText();
    }

    public void textField(String st)
    {
        this.rezultat.append(st);
    }

}
