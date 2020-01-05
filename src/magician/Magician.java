package magician;

import fileio.FileSystem;

import java.io.IOException;
import java.util.Observable;

public final class Magician implements java.util.Observer {
  private FileSystem fileSystem;
  private static Magician instance = null;

  private Magician(final FileSystem fileSystem) {
    this.fileSystem = fileSystem;
  }

  public static Magician getInstance(final FileSystem fileSystem) {
    if (instance == null) {
      instance = new Magician(fileSystem);
    }
    return instance;
  }

  @Override
  public void update(final Observable observable, final Object o) {
//    System.out.println(o.toString());
    try {
      this.fileSystem.writeWord(o.toString());
      this.fileSystem.writeWord("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
