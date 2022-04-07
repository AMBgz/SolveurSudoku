public class Main {
    public static void main(String[] args){
        int[][] board = {
                {0, 0, 2, 0, 0, 0, 4, 9, 0 },
                { 9, 0, 3, 0, 0, 6, 0, 0, 0 },
                { 5, 0, 0, 3, 0, 4, 0, 2, 0 },
                { 0, 0, 0, 1, 0, 5, 0, 0, 7 },
                { 0, 0, 0, 6, 0, 9, 0, 0, 0 },
                { 7, 0, 0, 8, 0, 2, 0, 0, 0 },
                { 0, 9, 0, 4, 0, 3, 0, 0, 1 },
                { 0, 0, 0, 9, 0, 0, 6, 0, 4 },
                { 0, 6, 5, 0, 0, 0, 9, 0, 0 }
        };


        Solveur s = new Solveur(board);
        s.solve(board);
        s.printBoard();

    }
}
