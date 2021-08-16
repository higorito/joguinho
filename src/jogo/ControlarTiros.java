package jogo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import jplay.Scene;
import jplay.Sound;
import jplay.URL;

public class ControlarTiros {
	
	LinkedList<Tiro> tiros = new LinkedList<>();

	
	public void addTiro(double x, double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y , caminho);
		tiros.addFirst(tiro);
		
		
		cena.addOverlay(tiro);
		
		somTiro();
		
		
	}
	public void run() {
		for (int i = 0; i < tiros.size(); i++) {  //nao é .leght pq é estrutura de dados
			Tiro tiro = tiros.removeFirst();
			tiro.move();
			tiros.addLast(tiro);

			
		}
		
	}
	
	private void somTiro() {
		new Sound(URL.audio("flecha.wav")).play();
	}
	
}
