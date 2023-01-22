package ProgrammingExam1;
import java.awt.Color;
import java.util.ArrayList; 

/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Hatim Eqbal Hussien Tayabally
Student Number: 217888199
Course Section: M
*/

public class PE1 {
	public static void main(String[] args) {
		
		/* A canvas should be created for drawing.
		 * All the shapes should be drawn on the canvas.
		 * The bottom left coordinate of the canvas is (0,0)
		 * The top right coordinates of the canvas is (1, 1) 
		 * The input parameter to Draw() constructor is the 
		 * title of the canvas.
		 */
        //Draw blankCanvas = new Draw("Programmign Exam 1");
        
       //System.out.println(nestedCircle (0.5, 0.5, 0.4, 0.05, blankCanvas, " "));
     // System.out.println(squares(0.5, 0.5, 0.2, 2, blankCanvas));
        //Point p1 = new Point(0.1, 0.1);
       // Point p2 = new Point(0.9, 0.1);
       // Point p3 = new Point(0.5, 0.9);
       // ArrayList<String> points = new ArrayList<String>();
        //points = PE1.drillPoints(p1, p2, p3, 1, blankCanvas, points);
        //System.out.println(drillPoints( p1,  p2,  p3,  5,  blankCanvas,  points));
        
        
        /* To draw a point, point function is called with proper parameters: 
         * point(x_coordinate_of_point, y_coordinate_of_point)
         */
       // blankCanvas.point(0.7, 0.7);
        
        /* To draw a circle, circle function is called with proper parameters: 
         * circle(x_coordinate_of_center, y_coordinate_of_center, radius)
         */
        //blankCanvas.circle(0.5, 0.5, 0.5);

        /* To draw a square, square function is called with proper parameters: 
         * square(x_coordinate_of_center, y_coordinate_center, sides_half_length)
        */
        //blankCanvas.square(0.5,  0.5, 0.4);
        
        /*
         * To change the color of the pen, setPenColor is used with three numbers that are in [0, 255] range.
         * All the colors can be made as a combination of red, green and blue. 
         * The parameters show the richness of red, green and blue of a color. 
         * For example setPenColor(new Color(0, 0, 0) sets the color of the pen
         * to black and setPenColor(new Color(255, 255, 255) sets the color to 
         * white.
         */
        // blankCanvas.setPenColor(new Color(150, 150, 150));
         
         /* To draw a line, line function is called 
          * with proper parameters: 
          * line(x_coordinate_of_center, y_coordinate_center, sides_half_length)
         */
         //blankCanvas.line(0.0, 0.5, 1, 0.5);
        
         
 
	}

	
	/**
	 * This method draws a number of circles that share the same center, as long as the radius is positive.
	 * @param x is the x-coordinate of the circles
	 * @param y is the y-coordinate of the circles. 
	 * @param radius is the radius of a circle. 
	 * 		The function is called with the radius that is cut to two decimal points. 
	 * 		For example 0.39876543210 must be cut to 0.39
	 * @param diff is the difference between the radius of a circle and its immediate inner circle.
	 * @param page is the canvas on which the circles are drawn.
	 * @param radiusList is an accumulated list of the radius of the circles that were drawn. 
	 * @return a list of all the circles' radius that were drawn. 
	 */
	public static String nestedCircle (double x, double y, double radius, double diff,  Draw page, String radiusList) {
		
		
		radius=Math.round(radius*100.0)/100.0;
		
//using if statement to withold input parameter		
//using in substring to eliminate extra comma at end
//using .length to get last index in substring
		
		if(radius < 0) 
		{
		int l = radiusList.length();
		int z = l-2;
		String subList = radiusList.substring(0,z);
		return "[" + subList + "]";
		}
		else 
		{ 
				
//calling integrated circle function on our canvas to draw initial circle
				
		page.circle(x, y, radius);
			
//storing value of radiuses (radii)

		radiusList += String.valueOf(radius) + "," + " "; 
		radius -= diff;
			
//calling the function again for recursion	
			
		return nestedCircle(x, y, radius, diff, page, radiusList);
		}
		
		}
	/**
	 * This method recursively draws 4 squares, whose center falls on a corner of 
	 * previously drawn square. The side of the square is half as much as the side of the 
	 * square that is drawn in previous round. 
	 * @param x is the x-coordinate of the square
	 * @param y is the y-coordinate of the square
	 * @param halfLength is half the size of the square's side
	 * @param order is the number of the rounds by which a set of squares is drawn
	 * @param page is the canvas on which the squares are drawn.
	 * @return a list of the center of smallest squares that are drawn.. 
	 * 		The coordinates should be cut to one decimal point. For example:
	 * 		 0.39876543210 is cut to 0.3 
	 */
	public static String squares (double x, double y, double halfLength, int order, Draw page) {
		
//cutting to one decimal place for coordinates
		
		x=Math.round(x*10.0)/10.0;
		y=Math.round(y*10.0)/10.0;
	
//base case
//returning values of latest rescursion ie smallest square
		
		if (order==0) 
		{
			
		return "[" + (x-halfLength)+ ", " + (y-halfLength)+ "]" + "[" + (x+halfLength)+ ", " + (y-halfLength)+ "] " + "[" + (x+halfLength)+ ", " + (y+halfLength)+ "]" + "[" + (x-halfLength)+ ", " + (y+halfLength)  +"]";
		}
		
// calling square function to our canvas (initial square)
		page.square(x, y, halfLength);
		
//recursive algorithm for drawing square at each corner of initial
		
		squares(x-halfLength, y-halfLength, halfLength/2, order-1,page);
		squares(x+halfLength, y-halfLength, halfLength/2, order-1,page);
		squares(x+halfLength, y+halfLength, halfLength/2, order-1,page);
		squares(x-halfLength, y+halfLength, halfLength/2, order-1,page);
		
		return 	squares ( x,  y,  halfLength,  order-1,  page);
		
		
		
	}
	/**
	 * This method specifies which coordinates should be drilled. It also draw the 
	 * horizontal line of each triangle. No duplicate point should be added to the output. 
	 * @param p1 is one of the vertex of the triangle
	 * @param p2 is the second vertex of the triangle
	 * @param p3 is the third vertex of the triangle
	 * @param order is the number of times a nested triangle should be drawn. 
	 * 			<code> order >= 0 </code>, however if it is zero, nothing should be drawn
	 * @param page is the canvas on which this method draws.
	 * @param array is the list of the points that should be drilled. To add to this list point.toString() must be added.
	 * @return an array that contains all the points that should be drilled. this method should not have any duplicate points in it. 
	 */
	public static ArrayList<String> drillPoints(Point p1, Point p2, Point p3, int order, Draw page, ArrayList<String> array) {
		
		
//if order is zero, no output
		
		if(order == 0) 
		{
		return new ArrayList<String>();
		}
		
//base case
		
		if(order == 1) 
		{
			
//using !contains to eliminate duplicates
//using array.add to add value of point into list
			
		if(!array.contains(p1.toString()))	
		array.add(p1.toString());
		if(!array.contains(p2.toString()))
		array.add(p2.toString());
		if(!array.contains(p3.toString()))
		array.add(p3.toString());
		
//calling integrated point and line function to our canvas
		
		page.line(p1.x, p1.y, p2.x, p2.y);
		page.point(p3.x, p3.y);
		
//outputting stored points in array
		
		return array;
		}
		
//calculating middle point of 2 points, needed for recursive algorithm	
		
		Point p5 = Point.midpoint(p1, p2);
		Point p6 = Point.midpoint(p2, p3);
		Point p7 = Point.midpoint(p3, p1);

//using !contains to eliminate duplicates
//using array.add to add value of point into list
		
		if(!array.contains(p5.toString()))
		array.add(p5.toString());
		if(!array.contains(p6.toString()))
		array.add(p6.toString());
		if(!array.contains(p7.toString()))
		array.add(p7.toString());
		
//recursive algorithm to draw triangle
		
		drillPoints( p1,  p5,  p7,  order-1,  page,  array);
		drillPoints( p5,  p2,  p6,  order-1,  page,  array);
		drillPoints( p7,  p6,  p3,  order-1,  page,  array);
		
		
		return drillPoints( p1,  p2,  p3,  order-1,  page,  array);
	}

}
/**
 * This class creates a point. 
 *
 */
class Point {
	double x; 
	double y; 
	/**
	 * This is the constructor that builds a point
	 * @param x is the x-coordinate of the point
	 * @param y is the y-coordinate of the point
	 */
	public Point(double x, double y) {
		// your code goes here. Task 0
		this.x=x;
		this.y=y;
	}
	/**
	 * This method returns the mid point of a line, 
	 * whose two ends are given.
	 * @param p1 is one end of the line
	 * @param p2 is the other end of the line
	 * @return the mid point of the line. Both the 
	 * coordinates are cut to two decimal points. 
	 * e.g. 0.37654 is cut to 0.37
	 */
	public static Point midpoint(Point p1, Point p2) {
		// your code goes here. Task 0
		double px= (p1.x + p2.x)/2;
		double py= (p1.y + p2.y)/2;
		double pxr= (double) Math.round(px*100)/100;
		double pyr= (double) Math.round(py*100)/100;
		return new Point(pxr, pyr);
	}
	@Override
	/**
	 * This method returns the coordinate of this object as a string.
	 */
	public String toString() {
		return "["+this.x + ", "+ this.y +"]";
	}
	
}
