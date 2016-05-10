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
	private Juego juego = new Juego();
	
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
					marca = juego.cambiarTurno(marca);
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
	
	//juego.validarCelda();
	
	public void eventCeldas() {
		celdas[0][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[0][0], celdaEnJuego, marca);
				
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[0][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[0][1], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[0][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[0][2], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[1][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida =juego.validarCelda(celdas[1][0], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[1][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[1][1], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[1][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[1][2], celdaEnJuego, marca);
			}
		});
		celdas[2][0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[2][0], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[2][1].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[2][1], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});
		celdas[2][2].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean esCeldaValida = juego.validarCelda(celdas[2][2], celdaEnJuego, marca);
				if(esCeldaValida){
					juego.validarGane(celdas, marca);
				}
			}
		});

	}
}