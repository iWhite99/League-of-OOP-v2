package utils;

public class Position {
  private int currentRow;
  private int currentColumn;

  public Position(final int currentRow, final int currentColumn) {
    this.currentRow = currentRow;
    this.currentColumn = currentColumn;
  }

  public Position() {
    this.currentRow = 0;
    this.currentColumn = 0;
  }

  public final int getCurrentRow() {
    return currentRow;
  }

  public final void setCurrentRow(final int currentRow) {
    this.currentRow = currentRow;
  }

  public final int getCurrentColumn() {
    return currentColumn;
  }

  public final void setCurrentColumn(final int currentColumn) {
    this.currentColumn = currentColumn;
  }

  public final boolean equals(final Position position) {
    return this.currentColumn == position.currentColumn && this.currentRow == position.currentRow;
  }
}
