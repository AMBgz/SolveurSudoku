public class Solveur {
    int[][] board;
    int BOARD_START;
    int BOARD_SIZE;
    final int Min_Value=1;
    final int Max_Value=9;

    public Solveur(int[][] b){
        board=b;
        BOARD_SIZE=b.length;
        BOARD_START=0;
    }

    public boolean solve(int[][] bard){
        for(int k=BOARD_START;k<BOARD_SIZE;k++){
            for(int c=BOARD_START;c<BOARD_SIZE;c++){
                if(board[k][c]==0){
                    for(int res=Min_Value;res<=Max_Value;res++){
                        bard[k][c]=res;
                        if(isValid(k,c,bard)&&solve(bard)){

                            return true;
                        }
                        bard[k][c]=0;
                    }
                    return false;
                }
            }

        }
        return true;
    }

     void printBoard() {
        for (int row = BOARD_START; row < BOARD_SIZE; row++) {
            for (int column = BOARD_START; column < BOARD_SIZE; column++) {
                System.out.print(board[row][column]+ " ");
            }
            System.out.println();
        }
    }

    public boolean isValid(int k,int c, int[][] board){
       return columValid(c,board) && rowValid(k,board) && squareValid(k,c,board);
    }

    public boolean rowValid(int k, int[][] board){
        for(int r=Min_Value;r<=Max_Value;r++) {
            int cpt=0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[k][j]==r){
                    cpt+=1;
                }
            }
            if(cpt>1) {
                return false;
            }
        }
        return true;
    }

    public boolean columValid(int c, int[][] board){
        for(int r=Min_Value;r<=Max_Value;r++) {
            int cpt=0;
            for (int j = 0; j < BOARD_SIZE; j++) {

                if (board[j][c]==r){
                    cpt+=1;
                }
            }
            if(cpt>1) return false;
        }
        return true;
    }

    public boolean squareValid(int k, int c,int[][] board){
        int x_coin_HG;
        int y_coin_HG;
        if((k+1)%3==2){
            x_coin_HG=k-1;
        }else if((k+1)%3==0){
            x_coin_HG=k-2;
        }else x_coin_HG=k;
        if((c+1)%3==2){
            y_coin_HG=c-1;
        }else if((c+1)%3==0){
            y_coin_HG=c-2;
        }else y_coin_HG=c;


        int xlim=x_coin_HG+3;
        int ylim=y_coin_HG+3;
        for(int r=Min_Value;r<=Max_Value;r++) {
            int cpt=0;
            for (int l=x_coin_HG; l<xlim;l++){
                for(int p=y_coin_HG;p<ylim;p++){
                    if(board[l][p]==r){
                        cpt+=1;
                    }
                }
                if(cpt>1){
                    return false;
                }
            }
        }
        return true;
    }
}
