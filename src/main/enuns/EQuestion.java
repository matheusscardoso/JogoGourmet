package main.enuns;

public enum EQuestion {

    APP_TITLE("Jogo Gourmet"),
    PENSE_EM_UM_PRATO("Pense em um prato que gosta"),
    O_PRATO_QUE_PENSOU_E("O prato que você pensou é "),
    QUAL_PRATO_VOCE_PENSOU("Qual prato você pensou?"),
    RESPOSTA_CATEGORIA(" é ______ mas "),
    NAO(" não."),
    CLICADO(" Clicado"),
    DESISTO("Desisto"),
    CONFIRM("Confirm"),
    ACERTEI("Acertei de novo!");

    private final String description;

    EQuestion(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
