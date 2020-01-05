package input;

import angels.Angel;
import angels.AngelFactory;
import fileio.FileSystem;
import heroes.Hero;
import heroes.HeroFactory;
import magician.Magician;
import map.Map;
import moves.Move;
import moves.MoveFactory;
import sites.Site;
import utils.Constants;
import utils.Position;

import java.io.IOException;
import java.util.ArrayList;

public class GameLoader {
  private String inputFile;
  private String outputFile;
  private FileSystem fileSystem;

  public GameLoader(final String inputFile, final String outputFile) {
    this.inputFile = inputFile;
    this.outputFile = outputFile;
  }

  public final GameInput load() {
    int siteHeight = 0;
    int siteWidth = 0;
    Site[][] siteMap = null;
    int heroesNumber = 0;
    Hero[] heroes = null;
    int roundsNumber = 0;
    ArrayList<ArrayList<Angel>> angels = null;
    Magician magician = null;
    this.fileSystem = null;
    // Initialize the values with 0 and null if an exception is thrown
    try {
      this.fileSystem = new FileSystem(this.inputFile, this.outputFile);
      siteHeight = this.fileSystem.nextInt();  // Get the height of the map
      siteWidth = this.fileSystem.nextInt();  // Get the width of the map
      char[][] map = new char[siteHeight][siteWidth];
      for (int i = 0; i < siteHeight; i++) {
        map[i] = this.fileSystem.nextWord().toCharArray();
      }
      siteMap = Map.getInstance(map).getSiteMap();
      heroesNumber = this.fileSystem.nextInt();  // Get the number of the heroes
      heroes = new Hero[heroesNumber];  // Allocate the heroes
      HeroFactory heroFactory = new HeroFactory();  // Used to generate different types of heroes
      for (int i = 0; i < heroesNumber; i++) {
        heroes[i] = heroFactory.getHero(this.fileSystem.nextWord(), i);
        // Get the wanted type of hero in the actual position
        Position initialPosition = new Position(this.fileSystem.nextInt(),
                this.fileSystem.nextInt());
        // Get the initial position of a hero
        heroes[i].setPosition(initialPosition);
        // Set the initial position of a hero
      }
      roundsNumber = this.fileSystem.nextInt();  // Get the number of rounds
      for (int i = 0; i < heroesNumber; i++) {
        heroes[i].setMoves(new Move[roundsNumber]);  // Allocate the number of moves for each hero
      }
      MoveFactory moveFactory = new MoveFactory();  // Used to generate different types of moves
      for (int i = 0; i < roundsNumber; i++) {
        char[] currentRowMoves = this.fileSystem.nextWord().toCharArray();
        // Keep the row as a char array in order to access directly every move for each hero
        for (int j = 0; j < heroesNumber; j++) {
          heroes[j].getMoves()[i] = moveFactory.getMove(currentRowMoves[j]);
          // Set the current move
        }
      }
      AngelFactory angelFactory = new AngelFactory();
      angels = new ArrayList<>();
      magician = Magician.getInstance(this.fileSystem);
      for (int i = 0; i < roundsNumber; i++) {
        ArrayList<Angel> roundAngels = new ArrayList<>();
        int currentRoundAngels = this.fileSystem.nextInt();
        for (int j = 0; j < currentRoundAngels; j++) {
          String currentAngel = this.fileSystem.nextWord();
          String[] info = currentAngel.split(",");
          String angelType = info[0];
          int row = Integer.parseInt(info[1]);
          int column = Integer.parseInt(info[2]);
          Position position = new Position(row, column);
          roundAngels.add(angelFactory.getAngel(angelType, position, magician));
        }
        angels.add(i, roundAngels);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new GameInput(siteMap, heroesNumber, heroes, roundsNumber, angels, magician,
            this.fileSystem);
  }

  public final void end(final GameInput gameInput) {
    try {
      this.fileSystem.writeWord("~~ Results ~~");
      this.fileSystem.writeWord(Constants.NEWLINE);
      for (Hero currentHero : gameInput.getHeroes()) {
        this.fileSystem.writeWord(currentHero.toString());
        this.fileSystem.writeWord(Constants.NEWLINE);
      }
      this.fileSystem.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
