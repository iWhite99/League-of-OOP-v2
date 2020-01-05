package angels;

import magician.Magician;
import utils.Position;

public final class AngelFactory {
  /**
   * @param angelType represents the type of the Angel that will be returned
   * @param position represents the position of the Angel on the map
   * @param magician represents the Observer where the information will be reported
   * @return an Angel of the wanted type or null if the type is not implemented
   */
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
