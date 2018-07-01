package com.mlaptev.app;

import java.util.Scanner;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * Link: https://www.hackerrank.com/challenges/halloween-sale
 *
 * Using a simple problem from HackerRank site as a task for homework.
 */
public class HalloweenSale {

  private static final Logger logger = LogManager.getLogger(HalloweenSale.class);

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int p = scanner.nextInt();
      int d = scanner.nextInt();
      int m = scanner.nextInt();
      int s = scanner.nextInt();
      logger.info("Maximum number of games: {}", getMaximumNumberOfGamesToBuy(p, d, m, s));
    }
  }

  static int getMaximumNumberOfGamesToBuy(int p, int d, int m, int s) {
    int numberOfGames = 0;
    while (s >= p) {
      numberOfGames++;
      s -= p;
      p -= d;
      if (p < m) {
        p = m;
      }
    }
    return numberOfGames;
  }
}
