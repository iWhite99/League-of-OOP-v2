package heroes;

import java.util.Comparator;

public class HeroIdComparator implements Comparator<Hero> {
  @Override
  public final int compare(final Hero hero, final Hero t1) {
    return hero.getId() - t1.getId();
  }
}
