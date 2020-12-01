package org.graphics;

import java.io.*;
import java.util.Scanner;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/*
 *					__________________________________________________________________________________________
 *  		        |    HANGMAN GAME														   	   _  |=|  X |
 * 		            |________________________________________________________________________________________|
 * 					||																						||
 * 					||											x = +100									||
 * 					||										    | 									        ||
 *  				||											| 									        ||
 *   				||											| 									        ||
 *    				||											| 									        ||
 *     				||											| 									        ||
 *      			||											| 									        ||
 *        			||											| 									        ||
 *         			||											| 									        ||
 *          		||										    | 									        ||
 *           		||											| 									        ||
 *            		||											| 									        ||
 * 			        || y = -100_________________________________|_________________________________ y = +100 ||
 *  				||											|(0,0) 									    ||
 *   				||											| 									        ||
 *    				||											| 									        ||
 *     				||											| 									        ||
 *      			||											| 									        ||
 *       			||											| 									        ||
 *        			||											| 									        ||
 *         			||											| 									        ||
 *          		||										    | 									        ||
 *           		||											| 									        ||
 *            		||											| 									        ||
 * 					||											x = -100 									||
 *					||______________________________________________________________________________________||
 *                  |________________________________________________________________________________________|
 *                  
 *                  
 *                  
 *                  
 * */


public class EventListener implements GLEventListener, KeyListener {

	Shapes shape=new Shapes();
	Work w=new Work();
	Render R=new Render();
	public static int attempts = 7;
	//public static int main = 0;
	public static int mEntity = 0;
	
	
	int x1=-60;
	
	
	public void display(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
//		shape.triangle(gl, -90, -90, -70, -70, -50, -90);
//		shape.triangle(gl, -40, -90, -20, -70, 0, -90, 1, 1, 0);
//		shape.rectangle(gl, -90,-65 , -50, -30);
//		shape.rectangle(gl, -40,0 , 0, -30, 0, 1, 1);
//		shape.circle(gl, 0, 0, 25, 1, 0, 1);
//		shape.line(gl, -30, 30, 30, 40, 0, 1, 0);
//		shape.string(gl,20, 70, "Hangman Game", 1, 1, 1);

		//work here for graphics//

		//BOX
		shape.rectangle(gl, -98,98 , 98, 95, 1, 1, 1);//Top
		shape.rectangle(gl, -98,-98 , -95, 95, 1, 1, 1);//Left
		shape.rectangle(gl, -98,-98 , 98, -95, 1, 1, 1);//Bottom
		shape.rectangle(gl, 98,-98 , 95, 95, 1, 1, 1);//Right
		
		shape.rectangle(gl, -93,93 , 93, 89, 1, 0, 0);
		shape.rectangle(gl, -93,-93 , -89, 89, 1, 0, 0);
		shape.rectangle(gl, -93,-93 , 93, -89, 1, 0, 0);
		shape.rectangle(gl, 93,-93 , 89, 89, 1, 0, 0);
	
		

						shape.rectangle(gl, -87, 50 , 10, 53, 1, 1, 1);
						shape.rectangle(gl, -87,-50 , -84, 50, 1, 1, 1);
						shape.rectangle(gl, -87, -50 , 10, -47, 1, 1, 1);
						shape.rectangle(gl, 7,-50 , 10, 50, 1, 1, 1);
						

			
		shape.string(gl,-80, -80, "Coded By: ", 1, 1, 0);
		
		if(x1>=-60&&w.lvl>=4&&x1!=1)
		{
			shape.rectangle(gl, -80,-20 , x1, -25, 1, 1, 1);
			if(x1<=1)
			x1++;
		}
		
		//Difficulties Representator//
		if(w.lvl==0)
		{
			shape.string(gl,20, 30, "Choose Difficulty:", 0, 0, 1);
			shape.string(gl,20, 15, "  1)  ROOKIE", 0, 1, 0);
			shape.string(gl,20, 0, "  2)  VERTERN", 1, 1, 0);
			shape.string(gl,20, -15, "  3)  EXTREME", 1, 0, 0);
			shape.string(gl,-60, 0, "WELLCOME", 0, 1, 1);
		}
		if(w.lvl==4&&x1>=0)
		{
			shape.string(gl,20, 15, "  >  ROOKIE", 0, 1, 0);
		}
		if(w.lvl==8&&x1>=0)
		{
			shape.string(gl,20, 15, "  >  VERTERN", 1, 1, 0);
		}
		if(w.lvl==12&&x1>=0)
		{
			shape.string(gl,20, 15, "  >  EXTREME", 1, 0, 0);
		}
		if(mEntity==12&&mEntity!=16)
		{
			shape.string(gl,-55, 0, "You Lose", 1, 0, 0);;
		}
		if(mEntity==16)
		{
			shape.string(gl,-55, 0, "You Win", 1, 0, 0);
		}
		
		
		
		if(attempts<=6&&attempts>=0&&mEntity!=16)
		shape.line(gl, -37, 50, -37, 35, 0, 1, 0);
		if(attempts<=5&&attempts>=0&&mEntity!=16)
		shape.line(gl, -37, 50, -37, 20, 0, 1, 0);
		if(attempts<=4&&attempts>=0&&mEntity!=16)
		shape.circle(gl, -37, 20, 5, 0, 0, 1);
		if(attempts<=3&&attempts>=0&&mEntity!=16)
		shape.rectangle(gl, -44, -1 , -30, 15, 1, 1, 1);
		if(attempts<=2&&attempts>=0&&mEntity!=16)
		shape.rectangle(gl, -42, -8 , -40, -1, 0, 1, 1);
		if(attempts<=1&&attempts>=0&&mEntity!=16)
		shape.rectangle(gl, -35, -8 , -33, -1, 0, 1, 1);
		//if(attempts>=6)
		//shape.line(gl, -41, 8, -40, 13, 0, 1, 0);
		//shape.line(gl, -34, 13, -33, 8, 0, 1, 0);	
		
		
		/*	
		shape.rectangle(gl, -90,-80 , -10, -75, 1, 1, 1);
		shape.rectangle(gl, -53, 10 , -48, -75, 1, 1, 1);		
		shape.triangle(gl, -57, 10, -44, 10, -50, 17, 0, 1, 1);
		shape.rectangle(gl, -48, 8 , -10, 2, 1, 1, 1);		
		shape.string(gl,x1, 70, "Hangman Game", 1, 1, 1);
		shape.circle(gl, x1, 50, 5, 1, 1, 0 );		
		x1--;
		for(int i=0;i<3  ;i++ )
		{
			if(x1<-100)
				x1=20;
		}		
		*/
		
		if(attempts<0&&mEntity!=16)
		{
			w.main++;
			mEntity=12;
		}
		
		
		shape.string(gl,-23, 70, "HANGMAN Game", 1, 1, 1);
		shape.bold(gl , -85, 80,"Life: "+Integer.toString(attempts), 0, 1, 1);//Telling Lifes
		if(x1>=0)
		shape.string(gl,30, -30, w.showword, 1, 1, 1);
		if(mEntity==12&&mEntity!=16)
		shape.string(gl,30, -40, w.wordToGuess, 1, 1, 1);
			//shape.line(gl, -20, 30, 30, 40, 0, 1, 0);
		
	}

	public void dispose(GLAutoDrawable drawable) {}
	
	public void init(GLAutoDrawable drawable) {
		
		GL2 gl = drawable.getGL().getGL2();
		gl.glClearColor(0, 0, 0, 1);
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}
	
	public void keyPressed(KeyEvent e) {

		R.sending=e.getKeyChar();
		char C =Character.toUpperCase(Render.sending);
		System.out.print(C);
		
		
		if(w.main==1)
		 {
			
			char[] wordToGuessChars = Work.wordToGuess.toCharArray();
			boolean trigger=false;
			for(int i=0; i<w.wordToGuess.length();i++)
			{
				//System.out.println("Match Found");
				if(C==wordToGuessChars[i])
				{
					System.out.print("Match Found at:");
					System.out.println(i);
					
					w.ReCensor(i,C);
					trigger=true;
				}
				//else 
				
			}
			if(trigger==false&&mEntity!=16)
			{
				attempts--;
				System.out.println("Attempts: "+attempts);
			}
			
		}
		
		if(w.main==0  &&C=='1'||C=='2'||C=='3')
		{
			w.Link(C);
		}
		
		//Verifing for Win//
		for(int i=0;i<w.length;i++)
		{
			if(w.censor[i]>='A'&&w.censor[i]<='Z')
			{
				if(check()==0)
				{
					System.out.println("True Condition: ");
					mEntity=16;
				}
			}
		}
		
				
	}
	
	boolean check=false;
	int check()
	{
		int x2=0;
		for(int i=0;i<w.length;i++)
		if(w.censor[i]=='*')
		{
			x2= 1;
		}
		return x2;
		
	}
    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}

}



  class Work 
{
	 
	//public char censor[];
	Render R=new Render();
	Scanner input = new Scanner(System.in);
	public static  String wordToGuess="";
	public static int lvl = 0;//For Difficulty Representation//
	public static int main = 0;//For Main Menu//
	
	
	
	static int length;
	public static String showword="";
	public static String link1;
	
	public String[] wordlist = new String[499];
	// Pick random index of words array
    public int ranNum = (int) (Math.random() * wordlist.length);
    
    public void Link(char C)
    {
		lvl++;
    	if(C=='1')
		{
    		//System.out.println("Success");
			link1="D:\\words\\words1.txt";
			lvl=4;
		}
		if(C=='2')
		{
			link1="D:\\words\\words2.txt";
			lvl=8;
		}
		if(C=='3')
		{
			link1="D:\\words\\words3.txt";
			lvl=12;
		}
		
	    try{
	    	
	    	FileInputStream ff=new FileInputStream(link1);
	    	ss = new Scanner(ff);

	    	for(int i=0;ss.hasNext()&&i<500;i++)
	    	{
	    		
	    		wordlist[i]=ss.next();
	    		
	    	}
	    }

	    catch(Exception ff)
	    	{
	    		System.out.println("Error! File Not Found.");
	    	}
		
		main++;
		File();
    }
    
	public void File(){

    

        //Set<String> previousGuesses = new HashSet<>();

        System.out.println("Your word to guess: ");
        
        wordToGuess = wordlist[ranNum].toUpperCase();
        length = wordToGuess.length();
        System.out.println(wordToGuess);
        
        Censoring();
        }
	
	public char censor[]=new char[11];
	private Scanner ss;
	
	void Censoring()
	{
        //creates and prints an array of chars with the same length as string
        //censor = wordToGuess.toCharArray();
        System.out.println(censor);
        System.out.println("Your secret word is: ");
        for (int index = 0; index < length; index++) {
            censor[index] = '*';
        }
        
        //prints the censored secret word
        showword = String.valueOf(censor);		
	}
	
	void ReCensor(int i, char C)
	{
		System.out.println("Changed. "+C);
		censor[i]=C;
		for(int j=0;j<length;j++)
		{
			if(censor[j]=='\0')
			{
				censor[j]='*';
			}
		}
		//System.out.println(String.valueOf(censor));
		showword = String.valueOf(censor);
		//System.out.println(censor[4]);
	}
}




