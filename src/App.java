import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {

  public static void main(String[] args) throws Exception {

    //API minhaAPI = API.MEME;

    String url = "https://linguagens-api-gabriel.herokuapp.com/linguagens";
    ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

    var http = new ClienteHttp();
   // String json = http.buscaDados(minhaAPI.url());
     String json = http.buscaDados(url);

    // exibir e manipular os dados
    // List<Conteudo> conteudos = minhaAPI.extrator().extraiConteudos(json);
    List<Conteudo> conteudos = extrator.extraiConteudos(json);
    
    var geradora = new GeradoraDeFigurinhas();

    for (int i = 0; i < conteudos.size() ; i++) {

      Conteudo conteudo = conteudos.get(i);

      Files.createDirectories(Paths.get("saida"));

      InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
      String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

      
      geradora.cria(inputStream, nomeArquivo);

      System.out.println(conteudo.getTitulo());
      System.out.println();

    } 

  }

}