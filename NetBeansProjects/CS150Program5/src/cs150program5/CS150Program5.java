/* Name: Jacob Melosi
 * Date: 11/1/2014
 * Class: CS150
 * Assignment: Program 5
 * Description: This program creates a grid of numbers all between 0 and 4
 *         and finds everywhere there are 4 or more in a row. It also resets.
 */

package cs150program5;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CS150Program5 extends Application {
    
    private static final int SIZE = 10;
    private int[][] numbersArray = new int[SIZE][SIZE];
    Button[][] btnValues = new Button[SIZE][SIZE];
    Button btnSolveNew = new Button("Solve");
    String[] isSolved = new String[2];
    public int found = 0;
    public final int PANE_HEIGHT = 350;
    public final int PANE_WIDTH = 300;
    public final int GRID_SIZE = SIZE;
    public final int MAX_GRID_VALUE = 4; // the grid will be between 0 and this#
    public final String STAGE_TITLE = "Four in a Row";
    
    @Override
    public void start(Stage primaryStage) {

        Label foundStatusLabel = new Label();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                btnValues[i][j] = new Button((int) (Math.random() * (MAX_GRID_VALUE+1)) + "");
                gridPane.add(btnValues[i][j], j, i);
            }
        }

        isSolved[0] = "No four are in a row.";
        isSolved[1] = "Four or more in a row found!";
        BorderPane pane = new BorderPane();
        pane.setTop(foundStatusLabel);
        BorderPane.setAlignment(foundStatusLabel, Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(btnSolveNew);
        BorderPane.setAlignment(btnSolveNew, Pos.CENTER);
        Scene scene = new Scene(pane, PANE_WIDTH, PANE_HEIGHT);
        primaryStage.setTitle(STAGE_TITLE);
        primaryStage.setScene(scene);
        primaryStage.show();
        foundStatusLabel.setText("Press solve to search for four in a row!");
        
        btnSolveNew.setOnAction(e -> {
            
            if (btnSolveNew.getText().equalsIgnoreCase("solve")) {
                for (int i = 0; i < numbersArray.length; i++) {
                    for (int j = 0; j < numbersArray[i].length; j++) {
                        numbersArray[i][j] = Integer.parseInt(btnValues[i][j].getText().trim());
                    } // .trim() removes the leading and trailing white spaces
                }
                found = 0;
                searchForFour(numbersArray);
                btnSolveNew.setText("New");
                foundStatusLabel.setText(isSolved[found]);
            } else {
                for (int i = 0; i < numbersArray.length; i++) {
                    for (int j = 0; j < numbersArray[0].length; j++) {
                        numbersArray[i][j] = (int) (Math.random() * (MAX_GRID_VALUE+1));
                        btnValues[i][j].setText(numbersArray[i][j] + "");
                        btnValues[i][j].setStyle("-fx-background: white");
                    }
                }
                foundStatusLabel.setText("Press solve to search for four in a row!");
                btnSolveNew.setText("Solve");
            }
        });
    }
    
    public void searchForFour(int[][] arr) {

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                columnSearch(arr, i, j);
                rowSearch(arr, i, j);
                diagonalDownLeftSearch(arr, i, j);
                diagonalDownRightSearch(arr, i, j);
            }
        }
    }

    public void columnSearch(int[][] arr, int i, int j) {
        
        if (i < GRID_SIZE - 3) {
            int num = arr[i][j];
            if((arr[i][j] == arr[i + 1][j]) &&
               (arr[i + 1][j] == arr[i + 2][j]) &&
               (arr[i + 2][j] == arr[i + 3][j])){
                        btnValues[i + 0][j].setStyle("-fx-border-color: yellow");
                        btnValues[i + 1][j].setStyle("-fx-border-color: yellow");
                        btnValues[i + 2][j].setStyle("-fx-border-color: yellow");
                        btnValues[i + 3][j].setStyle("-fx-border-color: yellow");
                        
                        found = 1;
            }
        }
    }
    
    public void rowSearch(int[][] arr, int i, int j) {
        
        if (j < GRID_SIZE - 3) {
            int num = arr[i][j];
            if((arr[i][j] == arr[i][j + 1]) &&
               (arr[i][j + 1] == arr[i][j + 2]) &&
               (arr[i][j + 2] == arr[i][j + 3])){
                        btnValues[i][j + 0].setStyle("-fx-border-color: red");
                        btnValues[i][j + 1].setStyle("-fx-border-color: red");
                        btnValues[i][j + 2].setStyle("-fx-border-color: red");
                        btnValues[i][j + 3].setStyle("-fx-border-color: red");

                        found = 1;
            }
        }
    }

    public void diagonalDownLeftSearch(int[][] arr, int i, int j) {
        
        if ((j > 2) && (i < GRID_SIZE - 3)) {
            int num = arr[i][j];
            if((arr[i][j] == arr[i + 1][j - 1]) && 
               (arr[i + 1][j - 1] == arr[i + 2][j - 2]) &&
               (arr[i + 2][j - 2] == arr[i + 3][j - 3])){
                        btnValues[i + 0][j - 0].setStyle("-fx-border-color: orange");
                        btnValues[i + 1][j - 1].setStyle("-fx-border-color: orange");
                        btnValues[i + 2][j - 2].setStyle("-fx-border-color: orange");
                        btnValues[i + 3][j - 3].setStyle("-fx-border-color: orange");
                        
                        found = 1;
            }
        }
    }

    public void diagonalDownRightSearch(int[][] arr, int i, int j) {
        if (j < GRID_SIZE - 3 && i < GRID_SIZE - 3) {
            int num = arr[i][j];
            if((arr[i][j] == arr[i + 1][j + 1]) &&
               (arr[i + 1][j + 1] == arr[i + 2][j + 2])&&
               (arr[i + 2][j + 2] == arr[i + 3][j + 3])){
                        btnValues[i + 0][j + 0].setStyle("-fx-border-color: blue");
                        btnValues[i + 1][j + 1].setStyle("-fx-border-color: blue");
                        btnValues[i + 2][j + 2].setStyle("-fx-border-color: blue");
                        btnValues[i + 3][j + 3].setStyle("-fx-border-color: blue");
                        
                        found = 1;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
