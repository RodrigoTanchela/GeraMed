/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

/**
 *
 * @author Pichau
 */
public class ExameDeSangue {
    private int id;
    private String eritrocitos;
    private String hemoglobina;
    private String hematocrito;
    private double VCM;
    private double HCM;
    private double CHCM;
    private String leucocitos;
    private int neutrofilos;
    private String plaquetas;

    public ExameDeSangue(String eritrocitos, String hemoglobina, String hematocrito, double VCM, double HCM, double CHCM, String leucocitos, int neutrofilos, String plaquetas) {
        this.eritrocitos = eritrocitos;
        this.hemoglobina = hemoglobina;
        this.hematocrito = hematocrito;
        this.VCM = VCM;
        this.HCM = HCM;
        this.CHCM = CHCM;
        this.leucocitos = leucocitos;
        this.neutrofilos = neutrofilos;
        this.plaquetas = plaquetas;
    }

    public String getEritrocitos() {
        return eritrocitos;
    }

    public String getHemoglobina() {
        return hemoglobina;
    }

    public String getHematocrito() {
        return hematocrito;
    }

    public double getVCM() {
        return VCM;
    }

    public double getHCM() {
        return HCM;
    }

    public double getCHCM() {
        return CHCM;
    }

    public String getLeucocitos() {
        return leucocitos;
    }

    public int getNeutrofilos() {
        return neutrofilos;
    }

    public String getPlaquetas() {
        return plaquetas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExameDeSangue{" + "eritrocitos=" + eritrocitos + ", hemoglobina=" + hemoglobina + ", hematocrito=" + hematocrito + ", VCM=" + VCM + 
                ", HCM=" + HCM + ", CHCM=" + CHCM + ", leucocitos=" + leucocitos + ", neutrofilos=" + neutrofilos + ", plaquetas=" + plaquetas + '}';
    }
    
    
    
    
    
    
}
