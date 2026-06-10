package entities;

public final class ProdutoImportado extends Produto{
    protected Double taxaImporta;


    public ProdutoImportado(String nome, Double preco, Double taxaImporta) {
        super(nome, preco);
        this.taxaImporta = taxaImporta;
    }


    public Double precoTotal(){
        return super.preco + taxaImporta;
    }

    @Override
    public final String priceTag(){
        return nome+" $ "+ String.format("%.2f", precoTotal())+"(Taxa de Importação: $ "+String.format("%.2f", taxaImporta)+")";
    }
    
}
