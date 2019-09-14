/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Predictive_Equations.Interfaces;

import dietary_predictive_equation_calc.Patient;

/**
 *
 * @author Robert
 */
public interface IPredictive_Equations {
// Mifflin-St Jeor equations.
    double MifflinStJeorM(Patient patient);
    double MifflinStJeorF(Patient patient);
// Harris Benedict Equations
    double HarrisBenedictM(Patient patient);
    double HarrisBenedictF(Patient patient);
// Owen Equations
    double OwenM(Patient patient);
    double OwenF(Patient patient);
// WHO/FAO/UNU Equations
    double WHO_FAO_UNUM(Patient patient);
    double WHO_FAO_UNUF(Patient patient);
// WHO/FAO/UNU Equations with height(m)
    double WHO_FAO_UNUM_H(Patient patient);
    double WHO_FAO_UNUF_H(Patient patient);
}