public class Side {
  private Square[] squares;

  public Side (String[] colour) {
    squares = new Square[9];
    for (int i = 0; i < 9; i++) {
      squares[i] = new Square(colour[i]);
    }
  }
}
