/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class TicTacToe extends Application {

    //Button btnCheckWin = new Button("Check\nfor\nWin!");
    Button[][] btnValues = new Button[3][3];
    Button btnReset = new Button("Reset");
    GridPane gridPane = new GridPane();
    Label whoseTurnLabel = new Label();
    Label gameScoreLabelX = new Label();
    Label gameScoreLabelO = new Label();
    public final int PANE_HEIGHT = 175;
    public final int PANE_WIDTH = 250;
    public final String STAGE_TITLE = "Tic-Tac-Toe";
    String[] whoseTurnArray = new String[2];
    String[] whoseTurnTextArray = new String[2];
    int[] gameScoreArray = new int[3];
    public int turn = 0;
    public int whoseTurn = turn % 2;
    public boolean gameWon = false;
    public boolean gameTied = false;
    public final String X = "X";
    public final String O = "O";
    public final String blank = "  ";
    public final String resetTopText = "       X's Turn First.\n Click an open space!";
    public String gameScoreTextX = "X's points:\n"+gameScoreArray[0];
    public String gameScoreTextO = "O's points:\n"+gameScoreArray[1];
    private int row, column;
    private int winningRow, winningColumn;

    @Override
    public void start(Stage primaryStage) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnValues[i][j] = new Button(blank);
                gridPane.add(btnValues[i][j], j, i);
                btnValues[i][j].setMaxSize(30, 30);
                btnValues[i][j].setMinSize(30, 30);
                btnValues[i][j].setStyle("-fx-border-color: black");
            }
        }

        gameScoreArray[0] = 0; // still have to implement the ties/wins dealio
        gameScoreArray[1] = 0;
        gameScoreArray[2] = 0;
        whoseTurnArray[0] = X;
        whoseTurnArray[1] = O;
        whoseTurnTextArray[1] = "         X's Turn.\n Click an open space!";
        whoseTurnTextArray[0] = "         O's Turn.\n Click an open space!";

        gridPane.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setTop(whoseTurnLabel);
        BorderPane.setAlignment(whoseTurnLabel, Pos.CENTER);
        pane.setLeft(gameScoreLabelX);
        BorderPane.setAlignment(gameScoreLabelX, Pos.CENTER);
        pane.setRight(gameScoreLabelO);
        BorderPane.setAlignment(gameScoreLabelO, Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(btnReset);
        //pane.setRight(btnCheckWin);
        BorderPane.setAlignment(btnReset, Pos.CENTER);
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        whoseTurnLabel.setText(resetTopText);
        gameScoreLabelX.setText(gameScoreTextX);
        gameScoreLabelO.setText(gameScoreTextO);
        
        
        for (row = 0; row < 3; row++) {
            for (column = 0; column < 3; column++) {
                btnValues[row][column].setOnAction(e -> {
                    if(gameWon==false){
                    makeMove((Button)e.getSource());
                    checkForWin();
                    }
                });
            }
        }

        btnReset.setOnAction(e -> {
            resetGame();
        });

//        btnCheckWin.setOnAction(e -> {
//            checkForWin();
//        });

    }

    public static void main(String[] args) {
        launch(args);
    }

    public void resetGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                btnValues[i][j].setText(blank);
//                btnValues[i][j].setText(Integer.toString((int) (Math.random() * 3)));
                btnValues[i][j].setStyle("-fx-border-color: black");
            }
        }
        turn = 0;
        whoseTurn = turn % 2;
        gameWon = false;
        whoseTurnLabel.setText(resetTopText);
    }

    public void makeMove(Button buttonClicked) {
        if ((buttonClicked.getText().equals(blank)) && (gameWon==false)) {
            buttonClicked.setText(whoseTurnArray[whoseTurn]);
            whoseTurnLabel.setText(whoseTurnTextArray[whoseTurn]);
            turn++;
            whoseTurn = turn % 2;
        }
    }

    public void checkForWin() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                checkRight(i, j);
                checkDown(i, j);
                checkDiagonals();
                checkForTie(i,j);
            }
        }
        if (gameWon == true) {
            whoseTurnLabel.setText(btnValues[winningRow][winningColumn].getText() + " has won!");
            if(btnValues[winningRow][winningColumn].getText().equals("X"))
                gameScoreArray[0]++;
            else
                gameScoreArray[1]++;
            gameScoreTextX = "X's points:\n"+gameScoreArray[0];
            gameScoreTextO = "O's points:\n"+gameScoreArray[1];
            gameScoreLabelX.setText(gameScoreTextX);
            gameScoreLabelO.setText(gameScoreTextO);
        }
    }

    public void checkRight(int i, int j) {
        if ((j < 1) && ((btnValues[i][j].getText().equals(btnValues[i][j + 1].getText())) && (btnValues[i][j + 1].getText().equals(btnValues[i][j + 2].getText())))) {
            if (!btnValues[i][j].getText().equals(blank)) {
                btnValues[i][j + 0].setStyle("-fx-border-color: orange");
                btnValues[i][j + 1].setStyle("-fx-border-color: orange");
                btnValues[i][j + 2].setStyle("-fx-border-color: orange");
                gameWon = true;
                winningRow = i;
                winningColumn = j;
            }
        }
    }

    public void checkDown(int i, int j) {
        if ((i < 1) && ((btnValues[i][j].getText().equals(btnValues[i + 1][j].getText())) && (btnValues[i + 1][j].getText().equals(btnValues[i + 2][j].getText())))) {
            if (!btnValues[i][j].getText().equals(blank)) {
                btnValues[i + 0][j].setStyle("-fx-border-color: orange");
                btnValues[i + 1][j].setStyle("-fx-border-color: orange");
                btnValues[i + 2][j].setStyle("-fx-border-color: orange");
                gameWon = true;
                winningRow = i;
                winningColumn = j;
            }
        }
    }

    public void checkDiagonals() {
        if ((!btnValues[0][0].getText().equals(blank))
                && ((btnValues[0][0].getText().equals(btnValues[1][1].getText())) && (btnValues[1][1].getText().equals(btnValues[2][2].getText())))) {
            btnValues[0][0].setStyle("-fx-border-color: orange");
            btnValues[1][1].setStyle("-fx-border-color: orange");
            btnValues[2][2].setStyle("-fx-border-color: orange");
            gameWon = true;
            winningRow = 0;
            winningColumn = 0;
        } else if ((!btnValues[0][2].getText().equals(blank))
                && ((btnValues[0][2].getText().equals(btnValues[1][1].getText())) && (btnValues[1][1].getText().equals(btnValues[2][0].getText())))) {
            btnValues[0][2].setStyle("-fx-border-color: orange");
            btnValues[1][1].setStyle("-fx-border-color: orange");
            btnValues[2][0].setStyle("-fx-border-color: orange");
            gameWon = true;
            winningRow = 0;
            winningColumn = 2;
        }
    }
    
    public void checkForTie(int i,int j){
        
        
        
        gameTied=true;
    }

}
