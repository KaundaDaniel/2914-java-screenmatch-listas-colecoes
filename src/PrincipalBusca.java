import br.com.alura.screenmatch.FimeManager;
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
        FimeManager fimeManager= new FimeManager();
        String titulo="";

         while (!titulo.equalsIgnoreCase("sair")){
             System.out.println("Digite o título do filme:");
             titulo = scanner.nextLine();
             if (titulo.equalsIgnoreCase("sair")) break;
                fimeManager.buscaFilme(titulo);

         }






        // System.out.println(tituloDTO);


    }
}
