package sites;

import heroes.Hero;

public class WoodsSite implements Site {
  @Override
  public final void acceptSiteAmplifier(final Hero hero) {
    hero.visitSiteAmplifier(this);
  }
}
