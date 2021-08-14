package jogo;

import jplay.Sprite;
import jplay.TileInfo;
import jplay.URL;
import jplay.Window;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Keyboard;
import jplay.Scene;

public class Jogador extends Sprite{
	
	private double velocidade = 1;
	private int direcao = 3;  //esse 3 é parado
	private boolean movendo = false; 
	
	
		public Jogador(int x, int y) {
			super(URL.sprite("jogador.png"),20);
			
			this.x = x;
			this.y = y;
			
			this.setTotalDuration(2000);
		}
		
		public void mover(Window janela, Keyboard teclado) {
			
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

		Controle controle = new Controle();
		
		
		
		
		
		public void caminho(Scene cena) {   //vai controlar p n atravessar as coisas
			Point min = new Point((int)this.x, (int)this.y);  //definindo tamanho personagem e usando cast
			
			Point max = new Point((int)this.x + this.width, (int)this.y + this.height);
			
			Vector<?>tiles = cena.getTilesFromPosition(min, max); //as imgs que estao no local do personagem
			
			for(int i =0; i< tiles.size();i++) {
				
				TileInfo tile = (TileInfo) tiles.elementAt(i);   //cast dnv
				
				if(controle.colisao(this, tile)==true) {   //lembrando que verifica se teve colisao
					
					if(colisaoVertical(this, tile)) {
						if(tile.y + tile.height - 2 < this.y) {
							this.y = tile.y + tile.height;   //apenas reposicionando o personagem de baixo pra cima
						}
						else if(tile.y > this.y + this.height-2) {  
							this.y = tile.y - this.height;     // de cima pra baixo
						}
					}
					if(colisaoHorizontal(this, tile)) {
						if(tile.x > this.x + this.width - 2) {
							this.x = tile.x - this.width;
						}
						else {
							this.x = tile.x + tile.width;
						}
						
						
						
						
					}
					
				}
			}
		}
		private boolean colisaoVertical(GameObject obj, GameObject obj2) {
			if(obj2.x + obj2.width <= obj.x) {   //ve se o tile 7 la + largura é menor ou igual ao personagem
				return false;
			}
			if(obj.x + obj.width <= obj2.x) {
				return false;
			}
			return true;
		}
		private boolean colisaoHorizontal(GameObject obj, GameObject obj2) {
			if(obj2.y + obj2.height <=obj.y) 
				return false;
			if(obj.y + obj.height <= obj2.y)
				return false;
			
			return true;
		}
		
		
		
		
	}

