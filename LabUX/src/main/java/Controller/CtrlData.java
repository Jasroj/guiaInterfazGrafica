/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Random;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JRS
 */
public class CtrlData {

    public void fillTickets(JTable tblTable) {
        DefaultTableModel tableModel = (DefaultTableModel) tblTable.getModel();
        List<String> valueList = Data.getValueList();
        if (valueList.size() > 0) {
            Random random = new Random();

            for (String tiquete : valueList) {
                int transitTime = random.nextInt(24) + 2;
                int caja = random.nextInt(4) + 1;
                tableModel.addRow(new Object[]{tiquete, "Caja " + caja, transitTime + " minutos"});
            }
        }
    }

    private static String whoseFirst(String edad, String urgencia, int asuntos) {

        if (Integer.parseInt(edad) >= 65) {
            return "A";
        }

        if (asuntos >= 2) {
            return "C";
        }

        if (urgencia != null && (urgencia.equalsIgnoreCase("Embarazada") || urgencia.equalsIgnoreCase("Niño en brazos"))) {
            return "B";
        }

        return "D";
    }

    private static DefaultTableModel tableModel(JTable tblTable) {
        DefaultTableModel tableModel;
        if (tblTable.getModel() instanceof DefaultTableModel) {
            tableModel = (DefaultTableModel) tblTable.getModel();
        } else {
            tableModel = new DefaultTableModel();
            tblTable.setModel(tableModel);

            tableModel.addColumn("Tiquete");
            tableModel.addColumn("Caja");
            tableModel.addColumn("Tiempo");
        }
        return tableModel;
    }

    public static void show(JTable tblTable, JTextArea txtSeen) {
        DefaultTableModel tableModel = (DefaultTableModel) tblTable.getModel();
        int totalCustomersServed = tableModel.getRowCount();
        int[] customersServedByCounter = new int[4];
        int totalWaitTime = 0;

        for (int i = 0; i < totalCustomersServed; i++) {
            String counterStr = tableModel.getValueAt(i, 1).toString();
            int counter = Integer.parseInt(counterStr.substring(counterStr.length() - 1)) - 1;

            customersServedByCounter[counter]++;
            totalWaitTime += Integer.parseInt(tableModel.getValueAt(i, 2).toString().split(" ")[0]);
        }

        StringBuilder result = new StringBuilder("Number of customers served by counter:\n");
        for (int i = 0; i < customersServedByCounter.length; i++) {
            result.append("Counter ").append(i + 1).append(": ").append(customersServedByCounter[i]).append(" customers\n");
        }

        double averageWaitTime = (double) totalWaitTime / totalCustomersServed;
        result.append("\nAverage wait time by counter: ").append(averageWaitTime).append(" minutes\n");

        result.append("\nTotal customers entered the bank: ").append(totalCustomersServed).append(" customers");

        txtSeen.setText(result.toString());
    }

}
