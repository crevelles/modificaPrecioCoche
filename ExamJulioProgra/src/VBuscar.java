import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class VBuscar extends JFrame {

	private JPanel contentPane;
	JTextField textMatricula;
	JTextField textMarca;
	JTextField textModelo;
	JTextField textPrecio;
	JButton btnBuscar;
	JButton btnSalir;
	JButton btnModificar;
	JButton btnSubir;
	JButton btnBajar;
	JButton btnCancelar;
	JLabel LBLError;


	public VBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textMatricula = new JTextField();
		textMatricula.setBounds(129, 72, 168, 20);
		contentPane.add(textMatricula);
		textMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblMatricula.setBounds(47, 68, 100, 23);
		contentPane.add(lblMatricula);
		
		btnBuscar = new JButton("BUSCAR");
		btnBuscar.setBounds(314, 71, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblMarca.setBounds(47, 110, 78, 23);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblModelo.setBounds(47, 150, 78, 23);
		contentPane.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 16));
		lblPrecio.setBounds(47, 192, 66, 23);
		contentPane.add(lblPrecio);
		
		textMarca = new JTextField();
		textMarca.setEditable(false);
		textMarca.setColumns(10);
		textMarca.setBounds(129, 113, 168, 20);
		contentPane.add(textMarca);
		
		textModelo = new JTextField();
		textModelo.setEditable(false);
		textModelo.setColumns(10);
		textModelo.setBounds(129, 154, 168, 20);
		contentPane.add(textModelo);
		
		textPrecio = new JTextField();
		textPrecio.setEditable(false);
		textPrecio.setColumns(10);
		textPrecio.setBounds(129, 196, 168, 20);
		contentPane.add(textPrecio);
		
		btnSalir = new JButton("SALIR");
		btnSalir.setBounds(521, 350, 89, 23);
		contentPane.add(btnSalir);
		
		btnModificar = new JButton("MODIFICAR\r\n");
		btnModificar.setBounds(47, 229, 116, 23);
		contentPane.add(btnModificar);
		
		btnSubir = new JButton("SUBIR");
		btnSubir.setBounds(173, 229, 78, 23);
		contentPane.add(btnSubir);
		
		btnBajar = new JButton("BAJAR");
		btnBajar.setBounds(263, 229, 78, 23);
		contentPane.add(btnBajar);
		
		btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(359, 229, 89, 23);
		contentPane.add(btnCancelar);
		
		LBLError = new JLabel("");
		LBLError.setFont(new Font("Leelawadee UI Semilight", Font.PLAIN, 18));
		LBLError.setBounds(47, 284, 404, 20);
		contentPane.add(LBLError);
		
		btnModificar.setVisible(false);
		btnCancelar.setVisible(false);
		btnSubir.setVisible(false);
		btnBajar.setVisible(false);
	}
	
		public void setControlador(Controlador c){
			btnBajar.addActionListener(c);
			btnSubir.addActionListener(c);
			btnBuscar.addActionListener(c);
			btnCancelar.addActionListener(c);
			btnModificar.addActionListener(c);
			btnSalir.addActionListener(c);
		}
}
