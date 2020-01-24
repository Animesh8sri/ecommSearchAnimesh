package com.example.baniya.search;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchPOJO {

	@SerializedName("productId")
	private String productId;

	@SerializedName("price")
	private double price;

	@SerializedName("imageUrl")
	private String imageUrl;

	@SerializedName("productRating")
	private double productRating;

	@SerializedName("weighted")
	private double weighted;

	@SerializedName("productName")
	private String productName;

	@SerializedName("productDescription")
	private String productDescription;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("productAttribute")
	private List<String> productAttribute;

	@SerializedName("productUsp")
	private String productUsp;

	public void setProductId(String productId){
		this.productId = productId;
	}

	public String getProductId(){
		return productId;
	}

	public void setPrice(double price){
		this.price = price;
	}

	public double getPrice(){
		return price;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setProductRating(double productRating){
		this.productRating = productRating;
	}

	public double getProductRating(){
		return productRating;
	}

	public void setWeighted(double weighted){
		this.weighted = weighted;
	}

	public double getWeighted(){
		return weighted;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setProductAttribute(List<String> productAttribute){
		this.productAttribute = productAttribute;
	}

	public List<String> getProductAttribute(){
		return productAttribute;
	}

	public void setProductUsp(String productUsp){
		this.productUsp = productUsp;
	}

	public String getProductUsp(){
		return productUsp;
	}

	@Override
 	public String toString(){
		return 
			"SearchPOJO{" +
			"productId = '" + productId + '\'' + 
			",price = '" + price + '\'' + 
			",imageUrl = '" + imageUrl + '\'' + 
			",productRating = '" + productRating + '\'' + 
			",weighted = '" + weighted + '\'' + 
			",productName = '" + productName + '\'' + 
			",productDescription = '" + productDescription + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			",productAttribute = '" + productAttribute + '\'' + 
			",productUsp = '" + productUsp + '\'' + 
			"}";
		}
}