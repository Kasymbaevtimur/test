package productStore;

import productStore.product.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreService {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void acceptProducts(List<? extends Product> newProducts, List<Product> storeCase) {
        List<Product> otherProducts = new ArrayList<>();
        for (Product product : newProducts) {
            if (product.getCompanyName().equals("TOIBOSS") || product.getCompanyName().equals("NUR") ||
                    product.getCompanyName().equals("MILKA")) {
                if (product.getDate().isAfter(LocalDate.now())) {
                    storeCase.add(product);
                } else {
                    otherProducts.add(product);
                }
            } else {
                otherProducts.add(product);
            }
        }
        System.out.println(ANSI_GREEN + "Добавленные продукты: " + ANSI_RESET);
        storeCase.forEach(System.out::println);
        System.out.println(ANSI_RED + "Не добавленные продукты: " + ANSI_RESET);
        otherProducts.forEach(System.out::println);
    }

    public void putInOnDisplay(List<? extends Product> products, List<Product> display) {
        List<Product> musor = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getDate().isAfter(LocalDate.now())){
                musor.add(products.get(i));
                products.remove(products.get(i));
            }
            if (!products.get(i).getDate().minusDays(7).isAfter(LocalDate.now())){
                display.add(products.get(i));
            }

        }
        System.out.println(ANSI_GREEN + "Продукты выставленные на витрину: " + ANSI_RESET);
        display.forEach(System.out::println);
        System.out.println(ANSI_RED + "Продукты удаленные из магазина: " + ANSI_RESET);
        musor.forEach(System.out::println);
    }

}
