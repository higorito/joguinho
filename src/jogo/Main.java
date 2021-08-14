package jogo;

import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Window janela = new Window(800, 600);
		
		GameImage menu = new GameImage(URL.sprite("MENU.png"));
		
		Keyboard teclado = janela.getKeyboard();  //instanciar o keyboard atraves do obj janela
		
		
		while(true) {
			menu.draw();
			janela.update();
			
			if(teclado.keyDown(Keyboard.ENTER_KEY)) {
				new Fase1(janela);
				
			}
		}
		
	}
}
