package model.util;

import java.util.function.Consumer;

import model.entities.Product;

public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product product) {

		product.setPrice(product.getPrice()*1.1);
		
	}

}
