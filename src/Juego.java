
public class Juego {
	private Jugador[] jugadores = new Jugador[1];
	private String marcas[] = {"O", "X"};
	
	public Juego(){
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador(marcas[i]);
		}
	}
	
	public void Jugar(){
		
	}
}
