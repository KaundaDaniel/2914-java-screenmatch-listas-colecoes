package br.com.alura.screenmatch.excecao;

public class ErroDeConversaoAno extends RuntimeException {
    private String mensangem;
    public ErroDeConversaoAno(String message) {
        this.mensangem = message;
    }
    public String getMensagem() {
        return this.mensangem;
    }


}
