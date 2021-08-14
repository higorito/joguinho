package jogo;

import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Fase1 {
	
	private Window janela;
	private Scene cena;  //scene é o arquivo do cenario
	
	private Jogador jogador;
	
	public Fase1(Window window) {
		janela = window;
		
		cena = new Scene();
		cena .loadFromFile(URL.scenario("Cenario_Fase1.scn"));
		
		jogador = new Jogador(640,350);
		run();
	}
	private void run() {
		while(true) {
			 cena.draw();
			 jogador.draw();
			 jogador.mover(janela);
			 janela.update();
		}
	}
}
