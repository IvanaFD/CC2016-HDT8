
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase Patient
 * Esta clases declara las caracteristicas de un paciente y usando un compareTo para ordenar por categoria de prioridad
 * 
 */

public class Patient implements Comparable<Patient>{

    
    private String name;
    private String symptom;
    private char category;



    /**
     * Constructor de lso atributos del paciente
     * 
     * @param name nombre del pacienye
     * @param symptom sintoma que posee el paciente
     * @param category categoría de la prioridad del paciente
     * @throws IllegalArgumentException si se presenta una categoría que no este en el rango permitido (A-E)
     */

    public Patient (String name, String symptom, char category){
        if (category < 'A' || category > 'E'){
            throw new IllegalArgumentException("La categoria de emergencia solo puede ser entre A y E");
        }
            this.name = name;
            this.symptom = symptom;
            this.category = category;

    }

    
    /**
     * 
     * compara la categoria de prioridad de los paciente
     * 
     * @param other el otro paciente con el que se compara la prioridad
     * @return -1 si es mayor la prioridad del paciente, 1 si es menor la prioridad del paciente, 0 si tienen igual prioridad
     * 
     */

    @Override
    public int compareTo(Patient other){
        if (this.category < other.category){
            return -1;
        }else if (this.category > category){
            return 1;
        }
        return 0;

    }


    //Getters
    public String getName(){
        return name;
    }

    public String getSymptom(){
        return symptom;
    }

    public char getCategory(){
        return category;
    }

    /**\
     * Devuelve los datos del paciente
     * 
     * @return decuelve una cadena con los datos del paciente
     *       
     */

    @Override 
    public String toString(){
        return "  Nombre: "+ name +"  sintoma: "+ symptom +"  categoria de la prioridad: "+ category;
    }
}


