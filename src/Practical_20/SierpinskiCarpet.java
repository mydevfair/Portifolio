/*
 *File: SierpinskiCarpet.java
 * Author: Chris Fairhurst
 * Date: January 6, 2023
 * Description: This file contains the implementation of a Sierpinski Carpet.
 */
package Practical_20;

public class SierpinskiCarpet {
    public char[][] board;//the board
    public int size;//the size of the board
    /**
     * Constructor
     * @param n
     * takes in the number of levels of recursion to generate the carpet
     * n = what power of 3 to use for the size of the board
     */
    public SierpinskiCarpet(int n){
        this.size = (int) Math.pow(3, n);//get the size of the board
        this.board = new char[size][size];//create the board
        initializeBoard();//call the method to initialise the board
    }
    //method to initialise the board with *
    public void initializeBoard(){
        for(int i = 0; i < size; i++){//loop through the rows
            for(int j = 0; j < size; j++){//loop through the columns
                board[i][j] = '*';//fill with *
            }
        }
    }
    //method to generate the carpet
    public void generateCarpet(char[][] board, int row, int col, int size){
        int newSize = size / 3;//get the new size
        if(newSize < 1) return;//base case

        for(int i = 0; i < 3; i++){//loop through the rows
            for(int j = 0; j < 3; j++){//loop through the columns
                if(i == 1 && j == 1){//if the row and column are 1
                    fillWithSpaces(board, row + newSize, col + newSize, newSize);//call the method to fill with spaces
                }else{
                    generateCarpet(board, row + i * newSize, col + j * newSize, newSize);//recursively call the method
                }
            }
        }
    }
    //method to fill the board with spaces
    public void fillWithSpaces(char[][] board, int row, int col, int size){
        for(int i = row; i < row + size; i++){//loop through the rows
            for(int j = col; j < col + size; j++){//loop through the columns
                board[i][j] = ' ';//fill with spaces
            }
        }
    }
    //method to print the carpet
    public void printCarpet(){
        System.out.println("Sierpinski Carpet");//print the title
        for(int i = 0; i < size; i++){//loop through the rows
            for(int j = 0; j < size; j++){//loop through the columns
                System.out.print(board[i][j]);//print the board
            }
            System.out.println();//print a new line
        }
    }
    //method to generate the carpet with levels of recursion
    public void generateCarpetWithLevels(char[][] board, int row, int col, int size, int level) {//generate the carpet with levels
        int newSize = size / 3;//new size of the carpet
        if (newSize < 1) return;//base case

        for (int i = 0; i < 3; i++) {//loop through the rows
            for (int j = 0; j < 3; j++) {//loop through the columns
                if (i == 1 && j == 1) {//if the row and column are in the middle
                    fillWithSpaces(board, row + newSize, col + newSize, newSize, Character.forDigit(level, 10));//fill with spaces
                } else {//otherwise
                    generateCarpetWithLevels(board, row + i * newSize, col + j * newSize, newSize, level + 1);//recursively call the method
                }
            }
        }
    }
    //method to fill the board with levels of recursion
    public void fillWithSpaces(char[][] board, int row, int col, int size, char level) {
        for(int i = row; i < row + size; i++){//loop through the rows
            for(int j = col; j < col + size; j++){//loop through the columns
                board[i][j] = level;//fill with the current level number of recursion
            }
        }
    }
    //method to print the carpet with levels
    public void printCarpetLevels(){
        System.out.println("Sierpinski Carpet With Levels Of Recursion");//print the title
        for(int i = 0; i < size; i++){//loop through the rows
            for(int j = 0; j < size; j++){//loop through the columns
                System.out.print(board[i][j]);//print the board
            }
            System.out.println();//print a new line
        }
    }


    //main method
    public static void main(String[] args){
        SierpinskiCarpet s = new SierpinskiCarpet(2);//create a new object
        s.generateCarpet(s.board, 0,0, s.size);//generate the carpet
        s.printCarpet();//print the carpet
        s.generateCarpetWithLevels(s.board, 0,0, s.size,0);//generate the carpet with levels
        s.printCarpetLevels();//print the carpet with levels
    }
}
