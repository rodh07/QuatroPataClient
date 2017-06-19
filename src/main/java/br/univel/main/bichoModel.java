package br.univel.main;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import br.univel.bicho.Bicho;

public class bichoModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Bicho> list;

	public bichoModel(ArrayList bichos) {
		this.list = bichos;
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Bicho bch = this.list.get(row);

		switch (col) {
		case 0:
			return bch.getId();
		case 1:
			return bch.getNome();
		case 2:
			return bch.getEspecie();
		case 3:
			return bch.getDono();
		case 4:
			return bch.getEmailDono();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {

		switch (col) {
		case 0:
			return "Id";
		case 1:
			return "Nome";
		case 2:
			return "Espécie";
		case 3:
			return "Dono";
		case 4:
			return "Email do Dono";
		default:
			return "";
		}
	}
}
