package businesslogic.iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import transfer.Item;

public class Cart implements Iterable<Item>
{

	private ArrayList<Item> products;
	protected Map<Item, Integer> unitsMap;
	
	@Override
	public Iterator<Item> getIterator() {
		return new CartIterator();
	}
	
	public Cart (){
		products = new ArrayList<>();
		unitsMap = new HashMap<Item, Integer>();
	}

	public float getTotalPrice()
	{
		float total = 0;
		for(Item item: products)
		{
			total += item.getPrice() * unitsMap.get(item);
		}

		return total;
	}
	
	public void addItem(Item i) {		
		boolean found = false;
		for(Item item : products) {
			if(item.getId() == i.getId()) {
				found = true;
				int currentUnits = unitsMap.get(item);
				if(currentUnits < item.getNumberOfCopies())
					unitsMap.put(item, currentUnits + 1);
			}
		}
		
		if(!found){
			products.add(i);
			unitsMap.put(i, 1);
		}
	}

	public void addItems(List<Item> items) {
		for(Item i : items)
			this.addItem(i);
	}
	
	public int getUnits(Item i) {
		return unitsMap.get(i);
	}
	
	public void emptyCart() {
		products = new ArrayList<>();
	}
	
	public List<Item> getItems(){
		return products;
	}
	
	private class CartIterator implements Iterator<Item> {
		
		int index = 0;
		
		@Override
		public boolean hasNext() {
			return (index < products.size());
		}

		@Override
		public Item next() {
			if(this.hasNext()){
				return products.get(index++);
			}
			return null;
		}
	}
}