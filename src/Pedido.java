import java.util.List;

public class Pedido {
    private final String tipo;
    private final String tamanho;
    private final String pagamento;
    private final List<String> itens;

    private final String tipoPao;
    private final String tipoMassa;
    private final boolean bordaRecheada;

    private final String entrega;
    private final String enderecoEntrega;
    private final String cupom;
    private final String observacao;
    private final Double trocoPara;

    public Pedido(PedidoBuilder pedidoBuilder) {
        this.tipo = pedidoBuilder.tipo;
        this.tamanho = pedidoBuilder.tamanho;
        this.pagamento = pedidoBuilder.pagamento;
        this.itens = pedidoBuilder.itens;
        this.tipoPao = pedidoBuilder.tipoPao;
        this.tipoMassa = pedidoBuilder.tipoMassa;
        this.bordaRecheada = pedidoBuilder.bordaRecheada;
        this.entrega = pedidoBuilder.entrega;
        this.enderecoEntrega = pedidoBuilder.enderecoEntrega;
        this.cupom = pedidoBuilder.cupom;
        this.observacao = pedidoBuilder.observacao;
        this.trocoPara = pedidoBuilder.trocoPara;
    }

    public void informacao() {

        System.out.println("===== RESUMO DO PEDIDO =====");
        System.out.println("Tipo: " + tipo);
        System.out.println("Tamanho: " + tamanho);

        System.out.println("Itens:");
        for (String item : itens) {
            System.out.println(item);
        }

        if (tipoPao != null)
            System.out.println("Pão: " + tipoPao);

        if (tipoMassa != null)
            System.out.println("Massa: " + tipoMassa);

        if ("PIZZA".equals(tipo))
            System.out.println("Borda recheada: " + bordaRecheada);

        System.out.println("Pagamento: " + pagamento);

        if (trocoPara != null)
            System.out.println("Troco para: " + trocoPara);

        System.out.println("Entrega: " + entrega);

        if (enderecoEntrega != null)
            System.out.println("Endereço: " + enderecoEntrega);

        if (cupom != null)
            System.out.println("Cupom: " + cupom);

        if (observacao != null)
            System.out.println("Observação: " + observacao);

        System.out.println();
    }
}
