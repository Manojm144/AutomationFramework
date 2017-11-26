package com.framework.tests.data;

public class ProductDetails {

	public String productName;
	public String prise;
	public String sellerName;
	public ProductDetails(String productName, String prise, String sellerName) {
		super();
		this.productName = productName;
		this.prise = prise;
		this.sellerName = sellerName;
	}
	@Override
	public String toString() {
	return productName+" - "+prise+" - "+sellerName;
	}
}
