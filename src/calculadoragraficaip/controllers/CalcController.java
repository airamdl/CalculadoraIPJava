package calculadoragraficaip.controllers;

import calculadoragraficaip.models.IPv4Address;
import calculadoragraficaip.views.CalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador de la calculadora, encargado de manejar la lógica de cálculo.
 */
public class CalcController {

    private CalcView view;

    public CalcController(CalcView view) {
        this.view = view;

        // Añadir listener al botón de calcular
        this.view.getCalculateButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCalculation();
            }
        });
    }

    private void handleCalculation() {
        try {
            // Obtener los valores de la vista
            String ip = view.getIPField().getText();
            String mask = view.getMaskField().getText();

            // Verificar si la máscara está en formato CIDR y dividir si es necesario
            int maskInt;
            if (mask.contains("/")) {
                String[] parts = mask.split("/");
                ip = parts[0];
                mask = parts[1];
                maskInt = Integer.parseInt(mask);
            } else {
                maskInt = Integer.parseInt(mask);
            }

            IPv4Address address = new IPv4Address(ip, maskInt);

            // Mostrar los resultados en el área de texto
            String resultados = String.format(
                    "Dirección IP: %s (%s)\n"
                    + "Máscara de red: %s (%s)\n"
                    + "Dirección de red: %s\n"
                    + "Dirección de broadcast: %s\n"
                    + "Primer host: %s\n"
                    + "Último host: %s\n"
                    + "Máximo número de hosts: %.0f\n"
                    + "Tipo: %s\n",
                    address.getIPAddress(), address.getBinaryAddress(),
                    address.getDecimalMask(), address.getBinaryMask(),
                    address.getDecimalNetwork(),
                    address.getDecimalBroadcast(),
                    address.getDecimalFirstHost(),
                    address.getDecimalLastHost(),
                    address.getMaxHosts(),
                    address.getType()
            );

            view.getResultsArea().setText(resultados);

        } catch (Exception ex) {
            view.getResultsArea().setText("Error: " + ex.getMessage());
        }
    }
}
