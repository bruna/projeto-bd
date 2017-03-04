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

import model.bean.Aluno;
import model.bean.Disciplina;
import model.dao.AlunoDAO;
import model.dao.DisciplinaDAO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewDisciplina extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumDiscipl;
	private JTextField txtDNome;
	private JTextField txtDepto;
	private JTable jTProduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDisciplina frame = new ViewDisciplina();
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
	public ViewDisciplina() {
		setTitle("Tabela Disciplina");
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
				Object[] dados = {txtNumDiscipl.getText(),txtDNome.getText(),txtDepto.getText()};
				dtmProdutos.addRow(dados);*/
				
				Disciplina d = new Disciplina();
				DisciplinaDAO ddao = new DisciplinaDAO();
				d.setNumDiscipl(txtNumDiscipl.getText());
				d.setDnome(txtDNome.getText());
				d.setDepto(txtDepto.getText());
				
				ddao.create(d);
				
				txtNumDiscipl.setText("");
				txtDNome.setText("");
				txtDepto.setText("");
				
				readJTable();
			}
		});
		btnNewButton.setBounds(33, 114, 117, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NumDiscipl");
		lblNewLabel.setBounds(20, 11, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblQtd = new JLabel("DNome");
		lblQtd.setBounds(162, 11, 46, 14);
		panel.add(lblQtd);
		
		JLabel lblNewLabel_1 = new JLabel("Depto");
		lblNewLabel_1.setBounds(304, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtNumDiscipl = new JTextField();
		txtNumDiscipl.setBounds(10, 36, 130, 20);
		panel.add(txtNumDiscipl);
		txtNumDiscipl.setColumns(10);
		
		txtDNome = new JTextField();
		txtDNome.setBounds(162, 36, 122, 20);
		panel.add(txtDNome);
		txtDNome.setColumns(10);
		
		txtDepto = new JTextField();
		txtDepto.setBounds(304, 36, 130, 20);
		panel.add(txtDepto);
		txtDepto.setColumns(10);
		
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
					
					Disciplina d = new Disciplina();
					DisciplinaDAO ddao = new DisciplinaDAO();
					
					d.setNumDiscipl(txtNumDiscipl.getText());
					d.setDnome(txtDNome.getText());
					d.setDepto(txtDepto.getText());
					
					ddao.update(d);
					
					txtNumDiscipl.setText("");
					txtDNome.setText("");
					txtDepto.setText("");
					
					readJTable();
					
				}else{
					JOptionPane.showMessageDialog(null, "Selecione uma disciplina para atualizar");
				}
				
			}
		});
		btnAtualizar.setBounds(364, 114, 89, 23);
		panel.add(btnAtualizar);
		
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
				txtNumDiscipl.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 0).toString());
				txtDNome.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 1).toString());
				txtDepto.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 2).toString());
			}
		});
		scrollPane.setViewportView(jTProduto);
		jTProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NumDiscipl", "Dnome", "Depto"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
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
		DisciplinaDAO ddao = new DisciplinaDAO();
		
		for(Disciplina d:ddao.read()){
			
			modelo.addRow(new Object[]{
					d.getNumDiscipl(),
					d.getDnome(),
					d.getDepto()
			});
			
		}
		
	}
}
