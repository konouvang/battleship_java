package com.company;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int GAME_WIDTH = 5;
    private static final int GAME_HEIGHT = 5;
    private static final int TARGETS = 5;

    private static char[][] grid = new char[GAME_WIDTH][GAME_HEIGHT];
    private static char[][] targets = new char[GAME_WIDTH][GAME_HEIGHT];

    private static int hitsLeft = TARGETS;
    private static int guesses = 0;


    public static void main(String[] args) {
        // playboard build
        for (int i = 0; i < GAME_WIDTH; i++) {
            for (int j = 0; j < GAME_HEIGHT; j++) {
                grid[i][j] = 'O';
            }
        }
        // puts the targets to the game board ( not the player board )
        assignHits(TARGETS);

        while(hitsLeft > 0) {
            promptUser();
            printMap();
        }

        System.out.println("You win");
        System.out.println("total guesses: " + guesses);

    }

    public static void assignHits(int num_of_targets) {
        // this will set up where the enemy ships go!

        Random random = new Random();

        for (int i = 0; i < num_of_targets; i++) {
            int y = random.nextInt(GAME_HEIGHT);
            int x = random.nextInt(GAME_WIDTH);
            targets[x][y] = 'y';


        }
    }

    public static void printMap() {
        // this shows player's board as they are playing!
        for (int i = 0; i < GAME_WIDTH; i++) {
            for (int j = 0; j < GAME_HEIGHT; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println(" ");
        }
    }

    public static String getInput(String message) {
        // collect user input and return that they enter as a string
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void promptUser() {
        // game loop!


        int xGuess;
        int yGuess;

        try {
            xGuess = Integer.parseInt(getInput("Enter an X value: "));
        } catch (Exception error) {
            xGuess = -1;
        }


        try {
            yGuess = Integer.parseInt(getInput("Enter an X value: "));
        } catch (Exception error) {
            yGuess = -1;
        }

        try {
            if (targets[yGuess][xGuess] == 'Y') {
                grid[yGuess][xGuess] = 'H';
                targets[yGuess][xGuess] = 'O';


            } else if (grid[yGuess][xGuess] == 'M') {
                System.out.println("you already guess this");
            } else {
                grid[yGuess][xGuess] = 'M';
                System.out.println("miss");
                ++guesses;

            }
        } catch (Exception error){
                System.out.println(" you entered a position already guessed");
            }
        }
    }

    //CHECK FOR MISS HIT OR ALREADY GUESSED





