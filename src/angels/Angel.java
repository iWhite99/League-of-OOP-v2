package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import utils.Position;

public abstract class Angel {
  private Position position = null;

  public Angel(final Position position) {
    this.position = position;
  }

  public abstract void visitDamageAmplifier(Knight knight);
  public abstract void visitDamageAmplifier(Pyromancer pyromancer);
  public abstract void visitDamageAmplifier(Rogue rogue);
  public abstract void visitDamageAmplifier(Wizard wizard);
}
