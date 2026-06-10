package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class ProdutoUsado extends Produto {
    protected LocalDate dataFabri;

    public ProdutoUsado(String nome, Double preco, LocalDate dataFabri) {
        super(nome, preco);
        this.dataFabri = dataFabri;
    }

    @Override
    public String priceTag() {
        DateTimeFormatter formatoBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataFabri.format(formatoBR);

        return nome + " (usado) $ " + String.format("%.2f", preco) + " (Data de fabricação: " + dataFormatada + ")";
    }
}