package ru.toyota.deals;

import java.io.FileWriter;
import java.io.IOException;

public class Report {

    private String managerName;
    private final String[] sales;
    private int salesCount;

    public Report(int maxSales,String managerName) {
        this.sales = new String[maxSales];
        this.salesCount = 0;
        this.managerName = managerName;
    }

    public String[] getSales() {
        return sales;
    }

    public int getSalesCount() {
        return salesCount;
    }

    public void addSale(String saleInfo) {
        if (salesCount < sales.length) {
            sales[salesCount++] = saleInfo;
        }
    }

    public void generateReportTxt() {
        try (FileWriter writer = new FileWriter(managerName + " report.txt")) {
            writer.write("Менеджер: " + managerName + "\n");
            for (int i = 0; i < salesCount; i++) {
                writer.write(sales[i] + "\n");
            }
            writer.write("Total Sales: " + salesCount + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
