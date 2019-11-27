package main;

import heroes.HeroComparator;
import heroes.HeroIdComparator;
import input.GameInput;
import input.GameLoader;

import java.util.Arrays;

public final class Main {
  private Main() {

  }

  public static void main(final String[] args) {
    GameLoader gameLoader = new GameLoader(args[0], args[1]);
    GameInput gameInput = gameLoader.load();
    Arrays.sort(gameInput.getHeroes(), new HeroComparator());
    gameInput.run();
    Arrays.sort(gameInput.getHeroes(), new HeroIdComparator());
    gameLoader.end(gameInput);
  }
}
