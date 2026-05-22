import model.*;
import service.AutoServiceManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        AutoServiceManager manager = new AutoServiceManager();

        try (Scanner scanner = new Scanner(System.in)) {

            boolean running = true;

            while (running) {

                System.out.println("\n========== АВТОСЕРВІС ==========");
                System.out.println("1 - Додати заявку");
                System.out.println("2 - Показати всі заявки");
                System.out.println("3 - Пошук за номером авто");
                System.out.println("4 - Пошук за власником");
                System.out.println("5 - Показати заплановані заявки");
                System.out.println("0 - Вихід");

                System.out.print("Ваш вибір: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:

                        System.out.println("\n===== НОВА ЗАЯВКА =====");

                        System.out.print("ПІБ власника: ");
                        String ownerName = scanner.nextLine();

                        System.out.print("Марка авто: ");
                        String brand = scanner.nextLine();

                        System.out.print("Номер авто: ");
                        String plateNumber = scanner.nextLine();

                        System.out.print("Рік випуску авто: ");
                        int year = scanner.nextInt();

                        System.out.print("Місяць випуску: ");
                        int month = scanner.nextInt();

                        System.out.print("День випуску: ");
                        int day = scanner.nextInt();
                        scanner.nextLine();

                        Owner owner = new Owner(ownerName);

                        Car car = new Car(
                                brand,
                                plateNumber,
                                LocalDate.of(year, month, day),
                                owner
                        );

                        List<WorkType> works = new ArrayList<>();

                        boolean addingWorks = true;

                        while (addingWorks) {

                            System.out.println("\nОберіть роботу:");
                            System.out.println("1 - Заміна масла");
                            System.out.println("2 - Заміна гальмівної рідини");
                            System.out.println("3 - Заміна свічок");
                            System.out.println("4 - Заміна повітряного фільтра");
                            System.out.println("5 - Діагностика двигуна");
                            System.out.println("0 - Завершити вибір");

                            int workChoice = scanner.nextInt();
                            scanner.nextLine();

                            switch (workChoice) {

                                case 1:
                                    works.add(WorkType.OIL_CHANGE);
                                    break;

                                case 2:
                                    works.add(WorkType.BRAKE_FLUID_CHANGE);
                                    break;

                                case 3:
                                    works.add(WorkType.SPARK_PLUG_REPLACEMENT);
                                    break;

                                case 4:
                                    works.add(WorkType.AIR_FILTER_REPLACEMENT);
                                    break;

                                case 5:
                                    works.add(WorkType.ENGINE_DIAGNOSTICS);
                                    break;

                                case 0:
                                    addingWorks = false;
                                    break;

                                default:
                                    System.out.println("Невірний вибір!");
                            }
                        }

                        System.out.println("\nТип обслуговування:");
                        System.out.println("1 - ТО");
                        System.out.println("2 - Регламентний ремонт");
                        System.out.println("3 - Ремонт після ДТП");

                        int serviceChoice = scanner.nextInt();
                        scanner.nextLine();

                        ServiceType serviceType;

                        switch (serviceChoice) {

                            case 1:
                                serviceType = ServiceType.TECHNICAL_SERVICE;
                                break;

                            case 2:
                                serviceType = ServiceType.REGULATED_REPAIR;
                                break;

                            case 3:
                                serviceType = ServiceType.ACCIDENT_REPAIR;
                                break;

                            default:
                                serviceType = ServiceType.TECHNICAL_SERVICE;
                        }

                        System.out.print("Вартість ремонту/ТО: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Рекомендації механіка: ");
                        String recommendation = scanner.nextLine();

                        ServiceRequest request = new ServiceRequest(
                                LocalDate.now(),
                                car,
                                works,
                                LocalDateTime.now().plusDays(2),
                                serviceType,
                                LocalDate.now().minusMonths(6),
                                LocalDate.now().minusMonths(12),
                                works,
                                price,
                                recommendation
                        );

                        manager.addRequest(request);

                        System.out.println("\nЗаявку успішно додано!");

                        break;

                    case 2:

                        System.out.println("\n===== ВСІ ЗАЯВКИ =====");

                        manager.printAllRequests();

                        break;

                    case 3:

                        System.out.print("Введіть номер авто: ");
                        String plateSearch = scanner.nextLine();

                        manager.searchByPlate(plateSearch);

                        break;

                    case 4:

                        System.out.print("Введіть ПІБ власника: ");
                        String ownerSearch = scanner.nextLine();

                        manager.searchByOwner(ownerSearch);

                        break;

                    case 5:

                        System.out.println("\n===== ЗАПЛАНОВАНІ ЗАЯВКИ =====");

                        manager.showPlannedRequests();

                        break;

                    case 0:

                        running = false;

                        System.out.println("Програму завершено.");

                        break;

                    default:

                        System.out.println("Невірний вибір!");
                }
            }
        }
    }
}