public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int x2, int y1, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double round(double x){
        return Math.round(x*100)/100.0;
    }
    public double slope (){
        return round((double)(y2-y1)/(x2-x1));
    }

    public double yIntercept(){
        return round((double)y1-(slope()*x1));
    }

    public double distance(){
        return round(Math.sqrt(Math.pow((double)x2-x1,2) + Math.pow((double)y2-y1,2)));
    }

    public String equation(){
        String m = "";
        String b;
        int xDiff = x2-x1;
        int yDiff = y2-y1;
        if (slope() == 1) {
            m = "";
        } else if (slope() == -1) {
            m = "-";
        } else{
            if (slope() % 1 == 0) {
                m = Double.toString(slope());
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
                    b = "-" + Double.toString(yIntercept());
                }else {
                    b = "- " + Double.toString(yIntercept());
                }
            }
            else {
                if (slope() == 0){
                    b = Double.toString(yIntercept());
                } else {
                    b = "+ " + Double.toString(yIntercept());
                }
            }
        }
        if (slope() == 0){
            return "y = " + b;
        }else{
            return "y = " + m + "x " + b;
        }
    }

    public String coordinateForX(double xValue){
        return "(" + xValue + ", " + ((slope()*xValue)+yIntercept()) + ")";
    }

    public void lineInfo(){
        System.out.println("The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")" );
        System.out.println("The equation of the line between these points is: " + equation());
        System.out.println("The slope of this line is: " + slope());
        System.out.println("The y-intercept of the line is: " + yIntercept());
        System.out.println("The distance between the two points is: " + distance());
    }
}

