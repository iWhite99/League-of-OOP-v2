package strategies;

import heroes.Hero;

/**
 * Strategy pattern interface in order to implement strategies for each type of player.
 */
public interface Strategy {
  void apply(Hero hero);
}
