
/**
 * Practice Assignment A0
 *
 * COMP 1020 SECTION A0
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 0, question #
 * @author       Mykola Chudak, 008043157
 * @version      1/22/2025
 *
 * PURPOSE: Analyzing the scores of a "class of students"
 */

import java.util.Random;

public class A0 {

    // Array testing in the main method
    public static void main(String[] args) {
        int[] array = new int[20];
        Random rand = new Random();

        for (int index = 0; index < array.length; index++) {
            array[index] = rand.nextInt(101);
        }

        System.out.println("Average Score: " + A0.calculateAverage(array));
        System.out.println("Highest Score: " + A0.findHighestScore(array));
        System.out.println("Lowest Score: " + A0.findLowestScore(array));
        System.out.println(
                "Number of Students Scoring Above Average: " + A0.countAboveAverage(array, A0.calculateAverage(array)));

        int threshold = 50;
        A0.printGradesAboveThreshold(array, threshold);

    }

    public static int calculateAverage(int[] scores) {
        int sum = 0;
        int average = 0;

        for (int index = 0; index < scores.length; index++) {
            sum += scores[index];
        }

        average = sum / scores.length;

        return average;
    }

    public static int findHighestScore(int[] scores) {
        int max = scores[0];

        for (int index = 0; index < scores.length; index++) {
            max = Math.max(max, scores[index]);
        }

        return max;

    }

    public static int findLowestScore(int[] scores) {
        int min = scores[0];

        for (int index = 0; index < scores.length; index++) {
            min = Math.min(min, scores[index]);
        }

        return min;
    }

    public static int countAboveAverage(int[] scores, double average) {
        int counter = 0;

        for (int index = 0; index < scores.length; index++) {

            if (scores[index] > average) {
                counter += 1;
            }

        }

        return counter;
    }

    public static int[] printGradesAboveThreshold(int[] scores, int threshold) {
        int count = 0;

        for (int index = 0; index < scores.length; index++) {
            if (scores[index] > threshold) {
                count++;
            }
        }

        int[] result = new int[count];
        int resultIndex = 0;

        for (int index = 0; index < scores.length; index++) {
            if (scores[index] > threshold) {
                result[resultIndex] = scores[index];
                resultIndex++;
            }
        }

        System.out.print("Scores above " + threshold + ": ");

        for (int i = 0; i < result.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(result[i]);
        }
        return result;
    }

}