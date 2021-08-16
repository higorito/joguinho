package jogo;

import jplay.Scene;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Fase1 {
	
	private Window janela;
	private Scene cena;  //scene � o arquivo do cenario
	
	private Jogador jogador;
	
	private Keyboard teclado;
	
	private Slime slime;
	
	public Fase1(Window window) {
		janela = window;
		
		cena = new Scene();
		cena .loadFromFile(URL.scenario("Cenario_Fase1.scn"));
		
		jogador = new Jogador(540,350);
		teclado = janela.getKeyboard();
		
		slime = new Slime(300,300);
		
		
		Som.play("musicmine.wav");
		run();
	}
	private void run() {
		while(true) {
			 jogador.mover(janela, teclado);
			jogador.caminho(cena);
			 
			slime.caminho(cena);
			slime.perseguir(jogador.x, jogador.y);
			
			 cena.moveScene(jogador);  //centralizar o jogador no cenario //tipo camera
			 
			 jogador.x += cena.getXOffset();        //p/ movimenta��o ser mais suave
			 jogador.y += cena.getYOffset();			//meio que movimentar junto com o cenario
			
			 slime.x += cena.getXOffset();        
			 slime.y += cena.getYOffset();
			 
			 jogador.atirar(janela, cena, teclado);
			 
			 
			 jogador.draw();	
			 slime.draw();
			 janela.update();
			 janela.delay(20);
			
		}
	}
}
