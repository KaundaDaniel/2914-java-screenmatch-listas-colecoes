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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String titulo="";
        List<Titulo> titulos = new ArrayList<Titulo>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

         while (!titulo.equalsIgnoreCase("sair")){
             System.out.println("Digite o título do filme:");
             titulo = scanner.nextLine();
             if (titulo.equalsIgnoreCase("sair")) break;

             try {

                 HttpClient client = HttpClient.newHttpClient();
                 HttpRequest request = HttpRequest.newBuilder()
                         .uri(URI.create("https://www.omdbapi.com/?t="+titulo.replace(" ", "+")+"&apikey=4cb11c13"))
                         .build();

                 HttpResponse<String> response = client
                         .send(request, HttpResponse.BodyHandlers.ofString());
                 //System.out.println(response.body());



                 TituloDTO tituloDTO= gson.fromJson(response.body(), TituloDTO.class);
                 Titulo titulo1 = new Titulo(tituloDTO);
                 titulos.add(titulo1);


                // System.out.println("Meu titulo convertido: "+titulo1);
             } catch ( NumberFormatException e) {
                 System.out.println("Aconteceu um erro: "+e.getMessage());
             }catch ( IllegalArgumentException e){
                 System.out.println("Aconteceu um erro: "+e.getMessage());
             } catch (ErroDeConversaoAno e) {
                 System.out.println(e.getMensagem());;
             }

         }
        System.out.println(titulos);

                 FileWriter escrita= new FileWriter("filme.json");
                 escrita.write(gson.toJson(titulos));
                 escrita.close();




        // System.out.println(tituloDTO);


    }
}
