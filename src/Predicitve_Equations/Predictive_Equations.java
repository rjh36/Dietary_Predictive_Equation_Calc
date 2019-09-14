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
 * 
 * @author Robert
 */
public class Predictive_Equations implements IPredictive_Equations {
// kg, cm
// age, weight, height, gender.
// RMR == resting metabolic rate.
    
// Mifflin-St Jeor equations.
    @Override
    public double MifflinStJeorM(Patient patient) {
        return 9.99 * patient.getWeight() + 6.25 * patient.getHeight() - 4.92 * patient.getAge() + 5;
    }
    
    @Override
    public double MifflinStJeorF(Patient patient) {
        return 9.99 * patient.getWeight() + 6.25 * patient.getHeight() - 4.92 * patient.getAge() - 161;
    }
    
// Harris Benedict Equations
    @Override
    public double HarrisBenedictM(Patient patient) {
        return 66.47 + 13.75 * patient.getWeight() + 5.0 * patient.getHeight() - 6.75 * patient.getAge();
    }
    
    @Override
    public double HarrisBenedictF(Patient patient) {
        return 655.09 + 9.56 * patient.getWeight() + 1.84 * patient.getHeight() - 4.67 * patient.getAge();
    }
    
// Owen Equations
    @Override
    public double OwenM(Patient patient) {
        return 879 + 10.2 * patient.getWeight();
    }
    
    @Override
    public double OwenF(Patient patient) {
        return 795 + 7.18 * patient.getWeight();
    }
    
// WHO/FAO/UNU Equations
    // 1-17 case needs accounting for.
    @Override
    public double WHO_FAO_UNUM(Patient patient) {
        if (patient.getAge() <= 30)
            return 15.3 * patient.getWeight() + 679;
        else if (patient.getAge() <= 60)
            return 11.6 * patient.getWeight() + 879;
        else
            return 13.5 * patient.getWeight() + 487;
    }
    
    @Override
    public double WHO_FAO_UNUF(Patient patient) {
        if (patient.getAge() <= 30)
            return 14.7 * patient.getWeight() + 496;
        else if (patient.getAge() <= 60)
            return 8.7 * patient.getWeight() + 829;
        else
            return 10.5 * patient.getWeight() + 596;
    }
    
// WHO/FAO/UNU Equations with height (m)
    // 1-17 case needs accounting for.
    @Override
    public double WHO_FAO_UNUM_H(Patient patient) {
        if (patient.getAge() <= 30)
            return 15.4 * patient.getWeight() - 27 * patient.getHeight() + 717;
        else if (patient.getAge() <= 60)
            return 11.3 * patient.getWeight() + 16 * patient.getHeight() + 901;
        else
            return 8.8 * patient.getWeight() + 1128 * patient.getHeight() - 1071;
    }
    
    @Override
    public double WHO_FAO_UNUF_H(Patient patient) {
        if (patient.getAge() <= 30)
            return 13.3 * patient.getWeight() + 334 * patient.getHeight() + 35;
        else if (patient.getAge() <= 60)
            return 8.7 * patient.getWeight() - 25 * patient.getHeight() + 865;
        else
            return 9.2 * patient.getWeight() + 637 * patient.getHeight() - 302;
    }
}