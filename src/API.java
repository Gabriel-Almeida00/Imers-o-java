public enum API {

    IMDB("https://api.mocki.io/v2/549a5d8b",
     new ExtratorDeConteudoDoIMDB()),

    NASA("https://api.mocki.io/v2/549a5d8b/NASA-APOD",
     new ExtratorDeConteudoDaNasa()),

    MEME("https://api.mocki.io/v2/549a5d8b/Memes",
     new ExtratorDeConteudoDoMemes());

    private String url;
    private ExtratorDeConteudo extrator;

     API(String url, ExtratorDeConteudo extrator) {
        this.url = url;
        this.extrator = extrator;
    }

    public String url() {
        return url;
    }

    public ExtratorDeConteudo extrator() {
        return extrator;
    }
}
