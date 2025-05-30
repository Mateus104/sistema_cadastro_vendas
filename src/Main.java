import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();
        int opcao;

        do {
            String menu = "1 - Cadastro do Cliente\n" +
                          "2 - Cadastro do Produto\n" +
                          "3 - Efetivar uma Venda\n" +
                          "4 - Listar Clientes\n" +
                          "5 - Listar Produtos\n" +
                          "6 - Consulta de Vendas\n" +
                          "0 - Sair";
            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Nome do cliente:");
                    String cpf = JOptionPane.showInputDialog("CPF (11 dígitos):");
                    try {
                        Cliente c = new Cliente(nome, cpf);
                        loja.adicionarCliente(c);
                    } catch (IllegalArgumentException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;
                case 2:
                    String[] tipos = {"Produto", "Livro"};
                    int tipo = JOptionPane.showOptionDialog(null, "Tipo de produto:",
                            "Cadastro de Produto", 0, JOptionPane.QUESTION_MESSAGE, null,
                            tipos, tipos[0]);

                    int id = loja.getQtdProdutos() + 1;
                    String nomeProd = JOptionPane.showInputDialog("Nome:");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));

                    if (tipo == 1) {
                        String autor = JOptionPane.showInputDialog("Autor:");
                        loja.adicionarProduto(new Livro(id, nomeProd, preco, autor));
                    } else {
                        loja.adicionarProduto(new Produto(id, nomeProd, preco));
                    }
                    break;
                case 3:
                    Cliente[] clientes = loja.getClientes();
                    Produto[] produtos = loja.getProdutos();
                    int qtdClientes = loja.getQtdClientes();
                    int qtdProdutos = loja.getQtdProdutos();

                    if (qtdClientes == 0 || qtdProdutos == 0) {
                        JOptionPane.showMessageDialog(null, "Cadastre clientes e produtos primeiro.");
                        break;
                    }
                    String[] opcoesClientes = new String[qtdClientes];
                    for (int i = 0; i < qtdClientes; i++) {
                        opcoesClientes[i] = (i + 1) + " - " + clientes[i].getNome();
                    }
                    int escolhaCliente = JOptionPane.showOptionDialog(null, "Escolha o cliente:",
                            "Clientes", 0, JOptionPane.QUESTION_MESSAGE, null,
                            opcoesClientes, opcoesClientes[0]);
                    Cliente clienteSelecionado = clientes[escolhaCliente];

                    String[] opcoesProdutos = new String[qtdProdutos];
                    for (int i = 0; i < qtdProdutos; i++) {
                        opcoesProdutos[i] = (i + 1) + " - " + produtos[i].getNome();
                    }
                    Produto[] produtosSelecionados = new Produto[10];
                    int qtdSelecionados = 0;
                    boolean continuar = true;
                    while (continuar && qtdSelecionados < 10) {
                        int escolhaProduto = JOptionPane.showOptionDialog(null, "Escolha um produto:",
                                "Produtos", 0, JOptionPane.QUESTION_MESSAGE, null,
                                opcoesProdutos, opcoesProdutos[0]);
                        produtosSelecionados[qtdSelecionados++] = produtos[escolhaProduto];
                        int cont = JOptionPane.showConfirmDialog(null, "Adicionar outro produto?");
                        if (cont != 0) continuar = false;
                    }
                    loja.realizarVenda(clienteSelecionado, produtosSelecionados, qtdSelecionados);
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, loja.listarClientes());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, loja.listarProdutos());
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, loja.listarVendas());
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo... :)");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        } while (opcao != 0);
    }
}
