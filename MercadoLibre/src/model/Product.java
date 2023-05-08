package model;

public class Product implements Comparable<Product> {
    private String nameProduct;

    private String description;
    private int numberOfTimesPurchased;

    private int price;


    private int quanty;

    private TypeCategory category;
    public Product(String nameProduct, String description,int numberOfTimesPurchased,int price, int quanty,int categories){
        this.nameProduct=nameProduct;
        this.description=description;
        this.numberOfTimesPurchased=numberOfTimesPurchased;
        this.price=price;
        this.quanty=quanty;

        switch (categories){

            case 1: category = TypeCategory.BOOKS;
                break;
            case 2:category = TypeCategory.ELECTRONICS;
                break;
            case 3: category = TypeCategory.CLOTHING;
                break;
            case 4: category = TypeCategory.EATS;
                break;
            case 5: category = TypeCategory.PAPERWORK;
                break;
            case 6: category = TypeCategory.SPORTS;
                break;
            case 7:category = TypeCategory.BEAUTYPRODUCTS;
                break;
            case 8: category = TypeCategory.PERSONALCARE;
                break;
            case 9:category = TypeCategory.TOYS;
                break;
            case 10:category = TypeCategory.GAMES;
                break;
                case 11 : category = TypeCategory.DRINKS;
            break;
        }

    }


    public TypeCategory getCategory(){
        return category;
    }

    public void setCategory(TypeCategory category) {
        this.category = category;
    }

    public int getNumberOfTimesPurchased() {
        return numberOfTimesPurchased;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }



    public int getQuanty() {
        return quanty;
    }

    public void setQuanty(int quanty) {
        this.quanty = quanty;
    }



    public String getNameProduct() {
        return nameProduct;
    }

    public void setNumberOfTimesPurchased(int numberOfTimesPurchased) {
        this.numberOfTimesPurchased = numberOfTimesPurchased;
    }

    //comparison order name, price, quanty, number of times purchased
    @Override
    public int compareTo(Product product) {

        int value = this.nameProduct.compareTo(product.getNameProduct());

        if (value == 0){
            value =  this.price - product.getPrice();


            if (value == 0){
                value = this.quanty - product.getQuanty();
            }
            if (value == 0){
                value = this.numberOfTimesPurchased - product.getNumberOfTimesPurchased();
            }
        }
        return value;
    }

    @Override
    public String toString() {


        String msg= String.format("""
                        Name    |   Description     |        # selled     |       Price          |    Quantity        |        Category    
                         %s        %s                 %s             %s                     %s                      %s            
                    """,nameProduct,description,numberOfTimesPurchased,price,quanty,category);
        return msg;
    }

}
