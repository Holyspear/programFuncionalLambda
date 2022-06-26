package model.entities;

public class Product {
	
	private String name;
	private Double price;
	
	public Product(){
		
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	//Com m�todo est�tico n�o preciso implementar a interface Predicate
	public static boolean staticProductPredicate(Product product) {
		return product.getPrice() >= 100.0;
	}
	//M�todo n�o est�tico trabalha com a pr�pria inst�ncia.
	//Por isso n�o h� necessidade de argumento de um Product.
	public boolean nonstaticProductPredicate() {
		return getPrice() >= 100.0;
	}
	
	@Override
	public String toString() {
		return getName() + ", " + String.format("%.2f", getPrice());
	}
	//Com m�todo est�tico n�o preciso implementar a interface Consumer
	public static void StaticPriceUpdate(Product product) {
		product.setPrice(product.getPrice()*1.1);		
	}
	//M�todo n�o est�tico substituindo interface Comsumer
	public void nonStaticPriceUpdate() {
		setPrice(getPrice()*1.1);
	}
}
