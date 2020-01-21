package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

import businesslogic.Order;

@SuppressWarnings("serial")
public class OrderTable extends JPanel{
	protected JTable table;
	protected MyOrderTableModel tableModel;
	protected Order order;
	
	public OrderTable(Order order) {
		this.order = order;
		initGUI();
	}
	
	public void setSummary(Order order) {
		this.order = order;
		tableModel.refresh();
	}
	
	protected void initGUI() {
		this.setLayout(new BorderLayout());
		tableModel = new MyOrderTableModel();
		table = new JTable(tableModel);
		table.setShowGrid(false);
		JScrollPane jscroll = new JScrollPane(table);
		jscroll.getViewport().setBackground(Color.WHITE);
		this.add(jscroll, BorderLayout.CENTER);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(String.class, centerRenderer);
		this.setBorder(new TitledBorder(null, "Order Summary:", TitledBorder.LEADING, TitledBorder.TOP, null, Color.DARK_GRAY));
	}

	public class MyOrderTableModel extends AbstractTableModel {
		
		protected String[] header;
		
		public MyOrderTableModel() {
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
			String[] array = order.orderSummary().split("  ");
			return (array.length - 1) / 3;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			String str = null;
			String[] array = order.orderSummary().split("  ");
			switch (columnIndex) {
				case 0:
					if(rowIndex < order.getCart().getItems().size())
						str = array[rowIndex * 3];
					else
						str = array[(order.getCart().getItems().size() * 3) + ((rowIndex - order.getCart().getItems().size()) * 3)];
					break;
				case 1:
					if(rowIndex < order.getCart().getItems().size())
						str = array[(rowIndex * 3) + 1];
					else
						str = array[(order.getCart().getItems().size() * 3) + (((rowIndex - order.getCart().getItems().size()) * 3) + 1)];
					break;
				case 2:
					if(rowIndex < order.getCart().getItems().size())
						str = array[(rowIndex * 3) + 2];
					else
						str = array[(order.getCart().getItems().size() * 3) + (((rowIndex - order.getCart().getItems().size()) * 3) + 2)];
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
