// Name: Mouhamed Ba
// CS 143
// Assignment: Sudoku
// This program will create a SudokuBoard from the data1.sdk file
// and print the puzzle to the console, along with validity checks.

// pre: data1.sdk exists in the same folder as this program
// post: the Sudoku puzzle and its status are printed to the console

public class PlaySudoku2 {
public static void main(String[] args) {

// Create a new SudokuBoard from the file
SudokuBoard board = new SudokuBoard("Sudoku/data1.sdk");
// Print the Sudoku puzzle
System.out.println(board);

// Check if the board is valid according to Sudoku rules
System.out.println("Valid? " + board.isValid());

// Check if the board is completely solved
System.out.println("Solved? " + board.isSolved());
System.out.println("Current working directory: " + System.getProperty("user.dir"));
}
}

/*
Example Output:

2 . . | 1 . 5 | . . 3
. 5 4 | . . . | 7 1 .
. 1 . | 2 . 3 | . 8 .
---------------------
6 . 2 | 8 . 7 | 3 . 4
. . . | . . . | . . .
1 . 5 | 3 . 9 | 8 . 6
---------------------
. 2 . | 7 . 1 | . 6 .
. 8 1 | . . . | 2 4 .
7 . . | 4 . 2 | . . 1

Valid? true
Solved? false
*/
