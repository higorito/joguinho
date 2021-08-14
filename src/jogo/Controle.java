package jogo;

import jplay.GameObject;
import jplay.TileInfo;

public class Controle {
	
	public boolean colisao(GameObject obj, TileInfo tile){
		if((tile.id>=13) && obj.collided(tile)) {   //esse 7 depende da lista la no .scn
			return true;
		}
		return false;
	}
}
