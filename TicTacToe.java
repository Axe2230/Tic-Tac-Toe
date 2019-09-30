   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.util.Scanner;
   import java.io.*;
  
   public class TicTacToe extends JPanel
   {
   //Declare Subcomponents
      private JButton [][] buttonArray;
      private int[][] intArray;
      public JButton resetButton;
      public JLabel scoreLabel;	
      public JPanel buttonPanel;
      public boolean gameWon;
      public int alternate;
      public int rand;
      public int score;
      public int xScore;
      public int oScore;
      public int counter;
   
   
      public TicTacToe(){
       
         gameWon = false;
         alternate = 0;
         score = 0;
         xScore = 0;
         oScore = 0;
         counter = 0;
         
         setLayout(new BorderLayout());
      //NORTH
         scoreLabel = new JLabel("Tic Tac Toe");
         scoreLabel.setForeground(new Color(0, 89, 220));
         scoreLabel.setFont(new Font("Ariel Black", Font.PLAIN, 24));
         scoreLabel.setHorizontalAlignment(JLabel.CENTER);
         add(scoreLabel, BorderLayout.NORTH); 
        
         rand = (int)(Math.random () * 2) +1;
         if(rand == 1) {
            scoreLabel.setText(" X Starts!");
            alternate = 2;
         }
         if(rand == 2) {
            alternate = 1;
            scoreLabel.setText(" O Starts!");
         }
      
      //CENTER
         buttonPanel = new JPanel();
         buttonPanel.setLayout(new GridLayout(3, 3));
         buttonArray = new JButton[3][3];
         intArray = new int[3][3];
         for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
               buttonArray[row][col] = new JButton("");
               buttonArray[row][col].addActionListener(new ButtonPressed(row, col));
               buttonPanel.add(buttonArray[row][col]); 
               intArray[row][col] = 0;
            }
         }
         add(buttonPanel, BorderLayout.CENTER);
      //SOUTH
         resetButton = new JButton("Reset");
         resetButton.addActionListener(new resetPressed());
         add(resetButton, BorderLayout.SOUTH);
      
      }
      private class ButtonPressed implements ActionListener {
         private int row;
         private int col;
         public ButtonPressed(int r, int c) {
            row = r;
            col = c;
         }
         public void actionPerformed(ActionEvent e) {
         // Add code here to place an X or O in the square, then  determine if the player won.  
            
            scoreLabel.setText(" Tic Tac Toe");
            counter ++;
            if(alternate%2 == 0 ){
               buttonArray[row][col].setText("X");
               buttonArray[row][col].setEnabled(false);
               checkWin(row,col);
            	
            }
            else if (alternate%2 != 0){
               buttonArray[row][col].setText("O");
               buttonArray[row][col].setEnabled(false);
               checkWin(row,col);
            }
                
            alternate++;
            
         }
      
         
            
      }
      
      private class resetPressed implements ActionListener {
      
         
         public void actionPerformed(ActionEvent e) {
           
            for (int row = 0; row < 3; row++) {
               for (int col = 0; col < 3; col++) {
                  buttonArray[row][col].setText("");
                  buttonArray[row][col].setEnabled(true);
                  
               }
            } 
            int rand = (int)(Math.random () * 2) +1;
           
            if(rand == 1) {
               scoreLabel.setText(" X Starts!");
            }
            if(rand == 2) {
               scoreLabel.setText(" O Starts!");
            }
            counter = 0;
            
         }
      }
      public void checkWin(int row, int col)
      {
         try {
            if (buttonArray[0][2].getText()==buttonArray[1][2].getText()&& buttonArray[1][2].getText()==buttonArray[2][2].getText()&& buttonArray[2][2].getText()==buttonArray[0][2].getText()&& buttonArray[1][2].getText()!="")
            {
               gameWon = true;
              
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
               
               if(buttonArray[1][2].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][2].getText() == "O"){
                  oScore ++ ;
               }
               
            	 
               scoreLabel.setText(buttonArray[1][2].getText()+ " wins!"  + "X score: "+ xScore + " O score: " + oScore );
            }
            else if(buttonArray[0][1].getText()==buttonArray[1][1].getText()&& buttonArray[1][1].getText()==buttonArray[2][1].getText()&& buttonArray[2][1].getText()==buttonArray[0][1].getText()&& buttonArray[1][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
            	
               if(buttonArray[1][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][1].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[1][1].getText()+ " wins!"+  "X score: "+ xScore + " O score: " + oScore);
            }
            else if (buttonArray[0][0].getText()==buttonArray[1][0].getText()&& buttonArray[1][0].getText()==buttonArray[2][0].getText()&& buttonArray[2][0].getText()==buttonArray[0][0].getText()&& buttonArray[1][0].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
              
               if(buttonArray[1][0].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][0].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[1][0].getText()+ " wins!"+ "X score: "+ xScore + " O score: " + oScore);
            }
            else if (buttonArray[2][0].getText()==buttonArray[2][1].getText()&& buttonArray[2][1].getText()==buttonArray[2][2].getText()&& buttonArray[2][2].getText()==buttonArray[2][0].getText()&& buttonArray[2][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
               
               if(buttonArray[2][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[2][1].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[2][1].getText()+ " wins!"+ "X score: "+ xScore + " O score: " + oScore);
            }
            else if  (buttonArray[1][0].getText()==buttonArray[1][1].getText()&& buttonArray[1][1].getText()==buttonArray[1][2].getText()&& buttonArray[1][2].getText()==buttonArray[1][0].getText()&& buttonArray[1][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
               
               if(buttonArray[1][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][1].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[1][1].getText()+ " wins!"+ "X score: "+ xScore + " O score: " + oScore);
            }
            else if  (buttonArray[0][0].getText()==buttonArray[0][1].getText()&& buttonArray[0][1].getText()==buttonArray[0][2].getText()&& buttonArray[0][2].getText()==buttonArray[0][0].getText()&& buttonArray[0][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
               if(buttonArray[0][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[0][1].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[0][1].getText()+ " wins!"+  "X score: "+ xScore + " O score: " + oScore);
            }
            else if (buttonArray[0][0].getText()==buttonArray[1][1].getText()&& buttonArray[1][1].getText()==buttonArray[2][2].getText()&& buttonArray[2][2].getText()==buttonArray[0][0].getText()&& buttonArray[1][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               buttonArray[2][0].setEnabled(false);
               
               if(buttonArray[1][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][1].getText() == "O"){
                  oScore ++;
               } 
               scoreLabel.setText(buttonArray[1][1].getText()+ " wins!"+  "X score: "+ xScore + " O score: " + oScore);
            }
            else if (buttonArray[0][2].getText()==buttonArray[1][1].getText()&& buttonArray[1][1].getText()==buttonArray[2][0].getText()&& buttonArray[2][0].getText()==buttonArray[0][2].getText()&& buttonArray[1][1].getText()!="")
            {
               gameWon = true;
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[2][1].setEnabled(false);
               buttonArray[0][2].setEnabled(false);
               buttonArray[0][1].setEnabled(false);
               buttonArray[1][1].setEnabled(false);
               buttonArray[2][2].setEnabled(false);
               buttonArray[1][2].setEnabled(false);
               buttonArray[0][0].setEnabled(false);
               buttonArray[1][0].setEnabled(false);
               
               buttonArray[2][0].setEnabled(false);
               
               if(buttonArray[1][1].getText() == "X"){
                  xScore ++;
               }
               if(buttonArray[1][1].getText() == "O"){
                  oScore ++;
               }   
               scoreLabel.setText(buttonArray[1][1].getText()+ " wins!"+  "X score: "+ xScore + " O score: " + oScore);
            }
            
            else if(counter == 9) {
               scoreLabel.setText(" Draw");
            }
             
         
         }
            catch(Exception e) {
               gameWon = true;
            
               scoreLabel.setText(" Draw");
               
            }
      }
   
   
   
      public static void main(String[] args)
      {         
         JFrame frame = new JFrame("Tic Tac Toe");
         frame.setSize(375, 375);
         frame.setLocation(200, 200);
         frame.setContentPane(new TicTacToe());
         frame.setVisible(true);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
   }