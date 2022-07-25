import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;

public class GeradoraDeFigurinhas {

    public void cria(InputStream InputStream, String nomeArquivo) throws Exception {

        // leitura da imagem

        // InputStream inputStream =

        // new FileInputStream(new File("entrada/filme-maior.jpg"));

        // InputStream inputStream =

        // new
        // URL("https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")

        // .openStream();

        BufferedImage imagemOriginal = ImageIO.read(InputStream);

       // cria nova imagem em memória com transparência e com tamanho novo
       int largura = imagemOriginal.getWidth();
       int altura = imagemOriginal.getHeight();
       int novaAltura = altura + 500;
       BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

       // copiar a imagem original para nova imagem (em memória)
       Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
       graphics.drawImage(imagemOriginal, 0, 250, null);

       // configurar a fonte
       var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 60);
       graphics.setColor(Color.magenta);
       graphics.setFont(fonte);

       // escrever uma frase na nova imagem
       graphics.drawString("TOP D+", 25, novaAltura - 200);

   
       // escrever a nova imagem em um arquivo
       ImageIO.write(novaImagem, "png", new File(nomeArquivo));
    }

}