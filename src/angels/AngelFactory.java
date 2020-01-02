package angels;

import utils.Position;

public class AngelFactory {
  public Angel getAngel(final String angelType, final Position position) {
    switch (angelType) {
      case "DamageAngel":
        return new DamageAngel(position);
      case "DarkAngel":
        return new DarkAngel(position);
      case "Dracula":
        return new Dracula(position);
      case "GoodBoy":
        return new GoodBoy(position);
      case "LevelUpAngel":
        return new LevelUpAngel(position);
      case "LifeGiver":
        return new LifeGiver(position);
      case "SmallAngel":
        return new SmallAngel(position);
      case "TheDoomer":
        return new TheDoomer(position);
      case "XPAngel":
        return new XPAngel(position);
      default:
        return null;
    }
  }
}
