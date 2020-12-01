package org.graphics;

import com.jogamp.newt.event.KeyAdapter;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;
import java.io.*;
import java.util.Scanner;



public class Render {
	
	
	public static char sending;
	private static GLWindow window = null;
	
	public static void init() {
		GLProfile.initSingleton();
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities caps = new GLCapabilities(profile);
		
		window=GLWindow.create(caps);
		window.setSize(640, 640);
		window.setResizable(false);
		window.addGLEventListener(new EventListener());
		window.addKeyListener(new EventListener());
		window.setTitle("Hangman Game");
		
		window.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
     
            	sending=e.getKeyChar();
            	//System.out.println(sending);
                fun(sending);
            	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    window.getAnimator().stop();
                }
            }
        });
		
		FPSAnimator animator = new FPSAnimator(window, 60);
		animator.start();
		
		window.setVisible(true);
		
	}
	static void fun(char a)
	{
		//System.out.println("test"+a);
	}
	
	public static void main(String[] args) {
		
		System.out.println("Main Method");
		Work w=new Work();
		EventListener E=new EventListener();
		
		init();
		//w.File();
		System.out.println(sending);
		
		
			
         
    }
}      

		



/*



try {
	FileInputStream fin=new FileInputStream("C:\\Users\\SoNiC\\workspace\\Hangman_Game\\org\\words\\easy words.txt");
	int i=fin.read();
	System.out.println((char)i);
	
	fin.close();
}catch(Exception e) 
{System.out.println(e);}
*/