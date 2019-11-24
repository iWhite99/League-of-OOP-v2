package sites;

import heroes.Hero;

public class DesertSite implements Site {
  @Override
  public final void acceptSiteAmplifier(final Hero hero) {
    hero.visitSiteAmplifier(this);
  }
}
