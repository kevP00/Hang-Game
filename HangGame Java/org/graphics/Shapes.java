package org.graphics;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;


/*						_______________
 * 					>>  METHODS DETAILS  <<
 *						_______________
 *
 *	  _________
 * 1. RECTANGLE:
 * 		
 * 		"Two types of Rectangles in the shapes class :  Filled and Unfilled rectangle"
 * 
 * 		    ________________
 *  	>>  FILLED RECTANGLE:      rectangle(GL2 gl,float x1,float y1,float x2,float y2, int r, int g, int b)
 *  		__________________
 *  	>>  UNFILLED RECTANGLE:    rectangle(GL2 gl,float x1,float y1,float x2,float y2)  
 *  		
 *  		gl : GL2 graphics Library object
 *  		x1 : Initial point x-axis value
 *    		y1 : Initial point y-axis value
 *      	x2 : Final point x-axis value
 *        	y2 : Final point y-axis value
 *          
 *          r : red color value
 *          g : green color value
 *          b : blue color value
 *          
 *          
 *          ______________ (x2,y2)
 *          |				|
 *          |				|
 * 			|				|
 *          |				|
 *          |				|
 * 	   (x1,y1)______________|
 * 
 *  
 *     ________
 *  2. TRIANGLE:
 * 		
 * 		"Two types of triangles in the shapes class :  Filled and Unfilled triangle"
 * 
 * 		    ________________
 *  	>>  FILLED TRIANGLE:      triangle(GL2 gl,float x1,float y1,float x2,float y2,float x3,float y3, int r, int g, int b)
 *  		__________________
 *  	>>  UNFILLED TRIANGLE:    triangle(GL2 gl,float x1,float y1,float x2,float y2,float x3,float y3) 
 *  		
 *  		gl : GL2 graphics Library object
 *  		x1 : Base Initial point x-axis value
 *    		y1 : Base Initial point y-axis value
 *      	x2 : Base Final point x-axis value
 *        	y2 : Base Final point y-axis value
 *          x3 : Perp. point x-axis value
 *        	y3 : Perp. point y-axis value
 *          
 *          r : red color value
 *          g : green color value
 *          b : blue color value
 *
 *						
 *								 /\ (x3,y3)
 *							    /  \
 *							   /    \
 *							  /      \
 *							 /        \
 *					(x1,y1) /__________\ (x2,y2)
 *
 *  
 *  
 *  3. CIRCLE:
 * 
 * 		    _____________
 *  	>>  FILLED CIRCLE:      circle(GL2 gl, float sx, float sy, float radius,int r,int g,int b)
 *  		
 *  		gl : GL2 graphics Library object
 *  		sx : Initial point x-axis value
 *    		sy : Initial point y-axis value
 *    		radius : raduis of the circle
 *          
 *          r : red color value
 *          g : green color value
 *          b : blue color value
 *
 *								   |<-- radius-->|       |<-- radius-->|
 *								  (_______________(sx,sy)_______________)
 *
 *  
 *  4. LINE:
 * 
 * 		    ____
 *  	>>  LINE:      line(GL2 gl,float x1,float y1,float x2,float y2, int r, int g, int b)
 *  		
 *  		gl : GL2 graphics Library object
 *  		x1 : Initial point x-axis value
 *    		y1 : Initial point y-axis value
 *  		x2 : Final point x-axis value
 *    		y2 : Final point y-axis value
 *          
 *          r : red color value
 *          g : green color value
 *          b : blue color value
 *
 *
 *								 (x1,y1)_________________________________(x2,y2)
 *
 *
 *  
 *  
 *  5. STRING:
 * 
 * 		    ______
 *  	>>  STRING:      string(GL2 gl,float x, float y,String text, int r,int g,int b)
 *  		
 *  		gl : GL2 graphics Library object
 *  		x : Initial point x-axis value
 *    		y : Initial point y-axis value
 *    		text : String value that you want to print
 *          
 *          r : red color value
 *          g : green color value
 *          b : blue color value
 *          
 *          
 *
 *
 *
 *				______________
 *				COLORS DETAILS
 *				______________
 *
 *
 *
 *		(r,g,b) = (0,0,0) = Black
 *		(r,g,b) = (1,0,0) = Red
 *		(r,g,b) = (0,1,0) = Green
 *		(r,g,b) = (0,0,1) = Blue
 *		(r,g,b) = (1,1,1) = White
 *		(r,g,b) = (1,1,0) = Yellow
 *		(r,g,b) = (1,0,1) = Magenta
 *		(r,g,b) = (0,1,1) = Cyan
 *
 *
 */



public class Shapes {
	
	
	public void rectangle(GL2 gl,float x1,float y1,float x2,float y2, int r, int g, int b) {
		
		gl.glColor3f(r, g, b);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2f(x1/100, y1/100);
		gl.glVertex2f(x2/100, y1/100);
		gl.glVertex2f(x2/100, y2/100);
		gl.glVertex2f(x1/100, y2/100);
		gl.glEnd();
		
	}
	
	public void line(GL2 gl,float x1,float y1,float x2,float y2, int r, int g, int b) {
		
		gl.glColor3f(r, g, b);
		gl.glBegin(GL2.GL_LINES);
		gl.glVertex2f(x1/100, y1/100);
		gl.glVertex2f(x2/100, y2/100);
		gl.glEnd();
		
	}
	
	public void triangle(GL2 gl,float x1,float y1,float x2,float y2,float x3,float y3, int r, int g, int b) {
		
		  gl.glColor3f(r, g, b);
		  gl.glBegin(GL2.GL_TRIANGLES);
		  gl.glVertex2f(x1/100, y1/100);
		  gl.glVertex2f(x3/100, y3/100);
		  gl.glVertex2f(x2/100, y2/100);
		  gl.glEnd(); 
		
	}
	
	public void circle(GL2 gl, float sx, float sy, float radius,int r,int g,int b) {
		
		
		gl.glColor3f(r, g, b);
		sx/=100;
		sy/=100;
		radius/=100;
		int nvertices = 722;
		double vertices[][]=new double[nvertices][2];
		
		double hdegree = Math.PI / 360.0;
		float angle = 0;
		for (int i = 0; i < nvertices; ++i) 
		{
			vertices[i][0] = radius * Math.cos(angle);
			vertices[i][1] = radius * Math.sin(angle);
			angle += hdegree;
		}
		
		gl.glBegin(GL.GL_TRIANGLE_FAN);
		gl.glVertex4f(sx, sy, 0, 1);
		
		for (int i = 0; i < nvertices; ++i)
			gl.glVertex4f(sx + new Float(vertices[i][0]), sy + new Float(vertices[i][1]), 0, 1);
		gl.glEnd();
	}
	
	public void rectangle(GL2 gl,float x1,float y1,float x2,float y2) {
		
		  gl.glColor3f(1, 1, 1);
		  gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x1/100, y1/100, 0);
	      gl.glVertex3f(x1/100, y2/100, 0);
	      gl.glEnd();
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x1/100, y2/100, 0);
	      gl.glVertex3f(x2/100, y2/100, 0);
	      gl.glEnd();
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x2/100, y2/100, 0);
	      gl.glVertex3f(x2/100, y1/100, 0);
	      gl.glEnd();
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x2/100, y1/100, 0);
	      gl.glVertex3f(x1/100, y1/100, 0);
	      gl.glEnd();
	      gl.glFlush();
		
	}
	
	public void triangle(GL2 gl,float x1,float y1,float x2,float y2,float x3,float y3) {
		
		  gl.glColor3f(1, 1, 1);
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x1/100, y1/100, 0);
	      gl.glVertex3f(x3/100, y3/100, 0);
	      gl.glEnd();
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x3/100, y3/100, 0);
	      gl.glVertex3f(x2/100, y2/100, 0);
	      gl.glEnd();
	      gl.glBegin (GL2.GL_LINES);
	      gl.glVertex3f(x2/100, y2/100, 0);
	      gl.glVertex3f(x1/100, y1/100, 0);
	      gl.glEnd();
	      gl.glFlush();
		
	}

	
	GLUT glut = new GLUT();
	void string(GL2 gl,float x, float y,String text, int r,int g,int b) {
	   
		gl.glColor3f(r, g, b);
		gl.glRasterPos2f((x/100), (y/100));
        glut.glutBitmapString(5, text);

	}
	
	void bold(GL2 gl,float x, float y,String text, int r,int g,int b) {
		   
		gl.glColor3f(r, g, b);
		gl.glRasterPos2f((x/100), (y/100));
        glut.glutBitmapString(8, text);

	}
 
	
}