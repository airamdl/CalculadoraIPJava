package calculadoragraficaip.views;

import javax.swing.*;
import java.awt.*;

/**
 * Clase de la vista para la calculadora de IPv4 con un diseño visual mejorado.
 */
public class CalcView extends JFrame {

    private JTextField ipField;
    private JTextField maskField;
    private JButton calculateButton;
    private JTextArea resultsArea;

    public CalcView() {
        setTitle("Calculadora IPv4");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Configuración principal del panel contenedor
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(250, 250, 255));
        
        // Panel de entrada con BoxLayout (vertical)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Datos de Entrada"));
        inputPanel.setBackground(new Color(230, 240, 255));

        // Campo de Dirección IP
        JLabel ipLabel = new JLabel("Dirección IP:");
        ipLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ipLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ipField = new JTextField();
        ipField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        ipField.setFont(new Font("Arial", Font.PLAIN, 14));
        ipField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 255), 2));

        // Campo de Máscara
        JLabel maskLabel = new JLabel("Máscara (CIDR):");
        maskLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        maskLabel.setFont(new Font("Arial", Font.BOLD, 14));
        maskField = new JTextField();
        maskField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        maskField.setFont(new Font("Arial", Font.PLAIN, 14));
        maskField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 255), 2));

        // Botón Calcular
        calculateButton = new JButton("Calcular");
        calculateButton.setFont(new Font("Arial", Font.BOLD, 14));
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculateButton.setBackground(new Color(60, 160, 255));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setPreferredSize(new Dimension(120, 40));

        // Agregar componentes al panel de entrada
        inputPanel.add(Box.createVerticalStrut(10)); // Espaciado superior
        inputPanel.add(ipLabel);
        inputPanel.add(Box.createVerticalStrut(5));
        inputPanel.add(ipField);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(maskLabel);
        inputPanel.add(Box.createVerticalStrut(5));
        inputPanel.add(maskField);
        inputPanel.add(Box.createVerticalStrut(15));
        inputPanel.add(calculateButton);
        inputPanel.add(Box.createVerticalStrut(10));

        // Área de resultados con desplazamiento
        resultsArea = new JTextArea();
        resultsArea.setFont(new Font("Consolas", Font.PLAIN, 13));
        resultsArea.setEditable(false);
        resultsArea.setLineWrap(true);
        resultsArea.setWrapStyleWord(true);
        resultsArea.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Resultados"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setPreferredSize(new Dimension(400, 200));

        // Agregar paneles al contenedor principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        // Agregar panel principal al JFrame
        add(mainPanel);
    }

    // Getters para los componentes
    public JTextField getIPField() {
        return ipField;
    }

    public JTextField getMaskField() {
        return maskField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JTextArea getResultsArea() {
        return resultsArea;
    }
}
