package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ServiceRequest {

    private LocalDate requestDate;
    private Car car;

    private List<WorkType> plannedWorks;
    private LocalDateTime serviceDateTime;

    private ServiceType serviceType;

    private LocalDate lastServiceDate;
    private LocalDate lastRepairDate;

    private List<WorkType> completedWorks;

    private double price;
    private String mechanicRecommendation;
    
    public ServiceRequest(LocalDate requestDate,
                          Car car,
                          List<WorkType> plannedWorks,
                          LocalDateTime serviceDateTime,
                          ServiceType serviceType,
                          LocalDate lastServiceDate,
                          LocalDate lastRepairDate,
                          List<WorkType> completedWorks,
                          double price,
                          String mechanicRecommendation) {

        this.requestDate = requestDate;
        this.car = car;
        this.plannedWorks = plannedWorks;
        this.serviceDateTime = serviceDateTime;
        this.serviceType = serviceType;
        this.lastServiceDate = lastServiceDate;
        this.lastRepairDate = lastRepairDate;
        this.completedWorks = completedWorks;
        this.price = price;
        this.mechanicRecommendation = mechanicRecommendation;
    }

    public LocalDate getRequestDate() { return requestDate; }

    public Car getCar() { return car; }

    public List<WorkType> getPlannedWorks() { return plannedWorks; }

    public LocalDateTime getServiceDateTime() { return serviceDateTime; }

    public ServiceType getServiceType() { return serviceType; }

    public List<WorkType> getCompletedWorks() { return completedWorks; }

    public LocalDate getLastServiceDate() { return lastServiceDate; }

    public LocalDate getLastRepairDate() { return lastRepairDate; }

    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "\n===== ЗАЯВКА =====" +
                "\nДата заявки: " + requestDate +
                "\nАвто: " + car +
                "\nТип обслуговування: " + serviceType +
                "\nЗаплановані роботи: " + plannedWorks +
                "\nВиконані роботи: " + completedWorks +
                "\nДата ТО: " + serviceDateTime +
                "\nВартість: " + price +
                "\nРекомендації: " + mechanicRecommendation;
    }
}