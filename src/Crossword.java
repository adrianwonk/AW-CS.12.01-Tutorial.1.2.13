public class Crossword {

    private Square[][] puzzle;

    public Square[][] getPuzzle() {
        return puzzle;
    }

    public Crossword(boolean[][] blackSquares) {
        int i = 1;
        puzzle = new Square[blackSquares.length][];
        for (int r = 0; r < blackSquares.length; r++) {
            puzzle[r] = new Square[blackSquares[r].length];
            for (int c = 0; c < blackSquares[r].length; c++) {
                if (blackSquares[r][c]) {
                    puzzle[r][c] = new Square(true, 0);
                } else if (toBeLabeled(r, c, blackSquares)) {
                    puzzle[r][c] = new Square(false, i);
                    i++;
                } else {
                    puzzle[r][c] = new Square(false, 0);
                }
            }
        }
    }

    private boolean toBeLabeled(int r, int c, boolean[][] blackSquares)
    {
        try {
            if (blackSquares[r-1][c]){
                return true;
            }
            else if (blackSquares[r][c-1]){
                return true;
            }
            else {
                return false;
            }
        }
        catch (Exception e) {
            return true;
        }
    }
}