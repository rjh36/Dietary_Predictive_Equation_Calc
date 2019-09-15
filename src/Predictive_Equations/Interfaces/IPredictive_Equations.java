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
// Harris Benedict
    double HarrisBenedict(Patient patient);
// Mifflin-St Jeor
    double MifflinStJeor(Patient patient);
// Ireton-Jones (1992)
    double IretonJones1992(Patient patient);
// Ireton-Jones (1997)
    double IretonJones1997(Patient patient);
// Penn State (1998)
    double PennState1998(Patient patient);
// Penn State (2003)
    double PennState2003(Patient patient);
// Penn State (2010)
    double PennState2010(Patient patient);
// Swinamer (1990)
    double Swinamer1990(Patient patient);
// Brandi (1999)
    double Brandi1999(Patient patient);
// Faisy (2003)
    double Faisy2003(Patient patient);
}