package jogo;

import jplay.Sprite;
import jplay.URL;
import jplay.Window;
import jplay.Keyboard;

public class Jogador extends Sprite{
	
	private double velocidade = 0.3;
	private int direcao = 3;  //esse 3 é parado
	private Keyboard teclado;
	private boolean movendo = false; 
	
	
		public Jogador(int x, int y) {
			super(URL.sprite("jogador.png"),20);
			
			this.x = x;
			this.y = y;
			
			this.setTotalDuration(2000);
		}
		
		public void mover(Window janela) {
			if(teclado == null) {
				teclado = janela.getKeyboard();
			}
			if(teclado.keyDown(Keyboard.LEFT_KEY)) {
				if(this.x >0) {
					this.x -= velocidade;
				}
				if(direcao != 1) {
					setSequence(4,8);  //de acordo com a imagem la... pra saber qual animação fazer
					direcao = 1;
				}
				movendo = true;
			}else if(teclado.keyDown(Keyboard.RIGHT_KEY)) {
				if(this.x < janela.getWidth() - 60) {  //pra pegar a largura da janela e saber o limite
					this.x += velocidade;
				}
				if(direcao != 2) {
					setSequence(8, 12); 
					direcao = 2;
				}
				movendo = true;
				
			}else if(teclado.keyDown(Keyboard.UP_KEY)) {
				if(this.y > 0) {
					this.y -= velocidade;
				}
				if(direcao != 4) {
					setSequence(12,16); 
					direcao = 4;
				}
				movendo = true;
				
			}else if(teclado.keyDown(Keyboard.DOWN_KEY)) {
				if(this.y < janela.getHeight() - 60) {   //pegar altura
					this.y += velocidade;
				}
				if(direcao != 5) {
					setSequence(0, 4); 
					direcao = 5;
				}
				movendo = true;
				
			}
			if(movendo) {
				update();
				movendo = false;
			}
			
		}
	}

