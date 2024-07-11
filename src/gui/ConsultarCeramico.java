package gui;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class ConsultarCeramico extends JDialog implements ActionListener, ItemListener {
	
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
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAnchocm;
	private JLabel lblLargocm;
	private JLabel lblEspesormm;
	private JLabel lblContenido;
	private JComboBox<String> cmbModelo;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		try {
			ConsultarCeramico dialog = new ConsultarCeramico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarCeramico() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConsultarCeramico.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Consultar Cer\u00E1mico");
		setBounds(100, 100, 462, 309);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(10, 17, 106, 14);
		contentPanel.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 61, 106, 14);
		contentPanel.add(lblPrecio);
		
		lblAnchocm = new JLabel("Ancho (cm)");
		lblAnchocm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAnchocm.setBounds(10, 105, 106, 14);
		contentPanel.add(lblAnchocm);
		
		lblLargocm = new JLabel("Largo (cm)");
		lblLargocm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLargocm.setBounds(10, 149, 106, 14);
		contentPanel.add(lblLargocm);
		
		lblEspesormm = new JLabel("Espesor (mm)");
		lblEspesormm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspesormm.setBounds(10, 193, 106, 14);
		contentPanel.add(lblEspesormm);
		
		lblContenido = new JLabel("Contenido");
		lblContenido.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContenido.setBounds(10, 237, 106, 14);
		contentPanel.add(lblContenido);
		
		cmbModelo = new JComboBox<String>();
		cmbModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbModelo.addItemListener(this);
		cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] 
		{"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cmbModelo.setBounds(102, 8, 157, 33);
		contentPanel.add(cmbModelo);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(102, 52, 157, 33);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtAncho = new JTextField();
		txtAncho.setEditable(false);
		txtAncho.setBounds(102, 96, 157, 33);
		contentPanel.add(txtAncho);
		txtAncho.setColumns(10);
		
		txtLargo = new JTextField();
		txtLargo.setEditable(false);
		txtLargo.setBounds(102, 140, 157, 33);
		contentPanel.add(txtLargo);
		txtLargo.setColumns(10);
		
		txtEspesor = new JTextField();
		txtEspesor.setEditable(false);
		txtEspesor.setBounds(102, 184, 157, 33);
		contentPanel.add(txtEspesor);
		txtEspesor.setColumns(10);
		
		txtContenido = new JTextField();
		txtContenido.setEditable(false);
		txtContenido.setBounds(102, 228, 157, 33);
		contentPanel.add(txtContenido);
		txtContenido.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setIcon(new ImageIcon(ConsultarCeramico.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setBounds(327, 8, 109, 33);
		contentPanel.add(btnCerrar);
		
		//Cargando los valores de las variables 
		//en los jtextfield al iniciar el Jdialog
		txtPrecio.setText("" + MenuPrincipal.precio0);
		txtAncho.setText("" + MenuPrincipal.ancho0);
		txtLargo.setText("" + MenuPrincipal.largo0);
		txtEspesor.setText("" + MenuPrincipal.espesor0);
		txtContenido.setText("" + MenuPrincipal.contenido0);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar (e);
		}
	}
	
	protected void actionPerformedBtnCerrar (ActionEvent e) {
		dispose();
	}
	
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cmbModelo) {
			itemStateChangedCmbModelo(e);
		}
	}
	
	protected void itemStateChangedCmbModelo (ItemEvent e) {
		
		//Declarando las variables que se usarán 
		//para mostrar los resultados en el txtArea
		double precio, ancho, largo, espesor;
		int item, contenido;
		
		//Asignando las variables al valor de retorno de los métodos
		item = cmbModelo.getSelectedIndex();  //Índice del jcomboBox
		precio = precio(item);
		ancho = ancho(item);
		largo = largo(item);
		espesor = espesor(item);
		contenido = contenido(item);
		
		//Mostrando resultados
		mostrarResultado(precio, ancho, largo, espesor, contenido);	
	}
	
	//CREANDO LOS MÉTODOS
	
	//Obteniendo los precios
	double precio(int item) {
		switch (item) {
		case 0:    return MenuPrincipal.precio0;
		case 1:    return MenuPrincipal.precio1;
		case 2:    return MenuPrincipal.precio2;
		case 3:    return MenuPrincipal.precio3;
		default:   return MenuPrincipal.precio4;
		}	
	}
	
	//Obteniendo el ancho
	double ancho(int item) {
		switch(item) {
		case 0:    return MenuPrincipal.ancho0;
		case 1:    return MenuPrincipal.ancho1;
		case 2:    return MenuPrincipal.ancho2;
		case 3:    return MenuPrincipal.ancho3;
		default:   return MenuPrincipal.ancho4;
		}
	}
	
	//Obteniendo el largo
	double largo(int item) {
		switch(item) {
		case 0:    return MenuPrincipal.largo0;
		case 1:    return MenuPrincipal.largo1;
		case 2:    return MenuPrincipal.largo2;
		case 3:    return MenuPrincipal.largo3;
		default:   return MenuPrincipal.largo4;
		}
	}
	
	//Obteniendo el espesor
	double espesor(int item) {
		switch(item) {
		case 0:    return MenuPrincipal.espesor0;
		case 1:    return MenuPrincipal.espesor1;
		case 2:    return MenuPrincipal.espesor2;
		case 3:    return MenuPrincipal.espesor3;
		default:   return MenuPrincipal.espesor4;
		}
	}
	
	//Obteniendo el contenido
	int contenido(int item) {
		switch(item) {
		case 0:    return MenuPrincipal.contenido0;
		case 1:    return MenuPrincipal.contenido1;
		case 2:    return MenuPrincipal.contenido2;
		case 3:    return MenuPrincipal.contenido3;
		default:   return MenuPrincipal.contenido4;
		}
	}
	
	//Mostrando los resultados 
	void mostrarResultado(double precio, double ancho, double largo, double espesor, int contenido) {
		txtPrecio.setText("" + precio);
		txtAncho.setText("" + ancho);
		txtLargo.setText("" + largo);
		txtEspesor.setText("" + espesor);
		txtContenido.setText("" + contenido);
	}
	
}
