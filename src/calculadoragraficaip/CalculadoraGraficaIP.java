package calculadoragraficaip;

import calculadoragraficaip.controllers.CalcController;
import calculadoragraficaip.views.CalcView;

/**
 * Clase principal de la aplicación Calculadora Gráfica para IPv4.
 */
public class CalculadoraGraficaIP {

    /**
     * Método principal que inicia la aplicación.
     *
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {
        CalcView view = new CalcView();
        view.setVisible(true);

        // Crear el controlador
        new CalcController(view);
    }
}
