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

import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VenderCeramico extends JDialog implements ActionListener, ItemListener  {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecio;
	private JTextField txtCantidad;
	private JScrollPane scrollPane;
	private JTextArea txtBoleta;
	private JButton btnCerrar;
	private JComboBox<String> cmbModelo;
	private JLabel lblCantidad;
	private JLabel lblPrecio;
	private JLabel lblModelo;

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
					VenderCeramico dialog = new VenderCeramico();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});		
	}
	
	//DECLARANDO LAS VARIABLES GLOBALES PARA EL JBUTTON VENDER
	double precioVenta, impCompra, impDescuento, impPagar;
	int cantidadVenta, cantidadObsequio;
	String nombreObsequio;
	private JButton btnVender;

	/**
	 * Create the dialog.
	 */
	public VenderCeramico() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VenderCeramico.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Vender Cer\u00E1mico");
		setBounds(100, 100, 495, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblModelo.setBounds(10, 21, 64, 14);
		contentPanel.add(lblModelo);
		
		
		cmbModelo = new JComboBox<String>();
		cmbModelo.addItemListener(this);
		cmbModelo.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbModelo.setModel(new DefaultComboBoxModel<String>(new String[] 
		{"Cinza Plus", "Luxury", "Austria", "Yungay Mix", "Thal\u00EDa"}));
		cmbModelo.setBounds(84, 11, 159, 34);
		contentPanel.add(cmbModelo);
		
		
		lblPrecio = new JLabel("Precio (S/)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(10, 70, 64, 14);
		contentPanel.add(lblPrecio);
		
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCantidad.setBounds(10, 116, 64, 14);
		contentPanel.add(lblCantidad);
		
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setBounds(84, 60, 159, 34);
		contentPanel.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(84, 106, 159, 34);
		contentPanel.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		
		btnVender = new JButton("Vender");
		btnVender.addActionListener(this);
		btnVender.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVender.setIcon(new ImageIcon(VenderCeramico.class.getResource("/gui/iconos/Money.png")));
		btnVender.setBounds(353, 11, 116, 34);
		contentPanel.add(btnVender);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setIcon(new ImageIcon(VenderCeramico.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(353, 60, 116, 34);
		contentPanel.add(btnCerrar);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 459, 284);
		contentPanel.add(scrollPane);
			
		txtBoleta = new JTextArea();
		txtBoleta.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtBoleta.setEditable(false);
		scrollPane.setViewportView(txtBoleta);
		
		//Cargando el precio al iniciar el JDialog
		txtPrecio.setText("" + MenuPrincipal.precio0);	
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnVender) {
			actionPerformedBtnVender(e);
		}
		
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbModelo) {
			itemStateChangedCmbModelo(e);
		}
	}
	
	protected void itemStateChangedCmbModelo(ItemEvent e) {
		//Cargando el valor del precio de acuerdo al comboBox modelo
		int item = cmbModelo.getSelectedIndex();
		txtPrecio.setText("" + precio(item));
	}
	
	//MÉTODO PARA TRAER EL PRECIO AL ELEGIR UN ITEM DEL JCOMBOBOX
	double precio(int item) {
		switch(item) {
		case 0:  return MenuPrincipal.precio0;
		case 1:  return MenuPrincipal.precio1;
		case 2:  return MenuPrincipal.precio2;
		case 3:  return MenuPrincipal.precio3;
		default: return MenuPrincipal.precio4;
		}
	}
	
	protected void actionPerformedBtnVender(ActionEvent e) {
		//Llamando a los métodos
		obtenerDatos();
		importeCompra();
		importeDescuento();
		importePagar();
		obtenerObsequio();
		numeroObsequio();
		mostrarResultados();
		contAcum();
		contAcumTotal();
		mostrarMensajePantalla();		
	}
	
	//MÉTODOS PARA CALCULAR LAS VENTAS AL PRESIONAR EL BOTÓN VENDER
	//Método para obtener los valores de las JTextField
	void obtenerDatos() {
		precioVenta = Double.parseDouble(txtPrecio.getText());
		cantidadVenta = Integer.parseInt(txtCantidad.getText());
	}
	
	//Método calcular importe de compra
	void importeCompra() {
		impCompra = precioVenta * cantidadVenta;
	}
	
	//Método para calcular importe de descuento
	void importeDescuento() {
		if (cantidadVenta >= 16)
			impDescuento = impCompra * MenuPrincipal.porcentaje4/100;
		
		else if (cantidadVenta >= 11)
			impDescuento = impCompra * MenuPrincipal.porcentaje3/100;
		
		else if (cantidadVenta >= 6)
			impDescuento = impCompra * MenuPrincipal.porcentaje2/100;
		
		else
			impDescuento = impCompra * MenuPrincipal.porcentaje1/100;	
	}
	
	//Metodo apra calcular importe a Pagar
	void importePagar() {
		impPagar = impCompra - impDescuento;
	}
	
	void obtenerObsequio() {
		nombreObsequio = MenuPrincipal.tipoObsequio; 
	}
	
	//Metodo para determinar el cantidad de obsequio
	void numeroObsequio() {
		if (cantidadVenta >= 11)
			cantidadObsequio = cantidadVenta * MenuPrincipal.obsequioCantidad3;
		
		else if (cantidadVenta >= 6)
			cantidadObsequio = cantidadVenta * MenuPrincipal.obsequioCantidad2;
		
		else
			cantidadObsequio = cantidadVenta * MenuPrincipal.obsequioCantidad1;
	}
	
	//Metodo para mostrar los resultados en el JtextArea
	void mostrarResultados() {
		//Creando el objeto formato1 tipo DecimalFormat que realizará el redondeo de los
		//valores a 2 decimales
		DecimalFormat formato1 = new DecimalFormat("0.00");
		
		//Mostrando el resultado de la venta en el txtArea
		txtBoleta.setText("");
		txtBoleta.append("BOLETA DE VENTA" + "\n\n");
		txtBoleta.append("Modelo : " + cmbModelo.getSelectedItem() + "\n");
		txtBoleta.append("Precio : S/. " + formato1.format(precioVenta) + "\n");
		txtBoleta.append("Cantidad Adquirida : " + cantidadVenta + "\n");
		txtBoleta.append("Importe compra : S/. " + formato1.format(impCompra) + "\n");
		txtBoleta.append("Importe Descuento : S/. " + formato1.format(impDescuento) + "\n");
		txtBoleta.append("Importe Pagar : S/. " + formato1.format(impPagar) + "\n");
		txtBoleta.append("Tipo de Obsequio : " + nombreObsequio + "\n");
		txtBoleta.append("Unidades Obsequiadas : " + cantidadObsequio + "unidades");
	}
	
	//METODO CALCULAR LOS CONTADORES Y ACUMULADORES POR MODELO
	void contAcum() {
		//Obteniendo el indice del elemento seleccionado
		int item = cmbModelo.getSelectedIndex();
		
		//Calulando los:
		// - contadores de cantidad de ventas y unidades vendidas por modelo
		// - acumuladores de importes pagados por modelo
		// - porcentajes de cuota diaria por modelo
		
		//Estos valores servirán para poder generar los reportes
		switch(item) {
		case 0:
			MenuPrincipal.contadorVenta0 ++;
			MenuPrincipal.importeAcumulado0 += impPagar;
			MenuPrincipal.porcentajeCuota0 = (MenuPrincipal.importeAcumulado0/MenuPrincipal.cuotaDiaria)*100;
			MenuPrincipal.cantUniVendidas0 += cantidadVenta;
			break;
			
		case 1:
			MenuPrincipal.contadorVenta1 ++;
			MenuPrincipal.importeAcumulado1 += impPagar;
			MenuPrincipal.porcentajeCuota1 = (MenuPrincipal.importeAcumulado1/MenuPrincipal.cuotaDiaria)*100;
			MenuPrincipal.cantUniVendidas1 += cantidadVenta;
			break;
			
		case 2:
			MenuPrincipal.contadorVenta2 ++;
			MenuPrincipal.importeAcumulado2 += impPagar;
			MenuPrincipal.porcentajeCuota2 = (MenuPrincipal.importeAcumulado2/MenuPrincipal.cuotaDiaria)*100;
			MenuPrincipal.cantUniVendidas2 += cantidadVenta;
			break;
			
		case 3:
			MenuPrincipal.contadorVenta3 ++;
			MenuPrincipal.importeAcumulado3 += impPagar;
			MenuPrincipal.porcentajeCuota3 = (MenuPrincipal.importeAcumulado3/MenuPrincipal.cuotaDiaria)*100;
			MenuPrincipal.cantUniVendidas3 += cantidadVenta;
			break;
			
		default:
			MenuPrincipal.contadorVenta4 ++;
			MenuPrincipal.importeAcumulado4 += impPagar;
			MenuPrincipal.porcentajeCuota4 = (MenuPrincipal.importeAcumulado4/MenuPrincipal.cuotaDiaria)*100;
			MenuPrincipal.cantUniVendidas4 += cantidadVenta;
		}
	}
	
	//MÉTODO CALCULAR LOS CONTADORES Y ACUMULADORES TOTALES
	//Se usarán para mostrar el aviso cada 5 ventas
	void contAcumTotal() {
		MenuPrincipal.contadorVentaTotal ++;
		MenuPrincipal.importeAcumuladoTotal += impPagar;
		MenuPrincipal.porcentajeCuotaTotal += (impPagar/MenuPrincipal.cuotaDiaria)*100;
	}
	
	//METODO MOSTRAR MENSAJE EN PANTALLA CADA 5 VENTAS
	void mostrarMensajePantalla() {
		//Verificando si la cantidad de ventas acumuladas es multiplo de 5
		if (MenuPrincipal.contadorVentaTotal % 5 == 0) {
			JOptionPane.showInternalMessageDialog(null, "Venta Nro. 5" + 
		    MenuPrincipal.contadorVentaTotal + "\n" + "Importe total general acumulado: S/." + 
			Math.round(MenuPrincipal.importeAcumuladoTotal*100.0)/100.0 + "\n" + "Porcentaje de la cuota diaria: " +
		    Math.round(MenuPrincipal.porcentajeCuotaTotal*100.0)/100.0 + "%", "Avance de Ventas" , 1, null);	
		}
	}		
}
