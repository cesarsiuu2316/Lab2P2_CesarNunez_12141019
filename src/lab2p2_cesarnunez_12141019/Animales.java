
package lab2p2_cesarnunez_12141019;


public class Animales {
    
    private String nCientifico;
    private String nComun;
    private String habitat;
    private String alimentacion;
    private String rasgos; // descripcion de rasgos
    private String geografica; // distribución geográfica
    private int vida;

    public Animales(String nCientifico, String nComun, String habitat, String alimentacion, String rasgos, String geografica, int vida) {
        this.nCientifico = nCientifico;
        this.nComun = nComun;
        this.habitat = habitat;
        this.alimentacion = alimentacion;
        this.rasgos = rasgos;
        this.geografica = geografica;
        this.vida = vida;
    }
    
    public Animales(){}

    public String getnCientifico() {
        return nCientifico;
    }

    public void setnCientifico(String nCientifico) {
        this.nCientifico = nCientifico;
    }

    public String getnComun() {
        return nComun;
    }

    public void setnComun(String nComun) {
        this.nComun = nComun;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getRasgos() {
        return rasgos;
    }

    public void setRasgos(String rasgos) {
        this.rasgos = rasgos;
    }

    public String getGeografica() {
        return geografica;
    }

    public void setGeografica(String geografica) {
        this.geografica = geografica;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    @Override
    public String toString(){
        return "Nombre científico " + nCientifico + 
                ", Nombre común " + nComun +
                ", Hábitat " + habitat +
                ", Alimentación " + alimentacion +
                ", Descripción de rasgos " + rasgos +
                ", Distribución geográfica " + geografica +
                ", Vida " + vida;                
    }
    
}
