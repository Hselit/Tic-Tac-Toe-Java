package com.mycompany.tictactoe;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame implements ActionListener{
    JFrame frame = new JFrame();
    JPanel title = new JPanel();
    JPanel ButPanel = new JPanel();
    JButton[] buttons = new JButton[9];
    boolean xturn;
    JLabel text = new JLabel();
    Random random = new Random();

    GameFrame(){
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.yellow);
        
        title.setBackground(Color.red);
        title.setLayout(new BorderLayout());
        title.setBounds(0, 0, 800, 100);
        
        text.setFont(new Font("Sans",Font.BOLD,40));
        text.setText("Tic-Tac-Toe");
        text.setBackground(new Color(25,25,25));
        text.setForeground(new Color(25,255,0));
        text.setHorizontalAlignment(JLabel.CENTER);
        
        ButPanel.setLayout(new GridLayout(3,3));
        ButPanel.setBackground(Color.black);
        
        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setFont(new Font("sans",Font.BOLD,70));
            ButPanel.add(buttons[i]);
        }
        
        title.add(text);
        frame.add(ButPanel);
        frame.add(title,BorderLayout.NORTH);
        frame.setVisible(true);
        
        firstTurn();
    }
    
    public void firstTurn(){
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(random.nextInt(2)==0){
            xturn = true;
            text.setText("X's Turn");
        }
        else{
            xturn = false;
            text.setText("O's Turn");
        }
    }
    
    public void checkWin(){
        int flag=0;
        if((buttons[0].getText().equals("X")) && (buttons[1].getText().equals("X")) && (buttons[2].getText().equals("X"))){
            xWin(0,1,2);
            flag=1;
        }
        if((buttons[3].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[5].getText().equals("X"))){
            xWin(3,4,5);
            flag=1;
        }
        if((buttons[6].getText().equals("X")) && (buttons[7].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWin(6,7,8);
            flag=1;
        }
        if((buttons[0].getText().equals("X")) && (buttons[3].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWin(0,3,6);
            flag=1;
        }
        if((buttons[1].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[7].getText().equals("X"))){
            xWin(1,4,7);
            flag=1;
        }
        if((buttons[2].getText().equals("X")) && (buttons[5].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWin(2,5,8);
            flag=1;
        }if((buttons[0].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[8].getText().equals("X"))){
            xWin(0,4,8);
            flag=1;
        }
        if((buttons[2].getText().equals("X")) && (buttons[4].getText().equals("X")) && (buttons[6].getText().equals("X"))){
            xWin(2,4,6);
            flag=1;
        }
        
        
        if((buttons[0].getText().equals("O")) && (buttons[1].getText().equals("O")) && (buttons[2].getText().equals("O"))){
            oWin(0,1,2);
            flag=1;
        }
        if((buttons[3].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[5].getText().equals("O"))){
            oWin(3,4,5);
            flag=1;
        }
        if((buttons[6].getText().equals("O")) && (buttons[7].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWin(6,7,8);
            flag=1;
        }
        if((buttons[0].getText().equals("O")) && (buttons[3].getText().equals("O")) && (buttons[6].getText().equals("O"))){
            oWin(0,3,6);
            flag=1;
        }
        if((buttons[1].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[7].getText().equals("O"))){
            oWin(1,4,7);
            flag=1;
        }
        if((buttons[2].getText().equals("O")) && (buttons[5].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWin(2,5,8);
            flag=1;
        }if((buttons[0].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[8].getText().equals("O"))){
            oWin(0,4,8);
            flag=1;
        }
        if((buttons[2].getText().equals("O")) && (buttons[4].getText().equals("O")) && (buttons[6].getText().equals("O"))){
            oWin(2,4,6);
            flag=1;
        }
        if(flag!=1){
        int count=0;
        for(int i=0;i<9;i++){
            if(!buttons[i].getText().equals("")){
                count++;
            }
            if(count==9){
                text.setText("Match Draw");
                for(int j=0;j<9;j++){
                   buttons[j].setEnabled(false);
                }
            }
        }
        }
        
    }
    
    public void xWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text.setText("X Won");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    
    public void oWin(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);
        text.setText("O Won");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(xturn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        xturn = false;
                        text.setText("O's Turn");
                        checkWin();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        xturn = true;
                        text.setText("X's Turn");
                        checkWin();
                    }
                }
            }
        }
    }
}
