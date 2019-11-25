package moves;

import heroes.Hero;

public interface Move {
  // Visitable Move
  void acceptMove(Hero hero);
}
