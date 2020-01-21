package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import businesslogic.iterator.Cart;
import transfer.Item;

@SuppressWarnings("serial")
public class BrowseTable extends JPanel implements ShopObserver {
	protected JLabel iconLabel;
	protected JTable table;
	protected MyBrowseTableModel tableModel;
	protected List<Item> items;
	
	public BrowseTable(JLabel iconLabel) {
		this.iconLabel = iconLabel;
		initGUI();
	}
	
	protected void initGUI() {
		this.setLayout(new BorderLayout());
		tableModel = new MyBrowseTableModel();
		table = new JTable(tableModel);
		table.setShowGrid(false);
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.getViewport().setBackground(Color.WHITE);
		this.add(jscroll, BorderLayout.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		
		table.addMouseListener(new java.awt.event.MouseAdapter(){
		
			public void mouseClicked(java.awt.event.MouseEvent e){
				int row = table.rowAtPoint(e.getPoint());
				
				String path = items.get(row).getImagePath();
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/" + path));
				icon.setImage(icon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 1));
				iconLabel.setIcon(icon);
			}
		});
	}
	
	public List<Item> getSelectedItems(){
		int[] rows = table.getSelectedRows();
		List<Item> items = new ArrayList<Item>();
		for(int i : rows)
			items.add(this.items.get(i));
		return items;
	}

	@Override
	public void registered() {
		tableModel.refresh();
	}

	@Override
	public void browsed(List<Item> items) {
		this.items = items;
		tableModel.refresh();
	}

	@Override
	public void addToCart(Cart cart) {
	}

	@Override
	public void emptyCart() {
	}

	public class MyBrowseTableModel extends AbstractTableModel {
		
		protected String[] header;
		
		public MyBrowseTableModel() {
			header = new String[]{ "Title", "Developer", "Release Date", "Number of units", "Price" };
		}
		
		@Override
		public int getColumnCount() {
			return header.length;
		}
		
		@Override
		public String getColumnName(int columnIndex) {
			return header[columnIndex];
		}
		
		public void refresh() {
			if(items != null && items.size() != 0)
				table.setRowHeight(BrowseTable.this.getHeight() / items.size() - 11);
			fireTableStructureChanged();
		}

		@Override
		public int getRowCount() {
			return (items != null) ? items.size() : 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String str = null;
			switch (columnIndex) {
				case 0:
					str = items.get(rowIndex).getTitle();
					break;
				case 1:
					str = items.get(rowIndex).getDeveloper();
					break;
				case 2:
					str = items.get(rowIndex).getReleaseDate().toString();
					break;
				case 3:
					str = "" + items.get(rowIndex).getNumberOfCopies();
					break;
				case 4:
					str = "" + items.get(rowIndex).getPrice();
					break;
				default:
					break;
			}
			return str;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Class getColumnClass(int column) {
			return getValueAt(0, column).getClass();
        }
	}
}
