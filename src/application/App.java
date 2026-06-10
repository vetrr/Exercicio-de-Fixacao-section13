package application;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("--------------INICIANDO PROGRAMA--------------");
        System.out.println();

        System.out.print("Digite a quantidade de produtos: ");
        int quantidadeProd = sc.nextInt();

        List<Produto> listaDeProdutos = new ArrayList<>();

        for (int i=0; i<quantidadeProd; i++){
            System.out.println("Produto "+"#"+(i+1)+":");
            System.out.print("Comum, usado ou importado (c/u/i)?");
            char tipoProd = sc.next().charAt(0);
            sc.nextLine();
            switch (tipoProd) {
                case 'c':

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Preco: ");
                    Double preco = sc.nextDouble();
                    Produto p = new Produto(nome, preco);
                    listaDeProdutos.add(p);

                    break;
                case 'u':

                    System.out.print("Nome: ");
                    String nomeU = sc.nextLine();
                    System.out.print("Preço: ");
                    Double precoU = sc.nextDouble();
                    System.out.print("Data de fabricação: (DD/MM/YYYY)");
                    String dataFabri = sc.next();
                    LocalDate dataConvertida = LocalDate.parse(dataFabri, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    ProdutoUsado pU = new ProdutoUsado(nomeU, precoU, dataConvertida);
                    listaDeProdutos.add(pU);

                    break;
                case 'i':

                    System.out.print("Nome: ");
                    String nomeI = sc.nextLine();
                    System.out.print("Preço: ");
                    Double precoI = sc.nextDouble();
                    System.out.print("Taxa de importação: ");
                    Double taxaImpor = sc.nextDouble();
                    ProdutoImportado pI = new ProdutoImportado(nomeI, precoI, taxaImpor);
                    listaDeProdutos.add(pI);

                    break;
                default:
                    break;
            }

        }
        System.out.println();
        System.out.println("---PRECO DAS ETIQUETAS---");

        for (Produto item : listaDeProdutos) {
            System.out.println(item.priceTag());
        }


        sc.close();
    }
}
