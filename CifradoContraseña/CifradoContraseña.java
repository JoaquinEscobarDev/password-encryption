import javax.swing.JOptionPane;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradoContraseña {

        public static void main(String[] args) {
    // Obtener la contraseña del usuario mediante JOptionPane
            String contraseña = JOptionPane.showInputDialog("Ingrese su contraseña:");
    
    // Cifrar la contraseña
            String contraseñaCifrada = cifrarContraseña(contraseña);
    
    // Mostrar la contraseña cifrada (en un entorno real, deberías almacenarla de manera segura)
            JOptionPane.showMessageDialog(null, "Contraseña cifrada: " + contraseñaCifrada);
        }
    
   // Método para cifrar la contraseña usando SHA-256
        private static String cifrarContraseña(String contraseña) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(contraseña.getBytes());
    
   // Convertir el hash a una representación hexadecimal
                StringBuilder hexString = new StringBuilder();
                for (byte b : hash) {
                    String hex = Integer.toHexString(0xff & b);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
    
                return hexString.toString();
            } catch (NoSuchAlgorithmException e) {
    // Manejo de excepciones si el algoritmo no está disponible
                e.printStackTrace();
                return null;
            }
        }
    }
    