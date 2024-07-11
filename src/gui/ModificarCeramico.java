package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ModificarCeramico extends JDialog implements ActionListener, ItemListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtAncho;
	private JTextField txtLargo;
	private JTextField txtEspesor;
	private JTextField txtContenido;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAnchocm;
	private JLabel lblLargocm;
	private JLabel lblEspesormm;
	private JLabel lblContenido;
	private JComboBox<String> cmbModelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCeramico dialog = new ModificarCeramico();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ModificarCeramico() {
		setResizable(false);
		setModal(true);
		setTitle("Modificar Cer\u00E1mico");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCeramico.class.getResource("/gui/iconos/1613243.png")));
		setBounds(100, 100, 469, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(10, 16, 84, 14);
		contentPanel.add(lblModelo);
		
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 60, 91, 14);
		contentPanel.add(lblPrecio);
		
		
		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnchocm.setBounds(10, 104, 91, 14);
		contentPanel.add(lblAnchocm);
		
		
		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLargocm.setBounds(10, 148, 91, 14);
		contentPanel.add(lblLargocm);
		
		
		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspesormm.setBounds(10, 192, 91, 14);
		contentPanel.add(lblEspesormm);
		
		
		lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContenido.setBounds(10, 236, 84, 14);
		contentPanel.add(lblContenido);
		
		
		cmbModelo = new JComboBox<String>();
		cmbModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbModelo.addItemListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] 
		{"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cmbModelo.setBounds(104, 7, 142, 33);
		contentPanel.add(cmbModelo);
		
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(104, 51, 142, 33);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		txtAncho = new JTextField();
		txtAncho.setBounds(104, 95, 142, 33);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		
		txtLargo = new JTextField();
		txtLargo.setBounds(104, 139, 142, 33);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);
		
		
		txtEspesor = new JTextField();
		txtEspesor.setBounds(104, 183, 142, 33);
		contentPanel.add(txtEspesor);
		txtEspesor.setColumns(10);
		
	
		txtContenido = new JTextField();
		txtContenido.setBounds(104, 227, 142, 33);
		contentPanel.add(txtContenido);
		txtContenido.setColumns(10);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(ModificarCeramico.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(335, 7, 108, 33);
		contentPanel.add(btnCerrar);
		
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGrabar.addActionListener(this);
		btnGrabar.setIcon(new ImageIcon(ModificarCeramico.class.getResource("/gui/iconos/Save.png")));
		btnGrabar.setBounds(335, 52, 108, 33);
		contentPanel.add(btnGrabar);
			
		//Cargando los valores en los jtextfield al iniciar el jdialog
		txtPrecio.setText("" + MenuPrincipal.precio0);
		txtAncho.setText("" + MenuPrincipal.ancho0);
		txtLargo.setText("" + MenuPrincipal.largo0);
		txtEspesor.setText("" + MenuPrincipal.espesor0);
		txtContenido.setText("" + MenuPrincipal.contenido0);
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbModelo) {
			itemStateChangedCmbModelo(e);
		}
	}
	
	protected void itemStateChangedCmbModelo(ItemEvent e) {
		//Declarando las variables
		double precio, ancho, largo, espesor;
		int item, contenido;
			
		//Asignando las variables al valor de retorno de los metodos
		item = cmbModelo.getSelectedIndex();
		precio = precio(item);
		ancho = ancho(item);
		largo = largo(item);
		espesor = espesor(item);
		contenido = contenido(item);
			
		//Mostrando resultados
		mostrarResultado(precio, ancho, largo, espesor, contenido);
	}
	
	//CREANDO LOS MÉTODOS PARA JALAR LOS VALORES EN LOS JTEXTFIELD
	//Obteniendo los precios
	double precio(int item) {
		switch (item) {
		case 0:     return MenuPrincipal.precio0;
		case 1:     return MenuPrincipal.precio1;
		case 2:     return MenuPrincipal.precio2;
		case 3:     return MenuPrincipal.precio3;
		default:    return MenuPrincipal.precio4;
		}		
	}
	
	//Obteniendo el ancho
	double ancho(int item) {
		switch (item) {
		case 0:     return MenuPrincipal.ancho0;
		case 1:     return MenuPrincipal.ancho1;
		case 2:     return MenuPrincipal.ancho2;
		case 3:     return MenuPrincipal.ancho3;
		default:    return MenuPrincipal.ancho4;
		}
	}
	
	//Obteniendo el Largo
	double largo(int item) {
		switch (item) {
		case 0:     return MenuPrincipal.largo0;
		case 1:     return MenuPrincipal.largo1;
		case 2:     return MenuPrincipal.largo2;
		case 3:     return MenuPrincipal.largo3;
		default:    return MenuPrincipal.largo4;
		}		     
	}
	
	//Obteniendo el espesor
	double espesor(int item) {
		switch (item) {
		case 0:     return MenuPrincipal.espesor0;
		case 1:     return MenuPrincipal.espesor1;
		case 2:     return MenuPrincipal.espesor2;
		case 3:     return MenuPrincipal.espesor3;
		default:    return MenuPrincipal.espesor4;
		}
	}
	
	//Obteniendo el contenido
	int contenido(int item) {
		switch (item) {
		case 0:     return MenuPrincipal.contenido0;
		case 1:     return MenuPrincipal.contenido1;
		case 2:     return MenuPrincipal.contenido2;
		case 3:     return MenuPrincipal.contenido3;
		default:    return MenuPrincipal.contenido4;
		}
	}
	
	//Mostrando los valores en su respectivo textField
	void mostrarResultado(double precio, double ancho, double largo, double espesor, int contenido) {
		txtPrecio.setText("" + precio);
		txtAncho.setText("" + ancho);
		txtLargo.setText("" + largo);
		txtEspesor.setText("" + espesor);
		txtContenido.setText("" + contenido);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(e);
		}
		
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		//Deaclarando la variable item que captura el indice del JComboBox
		int item = cmbModelo.getSelectedIndex();
		
		//Llamando a los MÉTODOS
		nuevoPrecio(item);
		nuevoAncho(item);
		nuevoLargo(item);
		nuevoEspesor(item);
		nuevoContenido(item);
		
		//Mostrando aviso de modificación exitosa
		JOptionPane.showInternalMessageDialog(null, "Modificación Exitosa", "Aviso", 1, null);
		
		//Cerrando la ventana luego de grabar
		dispose();
	}
	
	//CREANDO LOS MÉTODOS PARA EL BOTÓN GRABAR
	void nuevoPrecio(int item) {
		
		//Modificando el valor del precio según el modelo seleccionado
		switch(item) {
		case 0: MenuPrincipal.precio0 = Double.parseDouble(txtPrecio.getText());
		break;
		case 1: MenuPrincipal.precio1 = Double.parseDouble(txtPrecio.getText());
		break;
		case 2: MenuPrincipal.precio2 = Double.parseDouble(txtPrecio.getText());
		break;
		case 3: MenuPrincipal.precio3 = Double.parseDouble(txtPrecio.getText());
		break;
		default: MenuPrincipal.precio4 = Double.parseDouble(txtPrecio.getText());
		}
	}
	
	void nuevoAncho(int item) {
		//Modificando el ancho según el modelo seleccionado
		switch(item) {
		case 0: MenuPrincipal.ancho0 = Double.parseDouble(txtAncho.getText());
		break;
		case 1: MenuPrincipal.ancho1 = Double.parseDouble(txtAncho.getText());
		break;
		case 2: MenuPrincipal.ancho2 = Double.parseDouble(txtAncho.getText());
		break;
		case 3: MenuPrincipal.ancho3 = Double.parseDouble(txtAncho.getText());
		break;
		default: MenuPrincipal.ancho4 = Double.parseDouble(txtAncho.getText());
		}
	}
	
	void nuevoLargo(int item) {
		//Modificando el largo según el modelo seleccionado
		switch(item) {
		case 0: MenuPrincipal.largo0 = Double.parseDouble(txtLargo.getText());
		break;
		case 1: MenuPrincipal.largo1 = Double.parseDouble(txtLargo.getText());
		break;
		case 2: MenuPrincipal.largo2 = Double.parseDouble(txtLargo.getText());
		break;
		case 3: MenuPrincipal.largo3 = Double.parseDouble(txtLargo.getText());
		break;
		default: MenuPrincipal.largo4 = Double.parseDouble(txtLargo.getText());
		}
	}
	
	void nuevoEspesor(int item) {
		//Modificando el espesor según el modelo seleccionado
		switch(item) {
		case 0: MenuPrincipal.espesor0 = Double.parseDouble(txtEspesor.getText());
		break;
		case 1: MenuPrincipal.espesor1 = Double.parseDouble(txtEspesor.getText());
		break;
		case 2: MenuPrincipal.espesor2 = Double.parseDouble(txtEspesor.getText());
		break;
		case 3: MenuPrincipal.espesor3 = Double.parseDouble(txtEspesor.getText());
		break;
		default: MenuPrincipal.espesor4 = Double.parseDouble(txtEspesor.getText());
		}
	}
	
	void nuevoContenido(int item) {
		//Modificando el contenido según el modelo seleccionado
		switch(item) {
		case 0: MenuPrincipal.contenido0 = Integer.parseInt(txtContenido.getText());
		break;
		case 1: MenuPrincipal.contenido1 = Integer.parseInt(txtContenido.getText());
		break;
		case 2: MenuPrincipal.contenido2 = Integer.parseInt(txtContenido.getText());
		break;
		case 3: MenuPrincipal.contenido3 = Integer.parseInt(txtContenido.getText());
		break;
		default: MenuPrincipal.contenido4 = Integer.parseInt(txtContenido.getText());
		}
	}
	
}
