package models;

public class Viaje {
    private int id;
    private String nombre;
    private String pais;
    private double puntuacion;
    private int isFavorite;
    private String urlImage;
    private int userId; 

    public Viaje() {
    }

    public Viaje(int id, String nombre, String pais, double puntuacion, int isFavorite, String urlImage, int userId) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.puntuacion = puntuacion;
        this.isFavorite = isFavorite;
        this.urlImage = urlImage;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
