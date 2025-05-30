public class Loja {
    private Cliente[] clientes = new Cliente[100];
    private Produto[] produtos = new Produto[100];
    private Venda[] vendas = new Venda[100];
    private int qtdClientes = 0;
    private int qtdProdutos = 0;
    private int qtdVendas = 0;

    public void adicionarCliente(Cliente c) {
        if (qtdClientes < clientes.length) {
            clientes[qtdClientes++] = c;
        }
    }
    public void adicionarProduto(Produto p) {
        if (qtdProdutos < produtos.length) {
            produtos[qtdProdutos++] = p;
        }
    }
    public void realizarVenda(Cliente c, Produto[] produtosSelecionados, int qtdSelecionados) {
        if (qtdVendas < vendas.length) {
            vendas[qtdVendas++] = new Venda(c, produtosSelecionados, qtdSelecionados);
        }
    }
    public String listarClientes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtdClientes; i++) {
            sb.append(i + 1).append(" - ").append(clientes[i].toString()).append("\n");
        }
        return sb.toString();
    }
    public String listarProdutos() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtdProdutos; i++) {
            sb.append(i + 1).append(" - ").append(produtos[i].toString()).append("\n");
        }
        return sb.toString();
    }
    public String listarVendas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < qtdVendas; i++) {
            sb.append("Venda ").append(i + 1).append(":\n").append(vendas[i].toString()).append("\n\n");
        }
        return sb.toString();
    }
    public Cliente[] getClientes() {
        return clientes;
    }
    public Produto[] getProdutos() {
        return produtos;
    }
    public int getQtdClientes() {
        return qtdClientes;
    }
    public int getQtdProdutos() {
        return qtdProdutos;
    }
}