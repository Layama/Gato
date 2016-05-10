import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Setting implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  boolean pausa = true;
	private final static String RUTA = "C://Users//Annonymous//Desktop//settings.txt";
	
	public Setting() {
		
	}

	public  boolean isPausa() {
		return pausa;
	}

	public  void setPausa(boolean pausa) {
		this.pausa = pausa;
	}

	public  void guardarSettings(Setting setting) {
		File file = new File(RUTA);
		FileOutputStream in;
		try {
			in = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(in);
			out.writeObject(setting);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return ""+isPausa();
	}

	public  Setting leerSetting() {
		File file = new File(RUTA);
		Setting settings = null;
		if (file.exists()) {
			FileInputStream in;
			try {
				in = new FileInputStream(file);
				ObjectInputStream out = new ObjectInputStream(in);
				settings = (Setting) (out.readObject());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else{
			settings = new Setting();
		}
		return settings;
	}
}
