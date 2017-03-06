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
import model.bean.Livro;
import model.bean.LivroAdotado;
import model.dao.AlunoDAO;
import model.dao.DisciplinaDAO;
import model.dao.LivroAdotadoDAO;
import model.dao.LivroDAO;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtISBNLivro;
	private JTextField txtTituloLivro;
	private JTextField txtEditora;
	private JTable jTProduto;
	private JTextField txtEdicao;
	private JTextField txtAutor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewLivro frame = new ViewLivro();
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
	public ViewLivro() {
		setTitle("Tabela Livro");
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
				
				
				Livro l = new Livro();
				LivroDAO ldao = new LivroDAO();
				l.setISBNLivro(txtISBNLivro.getText());
				l.setTituloLivro(txtTituloLivro.getText());
				l.setEditora(txtEditora.getText());
				l.setEdicao(txtEdicao.getText());
				l.setAutor(txtAutor.getText());
				
				ldao.create(l);
				
				txtISBNLivro.setText("");
				txtTituloLivro.setText("");
				txtEditora.setText("");
				txtEdicao.setText("");
				txtAutor.setText("");
				
				readJTable();
			}
		});
		btnNewButton.setBounds(33, 114, 117, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ISBNLivro");
		lblNewLabel.setBounds(20, 11, 84, 14);
		panel.add(lblNewLabel);
		
		JLabel lblQtd = new JLabel("TituloLivro");
		lblQtd.setBounds(162, 11, 72, 14);
		panel.add(lblQtd);
		
		JLabel lblNewLabel_1 = new JLabel("Editora");
		lblNewLabel_1.setBounds(304, 11, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtISBNLivro = new JTextField();
		txtISBNLivro.setBounds(10, 36, 130, 20);
		panel.add(txtISBNLivro);
		txtISBNLivro.setColumns(10);
		
		txtTituloLivro = new JTextField();
		txtTituloLivro.setBounds(162, 36, 122, 20);
		panel.add(txtTituloLivro);
		txtTituloLivro.setColumns(10);
		
		txtEditora = new JTextField();
		txtEditora.setBounds(304, 36, 130, 20);
		panel.add(txtEditora);
		txtEditora.setColumns(10);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(jTProduto.getSelectedRow()!= -1){
					
					Livro l = new Livro();
					LivroDAO ldao = new LivroDAO();

					l.setISBNLivro(txtISBNLivro.getText());

					ldao.delete(l);

					txtISBNLivro.setText("");
					txtTituloLivro.setText("");
					txtEditora.setText("");
					txtEdicao.setText("");
					txtAutor.setText("");

					readJTable();
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
					Livro l = new Livro();
					LivroDAO ldao = new LivroDAO();
					
					l.setISBNLivro(txtISBNLivro.getText());
					l.setTituloLivro(txtTituloLivro.getText());
					l.setEditora(txtEditora.getText());
					l.setEdicao(txtEdicao.getText());
					l.setAutor(txtAutor.getText());
					
					ldao.update(l);
					
					txtISBNLivro.setText("");
					txtTituloLivro.setText("");
					txtEditora.setText("");
					txtEdicao.setText("");
					txtAutor.setText("");
					
					readJTable();
					
				}else{
					JOptionPane.showMessageDialog(null, "Selecione um livro para atualizar");
				}
				
				
			}
		});
		btnAtualizar.setBounds(364, 114, 89, 23);
		panel.add(btnAtualizar);
		
		JLabel lblNota = new JLabel("Edi\u00E7\u00E3o");
		lblNota.setBounds(467, 11, 46, 14);
		panel.add(lblNota);
		
		txtEdicao = new JTextField();
		txtEdicao.setBounds(467, 36, 33, 20);
		panel.add(txtEdicao);
		txtEdicao.setColumns(10);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(537, 11, 46, 14);
		panel.add(lblAutor);
		
		txtAutor = new JTextField();
		txtAutor.setBounds(537, 36, 110, 20);
		panel.add(txtAutor);
		txtAutor.setColumns(10);
		
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
				txtISBNLivro.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 0).toString());
				txtTituloLivro.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 1).toString());
				txtEditora.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 2).toString());
				txtEdicao.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 3).toString());
				txtAutor.setText(jTProduto.getValueAt(jTProduto.getSelectedRow(), 4).toString());
			}
		});
		scrollPane.setViewportView(jTProduto);
		jTProduto.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ISBNLivro", "TituloLivro", "Editora", "Edi\u00E7\u00E3o", "Autor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, true, true
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
		LivroDAO ldao = new LivroDAO();
		
		for(Livro l:ldao.read()){
			
			modelo.addRow(new Object[]{
					l.getISBNLivro(),
					l.getTituloLivro(),
					l.getEditora(),
					l.getEdicao(),
					l.getAutor()
			});
			
		}
		
	}
}
