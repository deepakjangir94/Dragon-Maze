import java.io.*;
import java.util.Random;

public class DragonMaze {
    GamePiece hero;
    GamePiece dragon;
    GamePiece princess;
    int n, m;

    //random number generator function

    //2D array represent gameboard
    static char gameBoard[][] = new char[11][21];
    static char gameBoard_copy[][] = new char[11][21];

    void loadMazeFile(String location){
        try {
            File file = new File(location);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            int i = 0;
            while ((st = br.readLine()) != null) {
                // System.out.println(st);
                int j = 0;
                int len = st.length();
                while(j < len){
                    // System.out.print(st.charAt(j));
                    gameBoard[i][j] = st.charAt(j);
                    gameBoard_copy[i][j] = st.charAt(j);
                    if(gameBoard[i][j] == 'h'){
                        hero = new GamePiece(i, j, 'h');
                        gameBoard_copy[i][j] = ' ';
                        //System.out.print(hero.col);
                    }
                    else if(gameBoard[i][j] == 'D'){
                        dragon = new GamePiece(i, j, 'D');
                        gameBoard_copy[i][j] = ' ';
                    }
                    else if(gameBoard[i][j] == 'P'){
                        princess = new GamePiece(i, j, 'P');
                        gameBoard_copy[i][j] = ' ';
                    }
                    j++;
                }
                // System.out.print('\n');
                i++;
            }
            br.close();
            
        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }

    void printMaze(){
        int n = gameBoard.length;
        int m = gameBoard[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(gameBoard[i][j]);
            }
            System.out.print('\n');
        }
    }

    void moveHero(char c){
        char dir;
        switch (c) {

            // Case
            case 'w':
                dir = getCharAt(hero.row - 1, hero.col);
                if (dir == ' ') {
                    hero.moveUp();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row + 1, hero.col, ' ');
                }
                else if(dir == 'P'){
                    hero.moveUp();
                    hero.symbol = 'H';
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row + 1, hero.col, ' ');
                }
                else if(dir == 'F'){
                    hero.moveUp();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row + 1, hero.col, ' ');
                }
                else{
                    System.out.println("cannot move in this direction");
                }
                break;

            // Case
            case 'a':
                dir = getCharAt(hero.row, hero.col - 1);
                if (dir == ' ') {
                    hero.moveLeft();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col + 1, ' ');
                }
                else if(dir == 'P'){
                    hero.moveLeft();
                    hero.symbol = 'H';
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col + 1, ' ');
                }
                else if(dir == 'F'){
                    hero.moveLeft();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col + 1, ' ');
                }
                else {
                    System.out.println("cannot move in this direction");
                }
                break;

            // Case
            case 's':
                dir = getCharAt(hero.row + 1, hero.col);
                if (dir == ' ') {
                    hero.moveDown();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row - 1, hero.col, ' ');
                } else if (dir == 'P') {
                    hero.moveDown();
                    hero.symbol = 'H';
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row - 1, hero.col, ' ');
                } else if (dir == 'F') {
                    hero.moveDown();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row - 1, hero.col, ' ');
                }
                else {
                    System.out.println("cannot move in this direction");
                }
                break;

            // Case
            case 'd':
                dir = getCharAt(hero.row, hero.col + 1);
                if (dir == ' ') {
                    hero.moveRight();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col - 1, ' ');
                } else if (dir == 'P') {
                    hero.moveRight();
                    hero.symbol = 'H';
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col - 1, ' ');
                } else if (dir == 'F') {
                    hero.moveRight();
                    setCharAt(hero.row, hero.col, hero.symbol);
                    setCharAt(hero.row, hero.col - 1, ' ');
                }
                else {
                    System.out.println("cannot move in this direction");
                }
                break;
            
            // Case
            case 'f':
                System.out.println("cannot move in this direction");
                break;

            // Case
            default:
                System.out.print("choose the valid option ");
        }
    }

    void moveDragon(){
        Random random = new Random();
        int x = random.nextInt(4);
        char dir;
        switch (x) {

            // Case
            case 0:
                dir = getCharAt(dragon.row - 1, dragon.col);
                if(dir != '\0'){
                    dragon.moveUp();
                    setCharAt(dragon.row, dragon.col, dragon.symbol);
                    setCharAt(dragon.row + 1, dragon.col, gameBoard_copy[dragon.row + 1][dragon.col]);
                }
                break;

            // Case
            case 1:
                dir = getCharAt(dragon.row, dragon.col - 1);
                if(dir != '\0'){
                    dragon.moveLeft();
                    setCharAt(dragon.row, dragon.col, dragon.symbol);
                    setCharAt(dragon.row, dragon.col + 1, gameBoard_copy[dragon.row][dragon.col + 1]);
                }
                break;

            // Case
            case 2:
                dir = getCharAt(dragon.row + 1, dragon.col);
                if(dir != '\0'){
                    dragon.moveDown();
                    setCharAt(dragon.row, dragon.col, dragon.symbol);
                    setCharAt(dragon.row - 1, dragon.col, gameBoard_copy[dragon.row - 1][dragon.col]);
                }
                break;

            // Case
            case 3:
                dir = getCharAt(dragon.row, dragon.col + 1);
                if(dir != '\0'){
                    dragon.moveRight();
                    setCharAt(dragon.row, dragon.col, dragon.symbol);
                    setCharAt(dragon.row, dragon.col - 1, gameBoard_copy[dragon.row][dragon.col - 1]);
                }
                break;
        }

    }

    char getCharAt(int i, int j){
        if((0 <= i && i <= 10) && (0 <= j && j <= 20)){
            return gameBoard[i][j];
        }
        else{
            return '\0';
        }
    }

    void setCharAt(int i, int j, char c){
        if ((0 <= i && i <= 10) && (0 <= j && j <= 20)) {
            gameBoard[i][j] = c;
        }
    }
}
