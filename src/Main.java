public class Main {

    public static void main(String[] args) {
        Pedido p1 = new PedidoBuilder()

                .tipoHamburguer()
                .tipoPao("BRIOCHE")
                .tamanhoM()
                .addItem("X-Bacon")
                .pagarComPix()
                .entregaDelivery("Rua Aldagisa Maria Gadelha")
                .comObservacao("sem cebola")
                .build();
        p1.informacao();

        Pedido p2 = new PedidoBuilder()

                .tipoPizza()
                .tipoMassa("FINA")
                .tamanhoG()
                .addItem("Pizza Calabresa")
                .comBordaRecheada()
                .pagarComCartao()
                .entregaRetirada()
                .comCupom("10OFF")
                .build();
        p2.informacao();

        Pedido p3 = new PedidoBuilder()

                .tipoHamburguer()
                .tamanhoP()
                .tipoPao("INTEGRAL")
                .addItem("X-Calabresa")
                .pagarComDinheiro()
                .comTrocoPara(100)
                .entregaRetirada()
                .build();
        p3.informacao();

        try {
            Pedido pedidoIvalido = new PedidoBuilder()

                    .tipoPizza()
                    .tamanhoM()
                    .addItem("Pizza Calabresa")
                    .pagarComPix()
                    .entregaRetirada()
                    .build();

        } catch (IllegalStateException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}