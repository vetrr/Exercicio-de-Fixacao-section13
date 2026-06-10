package application;


import java.util.Locale;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Produto prod = new ProdutoImportado("Celular", 10.00, 30.00);



        System.out.println("PRECO DAS ETIQUETAS");

        System.out.println(prod.priceTag());





        sc.close();
    }
}
