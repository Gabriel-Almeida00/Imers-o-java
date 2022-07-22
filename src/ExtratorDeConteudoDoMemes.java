import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoMemes implements ExtratorDeConteudo {
    public List<Conteudo> extraiConteudos(String json) {

        // extrair só os dados que interessam: título, poster, classificação
        var parser = new JsonParser();
        List<Map<String, String>> ListaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> atributos : ListaDeAtributos) {
            String titulo = atributos.get("meme")
                    .replaceAll("(@+)(.*).jpg$", "$1.jpg");
         
            String urlImagem = atributos.get("urlImagem");

            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
