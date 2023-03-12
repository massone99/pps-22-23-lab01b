package e2;

import e2.grid.Cell;
import e2.grid.Grid;
import e2.grid.GridImpl;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GUI extends JFrame {

    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Grid grid;

    public GUI(int size, int numMines, Random random) {
        this.grid = new GridImpl(size, numMines, random);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        int sizeMultiplier = 100;
        this.setSize(sizeMultiplier *size, sizeMultiplier *size);

        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);

        ActionListener onClick = (e)->{
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            boolean aMineWasFound = this.grid.hitButton(pos);
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
                System.exit(0);
            } else {
                drawBoard();
            }
            boolean isThereVictory = this.grid.isVictory();
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                final JButton bt = (JButton)e.getSource();
                if (bt.isEnabled()){
                    final Pair<Integer,Integer> pos = buttons.get(bt);
                    // call the logic here to put/remove a flag
                    grid.flagCell(pos);
                }
                drawBoard();
            }
        };

        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }

    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            // call the logic here
            // if this button is a mine, draw it "*"
            // disable the button
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            Pair<Integer, Integer> buttonPosition = entry.getValue();
            JButton button = entry.getKey();
            Cell cellAtPosition = this.grid.getCellAtPosition(buttonPosition);
            if (cellAtPosition.isExpanded()){
                button.setText(String.valueOf(this.grid.getAdjacentMines(buttonPosition)));
                button.setEnabled(false);
            } else if (cellAtPosition.isFlagged()) {
                button.setText("F");
            } else {
                button.setText("");
            }
    	}
    }

}
