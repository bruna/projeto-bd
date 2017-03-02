package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import model.bean.Matricula;
import model.dao.MatriculaDAO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMatricula extends JFrame {

	private JPanel contentPane;
	private JTextField txtCPF;
	private JTextField txtDNumDiscipl;
	private JTextField txtSemestre;
	private JTable jTProduto;
	private JTextField txtNota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMatricula frame = new ViewMatricula();
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
	public ViewMatricula() {
		setTitle("Tabela Matricula");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 806, 532);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 770, 161);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*DefaultTableModel dtmProdutos = (DefaultTableModel)jTProduto.getModel();
				Object[] dados = {txtCPF.getText(),txtDNumDiscipl.getText(),txtSemestre.getText(),txtNota.getText()};
				dtmProdutos.addRow(dados);*/
				
				Matricula m = new Matricula();
				MatriculaDAO mdao = new MatriculaDAO();
				m.setCPF(txtCPF.getText());
				m.setNumDiscipl(txtDNumDiscipl.getText());
				m.setSemestre(txtSemestre.getText());
				m.setNota(txtNota.getText());
				
				mdao.create(m);
								
				readJTable();
			}
		});
		btnNewButton.setBounds(33, 114, 117, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("CPF");
		lblNewLabel.setBounds(20, 11, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblQtd = new JLabel("NumDiscipl");
		lblQtd.setBounds(162, 11, 72, 14);
		panel.add(lblQtd);
		
		JLabel lblNewLabel_1 = new JLabel("Semestre");
		lblNewLabel_1.setBounds(304, 11, 55, 14);
		panel.add(lblNewLabel_1);
		
		txtCPF = new JTextField();
		txtCPF.setBounds(10, 36, 130, 20);
		panel.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtDNumDiscipl = new JTextField();
		txtDNumDiscipl.setBounds(162, 36, 122, 20);
		panel.add(txtDNumDiscipl);
		txtDNumDiscipl.setColumns(10);
		
		txtSemestre = new JTextField();
		txtSemestre.setBounds(304, 36, 130, 20);
		panel.add(txtSemestre);
		txtSemestre.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(jTProduto.getSelectedRow()!= -1){
					DefaultTableModel dtmProdutos = (DefaultTableModel)jTProduto.getModel();
					dtmProdutos.removeRow(jTProduto.getSelectedRow());
					//System.out.println("Linha selecionada: "+jTProduto.getSelectedRow());
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um produto para excluir");
				}
				
				
	
			}
		});
		btnExcluir.setBounds(206, 114, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnAtualizar = new JButton("Atualizar");
		
		
		
		
		btnAtualizar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(jTProduto.getSelectedRow()!=-1){
					JOptionPane.showMessageDialog(null, "Atenção ao alterar os dados");
					
					jTProduto.setValueAt(txtCPF.getText(), jTProduto.getSelectedRow(), 0);
					jTProduto.setValueAt(txtDNumDiscipl.getText(), jTProduto.getSelectedRow(), 1);
					jTProduto.setValueAt(txtSemestre.getText(), jTProduto.getSelectedRow(), 2);
					jTProduto.setValueAt(txtNota.getText(), jTProduto.getSelectedRow(), 3);
					
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar");
				}
				
				
			}
		});
		btnAtualizar.setBounds(364, 114, 89, 23);
		panel.add(btnAtualizar);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(473, 11, 46, 14);
		panel.add(lblNota);
		
		txtNota = new JTextField();
		txtNota.setBounds(467, 36, 86, 20);
		panel.add(txtNota);
		txtNota.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 183, 770, 299);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 770, 299);
		panel_1.add(scrollPane);
		
		jTProduto = new JTable();
		jTProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCPF.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 0).toString());
				txtDNumDiscipl.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 1).toString());
				txtSemestre.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 2).toString());
				txtNota.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 3).toString());
			}
		});
		scrollPane.setViewportView(jTProduto);
		jTProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CPF", "NumDiscipl", "Semestre", "Nota"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		DefaultTableModel modelo = (DefaultTableModel) jTProduto.getModel();
		jTProduto.setRowSorter(new TableRowSorter<TableModel>(modelo));
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jTProduto.getModel();
		modelo.setNumRows(0);
		MatriculaDAO mdao = new MatriculaDAO();
		
		for(Matricula m:mdao.read()){
			
			modelo.addRow(new Object[]{
					m.getCPF(),
					m.getNumDiscipl(),
					m.getSemestre(),
					m.getNota()
			});
			
		}
		
	}
}
