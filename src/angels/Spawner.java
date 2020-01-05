package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;
import magician.Magician;
import utils.Constants;
import utils.Position;

public final class Spawner extends Angel {
  public Spawner(final Position position, final Magician magician) {
    super(position, magician);
  }

  @Override
  public void visitDamageAmplifier(final Knight knight) {
    if (knight.getCurrentHp() == 0) {
      knight.setCurrentHp(Constants.SPAWNER_KNIGHT);
      this.getMagician().update(this, Constants.SPAWNER_HELPED + knight.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + knight.heroTypeAndIndex()
              + Constants.RESPAWNED);
    }
  }

  @Override
  public void visitDamageAmplifier(final Pyromancer pyromancer) {
    if (pyromancer.getCurrentHp() == 0) {
      pyromancer.setCurrentHp(Constants.SPAWNER_PYROMANCER);
      this.getMagician().update(this, Constants.SPAWNER_HELPED + pyromancer.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + pyromancer.heroTypeAndIndex()
              + Constants.RESPAWNED);
    }
  }

  @Override
  public void visitDamageAmplifier(final Rogue rogue) {
    if (rogue.getCurrentHp() == 0) {
      rogue.setCurrentHp(Constants.SPAWNER_ROGUE);
      this.getMagician().update(this, Constants.SPAWNER_HELPED + rogue.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + rogue.heroTypeAndIndex()
              + Constants.RESPAWNED);
    }
  }

  @Override
  public void visitDamageAmplifier(final Wizard wizard) {
    if (wizard.getCurrentHp() == 0) {
      wizard.setCurrentHp(Constants.SPAWNER_WIZARD);
      this.getMagician().update(this, Constants.SPAWNER_HELPED + wizard.heroTypeAndIndex());
      this.getMagician().update(this, Constants.PLAYER + wizard.heroTypeAndIndex()
              + Constants.RESPAWNED);
    }
  }

  @Override
  public void spawn() {
    int row = this.getPosition().getCurrentRow();
    int column = this.getPosition().getCurrentColumn();
    this.getMagician().update(this, Constants.SPAWNER_SPAWNED + row + " " + column);
  }
}
