package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Robot amigo = new Robot("Амиго", 6);
        Robot enemy = new Robot("Сгибальщик-02", 8);
        int round = 0;

        while (amigo.getHits() > 0 && enemy.getHits() > 0) {
            ++round;
            if (round % 2 == 0) doMove(amigo, enemy, round);
            else doMove(enemy, amigo, round);
            Thread.sleep(1500);
        }
        if (amigo.getHits() <= 0 ) System.out.println("\n " + amigo.getName() + " скончался, " + enemy.getName() + " победил!");
        if (enemy.getHits() <= 0 ) System.out.println("\n " + enemy.getName() + " скончался, " + amigo.getName() + " победил!");
    }

    public static void doMove(Robot robotFirst, Robot robotSecond, int raund) {
        String damage = "";
        BodyPart attacked = robotFirst.attack();
        BodyPart defended = robotSecond.defense();
        int potentioalDamage = robotFirst.doDamage(attacked);

        if (attacked == defended) {
            damage = "              ///// ЗАБЛОКИРОВАНРО!!!";
        } else {
            damage = "        ///// НАНЕСЕГО УРОНА - " + potentioalDamage;
        }

        System.out.println(String.format("раунд %s: (хиты %s: %s; хиты %s: %s),\n    :::::::::::::::::::::   %s атаковал робота %s, атакована %s, защищена %s %s",
                raund, robotFirst.getName(), robotFirst.getHits(), robotSecond.getName(),
                robotSecond.getHits(), robotFirst.getName(), robotSecond.getName(), attacked, defended, damage));

        if (attacked != defended) robotSecond.setHits(robotSecond.getHits() - potentioalDamage);
    }
}
