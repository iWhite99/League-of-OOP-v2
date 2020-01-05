package angels;

import magician.Magician;
import utils.Position;

public final class AngelFactory {
  public Angel getAngel(final String angelType, final Position position, final Magician magician) {
    switch (angelType) {
      case "DamageAngel":
        return new DamageAngel(position, magician);
      case "DarkAngel":
        return new DarkAngel(position, magician);
      case "Dracula":
        return new Dracula(position, magician);
      case "GoodBoy":
        return new GoodBoy(position, magician);
      case "LevelUpAngel":
        return new LevelUpAngel(position, magician);
      case "LifeGiver":
        return new LifeGiver(position, magician);
      case "SmallAngel":
        return new SmallAngel(position, magician);
      case "Spawner":
        return new Spawner(position, magician);
      case "TheDoomer":
        return new TheDoomer(position, magician);
      case "XPAngel":
        return new XPAngel(position, magician);
      default:
        return null;
    }
  }
}
