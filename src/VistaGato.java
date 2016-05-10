import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javazoom.jl.decoder.JavaLayerException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VistaGato extends JFrame {


	private Celda[][] celdas = new Celda[3][3];
	private Celda celdaEnJuego = null;
	private JPanel contentPane;
	private final JButton btnReiniciar = new JButton("Reiniciar");
	private final JLabel label;
	private final JButton btnInstrucciones = new JButton("Info");
	private JButton btnCambiarTurno = new JButton("Listo!");
	private static boolean encendido = true;
	private final JLabel lblGanador = new JLabel("");

	private JLabel lblSonido = new JLabel("");
	private Juego juego = new Juego(lblSonido);
	private JLabel lblMarca = new JLabel("Jugador " + Juego.marca);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaGato frame = new VistaGato();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VistaGato() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VistaGato.class.getResource("/imagenes/hqdefault.jpg")));
		setTitle("Gato");
		setResizable(false);
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		getContentPane().add(btnNewButton, BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		btnCambiarTurno.setBackground(Color.WHITE);
		btnCambiarTurno.setEnabled(false);
		lblSonido.setHorizontalAlignment(SwingConstants.CENTER);
		lblSonido.setBounds(20, 306, 56, 58);
		lblGanador.setFont(new Font("Arial", Font.BOLD, 14));
		lblGanador.setBounds(214, 328, 89, 36);
		contentPane.add(lblGanador);
		contentPane.add(lblSonido);
		btnCambiarTurno.setBounds(405, 23, 109, 23);
		contentPane.add(btnCambiarTurno);
		lblMarca.setBounds(405, 77, 109, 23);
		contentPane.add(lblMarca);
		lblMarca.setFont(new Font("Arial", Font.BOLD, 14));
		juego.setMarca(lblMarca);
		btnReiniciar.setBackground(Color.WHITE);
		btnReiniciar.setBounds(425, 319, 89, 23);
		contentPane.add(btnReiniciar);
		pintarCeldas();
		eventCeldas();
		btnInstrucciones.setBackground(Color.WHITE);
		btnInstrucciones.setBounds(425, 284, 89, 23);
		contentPane.add(btnInstrucciones);
		label = new JLabel("");
		label.setIcon(new ImageIcon(VistaGato.class.getResource("/imagenes/dos-gatos-2070.jpg")));
		label.setBounds(-69, 0, 812, 548);
		contentPane.add(label);

		btnCambiarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.cambiarTurno(celdaEnJuego, lblMarca, btnCambiarTurno);
				
			}
		});

		lblSonido.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				encendido = !encendido;
				System.out.println(encendido+"ENS");
				if (encendido) {
					lblSonido.setIcon(new ImageIcon(VistaGato.class.getResource("/imagenes/encender.png")));
					juego.play();
				} else {
					lblSonido.setIcon(new ImageIcon(VistaGato.class.getResource("/imagenes/apagar.png")));
					juego.pausar();
				}

			}
		});

		btnReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				juego.movimientos = 0;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {

						System.out.println(i + " " + j);
						celdas[i][j].setText("");
						lblGanador.setText("");
						celdas[i][j].setEnabled(true);
						celdaEnJuego = null;
						btnCambiarTurno.setEnabled(false);
					}
				}
			}
		});

		btnInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Pulsa Listo!, cuando lo estes\n para quitar marca pulsa de nuevo el bloque\n que has tocado");
			}
		});

	}

	public void pintarCeldas() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				celdas[i][j] = new Celda("");
				celdas[i][j].setBounds(87 + i * 100, 20 + j * 100, 100, 100);
				celdas[i][j].setBackground(Color.WHITE);
				celdas[i][j].setFont(new Font("Arial", Font.PLAIN, 28));
				contentPane.add(celdas[i][j]);
			}
		}
	}

	public void eventCeldas() {
		celdas[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[0][0], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[0][1], celdaEnJuego, btnCambiarTurno);
				System.out.println(celdaEnJuego);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[0][2], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[1][0], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[1][1], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[1][2], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[2][0], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[2][1], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});
		celdas[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				celdaEnJuego = juego.validarCelda(celdas[2][2], celdaEnJuego, btnCambiarTurno);
				if (celdaEnJuego != null) {
					juego.validarGane(celdas, lblGanador);
				}
			}
		});

	}
}