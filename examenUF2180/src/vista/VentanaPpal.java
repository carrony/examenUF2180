package vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPpal extends JFrame {

	private JPanel contentPane;
	private Controlador controlador;

	/**
	 * Create the frame.
	 */
	public VentanaPpal() {
		setTitle("Gesti\u00F3n de Empresas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][20.00,grow][][grow]", "[grow][grow][grow]"));
		
		JPanel panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gesti\u00F3n de Centros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder)  panel.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(panel, "cell 1 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[::100px,grow][27.00,grow][::100px,grow]"));
		
		JButton btnNewButton = new JButton("Ver Centros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListarCentros();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton, "cell 0 0,grow");
		btnNewButton.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/tabla32.png")));
		
		JButton btnNewButton_1 = new JButton("Nuevo Centro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarInsertarCentros();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(btnNewButton_1, "cell 0 2,growy");
		btnNewButton_1.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/a\u00F1adir32.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gesti\u00F3n de Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((TitledBorder)  panel_1.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(panel_1, "cell 3 1,grow");
		panel_1.setLayout(new MigLayout("", "[]", "[::100px,grow][36.00,grow][::100px,grow]"));
		
		JButton btnNewButton_2 = new JButton("Ver Departamentos");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarListarDepartamentos();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButton_2, "cell 0 0,grow");
		btnNewButton_2.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/tabla32.png")));
		
		JButton btnNewButton_3 = new JButton("Nuevo Departamento ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarInsertarDepartamentos();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnNewButton_3, "cell 0 2,growy");
		btnNewButton_3.setIcon(new ImageIcon(VentanaPpal.class.getResource("/images/a\u00F1adir32.png")));
	}

	public void setControlador(Controlador controlador) {
		this.controlador=controlador;	
	}

}
