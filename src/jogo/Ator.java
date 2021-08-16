package jogo;

import java.awt.Point;
import java.util.Vector;

import jplay.GameObject;
import jplay.Scene;
import jplay.Sprite;
import jplay.TileInfo;

public class Ator extends Sprite{

	
	
	//coloquei tudo protegido pra n dar problema (encapsulamento + herança)
	
	protected double velocidade = 1;
	protected int direcao = 3;  //esse 3 é parado
	protected boolean movendo = false; 
	
	
	public Ator(String fileName, int numFrames) {
		super(fileName, numFrames);
		
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
