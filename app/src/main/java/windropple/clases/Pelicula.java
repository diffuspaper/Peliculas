package windropple.clases;

/**
 * Created by Sistemas on 30/07/2015.
 */
public class Pelicula {

    public Pelicula(){

    }

    public Pelicula(long idLocal, long idMovieDatabase, String imgSrc, String titulo, String fechaEstreno, String duracion, String sipnosis, String rating, String frase, String pagina) {
        this.idLocal = idLocal;
        this.idMovieDatabase = idMovieDatabase;
        this.imgSrc = imgSrc;
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.sipnosis = sipnosis;
        this.rating = rating;
        this.frase = frase;
        this.pagina = pagina;
    }

    public long getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(long idLocal) {
        this.idLocal = idLocal;
    }

    public long getIdMovieDatabase() {
        return idMovieDatabase;
    }

    public void setIdMovieDatabase(long idMovieDatabase) {
        this.idMovieDatabase = idMovieDatabase;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(String fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSipnosis() {
        return sipnosis;
    }

    public void setSipnosis(String sipnosis) {
        this.sipnosis = sipnosis;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    private long idLocal;
    private long idMovieDatabase;
    private String imgSrc;
    private String titulo;
    private String fechaEstreno;
    private String duracion;
    private String sipnosis;
    private String rating;
    private String frase;
    private String pagina;
}
