/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Ciclista extends Persona{
    
private int rankingMundial;

    public Ciclista(String nombre, String pais, int rankingMundial) {
        super(nombre, pais); 
        this.rankingMundial = rankingMundial;
    }
    
@Override
    public String toString() {
        return "CICLISTA -> " + super.toString() + " | Ranking: " + rankingMundial;
    }


    public int calcularPuntos(int puntosBase) {
        return puntosBase + 10;
    }


    public int calcularPuntos(int puntosBase, String medalla) {
        int total = puntosBase;
        
        if (medalla.equalsIgnoreCase("Oro")) {
            total += 100;
            if (this.rankingMundial < 10) { 
                total += 50; 
            }
        } else if (medalla.equalsIgnoreCase("Plata")) {
            total += 50;
        }
        return total;
    }
    
    public int getRankingMundial() { return rankingMundial; }
    public void setRankingMundial(int rankingMundial) { this.rankingMundial = rankingMundial; }
}
