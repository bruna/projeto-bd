package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("MiniSiga UFRPE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewAluno().setVisible(true);
			}
		});
		btnAluno.setBounds(10, 107, 89, 23);
		contentPane.add(btnAluno);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewDisciplina().setVisible(true);
			}
		});
		btnDisciplina.setBounds(109, 107, 89, 23);
		contentPane.add(btnDisciplina);
		
		JButton btnLivro = new JButton("Livro");
		btnLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewLivro().setVisible(true);	
			}
		});
		btnLivro.setBounds(303, 107, 89, 23);
		contentPane.add(btnLivro);
		
		JLabel lblEscolhaATabela = new JLabel("Escolha a tabela que deseja acessar");
		lblEscolhaATabela.setBounds(10, 37, 438, 23);
		contentPane.add(lblEscolhaATabela);
		
		JButton btnMatricula = new JButton("Matrícula");
		btnMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMatricula().setVisible(true);	
			}
		});
		btnMatricula.setBounds(204, 107, 89, 23);
		contentPane.add(btnMatricula);
		
		JButton btnLivroAdotado = new JButton("Livro Adotado");
		btnLivroAdotado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewLivroAdotado().setVisible(true);	
			}
		});
		btnLivroAdotado.setBounds(401, 107, 122, 23);
		contentPane.add(btnLivroAdotado);
	}
}
