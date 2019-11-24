package moves;

import utils.Constants;

public class MoveFactory {
  /**
   * @param moveType represents the type of the Move that will be returned
   * @return a Move of the wanted type or null if the type is not implemented.
   */
  public final Move getMove(final char moveType) {
    switch (moveType) {
      case Constants.MOVE_UP_CHAR:
        return new MoveUp();
      case Constants.MOVE_DOWN_CHAR:
        return new MoveDown();
      case Constants.MOVE_LEFT_CHAR:
        return new MoveLeft();
      case Constants.MOVE_RIGHT_CHAR:
        return new MoveRight();
      case Constants.NO_MOVE_CHAR:
        return new NoMove();
      default:
        return null;
    }
  }
}
