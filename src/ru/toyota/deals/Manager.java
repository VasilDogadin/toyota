package ru.toyota.deals;

import ru.toyota.cars.Car;
import ru.toyota.cars.CarColor;
import ru.toyota.cars.CarWarehouse;
import ru.toyota.cars.CountryFactory;

public class Manager {

    private final static float CAR_COST_PRICE_CAMRY = 5_000.00f;
    private final static float CAR_COST_PRICE_SOLARA = 8_000.00f;
    private final static float CAR_COST_PRICE_HIACE = 10_000.00f;
    private final static float CAR_COST_PRICE_DYNA = 12_000.00f;

    private String managerName;
    private CarWarehouse warehouse;
    private CountryFactory countryFactory;
    private Report report;

    private static final int MAX_SALES = 100;
    private String[] salesInfo;
    private int salesCount;

    public Manager(String managerName, CarWarehouse warehouse, CountryFactory countryFactory, Report report) {
        this.managerName = managerName;
        this.warehouse = warehouse;
        this.countryFactory = countryFactory;
        this.salesInfo = new String[MAX_SALES];
        this.salesCount = 0;
        this.report = report;
    }

    public CarWarehouse getWarehouse() {
        return warehouse;
    }

    public CountryFactory getCountryFactory() {
        return countryFactory;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setName(String ManagerName) {
        this.managerName = ManagerName;
    }

    public void sellCarToBuyer(Buyer buyer, Cashier cashier) {
        Car car = null;

        if (buyer.getBudget() >= 30_000.00f) {
            car = warehouse.getDynaCar();
            if (car == null) {
                car = countryFactory.createDyna(CarColor.LUNAR_ROCK, 30_000.00f);
            }
        } else if (buyer.getBudget() >= 22_000.00f) {
            car = warehouse.getDynaCar();
            if (car == null) {
                car = countryFactory.createDyna(CarColor.LUNAR_ROCK, 22_000.00f);
            }
        } else if (buyer.getBudget() >= 15_000.00f) {
            car = warehouse.getHiaceCar();
            if (car == null) {
                car = countryFactory.createHiace(CarColor.SUPER_WHITE, 15_000.00f);
            }
        } else if (buyer.getBudget() >= 13_000.00f) {
            car = warehouse.getSolaraCar();
            if (car == null) {
                car = countryFactory.createSolara(CarColor.BLUE_FLAME, 13_000.00f);
            }
        } else if (buyer.getBudget() >= 12_000.00f) {
            car = warehouse.getSolaraCar();
            if (car == null) {
                car = countryFactory.createSolara(CarColor.BLUE_FLAME, 12_000.00f);
            }
        } else if (buyer.getBudget() >= 11_000.00f) {
            car = warehouse.getCamryCar();
            if (car == null) {
                car = countryFactory.createCamry(CarColor.BLACK_SAND_PEARL, 11_000.00f);
            }
        } else if (buyer.getBudget() >= 10_000.00f) {
            car = warehouse.getCamryCar();
            if (car == null) {
                car = countryFactory.createCamry(CarColor.BLACK_SAND_PEARL, 10_000.00f);
            }
        }

        if (car != null && buyer.getBudget() >= car.getPriceInDollars()) {
            buyer.buyCar(car);
            cashier.acceptCar(car);
            salesInfo[salesCount++] = car.getName() + " - " + car.getPriceInDollars() + " - " + getCostPrice(car);
            System.out.println("Продан: " + car.getName() + " покупателю " + buyer.getName());
        } else {
            System.out.println("Недостаточно бюджета у покупателя " + buyer.getName());
        }
    }

    private float getCostPrice(Car car) {
        return switch (car.getName()) {
            case "Camry" -> CAR_COST_PRICE_CAMRY;
            case "Solara" -> CAR_COST_PRICE_SOLARA;
            case "Hiace" -> CAR_COST_PRICE_HIACE;
            case "Dyna" -> CAR_COST_PRICE_DYNA;
            default -> 0.00f;
        };
    }

    private float calculateExpenses() {
        float totalCost = 0;

        for (int i = 0; i < salesCount; i++) {
            String[] saleInfo = salesInfo[i].split(" - ");
            float costPrice = Float.parseFloat(saleInfo[2]);
            totalCost += costPrice;
        }
        return totalCost;
    }

    private float calculateProfit() {
        float totalRevenue = 0;

        for (int i = 0; i < salesCount; i++) {
            String[] saleInfo = salesInfo[i].split(" - ");
            float salePrice = Float.parseFloat(saleInfo[1]);
            totalRevenue += salePrice;
        }

        float expenses = calculateExpenses();
        return totalRevenue - expenses;
    }

    public void generateReport(Cashier cashier) {

        float expenses = calculateExpenses();
        float profit = calculateProfit();

        System.out.println();
        StringBuilder report = new StringBuilder();
        report.append("*** Отчёт ***" + "\n")
                .append("Отчет менеджера: ")
                .append(getManagerName());
        for (int i = 0; i < salesCount; i++) {
            report.append(salesInfo[i]).append("\n");
        }
        report.append("Итог: доходы - ").append(cashier.getTotalIncome())
                .append("$")
                .append(", расходы - ").append(expenses)
                .append("$")
                .append(", прибыль - ").append(profit)
                .append("$");
        System.out.println(report);
    }
}
