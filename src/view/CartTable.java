package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import businesslogic.iterator.Cart;
import transfer.Item;

@SuppressWarnings("serial")
public class CartTable extends JPanel implements ShopObserver {
	protected JLabel iconLabel;
	protected JTable table;
	protected MyCartTableModel tableModel;
	protected Cart cart;
	
	public CartTable(Cart cart, JLabel iconLabel) {
		this.cart = cart;
		this.iconLabel = iconLabel;
		initGUI();
	}
	
	protected void initGUI() {
		this.setLayout(new BorderLayout());
		tableModel = new MyCartTableModel();
		table = new JTable(tableModel);
		table.setShowGrid(false);
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.getViewport().setBackground(Color.WHITE);
		this.add(jscroll, BorderLayout.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		this.setBorder(new TitledBorder(null, "Cart:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
		table.addMouseListener(new java.awt.event.MouseAdapter(){
			public void mouseClicked(java.awt.event.MouseEvent e){
				int row = table.rowAtPoint(e.getPoint());
				
				String path = cart.getItems().get(row).getImagePath();
				ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/" + path));
				icon.setImage(icon.getImage().getScaledInstance(iconLabel.getWidth(), iconLabel.getHeight(), 1));
				iconLabel.setIcon(icon);
			}
		});
	}
	
	public double getTotal() {
		double total = 0;
		for(Item i : cart.getItems()) {
			total += i.getPrice() * cart.getUnits(i);
		}
		return total;
	}

	@Override
	public void registered() {
		tableModel.refresh();
	}

	@Override
	public void browsed(List<Item> items) {
	}

	@Override
	public void addToCart(Cart cart) {
		this.cart = cart;
		tableModel.refresh();
	}

	@Override
	public void emptyCart() {
		cart = new Cart();
		tableModel.refresh();
	}

	public class MyCartTableModel extends AbstractTableModel {
		
		protected String[] header;
		
		public MyCartTableModel() {
			header = new String[]{ "Title", "Number of units", "Price" };
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
			fireTableStructureChanged();
		}

		@Override
		public int getRowCount() {
			return (cart.getItems() != null) ? cart.getItems().size() : 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String str = null;
			switch (columnIndex) {
				case 0:
					str = cart.getItems().get(rowIndex).getTitle();
					break;
				case 1:
					str = "" + cart.getUnits(cart.getItems().get(rowIndex));
					
				break;
				case 2:
					str = "" + (cart.getItems().get(rowIndex).getPrice() * cart.getUnits(cart.getItems().get(rowIndex)));
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
