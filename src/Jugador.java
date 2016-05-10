import java.awt.Color;

public class Jugador {
	private String marca = "";
	
	public Jugador(String marca) {
		this.marca = marca;
	}
	
	public void pintar(Celda celda){
		celda.pintar(marca);
		if(marca.equals("O")){
			celda.setForeground(Color.blue);
		} else {
			celda.setForeground(Color.red);
		}
	}
}
