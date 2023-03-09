package productStore;

import productStore.product.Product;
import productStore.product.meatProduct.Fish;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Fish(1,"Fish1","TOIBOSS", LocalDate.of(2023,3,8)));
        products.add(new Fish(10,"Balyk","TOIBOSS", LocalDate.of(2023,3,2)));
        products.add(new Fish(6,"Fish6","TOIBOSS", LocalDate.of(2023,3,9)));
        products.add(new Fish(4,"Fish4","TOIBOSS", LocalDate.of(2023,4,5)));
        products.add(new Fish(5,"Fish5","TOIBOSS", LocalDate.of(2022,4,5)));
        products.add(new Fish(2,"Fish2","TOIBOSS2", LocalDate.of(2023,4,5)));
        products.add(new Fish(3,"Fish3","TOIBOSS", LocalDate.of(2023,2,20)));

        System.out.println(!products.get(0).getDate().minusDays(7).isAfter(LocalDate.now()));
        System.out.println(!products.get(3).getDate().minusDays(7).isAfter(LocalDate.now()));
        System.out.println(products.get(1).getDate().isAfter(LocalDate.now()));

//        List<Product> storeCase = new ArrayList<>();
//
//        StoreService storeService = new StoreService();
//        List<Product> showCase = new ArrayList<>();
//
//        storeService.acceptProducts(products,storeCase);
//        storeService.putInOnDisplay(products,showCase);





        


    }
    public static void method(List<? extends Product>products){
        for (Product product : products) {
            if (product.getDate().minusDays(7).isBefore(LocalDate.now())){
                System.out.println("Pros");
            }
            else {
                System.out.println("Ne");
            }
        }
    }
}