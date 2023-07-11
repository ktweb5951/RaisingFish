package com.kh.raisingfish;

public class Food {
    private String foodName;
    private int price;
    private int hunger;
    private int rating;
    
    
    public Food() {
    	
    }
    public Food(String foodName, int price, int hunger, int rating ) {
    	this.foodName = foodName;
    	this.price = price;
    	this.hunger = hunger;
    	this.rating = rating;
    }
    
    public String getFoodName() {
    	return this.foodName;
    }
    public int getPrice() {
    	return this.price;
    }
    public int getHunger() {
    	return this.hunger;
    }
    public int getRating() {
    	return this.rating;
    }
    
    public void setFoodName() {
    	this.foodName = foodName;
    }
    public void setPrice() {
    	this.price = price;
    }
    public void setHunger() {
    	this.hunger = hunger;
    }
    

    
    
    
    
}
