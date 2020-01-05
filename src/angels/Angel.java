package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Position;

/**
 * Implemented visitor pattern for different angel types.
 */
public abstract class Angel extends java.util.Observable {
  private Position position;
  private Magician magician;

  public Angel(final Position position, final Magician magician) {
    this.position = position;
    this.magician = magician;
  }

  public abstract void visitDamageAmplifier(Knight knight);
  public abstract void visitDamageAmplifier(Pyromancer pyromancer);
  public abstract void visitDamageAmplifier(Rogue rogue);
  public abstract void visitDamageAmplifier(Wizard wizard);

  public final Position getPosition() {
    return position;
  }

  public final void setPosition(final Position position) {
    this.position = position;
  }

  public final Magician getMagician() {
    return magician;
  }

  public abstract void spawn();
}
