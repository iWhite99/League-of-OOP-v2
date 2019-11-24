package sites;

import heroes.Hero;

public class LandSite implements Site {
  @Override
  public final void acceptSiteAmplifier(final Hero hero) {
    hero.visitSiteAmplifier(this);
  }
}
