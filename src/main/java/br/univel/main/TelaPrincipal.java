package br.univel.main;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import br.univel.EJBClient.RemoteEJBClient;
import br.univel.bicho.Bicho;
import br.univel.dao.bichoDao;
import java.awt.Font;
import java.awt.event.KeyAdapter;


public class TelaPrincipal extends JFrame implements Serializable {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEspecie;
	private JTextField txtDono;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnExcluir;
	private JButton btnEdit;
	private JButton btnNovo;
	private int editID;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JLabel lblCadastro;
	
	private bichoDao dao;
	private bichoModel bichoModel;
	private Bicho selecaoBicho;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 217, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 37, 37, 37, 37, 0, 40, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);
		
		lblCadastro = new JLabel("Cadastro de Animais");
		lblCadastro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCadastro = new GridBagConstraints();
		gbc_lblCadastro.gridwidth = 5;
		gbc_lblCadastro.insets = new Insets(0, 0, 5, 5);
		gbc_lblCadastro.gridx = 0;
		gbc_lblCadastro.gridy = 0;
		contentPane.add(lblCadastro, gbc_lblCadastro);

		JLabel lblNome = new JLabel("Nome:");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.insets = new Insets(0, 0, 5, 5);
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		contentPane.add(lblNome, gbc_lblNome);

		txtNome = new JTextField();
		GridBagConstraints gbc_txtNome = new GridBagConstraints();
		gbc_txtNome.gridwidth = 4;
		gbc_txtNome.insets = new Insets(0, 0, 5, 0);
		gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNome.gridx = 1;
		gbc_txtNome.gridy = 1;
		contentPane.add(txtNome, gbc_txtNome);
		txtNome.setColumns(10);

		JLabel lblEspcie = new JLabel("Espécie:");
		GridBagConstraints gbc_lblEspcie = new GridBagConstraints();
		gbc_lblEspcie.anchor = GridBagConstraints.EAST;
		gbc_lblEspcie.insets = new Insets(0, 0, 5, 5);
		gbc_lblEspcie.gridx = 0;
		gbc_lblEspcie.gridy = 2;
		contentPane.add(lblEspcie, gbc_lblEspcie);

		txtEspecie = new JTextField();
		GridBagConstraints gbc_txtEspecie = new GridBagConstraints();
		gbc_txtEspecie.gridwidth = 4;
		gbc_txtEspecie.insets = new Insets(0, 0, 5, 0);
		gbc_txtEspecie.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEspecie.gridx = 1;
		gbc_txtEspecie.gridy = 2;
		contentPane.add(txtEspecie, gbc_txtEspecie);
		txtEspecie.setColumns(10);

		JLabel lblDono = new JLabel("Dono:");
		GridBagConstraints gbc_lblDono = new GridBagConstraints();
		gbc_lblDono.anchor = GridBagConstraints.EAST;
		gbc_lblDono.insets = new Insets(0, 0, 5, 5);
		gbc_lblDono.gridx = 0;
		gbc_lblDono.gridy = 3;
		contentPane.add(lblDono, gbc_lblDono);

		txtDono = new JTextField();
		GridBagConstraints gbc_txtDono = new GridBagConstraints();
		gbc_txtDono.gridwidth = 4;
		gbc_txtDono.insets = new Insets(0, 0, 5, 0);
		gbc_txtDono.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDono.gridx = 1;
		gbc_txtDono.gridy = 3;
		contentPane.add(txtDono, gbc_txtDono);
		txtDono.setColumns(10);
		
		lblEmail = new JLabel("Email Dono:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 4;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 4;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		btnNovo = new JButton("Novo");
		btnNovo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				
				if (ke.getKeyCode() == KeyEvent.VK_ENTER) {

					NovoCadastro();
					txtNome.requestFocus();
					txtEspecie.requestFocus();
					txtDono.requestFocus();
					txtEmail.requestFocus();
				}
			}
		});
		btnNovo.setMnemonic(KeyEvent.VK_N);
		
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				NovoCadastro();
			}
		});
		GridBagConstraints gbc_btnNovo = new GridBagConstraints();
		gbc_btnNovo.fill = GridBagConstraints.VERTICAL;
		gbc_btnNovo.insets = new Insets(0, 0, 0, 5);
		gbc_btnNovo.gridx = 2;
		gbc_btnNovo.gridy = 6;
		contentPane.add(btnNovo, gbc_btnNovo);

		btnEdit = new JButton("Editar");
		btnEdit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				txtNome.requestFocus();
			}
		});
		btnEdit.setMnemonic(KeyEvent.VK_E);
		btnEdit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				editar();

			}

			private void editar() {
				try {
					editID = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(TelaPrincipal.this, "Por gentileza, selecionar um registro para edição", "Atenção!!",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				Bicho animalEditar = dao.pegarPorID(editID);

				txtNome.setText(animalEditar.getNome());
				txtEspecie.setText(animalEditar.getEspecie());
				txtDono.setText(animalEditar.getDono());
				txtEmail.setText(animalEditar.getEmailDono());

				selecaoBicho = animalEditar;
			}
		});
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.VERTICAL;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 3;
		gbc_btnEdit.gridy = 6;
		contentPane.add(btnEdit, gbc_btnEdit);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setMnemonic(KeyEvent.VK_E);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				exclusao();
			}

			private void exclusao() {
				int selecionarTable = 0;

				try {
					selecionarTable = (int) table.getModel().getValueAt(table.getSelectedRow(), 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(TelaPrincipal.this, "Selecione um registro para excluir!", "Atenção",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				Bicho deletar = dao.pegarPorID(selecionarTable);

				dao.deletar(deletar);

				JOptionPane.showMessageDialog(TelaPrincipal.this,
						"Animal " + deletar.getNome() + " removido com sucesso!!");

				bichoModel = new bichoModel(dao.pegarTodos());
				table.setModel(bichoModel);
			}
		});
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.fill = GridBagConstraints.VERTICAL;
		gbc_btnExcluir.gridx = 4;
		gbc_btnExcluir.gridy = 6;
		contentPane.add(btnExcluir, gbc_btnExcluir);

		try {

			dao = RemoteEJBClient.lookupRemoteStatelessCalculator();

		} catch (Exception e) {
			e.printStackTrace();
		}

		bichoModel = new bichoModel(dao.pegarTodos());
		table.setModel(bichoModel);

	}

	private void NovoCadastro() {
		if (selecaoBicho == null) {

			if (txtNome.getText().equals("") || txtEspecie.getText().equals("") ||
					 txtDono.getText().equals("") ||  txtEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(TelaPrincipal.this, "Preencha os campos!",
						"Atenção", JOptionPane.WARNING_MESSAGE);
			} else {

				Bicho bicho = new Bicho();
				bicho.setNome(txtNome.getText());
				bicho.setEspecie(txtEspecie.getText());
				bicho.setDono(txtDono.getText());
				bicho.setEmailDono(txtEmail.getText());

				dao.criar(bicho);
				clear();
				
				bichoModel = new bichoModel(dao.pegarTodos());
				table.setModel(bichoModel);
			}
		} else {

			selecaoBicho.setId(editID);
			selecaoBicho.setNome(txtNome.getText());
			selecaoBicho.setEspecie(txtEspecie.getText());
			selecaoBicho.setDono(txtDono.getText());
			selecaoBicho.setEmailDono(txtEmail.getText());

			dao.editar(selecaoBicho);

			selecaoBicho = null;

			clear();

			bichoModel = new bichoModel(dao.pegarTodos());
			table.setModel(bichoModel);

		}
	}

	protected void clear() {

		txtNome.setText("");
		txtEspecie.setText("");
		txtDono.setText("");
		txtEmail.setText("");

	}
}
