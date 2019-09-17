/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Predicitve_Equations;

import Predictive_Equations.Interfaces.IPredictive_Equations;
import dietary_predictive_equation_calc.Patient;

/**
 * This class holds methods for calculating the results of dietary predictive equations.
 * Add trimming for the double values
 * 
 * @author Robert
 */
public class Predictive_Equations implements IPredictive_Equations {
// Harris Benedict
    @Override
    public double HarrisBenedict(Patient patient) {
        if(patient.getGender() == 1)
            return 13.75*patient.getWeight()
                    + 5*patient.getHeight()
                    - 6.8*patient.getAge()
                    + 66;
        else
            return 1.8*patient.getHeight()
                    + 9.6*patient.getWeight()
                    - 4.7*patient.getAge()
                    + 655;
    }
    
// Mifflin-St. Jeor (1990)
    @Override
    public double MifflinStJeor(Patient patient) {
        if(patient.getGender() == 1)
            return 10*patient.getWeight()
                    + 6.25*patient.getHeight()
                    - 5*patient.getAge()
                    + 5;
        else
            return 10*patient.getWeight()
                    + 6.25*patient.getHeight()
                    - 5*patient.getAge()
                    - 161;
    }
    
// Ireton-Jones (1992)
    @Override
    public double IretonJones1992(Patient patient) {
        return 1925 
                - 10*patient.getAge()
                + 5*patient.getWeight()
                + 281*patient.getGender()
                + 292*patient.getTrauma()
                + 851*patient.getBurns();
    }
    
// Ireton-Jones (1997)
    @Override
    public double IretonJones1997(Patient patient) {
        return 1784 
                + 5*patient.getWeight()
                - 11*patient.getAge()
                + 244*patient.getGender()
                + 239*patient.getTrauma()
                + 804*patient.getBurns();
    }
    
// Penn State (1998)
    @Override
    public double PennState1998(Patient patient) {
        return 1.1*HarrisBenedict(patient)
                + 140*patient.getTmax()
                - 32*patient.getVe()
                - 5340;
    }
    
// Penn State (2003)
    @Override
    public double PennState2003(Patient patient) {
        return 0.96*MifflinStJeor(patient)
                + 167*patient.getTmax()
                - 31*patient.getVe()
                - 6212;
    }
// Penn State (2010)
    @Override
    public double PennState2010(Patient patient) {
        return 0.71*MifflinStJeor(patient)
                + 85*patient.getTmax()
                - 64*patient.getVe()
                - 3085;
    }
// Swinamer (1990)
    @Override
    public double Swinamer1990(Patient patient) {
        return 945*BSA(patient) 
                - 64*patient.getAge()
                + 108*patient.getTmax()
                + 24.2*patient.getRespRate()
                + 817*patient.getTidalVolume()
                - 4349;
    }
// Brandi (1999)
    @Override
    public double Brandi1999(Patient patient) {
        return 0.96*HarrisBenedict(patient)
                + 7*patient.getHeartRate()
                + 48*patient.getVe()
                - 702;
    }
// Faisy (2003)
    @Override
    public double Faisy2003(Patient patient) {
        return 8*patient.getWeight()
                + 14*patient.getHeight()
                + 42*patient.getVe()
                + 94*patient.getTmax()
                - 4834;
    }
    
// Body surface area
    private double BSA(Patient patient) {
        return Math.sqrt((patient.getWeight()*patient.getHeight()) / 3600);
    }
}