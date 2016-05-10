
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
	
	public String cambiarTurno(String marca){
		if (marca.equals("X")) {
			marca = "O";
		} else {
			marca = "X";
		}
		return marca;
	}
	
	public boolean validarCelda(Celda celda, Celda celdaEnJuego, String marca){
		boolean celdaValida = false;
		if (!celda.getText().equals("")) {
			celda.setText("");
			celdaEnJuego = null;
		
		} else {
			if(celdaEnJuego == null){
				celda.pintar(marca);
				celdaEnJuego = celda;
				celdaValida = true;
			}
		}
		return celdaValida;
	}
	public void validarGane(Celda[][] celdas, String marca) {
		System.out.println("entrp");
		if (celdas[0][0].getText().equals(marca) && celdas[1][0].getText().equals(marca)
				&& celdas[2][0].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[0][1].getText().equals(marca) && celdas[1][1].getText().equals(marca)
				&& celdas[2][1].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[0][2].getText().equals(marca) && celdas[1][2].getText().equals(marca)
				&& celdas[2][2].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[0][0].getText().equals(marca) && celdas[1][1].getText().equals(marca)
				&& celdas[2][2].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[0][2].getText().equals(marca) && celdas[1][1].getText().equals(marca)
				&& celdas[2][0].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[0][0].getText().equals(marca) && celdas[0][1].getText().equals(marca)
				&& celdas[0][2].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[2][0].getText().equals(marca) && celdas[2][1].getText().equals(marca)
				&& celdas[2][2].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		} else if (celdas[1][0].getText().equals(marca) && celdas[1][1].getText().equals(marca)
				&& celdas[1][2].getText().equals(marca)) {
			System.out.println("GANO!! Lo felicito");
		}
	}
}
