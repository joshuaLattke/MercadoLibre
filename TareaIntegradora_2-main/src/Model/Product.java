
    package Model;
    public class Product {



        private String nameProduct;

        private String description;
        private int numberOfTimesPurchased;

        private double price;


        private int quanty;

        private TypeCategory category;

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



        public void setPrice(double price) {
            this.price = price;
        }

        public double getPrice() {
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
        public Product(String nameProduct, String description,int numberOfTimesPurchased,double price, int quanty,TypeCategory category){
            this.nameProduct=nameProduct;
            this.description=description;
            this.numberOfTimesPurchased=numberOfTimesPurchased;
            this.price=price;
            this.quanty=quanty;
            this.category=category;

        }
    }


