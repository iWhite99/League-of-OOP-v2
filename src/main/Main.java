package main;

import input.GameInput;
import input.GameLoader;

public final class Main {
  private Main() {

  }

  public static void main(final String[] args) {
    GameLoader gameLoader = new GameLoader(args[0], args[1]);
    GameInput gameInput = gameLoader.load();
    if (gameInput != null) {
      gameInput.run();
      gameLoader.end(gameInput);
    }
  }
}
