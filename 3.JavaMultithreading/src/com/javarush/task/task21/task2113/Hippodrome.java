package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public void setGame(Hippodrome game) {
        this.game = game;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> myHorses = new ArrayList<>();
        myHorses.add(new Horse("Счастливчик", 3, 0));
        myHorses.add(new Horse("Лихач", 3, 0));
        myHorses.add(new Horse("Строптивый", 3, 0));
        game = new Hippodrome(myHorses);
        game.run();
        game.printWinner();
    }

    public void move() {
        for (Horse horse : this.horses) {
            horse.move();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print() {
        for (Horse horse : this.horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner() {
        Horse winner = null;
        int maxDistance = 0;
        for (Horse horse : horses) {
            if (maxDistance < horse.getDistance()) winner = horse;
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
