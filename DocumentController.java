
/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo 8
 * Ivana Figueroa - 24785
 * Clase DocumentControler
 * Se encarga de cargar todos los datos almacenados en un documento .txt con las caracteristicas de los pacientes
 * 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DocumentController {

    /**
     * Carga pacientes desde un archivo.
     * @param filename Ruta del archivo a leer
     * @return Lista de pacientes cargados
     * @throws IOException Si ocurre un error al leer el archivo
     */

    public static List<Patient> loadPatients(String filename){
        List<Patient> patients = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    patients.add(new Patient(parts[0].trim(),parts[1].trim(), parts[2].trim().charAt(0)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

}
 

