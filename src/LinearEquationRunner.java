import java.util.Scanner;

public class LinearEquationRunner {

private static int x1;
private static int x2;
private static int y1;
private static int y2;


    public static void main(String[] args){
        System.out.println("Welcome!");
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter coordinate 1: ");
        String coord1 = scan.nextLine();

        int x1 = Integer.parseInt(coord1.substring(1,coord1.indexOf(",")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(",")+2,coord1.length()-1));

        System.out.print("Enter coordinate 2: ");
        String coord2 = scan.nextLine();

        int x2 = Integer.parseInt(coord2.substring(1,coord2.indexOf(",")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(",")+2,coord2.length()-1));
        /*String firstHalfCoord1 = coord1.substring(0,4);
        if (firstHalfCoord1.contains("-")){
            x1 = Integer.parseInt(firstHalfCoord1.substring(1,3));
            y1 = Integer.parseInt(coord1.substring(5,coord1.length()-1));
        }
        else{
            x1 = Integer.parseInt(firstHalfCoord1.substring(1,2));
            y1 = Integer.parseInt(coord1.substring(4,coord1.length()-1));
        }


        String firstHalfCoord2 = coord2.substring(0,4);
        if (firstHalfCoord2.contains("-")){
            x2 = Integer.parseInt(firstHalfCoord2.substring(1,3));
            y2 = Integer.parseInt(coord2.substring(5,coord2.length()-1));
        }
        else{
            x2 = Integer.parseInt(firstHalfCoord2.substring(1,2));
            y2 = Integer.parseInt(coord2.substring(4,coord2.length()-1));
        }*/

        LinearEquation linearEquation = new LinearEquation(x1,x2,y1,y2);

        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);
    }
}
