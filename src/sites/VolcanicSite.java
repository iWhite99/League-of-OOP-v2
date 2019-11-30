package sites;

import heroes.Hero;

public class VolcanicSite implements Site {
  @Override
  public final void acceptSiteAmplifier(final Hero hero) {
    hero.visitSiteAmplifier(this);
  }

  @Override
  public final boolean rogueBonus() {
    return false;
  }
}
