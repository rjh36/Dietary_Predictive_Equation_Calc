/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dietary_predictive_equation_calc;

/**
 *
 * @author Robert
 */
public class Patient {
    
    private int age;
    private double weight;// Kilograms.
    private double height;// Centimeters.
    private int gender;// 1 male, 0 female. Pseudo boolean for equations.
    private int trauma;// 1 yes, 0 no. Pseudo boolean for equations.
    private int burns;// 1 yes, 0 no. Pseudo boolean for equations.
    // If on a ventilator
    private int respRate;
    private int tidalVolume;
    private int heartRate;
    private double Tmax;// Celcius.
    private double Ve;// Liters/min.
    
    public Patient() {
        age = 0;
        weight = 0.0;
        height = 0.0;
        gender = 1;
        trauma = 0;
        burns = 0;
    }
    
    public Patient(int age, 
            double weight, 
            double height, 
            boolean gender, 
            boolean trauma, 
            boolean burns) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
        setTrauma(trauma);
        setBurns(burns);
    }
    
    public Patient(String age, 
            String weight, 
            String height, 
            boolean gender, 
            boolean trauma, 
            boolean burns) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
        setTrauma(trauma);
        setBurns(burns);
    }
    
    public Patient(int age, 
            double weight, 
            double height, 
            boolean gender, 
            boolean trauma, 
            boolean burns,
            int respRate,
            int tidalVolume,
            int heartRate,
            double Tmax,
            double Ve) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
        setTrauma(trauma);
        setBurns(burns);
        setRespRate(respRate);
        setTidalVolume(tidalVolume);
        setHeartRate(heartRate);
        setTmax(Tmax);
        setVe(Ve);
    }
    
    public Patient(String age, 
            String weight, 
            String height, 
            boolean gender, 
            boolean trauma, 
            boolean burns,
            String respRate,
            String tidalVolume,
            String heartRate,
            String Tmax,
            String Ve) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
        setTrauma(trauma);
        setBurns(burns);
        setRespRate(respRate);
        setTidalVolume(tidalVolume);
        setHeartRate(heartRate);
        setTmax(Tmax);
        setVe(Ve);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws IllegalArgumentException {
        if(age < 0)
            throw new IllegalArgumentException("Age must be a positive integer.");
        this.age = age;
    }
    
    public void setAge(String age) throws IllegalArgumentException {
        age = age.trim();
        try {
            this.age = Integer.parseUnsignedInt(age);
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("Age must be a positive integer.");
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws IllegalArgumentException {
        if(weight < 0)
            throw new IllegalArgumentException("Weight must be a positive number.");
        this.weight = weight;
    }
    
    public void setWeight(String weight) throws IllegalArgumentException {
        try {
            double temp = Double.parseDouble(weight.trim());
            if(temp > 0)
                this.weight = temp;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Weight must be a positive number.");
        }
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws IllegalArgumentException {
        if(height < 0)
            throw new IllegalArgumentException("Height must be a positive number.");
        this.height = height;
    }
    
    public void setHeight(String height) throws IllegalArgumentException {
        try {
            double temp = Double.parseDouble(height.trim());
            if(temp > 0)
                this.height = temp;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Height must be a positive number.");
        }
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender)  throws IllegalArgumentException {
        if(gender != 1 && gender != 0)
            throw new IllegalArgumentException("Gender has been improperly inputted.");
        this.gender = gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender ? 1 : 0;
    }
    
    public int getTrauma() {
        return trauma;
    }
    
    public void setTrauma(int trauma)  throws IllegalArgumentException {
        if(trauma != 1 && trauma != 0)
            throw new IllegalArgumentException("Trauma has been improperly inputted.");
        this.trauma = trauma;
    }
    
    public void setTrauma(boolean trauma) {
        this.trauma = trauma ? 1 : 0;
    }

    public int getBurns() {
        return burns;
    }

    public void setBurns(int burns)  throws IllegalArgumentException {
        if(burns != 1 && burns != 0)
            throw new IllegalArgumentException("Burns has been improperly inputted.");
        this.burns = burns;
    }
    
    public void setBurns(boolean burns) {
        this.burns = burns ? 1 : 0;
    }
    
    public int getRespRate() {
        return respRate;
    }

    public void setRespRate(int respRate) throws IllegalArgumentException {
        if(respRate < 0)
            throw new IllegalArgumentException("RespRate must be a positive integer.");
        this.respRate = respRate;
    }
    
    public void setRespRate(String respRate) throws IllegalArgumentException {
        try {
            this.respRate = Integer.parseUnsignedInt(respRate.trim());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("RespRate must be a positive integer.");
        }
    }

    public int getTidalVolume() {
        return tidalVolume;
    }

    public void setTidalVolume(int tidalVolume) throws IllegalArgumentException {
        if(tidalVolume < 0)
            throw new IllegalArgumentException("TidalVolume must be a positive integer.");
        this.tidalVolume = tidalVolume;
    }
    
    public void setTidalVolume(String tidalVolume) throws IllegalArgumentException {
        try {
            this.tidalVolume = Integer.parseUnsignedInt(tidalVolume.trim());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("TidalVolume must be a positive integer.");
        }
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) throws IllegalArgumentException {
        if(heartRate < 0)
            throw new IllegalArgumentException("HeartRate must be a positive integer.");
        this.heartRate = heartRate;
    }
    
    public void setHeartRate(String heartRate) throws IllegalArgumentException {
        try {
            this.heartRate = Integer.parseUnsignedInt(heartRate.trim());
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException("HeartRate must be a positive integer.");
        }
    }

    public double getTmax() {
        return Tmax;
    }

    public void setTmax(double Tmax) throws IllegalArgumentException {
        if(Tmax < 0)
            throw new IllegalArgumentException("Tmax must be a positive number.");
        this.Tmax = Tmax;
    }
    
    public void setTmax(String Tmax) throws IllegalArgumentException {
        try {
            double temp = Double.parseDouble(Tmax.trim());
            if(temp > 0)
                this.Tmax = temp;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Tmax must be a positive number.");
        }
    }

    public double getVe() {
        return Ve;
    }

    public void setVe(double Ve) throws IllegalArgumentException {
        if(Ve < 0)
            throw new IllegalArgumentException("Ve must be a positive number.");
        this.Ve = Ve;
    }
    
    public void setVe(String Ve) throws IllegalArgumentException {
        try {
            double temp = Double.parseDouble(Ve.trim());
            if(temp > 0)
                this.Ve = temp;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Ve must be a positive number.");
        }
    }
}