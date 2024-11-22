package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Filme;

public class PrincipalFilmes {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 2023);
        filme1.setNome("O poderoso chefão");
        filme1.setDiretor("Nicolas Cage");
        filme1.setDuracaoEmMinutos(180);

        Filme filme2 = new Filme("A procura da verdade", 2016);
        filme2.setNome("A procura da verdade");
        filme2.setDiretor("Robert Downey Jr.");
        filme2.setDuracaoEmMinutos(135);

        System.out.println("Filme 1: " + filme1.getNome());
        System.out.println("Diretor: " + filme1.getDiretor());
    }
}
