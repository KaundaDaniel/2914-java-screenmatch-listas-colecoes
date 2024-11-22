package br.com.alura.screenmatch;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalFilmes {
    public static void main(String[] args) {
        Filme filme1 = new Filme("O poderoso chefão", 2023);
        filme1.setNome("O poderoso chefão");
        filme1.setDiretor("Nicolas Cage");
        filme1.setDuracaoEmMinutos(180);
        filme1.avalia(8);

        Filme filme2 = new Filme("A procura da verdade", 2016);
        filme2.setNome("A procura da verdade");
        filme2.setDiretor("Robert Downey Jr.");
        filme2.setDuracaoEmMinutos(135);
        filme2.avalia(7);

        Serie lost = new Serie("Lost", 2000);
        lost.setNome("Lost");
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);


        Serie resident = new Serie("Resident", 2016);
        resident.setNome("Resident");
        resident.setTemporadas(12);
        resident.setEpisodiosPorTemporada(22);
        resident.setMinutosPorEpisodio(45);



        System.out.println("Filme 1: " + filme1.getNome());
        System.out.println("Diretor: " + filme1.getDiretor());
        //Criando o ArrayList de titulos
        ArrayList<Titulo> titulos= new ArrayList<>();
        titulos.add(filme1);
        titulos.add(filme2);
        titulos.add(lost);
        titulos.add(resident);
        for (Titulo titulo : titulos){
            System.out.println(titulo.getNome());
            if(titulo instanceof Serie){
                Serie serie= (Serie) titulo;
                System.out.println("Mostra Temporadas: " + serie.getTemporadas());
            } else if (titulo instanceof Filme filme && filme.getClassificacao()>2 ) {
                System.out.println("Mostra Classificaçaão: " + filme.getClassificacao());
             }

        }

    }
}
