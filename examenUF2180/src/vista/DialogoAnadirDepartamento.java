package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class DialogoAnadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoDpto;
	private JTextField txtNombre;
	private JTextField txtCodigoCentro;
	private final ButtonGroup grupoTipo = new ButtonGroup();
	private JRadioButton rdbtnPropiedad;
	private JSpinner spinnerPresupuesto;
	private Controlador controlador;
	private JRadioButton rdbtnFunciones;


	/**
	 * Create the dialog.
	 */
	public DialogoAnadirDepartamento() {
		setTitle("Insertar Departamento");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "Detalles del departamento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow][grow]", "[][][][][][][][][]"));
		
		
			JLabel lblNewLabel_6 = new JLabel("");
			lblNewLabel_6.setIcon(new ImageIcon(DialogoAnadirDepartamento.class.getResource("/images/editar32.png")));
			contentPanel.add(lblNewLabel_6, "cell 0 0 1 9");
		
		{
			JLabel lblNewLabel = new JLabel("Código:");
			contentPanel.add(lblNewLabel, "cell 1 0,alignx trailing");
		}
		{
			txtCodigoDpto = new JTextField();
			contentPanel.add(txtCodigoDpto, "cell 2 0 2 1,growx");
			txtCodigoDpto.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Centro:");
			contentPanel.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		}
		{
			txtCodigoCentro = new JTextField();
			contentPanel.add(txtCodigoCentro, "cell 2 2 2 1,growx");
			txtCodigoCentro.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Tipo Dirección:");
			contentPanel.add(lblNewLabel_2, "cell 1 4,alignx right");
		}
		{
			rdbtnPropiedad = new JRadioButton("Propiedad");
			rdbtnPropiedad.setActionCommand("P");
			rdbtnPropiedad.setSelected(true);
			grupoTipo.add(rdbtnPropiedad);
			contentPanel.add(rdbtnPropiedad, "cell 2 4");
		}
		{
			rdbtnFunciones = new JRadioButton("En funciones");
			rdbtnFunciones.setActionCommand("F");
			grupoTipo.add(rdbtnFunciones);
			contentPanel.add(rdbtnFunciones, "cell 3 4");
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Presupuesto:");
			contentPanel.add(lblNewLabel_3, "cell 1 6,alignx right");
		}
		{
			spinnerPresupuesto = new JSpinner();
			spinnerPresupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
			contentPanel.add(spinnerPresupuesto, "cell 2 6");
		}
		{
			JLabel lblNewLabel_5 = new JLabel("(en miles de euros)");
			contentPanel.add(lblNewLabel_5, "cell 3 6");
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Nombre:");
			contentPanel.add(lblNewLabel_4, "cell 1 8,alignx trailing");
		}
		{
			txtNombre = new JTextField();
			contentPanel.add(txtNombre, "cell 2 8 2 1,growx");
			txtNombre.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	protected void recogerDatos() {
		try {
			int codDepto = Integer.parseInt(txtCodigoDpto.getText());
			int codCentro = Integer.parseInt(txtCodigoCentro.getText());
			
			String tipoDir="F";
			if (rdbtnPropiedad.isSelected()) {
				tipoDir="P";
			}
			
//			String tipoDir2 = 
//					grupoTipo.getSelection().getActionCommand();
			int presupuesto = (int)spinnerPresupuesto.getValue();
			
			String nombre = txtNombre.getText();
			
			Departamento dpto = new Departamento(codDepto, codCentro,
					tipoDir, presupuesto, nombre);
			
			controlador.insertarDepartamento(dpto);
			
			JOptionPane.showMessageDialog(this, 
					"Departamento insertado correctamente", 
					"Información", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(false);
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, 
					"Debe rellenar todos los campos y colocar números"
					+ " correctos en el código departamento/centro", 
					"Error en los datos", JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(this,
					"Error al insertar. "+e.getMessage()+" "+
							e.getSQLState(), 
					"Error al insertar", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	public void vaciar() {
		txtCodigoDpto.setText("");
		txtCodigoCentro.setText("");
		spinnerPresupuesto.setValue(5);
		txtNombre.setText("");
		rdbtnPropiedad.setSelected(true);
		rdbtnFunciones.setSelected(false);
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
