package mainChallenge;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import sortedCollections.StockItem;

public class Basket {

	private final String name;
	private final Map<StockItem, Integer> list;
	
	public Basket(String name){
		this.name=name;
		this.list=new TreeMap<>();
	}
	public int addToBasket(StockItem item, int quantity){
		if((item != null) && (quantity >0)){
			//check if we already have it in the basket
			int inBasket = list.getOrDefault(item, 0);
			int newQuantity = inBasket + quantity;
			if(newQuantity > 0){
				list.put(item, newQuantity);
				return quantity;
			}else if(newQuantity == 0){
				list.remove(item);
				return quantity;
			}
		}
		return 0;
	}
	
	public int removeFromBasket(StockItem stockItem, int quantity){
		if((stockItem != null) && (quantity >0)){
			int inBasket = list.getOrDefault(stockItem, 0);
			list.put(stockItem, inBasket - quantity);
			return inBasket;
		}
		return 0;
	}
	
	public void clearBasket(){
		this.list.clear();
	}
	public Map<StockItem, Integer> Items(){
		return Collections.unmodifiableMap(list);
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "\nShopping Basket "+ name + " contains "+ list.size()
				+((list.size() == 1) ? " item" : " items") +"\n";
		double totalCost = 0.0;
		for(Map.Entry<StockItem, Integer> item : list.entrySet()){
			s = s + item.getKey() + ", "+ item.getValue()+ " purchased\n";
			totalCost += item.getKey().getPrice()*item.getValue();
		}
		return s + "Total cost "+ totalCost;
	}
	


}
