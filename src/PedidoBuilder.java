import java.util.ArrayList;
import java.util.List;

public class PedidoBuilder {
    public String tipo;
    public String tamanho;
    public String pagamento;
    public List<String> itens = new ArrayList<>();

    public String tipoPao;
    public String tipoMassa;
    public boolean bordaRecheada;

    public String entrega;
    public String enderecoEntrega;
    public String cupom;
    public String observacao;
    public Double trocoPara;

    public PedidoBuilder tipoHamburguer() {

        this.tipo = "HAMBURGUER";
        return this;
    }

    public PedidoBuilder tipoPizza() {

        this.tipo = "PIZZA";
        return this;
    }

    public PedidoBuilder tamanhoP() {

        this.tamanho = "P";
        return this;
    }

    public PedidoBuilder tamanhoM() {

        this.tamanho = "M";
        return this;
    }

    public PedidoBuilder tamanhoG() {

        this.tamanho = "G";
        return this;
    }

    public PedidoBuilder pagarComPix() {

        this.pagamento = "PIX";
        return this;
    }

    public PedidoBuilder pagarComCartao() {

        this.pagamento = "CARTAO";
        return this;
    }

    public PedidoBuilder pagarComDinheiro() {

        this.pagamento = "DINHEIRO";
        return this;
    }

    public PedidoBuilder comTrocoPara(double valor) {

        this.trocoPara = valor;
        return this;
    }

    public PedidoBuilder entregaDelivery(String endereco) {

        this.entrega = "DELIVERY";
        this.enderecoEntrega = endereco;
        return this;
    }

    public PedidoBuilder entregaRetirada() {

        this.entrega = "RETIRADA";
        return this;
    }

    public PedidoBuilder tipoPao(String pao) {
        this.tipoPao = pao;
        return this;
    }

    public PedidoBuilder tipoMassa(String massa) {

        this.tipoMassa = massa;
        return this;
    }

    public PedidoBuilder comBordaRecheada() {

        this.bordaRecheada = true;
        return this;
    }

    public PedidoBuilder semBordaRecheada() {

        this.bordaRecheada = false;
        return this;
    }

    public PedidoBuilder addItem(String item) {

        this.itens.add(item);
        return this;
    }

    public PedidoBuilder comCupom(String cupom) {

        this.cupom = cupom;
        return this;
    }

    public PedidoBuilder comObservacao(String obs) {

        this.observacao = obs;
        return this;
    }

    public Pedido build() {

        if (!"HAMBURGUER".equals(tipo) && !"PIZZA".equals(tipo))
            throw new IllegalStateException("Tipo inválido");

        if (!"P".equals(tamanho) && !"M".equals(tamanho) && !"G".equals(tamanho))
            throw new IllegalStateException("Tamanho inválido");

        if (!"PIX".equals(pagamento) && !"CARTAO".equals(pagamento) && !"DINHEIRO".equals(pagamento))
            throw new IllegalStateException("Pagamento inválido");

        if (itens.size() < 1)
            throw new IllegalStateException("Pedido precisa ter pelo menos 1 item");

        if ("HAMBURGUER".equals(tipo)) {
            if (tipoPao == null)
                throw new IllegalStateException("Hamburguer precisa de tipo de pão");

            if (bordaRecheada)
                throw new IllegalStateException("Hamburguer não pode ter borda recheada");

            tipoMassa = null;
        }

        if ("PIZZA".equals(tipo)) {
            if (tipoMassa == null)
                throw new IllegalStateException("Pizza precisa de tipo de massa");

            tipoPao = null;
        }

        if ("DELIVERY".equals(entrega)) {
            if (enderecoEntrega == null || enderecoEntrega.isEmpty())
                throw new IllegalStateException("Delivery precisa de endereço");
        }

        if ("RETIRADA".equals(entrega)) {
            enderecoEntrega = null;
        }

        if (!"DINHEIRO".equals(pagamento) && trocoPara != null)
            throw new IllegalStateException("Troco só permitido para pagamento em dinheiro");

        if ("DINHEIRO".equals(pagamento) && trocoPara != null && trocoPara <= 0)
            throw new IllegalStateException("Troco precisa ser maior que zero");

        return new Pedido(this);
    }
}
