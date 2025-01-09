import br.com.alura.screenmatch.excecao.ErroDeConversaoAno;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloDTO;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título do filme:");
        String titulo = scanner.nextLine();


        try {


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://www.omdbapi.com/?t="+titulo.replace(" ", "+")+"&apikey=4cb11c13"))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();


            TituloDTO tituloDTO= gson.fromJson(response.body(), TituloDTO.class);
            Titulo titulo1 = new Titulo(tituloDTO);
            FileWriter escrita= new FileWriter("filme.txt");
            escrita.write(titulo1.toString());
            escrita.close();
            System.out.println("Meu titulo convertido: "+titulo1);
        } catch ( NumberFormatException e) {
            System.out.println("Aconteceu um erro: "+e.getMessage());
        }catch ( IllegalArgumentException e){
            System.out.println("Aconteceu um erro: "+e.getMessage());
        } catch (ErroDeConversaoAno e) {
            System.out.println(e.getMensagem());;
        }
        // System.out.println(tituloDTO);


    }
}
