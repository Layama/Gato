import javax.swing.JButton;

public class Celda extends JButton{
	
	public Celda(String texto) {
		super.setText(texto);
	}
	public void pintar(String texto){
		System.out.println(texto);
		super.setText(texto);
	}
}
