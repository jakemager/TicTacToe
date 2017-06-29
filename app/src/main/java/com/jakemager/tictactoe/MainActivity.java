package com.jakemager.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // this array will hold the game board (probably a horrible idea)
    // -1 is empty, 0 is o, 1 is x (int easy to compare)
    int[] gameBoard = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    int turn = 1; // shitty way to keep track of turns

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare variables
        final Button b0, b1, b2, b3, b4, b5, b6, b7, b8, newGameButton;

        // find all the buttons
        b0 = (Button)findViewById(R.id.button0);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        newGameButton = (Button)findViewById(R.id.newGameButton);


        // make listeners for buttons
        b0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b0, 0);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b1, 1);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b2, 2);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b3, 3);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b4, 4);
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b5, 5);
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b6, 6);
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b7, 7);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                move(b8, 8);
            }
        });

        newGameButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                newGame();
            }
        });
    }

    // Check moves
    void move(Button button, int position) {

        // if button is free
        if (button.getText().length() == 0) {
            // instantiate the button to represent move
            if (turn == 1) {
                turn = 0;
                gameBoard[position] = 1;
                button.setText("X");
            } else if (turn == 0) {
                turn = 1;
                gameBoard[position] = 0;
                button.setText("O");
            }


            int winner = CheckWinner();
            // if there is a winner
            if (winner > -1) {
                final TextView winnerText = (TextView)findViewById(R.id.winnerText);
                final Button newGameButton = (Button)findViewById(R.id.newGameButton);
                if (winner == 0) {
                    winnerText.setText("O WINS!");
                } else if (winner == 1) {
                    winnerText.setText("X WINS!");
                } else if (winner == 2) {
                    winnerText.setText("DRAW!");
                }
                newGameButton.setVisibility(View.VISIBLE);
                turn = -1;
            }
        }
    }

    // the worst way I can check for a winner
    int CheckWinner() {
        if (gameBoard[0] != -1 && gameBoard[0] == gameBoard[1] && gameBoard[0] == gameBoard[2]) {
            return gameBoard[0];
        } else if (gameBoard[3] != -1 && gameBoard[3] == gameBoard[4] && gameBoard[3] == gameBoard[5]) {
            return gameBoard[3];
        } else if (gameBoard[6] != -1 && gameBoard[6] == gameBoard[7] && gameBoard[6] == gameBoard[8]) {
            return gameBoard[6];
        } else if (gameBoard[0] != -1 && gameBoard[0] == gameBoard[3] && gameBoard[0] == gameBoard[6]) {
            return gameBoard[0];
        } else if (gameBoard[1] != -1 && gameBoard[1] == gameBoard[4] && gameBoard[1] == gameBoard[7]) {
            return gameBoard[1];
        } else if (gameBoard[2] != -1 && gameBoard[2] == gameBoard[5] && gameBoard[2] == gameBoard[8]) {
            return gameBoard[2];
        } else if (gameBoard[0] != -1 && gameBoard[0] == gameBoard[4] && gameBoard[0] == gameBoard[8]) {
            return gameBoard[0];
        } else if (gameBoard[2] != -1 && gameBoard[2] == gameBoard[4] && gameBoard[2] == gameBoard[6]) {
            return gameBoard[2];
        } else {
            int i;
            for (i = 0; i < 9; i++) {
                if (gameBoard[i] == -1) {
                    i = 10;
                }
            }
            if (i == 9) {
                return 2;
            }
        }

        return -1;
    }

    // reset and get ready for new game
    void newGame() {
        for (int i = 0; i < 9; i++) {
            gameBoard[i] = -1;
        }
        turn = 1;

        // declare variables
        final Button b0, b1, b2, b3, b4, b5, b6, b7, b8, newGameButton;
        final TextView winnerText = (TextView)findViewById(R.id.winnerText);

        // find all the buttons
        b0 = (Button)findViewById(R.id.button0);
        b1 = (Button)findViewById(R.id.button1);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);
        b5 = (Button)findViewById(R.id.button5);
        b6 = (Button)findViewById(R.id.button6);
        b7 = (Button)findViewById(R.id.button7);
        b8 = (Button)findViewById(R.id.button8);
        newGameButton = (Button)findViewById(R.id.newGameButton);

        b0.setText(null);
        b1.setText(null);
        b2.setText(null);
        b3.setText(null);
        b4.setText(null);
        b5.setText(null);
        b6.setText(null);
        b7.setText(null);
        b8.setText(null);
        winnerText.setText(null);
        newGameButton.setVisibility(View.INVISIBLE);

    }


}

