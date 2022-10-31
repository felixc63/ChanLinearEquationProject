public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

/* Creates a LinearEquation object */
    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    /* "Helper" method for use elsewhere in your methods; returns the value toRound rounded
    to the nearest hundredth*/
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
            m = ""; //if slope is 1, only x will be outputted
        } else if (slope() == -1) {
            m = "-"; //if slope is -1, only -x will be outputted
        } else{
            if (slope() % 1 == 0) { //checks if the slope is a whole number/integer
                m = Integer.toString((int)slope()); //converts the slope into a string
            } else {
                if ((xDiff > 0 && yDiff > 0) || (xDiff < 0 && yDiff < 0)) { //checks if both differences are both positive or negative;if so, then the slope will be positive
                    m = Math.abs(yDiff) + "/" + Math.abs(xDiff); //takes the absolute value of both differences to avoid negatives on both numbers Ex: -1/-2
                } else if ((xDiff > 0 && yDiff < 0) || (xDiff < 0 && yDiff > 0)) { //checks if one of the differences are negative and if one is positive;if so, then the slope will be negative
                    m = "-" + Math.abs(yDiff) + "/" + Math.abs(xDiff);
                }
            }
        }

        //The use of .toString is used to convert integers/doubles into strings
        if (yIntercept() == 0){
            b = ""; //Sets y-intercept as an empty string if y-intercept is 0
        }
        else{
            if (yIntercept() < 0){ //checks if y-intercept is negative
                if (slope() == 0){ //checks if slope exists
                    //when slope does not exist there will be no space in between the y-intercept and the sign
                    if (yIntercept()%1 == 0){ //if slope exists, then it will check whether the y-intercept is an integer
                        b = "-" + Integer.toString(Math.abs((int)yIntercept()));
                    }else {
                        b = "-" + Double.toString(Math.abs(yIntercept()));
                    }
                }else {
                    //when slope exists there will be a space in between the y-intercept and the sign
                    if (yIntercept()%1 == 0){
                        b = "- " + Integer.toString(Math.abs((int)yIntercept()));
                    }else {
                        b = "- " + Double.toString(Math.abs(yIntercept()));
                    }
                }
            }
            else {
                if (slope() == 0){
                    if (yIntercept()%1 == 0){ //if slope does not exist there will be no sign, symbolizing that the y-intercept is positive
                        b = Integer.toString((int)yIntercept());
                    }else {
                        b = Double.toString(yIntercept());
                    }
                } else {
                    if (yIntercept()%1 == 0){ //if slope does exist there will be a positive sign in front of the y-intercept
                        b = "+ " + Integer.toString((int)yIntercept());
                    }else {
                        b = "+ " + Double.toString(yIntercept());
                    }
                }
            }
        }

        if (slope() == 0){ //returns the correct format based on whether if slope exists or not
            return "y = " + b;
        }else{
            return "y = " + m + "x " + b;
        }
    }

    /* Returns a String of the coordinate point on the line that has the given x value, with
   both x and y coordinates as decimals to the nearest hundredth, e.g (-5.0, 6.75) */
    public String coordinateForX(double xValue){
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(((slope()*xValue)+yIntercept())) + ")";
    }

    /* Returns a string that includes all information about the linear equation, each on
   separate lines. Concats string variable and returns it.
  */
    public String lineInfo(){
        String str = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n";
        str += ("The equation of the line between these points is: " + equation() + "\n");
        str += ("The slope of this line is: " + slope() + "\n");
        str += ("The y-intercept of the line is: " + yIntercept() + "\n");
        str += ("The distance between the two points is: " + distance());
        return str;
    }
}

