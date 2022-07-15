import java.util.*;  

public class Project2 extends DragonMaze{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // System.in is a standard input stream
        System.out.print("Enter the colation of maze.txt file (like: C:\\Users\\Desktop\\test.txt): ");
        String location = sc.nextLine();
        
        System.out.println("location= " + location);
        DragonMaze match = new DragonMaze();
        match.loadMazeFile(location);

        boolean finish = false;
        while(finish == false){
            match.printMaze();
            System.out.println("Hero: " + match.hero.row + " " + match.hero.col);
            System.out.println("Dragon: " + match.dragon.row + " " + match.dragon.col);
            System.out.println("Make your move!");
            System.out.println("Valid moves are w, a, s, d, f (to wait)");

            char c = sc.next().charAt(0);
            // Switch statement with int data type
            switch (c) {

                // Case
                case 'w':
                    match.moveHero('w');
                    break;

                // Case
                case 'a':
                    match.moveHero('a');
                    break;

                // Case
                case 's':
                    match.moveHero('s');
                    break;

                // Case
                case 'd':
                    match.moveHero('d');
                    break;

                // Case
                case 'f':
                    match.moveHero('f');
                    break;

            }

            match.moveDragon();

            if(match.hero.adjacentTo(match.dragon)){
                System.out.println("EPIC FAIL! You are incinerated into a pile of ash by dragon fire.");
                finish = true;
            }
            if(match.hero.adjacentTo(match.princess)){
                System.out.println("You found your love.");
            }
            if((match.hero.row == 9) && (match.hero.col == 20)){
                System.out.println("EPIC WIN! You are a LEGEND!");
                finish = true;
            }
        }
        sc.close();
    }
}
