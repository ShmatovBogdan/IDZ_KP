package service;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import model.ServiceRequest;

public class AutoServiceManager {

    private List<ServiceRequest> requests = new ArrayList<>();

    // Додати заявку
    public void addRequest(ServiceRequest request) {
        requests.add(request);
    }

    // Загальна форма заявки
    public void printAllRequests() {
        requests.forEach(System.out::println);
    }

    // Список робіт для механіка за номером авто
    public void findWorksByPlate(String plate) {
        for (ServiceRequest request : requests) {
            if (request.getCar().getPlateNumber().equalsIgnoreCase(plate)) {
                System.out.println("Роботи для авто " + plate + ":");
                System.out.println(request.getPlannedWorks());
            }
        }
    }

    // Список ремонтів за датою
    public void findRequestsByDate(LocalDate date) {
        for (ServiceRequest request : requests) {
            if (request.getRequestDate().equals(date)) {
                System.out.println(request);
            }
        }
    }

    // Список запланованих заявок
    public void showPlannedRequests() {
        System.out.println("Заплановані заявки:");

        for (ServiceRequest request : requests) {
            System.out.println(request.getCar().getPlateNumber() +
                    " -> " + request.getServiceDateTime());
        }
    }

    // Пошук авто за номером
    public void searchByPlate(String plate) {
        for (ServiceRequest request : requests) {
            if (request.getCar().getPlateNumber().equalsIgnoreCase(plate)) {
                System.out.println(request);
            }
        }
    }

    // Пошук за власником
    public void searchByOwner(String ownerName) {
        for (ServiceRequest request : requests) {
            if (request.getCar().getOwner().getFullName()
                    .equalsIgnoreCase(ownerName)) {
                System.out.println(request);
            }
        }
    }
}