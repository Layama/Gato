import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;

public class VistaGato extends JFrame {

	private JPanel contentPane;
	private String marca = "X";
	private JLabel lblMarca = new JLabel("Jugador " + marca);
	private Celda[][] celdas = new Celda[3][3];
	private Celda celdaEnJuego = null;
	private boolean inicio = true; 
	public void setMarca(String marca) {
		this.marca = marca;
		lblMarca.setText("Jugador " + marca);
		if(marca.equals("O")){
			lblMarca.setForeground(Color.blue);
		}else{
			lblMarca.setForeground(Color.red);
		}
	}

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
	//juego.cambiarTurno();
	public void cambiarTurno(){
		if (marca.equals("X")) {
			setMarca("O");
		} else {
			setMarca("X");
		}
	}
	public VistaGato() {
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		getContentPane().add(btnNewButton, BorderLayout.WEST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		
		JButton btnCambiarTurno = new JButton("Listo!");
		btnCambiarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(celdaEnJuego != null){
					cambiarTurno();
					inicio = false;
				}
				
				if(celdaEnJuego != null){
					celdaEnJuego.setEnabled(false);
					celdaEnJuego = null;
				}
				
			}
		});
		btnCambiarTurno.setBounds(405, 23, 109, 23);
		contentPane.add(btnCambiarTurno);

		lblMarca.setBounds(405, 77, 109, 14);
		contentPane.add(lblMarca);

		pintarCeldas();
		eventCeldas();

	}

	//jugador.pintarCelda();
	public void pintarCeldas() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(i + " " + j);
				//celdas[i][j] = new Celda("Celda" + i + ", " + j);
				celdas[i][j] = new Celda("");
				celdas[i][j].setBounds(87 + i * 100, 20 + j * 100, 100, 100);
				contentPane.add(celdas[i][j]);
			}
		}
	}
	//Juego.validarGane();
	public void validarGane() {
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
	//juego.validarCelda();
	public void validarCelda(Celda celda){
	
			if (!celda.getText().equals("")) {
				celda.setText("");
				celdaEnJuego = null;
			} else {
				if(celdaEnJuego == null){
					celda.pintar(marca);
					validarGane();
					celdaEnJuego = celda;
				}
			}
	}
	public void eventCeldas() {
		celdas[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					 validarCelda(celdas[0][0]);
			}
		});
		celdas[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[0][1]);
			}
		});
		celdas[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[0][2]);
			}
		});
		celdas[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[1][0]);
			}
		});
		celdas[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[1][1]);
			}
		});
		celdas[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[1][2]);
			}
		});
		celdas[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[2][0]);
			}
		});
		celdas[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[2][1]);
			}
		});
		celdas[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				validarCelda(celdas[2][2]);
			}
		});

	}
}