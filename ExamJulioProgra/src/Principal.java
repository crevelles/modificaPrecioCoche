
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VBuscar vb = new VBuscar();
		BaseDatos bd = new BaseDatos();
		Controlador c = new Controlador(bd, vb);
		vb.setControlador(c);
		vb.setVisible(true);

	}

}
