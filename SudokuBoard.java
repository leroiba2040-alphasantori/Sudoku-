// Mouhamed Ba
// CS 143
//Mouhamed Ba                     
// HW: Sudoku Week 2 - Sudoku Solver Part 2
// This class reads a Sudoku board from a file, prints it nicely, 
// and can check if the board is valid or completely solved.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SudokuBoard {
private int[][] board;

// Constructor: read the Sudoku board from a file
// pre: the file exists and has exactly 9 lines of 9 characters (1-9 or '.')
// post: the board is filled; empty cells are stored as 0
public SudokuBoard(String filename) {
board = new int[9][9];
try {
Scanner sc = new Scanner(new File(filename));
for (int row = 0; row < 9; row++) {
String line = sc.nextLine();
for (int col = 0; col < 9; col++) {
char c = line.charAt(col);
if (c == '.') board[row][col] = 0;
else board[row][col] = Character.getNumericValue(c);
}
}
sc.close();
} catch (FileNotFoundException e) {
System.out.println("File not found: " + filename);
}
}

// Check that all numbers are between 0 and 9
private boolean isValidData() {
for (int r = 0; r < 9; r++) {
for (int c = 0; c < 9; c++) {
int val = board[r][c];
if (val < 0 || val > 9) return false;
}
}
return true;
}

// Check each row to make sure no number appears twice
private boolean checkRows() {
for (int r = 0; r < 9; r++) {
boolean[] seen = new boolean[10];
for (int c = 0; c < 9; c++) {
int val = board[r][c];
if (val != 0) {
if (seen[val]) return false;
seen[val] = true;
}
}
}
return true;
}

// Check each column to make sure no number appears twice
private boolean checkColumns() {
for (int c = 0; c < 9; c++) {
boolean[] seen = new boolean[10];
for (int r = 0; r < 9; r++) {
int val = board[r][c];
if (val != 0) {
if (seen[val]) return false;
seen[val] = true;
}
}
}
return true;
}

// Get one 3x3 mini-square from the board
private int[][] miniSquare(int spot) {
int[][] mini = new int[3][3];
for (int r = 0; r < 3; r++) {
for (int c = 0; c < 3; c++) {
mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
}
}
return mini;
}

// Check all 3x3 mini-squares for duplicates
private boolean checkMiniSquares() {
for (int i = 1; i <= 9; i++) {
int[][] mini = miniSquare(i);
boolean[] seen = new boolean[10];
for (int r = 0; r < 3; r++) {
for (int c = 0; c < 3; c++) {
int val = mini[r][c];
if (val != 0) {
if (seen[val]) return false;
seen[val] = true;
}
}
}
}
return true;
}

// Check if the board follows all Sudoku rules
public boolean isValid() {
return isValidData() && checkRows() && checkColumns() && checkMiniSquares();
}

// Check if the board is completely solved
public boolean isSolved() {
if (!isValid()) return false;
int[] count = new int[10];
for (int r = 0; r < 9; r++) {
for (int c = 0; c < 9; c++) {
int val = board[r][c];
if (val != 0) count[val]++;
}
}
for (int i = 1; i <= 9; i++) {
if (count[i] != 9) return false;
}
return true;
}

// Print the board in a nice way
public String toString() {
StringBuilder sb = new StringBuilder();
for (int row = 0; row < 9; row++) {
if (row % 3 == 0 && row != 0) sb.append("---------------------\n");
for (int col = 0; col < 9; col++) {
if (col % 3 == 0 && col != 0) sb.append("| ");
if (board[row][col] == 0) sb.append(". ");
else sb.append(board[row][col] + " ");
}
sb.append("\n");
}
return sb.toString();
}
}
// add the isValid method and isSolved method 