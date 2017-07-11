import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener{
	
	
	
	BaseDatos bd;
	VBuscar vb;
	ArrayList<Coche> coches = new ArrayList<>();
	

	public Controlador(BaseDatos bd,VBuscar vb) {
		super();
		this.bd = bd;
		this.vb = vb;
		bd.cargarVehiculos(coches);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		
		if(o == vb.btnSalir){
			vb.dispose();
			bd.cerrarBaseDatos();
		} else if(o == vb.btnBuscar){
			buscarVehiculo();
		} else if(o == vb.btnBajar){
			bajarPrecio();
		} else if(o == vb.btnSubir){
			subirPrecio();
		} else if(o == vb.btnCancelar){
			cancelar();
		} else if(o == vb.btnModificar){
			modificaPrecio();
		}
		
	}

	
	private void modificaPrecio() {
		String matricula = vb.textMatricula.getText();
		int precio = Integer.parseInt(vb.textPrecio.getText());
		if(bd.modificaPrecio(matricula, precio)){
			vb.LBLError.setText("Precio MODIFICADO");
			for (Coche coche : coches) {
				if(coche.getMatricula().equalsIgnoreCase(matricula)){
					coche.setPrecio(precio);
				}
			}
			deshBotones();
			vb.textMarca.setText(null);
			vb.textMatricula.setText(null);
			vb.textModelo.setText(null);
			vb.textPrecio.setText(null);
		}
		
	}


	private void cancelar() {
		deshBotones();
		vb.LBLError.setText(null);
		
	}


	private void bajarPrecio() {
		int precioInicial = Integer.parseInt(vb.textPrecio.getText());
		int precioModificado = precioInicial - 100;
		vb.textPrecio.setText(precioModificado+ "");
	}
	
	
	private void subirPrecio() {
		int precioInicial = Integer.parseInt(vb.textPrecio.getText());
		int precioModificado = precioInicial + 100;
		vb.textPrecio.setText(precioModificado+ "");
		
	}


	private void habilitaBotones(){
		vb.btnBajar.setVisible(true);
		vb.btnSubir.setVisible(true);
		vb.btnModificar.setVisible(true);
		vb.btnCancelar.setVisible(true);
	}
	
	private void deshBotones(){
		vb.btnBajar.setVisible(false);
		vb.btnSubir.setVisible(false);
		vb.btnModificar.setVisible(false);
		vb.btnCancelar.setVisible(false);
		vb.textMarca.setText(null);
		vb.textMatricula.setText(null);
		vb.textModelo.setText(null);
		vb.textPrecio.setText(null);
	}

	private void buscarVehiculo() {
		boolean encontrado = false;
		String matricula = vb.textMatricula.getText();
		if(matricula.length() == 0){
			vb.LBLError.setText("NO PUEDE QUEDAR EL CAMPO VACIO");
		} else {
			for (Coche coche : coches) {
				if(coche.getMatricula().equalsIgnoreCase(matricula)){
					vb.textMarca.setText(coche.getMarca());
					vb.textModelo.setText(coche.getModelo());
					vb.textPrecio.setText(coche.getPrecio()+"");
					encontrado = true;
					vb.LBLError.setText("Vehiculo encontrado");
					habilitaBotones();
				}
			}
			if(!encontrado){
				vb.LBLError.setText("Vehiculo NO encontrado");
				deshBotones();
			}
		}
		
	}


//	private void buscarVehiculo() {
//		String matricula = vb.textMatricula.getText();
//		if(matricula.length() == 0){
//			vb.LBLError.setText("El campo matrícula no DEBE quedar vacío");
//		} else {
//			ArrayList<Coche> coches = new ArrayList<>();
//			if(bd.vehiculoEncntrado(matricula)){
//				for (Coche coche : coches) {
//					if(coche.getMatricula().equalsIgnoreCase(matricula)){
//						vb.textMarca.setText(coche.getMarca());
//						vb.textModelo.setText(coche.getModelo());
//						vb.textPrecio.setText(coche.getPrecio()+"");
//					}
//					vb.LBLError.setText("Vehiculo encontrado");
//				}
//			} else {
//				vb.LBLError.setText("No hay ningun vehículo con la matricula introducida");
//			}
//		}	
//	}

}
