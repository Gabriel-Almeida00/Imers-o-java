import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics2D;

import java.awt.image.BufferedImage;

import java.io.File;

import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public void cria(InputStream InputStream, String nomeArquivo) throws IOException {

        BufferedImage imagemOriginal = ImageIO.read(InputStream);

        // cria nova imagem em memória com transparência e com tamanho novo

        int largura = 800;

        int altura = 1600;

        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        // copiar a imagem original pra novo imagem (em memória)

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();

        graphics.drawImage(imagemOriginal, 0, 0, largura, altura - 300, null);

        // configurar a fonte

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 94);

        graphics.setColor(Color.YELLOW);

        graphics.setFont(fonte);

        // imprimir uma foto

        InputStream foto = new FileInputStream("entrada/gabriel_foto.png");

        BufferedImage fotoOriginal = ImageIO.read(foto);

        graphics.drawImage(fotoOriginal, 350, altura - 700, 550, 700, null);

        // escrever uma frase na nova imagem

        graphics.drawString("TOPEZERA", largura / 12, altura - 100);

        // escrever a nova imagem em um arquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

}