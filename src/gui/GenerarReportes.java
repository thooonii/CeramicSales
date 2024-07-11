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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.text.DecimalFormat;


public class GenerarReportes extends JDialog implements ActionListener, ItemListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextArea txtReporte;
	private JScrollPane scrollPane;
	private JLabel lblReporte;
	private JComboBox<String> cmbTipoReporte;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarReportes dialog = new GenerarReportes();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//VARIABLE GLOBAL PARA JCOMBOBOX TIPO REPORTE
	//Variable que captura el indice del item selccionado en el JcomboBox
	int item;
	
	//Variables que guardan los valores de las variables globales 
	//Public Static del MenuPrincipal:
	String modelo0 = MenuPrincipal.modelo0, modelo1 = MenuPrincipal.modelo1, modelo2 = MenuPrincipal.modelo2, modelo3 = MenuPrincipal.modelo3, modelo4 = MenuPrincipal.modelo4;
	int cantVentas0 = MenuPrincipal.contadorVenta0, cantVentas1 = MenuPrincipal.contadorVenta1, cantVentas2 = MenuPrincipal.contadorVenta2, cantVentas3 = MenuPrincipal.contadorVenta3, cantVentas4 = MenuPrincipal.contadorVenta4;
	int unidVendidas0 = MenuPrincipal.cantUniVendidas0, unidVendidas1 = MenuPrincipal.cantUniVendidas1, unidVendidas2 = MenuPrincipal.cantUniVendidas2, unidVendidas3 = MenuPrincipal.cantUniVendidas3, unidVendidas4 = MenuPrincipal.cantUniVendidas4;
	double impAcum0 = MenuPrincipal.importeAcumulado0, impAcum1 = MenuPrincipal.importeAcumulado1, impAcum2 = MenuPrincipal.importeAcumulado2, impAcum3 = MenuPrincipal.importeAcumulado3, impAcum4 = MenuPrincipal.importeAcumulado4;
	double porCuota0 = MenuPrincipal.porcentajeCuota0, porCuota1 = MenuPrincipal.porcentajeCuota1, porCuota2= MenuPrincipal.porcentajeCuota2, porCuota3 = MenuPrincipal.porcentajeCuota3, porCuota4 = MenuPrincipal.porcentajeCuota4;
	int cantOptima = MenuPrincipal.cantidadOptima;
	double precio0 = MenuPrincipal.precio0, precio1 = MenuPrincipal.precio1, precio2 = MenuPrincipal.precio2, precio3 = MenuPrincipal.precio3, precio4 = MenuPrincipal.precio4;
	
	//Calculando variables globales precioPromedio
	double precioPromedio = (precio0 + precio1 + precio2 + precio3 + precio4)/5;
	
	//Creando el objeto formato1 tipo DecimalFormat que realizará 
	//el redondeo de los valores a 2 decimales
	DecimalFormat formato1 = new DecimalFormat("0.00");
	
	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GenerarReportes.class.getResource("/gui/iconos/1613243.png")));
		setTitle("Generar Reportes");
		setBounds(100, 100, 685, 380);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(100, 149, 237));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(0);
		contentPanel.setLayout(null);
		
		lblReporte = new JLabel("Tipo de reporte");
		lblReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReporte.setBounds(10, 16, 95, 14);
		contentPanel.add(lblReporte);
		
		
		cmbTipoReporte = new JComboBox<String>();
		cmbTipoReporte.addItemListener(this);
		cmbTipoReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		cmbTipoReporte.setModel(new DefaultComboBoxModel<String>(new String[]
		{"Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio ", "Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
		cmbTipoReporte.setBounds(115, 7, 346, 33);
		contentPanel.add(cmbTipoReporte);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCerrar.setIcon(new ImageIcon(GenerarReportes.class.getResource("/gui/iconos/Delete.png")));
		btnCerrar.setBounds(558, 7, 101, 33);
		contentPanel.add(btnCerrar);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 51, 649, 282);
		contentPanel.add(scrollPane);
			
		txtReporte = new JTextArea();
		txtReporte.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtReporte.setEditable(false);
		scrollPane.setViewportView(txtReporte);
		
		//MOSTRANDO EL PRIMER REPORTE EN EL TXTAREA (REPORTE DEL ITEM 0 DEL JCOMBOBOX)
		reportePorModelo();					
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
		actionPerformedBtnCerrar(e);
		}
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cmbTipoReporte) {
		itemStateChangedCmbTipoReporte(e);
		}
	}
	
	protected void itemStateChangedCmbTipoReporte(ItemEvent e) {
		//Llamando al Metodo
		obtenerTipoReporte();
	}
	
	//METODOS PARA EL JCOMBOBOX TIPO REPORTE
	void obtenerTipoReporte() {
		
		//Capturando el indice del elemento seleccionado en el JcomboBox
		item = cmbTipoReporte.getSelectedIndex();
		
		//Obteniendo el reporte de acuerdo al item seleccionado
		switch(item) {
		case 0:
			//Llamando al Metodo
			reportePorModelo();
			break;
			
		case 1:
			//Llamando al Metodo
			reportePrecioPromedio();
			break;
			
		case 2:
			//Llamando al Metodo
			reporteVentaOptima();
			break;
			
		default:
			//Llamando al Metodo
			reportePrecioMenoresMayores();
			
		}
		
		//colocando el cursor en la posicion 0 del JtextArea para que muestre la primera
		//linea de los reportes
		txtReporte.setCaretPosition(0);
	}
	
	//METODO REPORTE VENTAS POR MODELO POR MODELO
	void reportePorModelo() {
		//Imprimir título del reporte generado
		txtReporte.setText("VENTAS POR MODELO \n\n");
		
		//Imprimiendo listado del reporte por modelo
		txtReporte.append("Modelo                        : " + modelo0 + "\n");
		txtReporte.append("Cantidad de Ventas            : " + cantVentas0 + "\n");
		txtReporte.append("Cantidad de unidades vendidas : " + unidVendidas0 + "\n");
		txtReporte.append("Importe total vendido         : S/. " + formato1.format(impAcum0) + "\n");
		txtReporte.append("Aporte a la cuota diaria      : " + formato1.format(porCuota0) + "%" + "\n\n");
		
		txtReporte.append("Modelo                        : " + modelo1 + "\n");
		txtReporte.append("Cantidad de Ventas            : " + cantVentas1 + "\n");
		txtReporte.append("Cantidad de unidades vendidas : " + unidVendidas1 + "\n");
		txtReporte.append("Importe total vendido         : S/. " + formato1.format(impAcum1) + "\n");
		txtReporte.append("Aporte a la cuota diaria      : " + formato1.format(porCuota1) + "%" + "\n\n");
		
		txtReporte.append("Modelo                        : " + modelo2 + "\n");
		txtReporte.append("Cantidad de Ventas            : " + cantVentas2 + "\n");
		txtReporte.append("Cantidad de unidades vendidas : " + unidVendidas2 + "\n");
		txtReporte.append("Importe total vendido         : S/. " + formato1.format(impAcum2) + "\n");
		txtReporte.append("Aporte a la cuota diaria      : " + formato1.format(porCuota2) + "%" + "\n\n");
		
		txtReporte.append("Modelo                        : " + modelo3 + "\n");
		txtReporte.append("Cantidad de Ventas            : " + cantVentas3 + "\n");
		txtReporte.append("Cantidad de unidades vendidas : " + unidVendidas3 + "\n");
		txtReporte.append("Importe total vendido         : S/. " + formato1.format(impAcum3) + "\n");
		txtReporte.append("Aporte a la cuota diaria      : " + formato1.format(porCuota3) + "%" + "\n\n");
		
		txtReporte.append("Modelo                        : " + modelo4 + "\n");
		txtReporte.append("Cantidad de Ventas            : " + cantVentas4 + "\n");
		txtReporte.append("Cantidad de unidades vendidas : " + unidVendidas4 + "\n");
		txtReporte.append("Importe total vendido         : S/. " + formato1.format(impAcum4) + "\n");
		txtReporte.append("Aporte a la cuota diaria      : " + formato1.format(porCuota4) + "%" + "\n\n");
		
		//Colocando el cursor en la posicion 0 del JtextArea para que muestre la primera
		//linea del reporte
		txtReporte.setCaretPosition(0);
	}
	
		//MÉTODO REPORTE EN RELACIÓN AL PRECIO PROMEDIO
		void reportePrecioPromedio() {
			//Imprimir tÍtulo del reporte generado
			txtReporte.setText("PRECIO EN RELACIÓN AL PRECIO PROMEDIO" + "\n\n");
			
			//Imprimiendo el listado por modelo
			//Modelo0
			txtReporte.append("Modelo : " + modelo0 + "\n");
			int i = 0;
			while (i < 5) {
			    String modelo = "";
			    double precio = 0.0;
			    
			    switch (i) {
			    		//modelo0
			        case 0:
			            modelo = modelo0;
			            precio = precio0;
			            break;
			            //modelo1 
			        case 1:
			            modelo = modelo1;
			            precio = precio1;
			            break;
			            //modelo2
			        case 2:
			            modelo = modelo2;
			            precio = precio2;
			            break;
			            //modelo3
			        case 3:
			            modelo = modelo3;
			            precio = precio3;
			            break;
			            //modelo4
			        case 4:
			            modelo = modelo4;
			            precio = precio4;
		            default:
		                break;      
			    }
			    
			    //genera el precio en relacion al promedio
			    //dependiendo del modelo y precio asignado en la estructura switch
			    txtReporte.append("Modelo: " + modelo + "\n");
			    if (precio < precioPromedio)
			        txtReporte.append("Precio: S/. " + precio + " (Menor al Promedio)\n\n");
			    else if (precio > precioPromedio)
			        txtReporte.append("Precio: S/. " + precio + " (Mayor al Promedio)\n\n");
			    else
			        txtReporte.append("Precio: S/. " + precio + " (Igual al Promedio)\n\n");
			    
			    i++;
			}
		}

		
		//MÉTODO REPORTE VENTAS EN RELACIÓN A LA VENTA ÓPTIMA
		void reporteVentaOptima() {
		    // Imprimir título del reporte generado
		    txtReporte.setText("VENTAS EN RELACIÓN A LA VENTA ÓPTIMA" + "\n\n");

		    int i = 0;
		    while (i < 5) {
		        String modelo = "";
		        int unidadesVendidas = 0;

		        switch (i) {
		        		//modelo0
		            case 0:
		                modelo = modelo0;
		                unidadesVendidas = unidVendidas0;
		                break;
		                //modelo1
		            case 1:
		                modelo = modelo1;
		                unidadesVendidas = unidVendidas1;
		                break;
		                //modelo2
		            case 2:
		                modelo = modelo2;
		                unidadesVendidas = unidVendidas2;
		                break;
		                //modelo3
		            case 3:
		                modelo = modelo3;
		                unidadesVendidas = unidVendidas3;
		                break;
		                //modelo4
		            case 4:
		                modelo = modelo4;
		                unidadesVendidas = unidVendidas4;
		                break;
		            default:
		                break;
		        }
		        //genera el texto reporte de ventas optimas en
		        //relacion a la venta optima dependiendo el modelo y unidades vendidas
		        //asignadas en la estructura switch
		        txtReporte.append("Modelo: " + modelo + "\n");
		        int diferencia = unidadesVendidas - cantOptima;

		        if (diferencia < 0)
		            txtReporte.append("Cantidad de unidades vendidas: " + unidadesVendidas + " (" + Math.abs(diferencia) + " menos que la cantidad óptima)" + "\n\n");
		        else if (diferencia > 0)
		            txtReporte.append("Cantidad de unidades vendidas: " + unidadesVendidas + " (" + diferencia + " más que la cantidad óptima)" + "\n\n");
		        else
		            txtReporte.append("Cantidad de unidades vendidas: " + unidadesVendidas + " (igual a la cantidad óptima)" + "\n\n");

		        i++;
		    }
		}

		//MÉTODO REPORTE PRECIOS, MENORES Y MAYORES
		void reportePrecioMenoresMayores() {
		    // Imprimir título del reporte generado
		    txtReporte.setText("PRECIOS, MENORES Y MAYORES" + "\n\n");
		    txtReporte.append("Precio Promedio : S/. " + formato1.format(precioPromedio) + "\n");

		    double menorPrecio = Double.MAX_VALUE;
		    double mayorPrecio = Double.MIN_VALUE;

		    int i = 0;
		    while (i < 5) {
		        double precio = 0;

		        switch (i) {
		        		//precio0
		            case 0:
		                precio = precio0;
		                break;
		                //precio1
		            case 1:
		                precio = precio1;
		                break;
		                //precio2
		            case 2:
		                precio = precio2;
		                break;
		                //precio3
		            case 3:
		                precio = precio3;
		                break;
		                //precio4
		            case 4:
		                precio = precio4;
		                break;
		            default:
		                break;
		        }

		        if (precio < menorPrecio) {
		            menorPrecio = precio;
		        }

		        if (precio > mayorPrecio) {
		            mayorPrecio = precio;
		        }

		        i++;
		    }

		    // Imprimir el precio menor y mayor
		    txtReporte.append("Precio menor : S/. " + menorPrecio + "\n");
		    txtReporte.append("Precio mayor : S/. " + mayorPrecio + "\n\n");
		}
	
}
