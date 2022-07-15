
public class GamePiece {
    int row;
    int col;
    Character symbol;

    // default constructor
    GamePiece(){
        row = -1;
        col = -1;
        symbol = null;
    }

    // copy constructor
    GamePiece(GamePiece gPiece){  
        row  = gPiece.row;  
        col = gPiece.col;
        symbol = gPiece.symbol;  
    }

    // constructor
    GamePiece(int x, int y, char c){
        row = x;
        col = y;
        symbol = c;
    }

    void moveUp(){
        if(row >= 1){
            row--;
        }
    }

    void moveDown(){
        if(row < 10){
            row++;
        }
    }

    void moveLeft(){
        if(col > 0){
            col--;
        }
    }

    void moveRight(){
        if(col < 20){
            col++;
        }
    }

    int get_row(){
        return row;
    }

    int get_col(){
        return col;
    }

    char get_symbol(){
        return symbol;
    }

    void set_symbol(char c){
        symbol = c;
    }

    boolean adjacentTo(GamePiece a){
        if((Math.abs(row - a.row) == 1) && (Math.abs(col - a.col) == 0)){
            return true;
        }
        if((Math.abs(row - a.row) == 0) && (Math.abs(col - a.col) == 1)){
            return true;
        }
        return false;
    }
}
