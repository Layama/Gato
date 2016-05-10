import java.awt.Color;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Juego {
	public static String[] marcas = { "O", "X" };
	public static String marca = Juego.marcas[new Random().nextInt(2)];
	private Setting settings = new Setting().leerSetting();
	public static int movimientos = 0;
	private Thread threadSonido;



	public Juego(JLabel sonido) {

		if (settings.isPausa()) {
			sonido.setIcon(new ImageIcon(VistaGato.class.getResource("/imagenes/apagar.png")));
		} else {
			sonido.setIcon(new ImageIcon(VistaGato.class.getResource("/imagenes/encender.png")));
		}
		System.out.println(settings.isPausa());
		System.out.println(settings);
		try {
			iniciar();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String cambiarTurno() {
		if (marca.equals("X")) {
			marca = "O";
		} else {
			marca = "X";
		}
		return "Jugador " + marca;
	}

	public void setMarca(JLabel lblMarca) {
		lblMarca.setText("Jugador " + marca);
		if (marca.equals("O")) {
			lblMarca.setForeground(Color.blue);
		} else {
			lblMarca.setForeground(Color.red);
		}
	}
	public String cambiarTurno(Celda celda, JLabel marca, JButton turno) {
		if (celda != null) {
			marca.setText(cambiarTurno());
		}
		if (celda != null) {
			marca.setText(cambiarTurno());
			celda.setEnabled(false);
			celda = null;
			setMarca(marca);
		}
		turno.setEnabled(false);
		return "Jugador " + marca;
	}

	public Celda validarCelda(Celda celda, Celda celdaEnJuego, JButton listo) {
		if (!celda.getText().equals("")) {
			listo.setEnabled(false);
			celda.setText("");
			celdaEnJuego = null;
		} else {
			if (celdaEnJuego == null) {
				celda.pintar(marca);
				celdaEnJuego = celda;
				listo.setEnabled(true);
			}
		}
		return celdaEnJuego;
	}

	public void validarGane(Celda[][] celdas, JLabel lblGanador) {
		movimientos++;
		if (movimientos >= 3) {
			System.out.println("entrp");
			if (celdas[0][0].getText().equals(marca) && celdas[1][0].getText().equals(marca)
					&& celdas[2][0].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[0][1].getText().equals(marca) && celdas[1][1].getText().equals(marca)
					&& celdas[2][1].getText().equals(marca)) {

				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[0][2].getText().equals(marca) && celdas[1][2].getText().equals(marca)
					&& celdas[2][2].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[0][0].getText().equals(marca) && celdas[1][1].getText().equals(marca)
					&& celdas[2][2].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[0][2].getText().equals(marca) && celdas[1][1].getText().equals(marca)
					&& celdas[2][0].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[0][0].getText().equals(marca) && celdas[0][1].getText().equals(marca)
					&& celdas[0][2].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[2][0].getText().equals(marca) && celdas[2][1].getText().equals(marca)
					&& celdas[2][2].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			} else if (celdas[1][0].getText().equals(marca) && celdas[1][1].getText().equals(marca)
					&& celdas[1][2].getText().equals(marca)) {
				imprimirMensaje(marca, lblGanador);
				terminarJuego(celdas);
			}
		}
	}

	private void terminarJuego(Celda[][] celdas) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				celdas[i][j].setEnabled(false);
			}
		}
	}

	public void imprimirMensaje(String marca, JLabel ganador) {
		String mensaje = "Ganador " + marca + "!";
		ganador.setText(mensaje);
		System.out.println(marca);
		if (marca.equals("O")) {
			ganador.setForeground(Color.blue);
		} else {
			ganador.setForeground(Color.red);
		}
	}

	public void iniciar() throws FileNotFoundException, JavaLayerException, InterruptedException {
		final Player pl = new Player(new FileInputStream("src/sonidos/elisa.mp3"));

		new Thread() {
			public void run() {
				try {
					while (true) {
						if (!settings.isPausa()) {
							if (!pl.play(1)) {
								threadSonido.stop();
								break;
							}
						}
					}
				} catch (JavaLayerException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

	public void pausar() {
		System.out.println("NO");
		settings.setPausa(true);
		settings.guardarSettings(settings);
	}

	public void play() {
		settings.setPausa(false);
		try {
			iniciar();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JavaLayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		settings.guardarSettings(settings);
	}
}
