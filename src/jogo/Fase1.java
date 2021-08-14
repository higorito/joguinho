package jogo;

import jplay.Scene;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Fase1 {
	
	private Window janela;
	private Scene cena;  //scene é o arquivo do cenario
	
	private Jogador jogador;
	
	private Keyboard teclado;
	
	public Fase1(Window window) {
		janela = window;
		
		cena = new Scene();
		cena .loadFromFile(URL.scenario("Cenario_Fase1.scn"));
		
		jogador = new Jogador(540,350);
		teclado = janela.getKeyboard();
		
		Som.play("musicmine.wav");
		run();
	}
	private void run() {
		while(true) {
			 jogador.mover(janela, teclado);
			jogador.caminho(cena);
			 
			 cena.moveScene(jogador);  //centralizar o jogador no cenario //tipo camera
			 
			 jogador.x += cena.getXOffset();        //p/ movimentação ser mais suave
			 jogador.y += cena.getYOffset();			//meio que movimentar junto com o cenario
			 
			 jogador.draw();			 
			 janela.update();
			
		}
	}
}
