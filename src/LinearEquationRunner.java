import java.util.Scanner;

public class LinearEquationRunner {

    public static void main(String[] args){
        //Welcomes the user to the program
        System.out.println("Welcome!");
        Scanner scan = new Scanner(System.in);

        //Asks user to enter both coordinates
        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();

        //Converts inputted x and y values into integers
        int x1 = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",")+2,coord1.length()-1));

        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        int x2 = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",")+2,coord2.length()-1));

        //Checks if both x values are the same;if they are the program will end stating that both coordinates are on a vertical line.
        //If both x values are not the same, the program will create an object successfully
        if (x1 == x2){
            System.out.println();
            System.out.println("These points are on a vertical line: x = " + x1);
            System.exit(0);
        }

        //Object created
        LinearEquation linearEquation = new LinearEquation(x1,y1,x2,y2);
        System.out.println();
        System.out.println(linearEquation.lineInfo());

        System.out.println();
        System.out.print("Enter a value for x: ");
        //Calculates the point on the line using the user's inputted x value
        String coord3 = linearEquation.coordinateForX(scan.nextDouble());
        System.out.println();
        System.out.println("The point on the line is " + coord3);
    }
}
