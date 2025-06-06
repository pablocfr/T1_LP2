package pe.edu.cibertec.t1.swing;

import java.awt.EventQueue;


import pe.edu.cibertec.t1.entity.*;
import pe.edu.cibertec.t1.service.impl.*;
import pe.edu.cibertec.t1.service.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistroCertificacion extends JFrame {
	
	ClienteService clienteService = new ClienteServiceImpl();
	TipoauditoriaService tipoAuditoria = new TipoauditoriaServiceImpl();
	EspecialistaService especialistaService = new EspecialistaServiceImpl();
	CertificacionService certificacionService = new CertificacionServiceImpl();
	
	LocalDate fechaActual = LocalDate.now();

	// Convertir LocalDate a Date para fecha de emisión
	Date fechaEmision = Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant());

	// Calcular vencimiento con LocalDate
	LocalDate fechaVencimientoLocal = fechaActual.plusYears(1); 

	// Convertir LocalDate de vencimiento a Date
	Date fechaVencimiento = Date.from(fechaVencimientoLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());



	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JComboBox<Cliente> cboCliente;
	private JComboBox<Tipoauditoria> cboAuditoria;
	private JComboBox<Especialista> cboEspecialista;
	private JTextField txtEstado;
	private JTextArea textArea ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroCertificacion frame = new RegistroCertificacion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistroCertificacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		cboCliente = new JComboBox<>();
		cboCliente.setFont(new Font("Arial", Font.PLAIN, 11));
		cboCliente.setBounds(10, 36, 123, 22);
		contentPane.add(cboCliente);
		
		JLabel lblTipoDeAuditoria = new JLabel("Tipo de Auditoria");
		lblTipoDeAuditoria.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTipoDeAuditoria.setBounds(165, 11, 116, 14);
		contentPane.add(lblTipoDeAuditoria);
		
		cboAuditoria = new JComboBox<>();
		cboAuditoria.setFont(new Font("Arial", Font.PLAIN, 11));
		cboAuditoria.setBounds(158, 36, 123, 22);
		contentPane.add(cboAuditoria);
		
		JLabel lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEspecialista.setBounds(330, 11, 88, 14);
		contentPane.add(lblEspecialista);
		
		cboEspecialista = new JComboBox<>();
		cboEspecialista.setFont(new Font("Arial", Font.PLAIN, 11));
		cboEspecialista.setBounds(307, 36, 123, 22);
		contentPane.add(cboEspecialista);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grabar();
			}
		});
		btnRegistrar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnRegistrar.setBounds(179, 69, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(317, 69, 89, 23);
		contentPane.add(btnListar);
		
		textArea = new JTextArea();
		textArea.setEditable(false); // Opcional, si no quieres que el usuario edite
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 111, 563, 251); // Aplicamos el tamaño al scroll, no al textArea
		contentPane.add(scrollPane); // Agregamos el scrollPane, NO el textArea directamente


		
		txtEstado = new JTextField();
		txtEstado.setBounds(450, 36, 123, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		lblEstado.setBounds(489, 11, 46, 14);
		contentPane.add(lblEstado);
		
		llenarCombos();
	}
	
	void llenarCombos() {
		
		//COMBO BOX CLIENTES
		List<Cliente> clientes = clienteService.ListarTodo();
		
		DefaultComboBoxModel<Cliente> modelCli = new DefaultComboBoxModel<>(clientes.toArray(new Cliente[0]));
		cboCliente.setModel(modelCli);
		
		//COMBO BOX TIPO AUDITORIA
		List<Tipoauditoria> tipoauditoria = tipoAuditoria.ListarTodo();
				
		DefaultComboBoxModel<Tipoauditoria> modelTipo = new DefaultComboBoxModel<>(tipoauditoria.toArray(new Tipoauditoria[0]));
		cboAuditoria.setModel(modelTipo);
		
		//COMBO BOX ESPECIALISTA
		List<Especialista> especialistas = especialistaService.ListarTodo();
				
		DefaultComboBoxModel<Especialista> modelEspe = new DefaultComboBoxModel<>(especialistas.toArray(new Especialista[0]));
		cboEspecialista.setModel(modelEspe);
	}
	
	void grabar() {

	    String estado = txtEstado.getText().trim();
	    if (estado.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "El campo 'Estado' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    Cliente clienteSeleccionado = (Cliente) cboCliente.getSelectedItem();
	    if (clienteSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    Tipoauditoria auditoriaSeleccionada = (Tipoauditoria) cboAuditoria.getSelectedItem();
	    if (auditoriaSeleccionada == null) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de auditoría.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    Especialista especialistaSeleccionado = (Especialista) cboEspecialista.getSelectedItem();
	    if (especialistaSeleccionado == null) {
	        JOptionPane.showMessageDialog(null, "Debe seleccionar un especialista.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }

	    try {
	        Certificacion certi = new Certificacion();
	        certi.setEstado(estado);
	        certi.setFechaEmi(fechaEmision);
	        certi.setFechaVen(fechaVencimiento);
	        certi.setCliente(clienteSeleccionado);
	        certi.setTipoauditoria(auditoriaSeleccionada);
	        certi.setEspecialista(especialistaSeleccionado);

	        certificacionService.Crear(certi);

	        JOptionPane.showMessageDialog(null, "¡Certificación registrada con éxito al Cliente: " + certi.getCliente().getNombreEmpresa() + "!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	        
	        textArea.setText("");
  
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	void listar() {
		textArea.setText("");
		certificacionService.ListarTodo().forEach(c -> {
			textArea.append(imprimir(c));
		});
	}
	
	String imprimir(Certificacion certi) {
		return "N° Certificacion: " + certi.getIdCertificacion() + "\n" + "Cliente: " + certi.getCliente().getNombreEmpresa() + "\n" + 
				"Tipo Auditoria: " + certi.getTipoauditoria().getDescripcion() + "\n" + "Especialista: " + certi.getEspecialista().getNombre() + "\n" + 
				"Fecha Emisión: " + certi.getFechaEmi() + "\n" + "Estado Certificación: " + certi.getEstado() + "\n" + 
				"------------------------------------------------------------------\n";
	}
	
	
}
