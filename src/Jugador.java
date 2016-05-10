
public class Jugador {
	private String marca = "";
	
	public Jugador(String marca) {
		this.marca = marca;
	}
	
	public void pintar(Celda celda){
		celda.pintar(marca);
	}
}
