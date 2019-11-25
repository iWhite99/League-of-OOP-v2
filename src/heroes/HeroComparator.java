package heroes;

import java.util.Comparator;

public class HeroComparator implements Comparator<Hero> {
  @Override
  public final int compare(final Hero hero, final Hero t1) {
    return hero.compareCoefficient() - t1.compareCoefficient();
  }
}
