public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

/* Creates a LinearEquation object */
/* PRECONDITION: x1 and x2 are NOT equal (client programs are responsible for ensuring
   this precondition is not violated)*/
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
    to the nearest hundredth

    HINT:  the Math.round method can help with this!*/
    public double roundedToHundredth(double toRound){
        return Math.round(toRound*100)/100.0;
    }

    /* Calculates and returns the slope of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double slope (){
        return roundedToHundredth((double)(y2-y1)/(x2-x1));
    }

/* Calculates and returns the y-intercept of the line between (x1, y1) and
   (x2, y2), rounded to the nearest hundredth */
    public double yIntercept(){
        return roundedToHundredth((double)y1-(slope()*x1));
    }

/* Calculates and returns distance between (x1, y1) and (x2, y2), rounded to
   the nearest hundredth */
    public double distance(){
        return roundedToHundredth(Math.sqrt(Math.pow((double)x2-x1,2) + Math.pow((double)y2-y1,2)));
    }

    /* Returns a String that represents the linear equation of the line through points
   (x1, y1) and (x2, y2) in slope-intercept (y = mx + b) form, e.g. "y = 3x + 1.5".*/
    public String equation(){
        String m = ""; // Variable m represents slope
        String b; // Variable b represents y-intercept
        int xDiff = x2-x1;
        int yDiff = y2-y1;

        if (slope() == 1) {
            m = "";
        } else if (slope() == -1) {
            m = "-";
        } else{
            if (slope() % 1 == 0) {
                m = Integer.toString((int)slope());
            } else {
                if ((xDiff > 0 && yDiff > 0) || (xDiff < 0 && yDiff < 0)) {
                    m = Math.abs(yDiff) + "/" + Math.abs(xDiff);
                } else if ((xDiff > 0 && yDiff < 0) || (xDiff < 0 && yDiff > 0)) {
                    m = "-" + Math.abs(yDiff) + "/" + Math.abs(xDiff);
                }
            }
        }

        if (yIntercept() == 0){
            b = "";
        }
        else{
            if (yIntercept() < 0){
                if (slope() == 0){
                    if (yIntercept()%1 == 0){
                        b = "-" + Integer.toString(Math.abs((int)yIntercept()));
                    }else {
                        b = "-" + Double.toString(Math.abs(yIntercept()));
                    }
                }else {
                    if (yIntercept()%1 == 0){
                        b = "- " + Integer.toString(Math.abs((int)yIntercept()));
                    }else {
                        b = "- " + Double.toString(Math.abs(yIntercept()));
                    }
                }
            }
            else {
                if (slope() == 0){
                    if (yIntercept()%1 == 0){
                        b = Integer.toString((int)yIntercept());
                    }else {
                        b = Double.toString(yIntercept());
                    }
                } else {
                    if (yIntercept()%1 == 0){
                        b = "+ " + Integer.toString((int)yIntercept());
                    }else {
                        b = "+ " + Double.toString(yIntercept());
                    }
                }
            }
        }

        if (slope() == 0){
            return "y = " + b;
        }else{
            return "y = " + m + "x " + b;
        }
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
   both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){ return "(" + xValue + ", " + roundedToHundredth(((slope()*xValue)+yIntercept())) + ")"; }

    /* Returns a string that includes all information about the linear equation, each on
   separate lines:
     - The original points: (x1, y1) and (x2, y2)
     - The equation of the line in y = mx + b format (using equation() method)
     - The slope of the line, as a decimal (using slope() method)
     - The y-intercept of the line (using yIntercept() method)
     - The distance between the two points (using distance() method)

  This method should call all other appropriate methods to get the info it needs:
  equation(), slope(), yIntercept(), distance().

  */
    public void lineInfo(){
        System.out.println("The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" );
        System.out.println("The equation of the line between these points is: " + equation());
        System.out.println("The slope of this line is: " + slope());
        System.out.println("The y-intercept of the line is: " + yIntercept());
        System.out.println("The distance between the two points is: " + distance());
    }
}

