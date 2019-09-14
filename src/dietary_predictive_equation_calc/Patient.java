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
    private boolean gender;// True male, False female.
    
    public Patient() {
        age = 0;
        weight = 0.0;
        height = 0.0;
        gender = true;
    }
    
    public Patient(int age, double weight, double height, boolean gender) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
    }
    
    public Patient(String age, String weight, String height, boolean gender) throws IllegalArgumentException {
        setAge(age);
        setWeight(weight);
        setHeight(height);
        setGender(gender);
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
            weight = weight.trim();
            double w = Double.parseDouble(weight);
            if(w > 0)
                this.weight = w;
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
            height = height.trim();
            double h = Double.parseDouble(height);
            if(h > 0)
                this.height = h;
            else
                throw new NumberFormatException();
        }
        catch(NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Height must be a positive number.");
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
    @Override
    public String toString() {
        return age + " " + weight + " " + height + " " + gender;
    }    
}