package Service;



import Route.Route;
import Route.RouteServices;
import Route.Station;
import Route.StationService;
import Ticket.Ticket;
import Ticket.FirstClass;
import Ticket.SecondClass;
import Ticket.BunkBed;
import TicketServices.TicketService;
import Train.Train;
import Train.Boogie;
import Train.PassengerTrain;
import TrainServices.TrainService;
import User.UserService;
import User.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Service {
    private static Service instance;
    private static TicketService ticketService = TicketService.getInstance();
    private static TrainService trainService = TrainService.getInstance();
    private static UserService userService = UserService.getInstance();
    private static RouteServices routeService = RouteServices.getInstance();
    private static StationService stationsService = StationService.getInstance();

    private Scanner scanner = new Scanner(System.in);

    public static Service getInstance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }

    Train readTrain(){
        System.out.println("0 - Boogie");
        System.out.println("1 - Passenger Train");
        int option = scanner.nextInt();
        if(option == 0){
            Boogie boogie = new Boogie();
            System.out.println("id = ");
            boogie.setId(scanner.nextInt());

            System.out.println("name = ");
            boogie.setName(scanner.next());

            System.out.println("speed = ");
            boogie.setSpeed(scanner.nextDouble());

            System.out.println("number of waggons = ");
            boogie.setNumberOWaggons(scanner.nextInt());

            System.out.println("fuel cost = ");
            boogie.setFuelCost(scanner.nextDouble());

            System.out.println("number of materials and quantities = ");
            int nr = scanner.nextInt();
            ArrayList<String> mat = new ArrayList<>();
            ArrayList<Double> qua = new ArrayList<>();
            System.out.println("materials and quantities = ");
            for(int i = 0; i < nr; ++i){
                System.out.println("material = ");
                mat.add(scanner.next());
                System.out.println("quantity = ");
                qua.add(scanner.nextDouble());
            }
            boogie.setMaterials(mat);
            boogie.setQuantity(qua);

            return boogie;
        } else {
            PassengerTrain passengerTrain = new PassengerTrain();
            System.out.println("id = ");
            passengerTrain.setId(scanner.nextInt());

            System.out.println("name = ");
            passengerTrain.setName(scanner.next());

            System.out.println("speed = ");
            passengerTrain.setSpeed(scanner.nextDouble());

            System.out.println("number of waggons = ");
            passengerTrain.setNumberOWaggons(scanner.nextInt());

            System.out.println("fuel cost = ");
            passengerTrain.setFuelCost(scanner.nextDouble());

            System.out.println("number of seats = ");
            passengerTrain.setNumberOfSeats(scanner.nextInt());

            System.out.println("number of classes = ");
            passengerTrain.setNumberOfClasses(scanner.nextInt());

            return passengerTrain;
        }
    }

    Station readStation() throws ParseException {
        Station station = new Station();
        System.out.println("id = ");
        station.setId(scanner.nextInt());

        System.out.println("name = ");
        station.setName(scanner.next());

        System.out.println("city = ");
        station.setCity(scanner.next());

        System.out.println("country = ");
        station.setCountry(scanner.next());

        System.out.println("date = ");
        String date = scanner.next();
        Date date_date = new SimpleDateFormat("dd/MM/yyyy").parse(date);
        station.setEstablishmentDate(date_date);

        return station;
    }

    Route readRoute() throws ParseException {
        Route route = new Route();

        System.out.println("id = ");
        route.setId(scanner.nextInt());

        List<Train> trains = new ArrayList<>();
        System.out.println("number of trains = ");
        int nr = scanner.nextInt();
        System.out.println("trains = ");
        for(int i = 0; i < nr; ++i){
            trains.add(readTrain());
        }
        route.setTrains(trains);

        System.out.println("destination = ");
        route.setDestination(readStation());

        System.out.println("origin = ");
        route.setOrigin(readStation());

        System.out.println("distance = ");
        route.setDistance(scanner.nextDouble());

        return route;
    }

    Ticket readTicket() throws ParseException { // 0 = FirstClass; 1 = SecondClass; 2 = BunkBed
        System.out.println("0 - First Class");
        System.out.println("1 - Second Class");
        System.out.println("2 - Bunk Bed");
        int option = scanner.nextInt();
        if(option == 0){
            FirstClass firstClass = new FirstClass();
            System.out.println("id = ");
            firstClass.setId(scanner.nextInt());

            System.out.println("price = ");
            firstClass.setPrice(scanner.nextDouble());

            System.out.println("seat = ");
            firstClass.setSeat(scanner.nextInt());

            System.out.println("Route = ");
            firstClass.setRoute(readRoute());

            System.out.println("number of meals included = ");
            int nr = scanner.nextInt();
            System.out.println("meals included = ");
            ArrayList arr = new ArrayList<>();
            for(int i = 0; i < nr; ++i){
                arr.add(scanner.next());
            }
            TreeSet t = new TreeSet(arr);
            firstClass.setMealsIncluded(t);

            return firstClass;

        } else if (option == 1){
            SecondClass secondClass = new SecondClass();

            System.out.println("id = ");
            secondClass.setId(scanner.nextInt());

            System.out.println("price = ");
            secondClass.setPrice(scanner.nextDouble());

            System.out.println("seat = ");
            secondClass.setSeat(scanner.nextInt());

            System.out.println("route = ");
            secondClass.setRoute(readRoute());

            System.out.println("discount = ");
            secondClass.setDiscount(scanner.nextDouble());

            return secondClass;
        } else {
            BunkBed bunkBed = new BunkBed();

            System.out.println("id = ");
            bunkBed.setId(scanner.nextInt());

            System.out.println("price = ");
            bunkBed.setPrice(scanner.nextDouble());

            System.out.println("seat = ");
            bunkBed.setSeat(scanner.nextInt());

            System.out.println("route = ");
            bunkBed.setRoute(readRoute());

            System.out.println("top bed = true & bottom bed = false ");
            bunkBed.setBedPosition(scanner.nextBoolean());

            return bunkBed;
        }
    }

    public User readUser(){
        User user = new User();
        System.out.println("id = ");
        user.setId(scanner.nextInt());

        System.out.println("name = ");
        user.setName(scanner.next());

        System.out.println("phone number = ");
        user.setPhoneNumber(scanner.next());

        System.out.println("email = ");
        user.setEmail(scanner.next());

        System.out.println("address = ");
        user.setAddress(scanner.next());

        return user;
    }

    public void printOptions(){
        System.out.println("0 - Tickets");
        System.out.println("1 - Trains");
        System.out.println("2 - Routes");
        System.out.println("3 - Stations");
        System.out.println("4 - Users");
        System.out.println("5 - Exit");
    }

    public void menu() throws ParseException {
        while(true){
            printOptions();
            int option = scanner.nextInt();
            if(option == 0){
                while(true){
                    System.out.println(" 0 - Get All");
                    System.out.println(" 1 - Get By Id");
                    System.out.println(" 2 - Add");
                    System.out.println(" 3 - Update");
                    System.out.println(" 4 - Delete");
                    System.out.println(" 5 - Exit");
                    int opt = scanner.nextInt();
                    if(opt == 0){
                        for(int i = 0; i < ticketService.getTickets().size(); ++i){
                            ticketService.getTickets().get(i).ticketInfo();
                        }
                    } else if(opt == 1){
                        int index = scanner.nextInt();
                        for(int i = 0; i < ticketService.getTickets().size(); ++i){
                            if(ticketService.getTickets().get(i).getId() == index){
                                ticketService.getTickets().get(i).ticketInfo();
                                break;
                            }
                        }
                    } else if(opt == 2){
                        Ticket ticket = readTicket();
                        ticketService.addTicket(ticket);
                    } else if(opt == 3){
                        int index = scanner.nextInt();
                        for(int i = 0; i < ticketService.getTickets().size(); ++i){
                            if(ticketService.getTickets().get(i).getId() == index){
                                Ticket ticket = readTicket();
                                ticketService.updateTicket(index, ticket);
                                break;
                            }
                        }
                    } else if(opt == 4){
                        int index = scanner.nextInt();
                        ticketService.deteleTicket(index);
                    } else {
                        break;
                    }
                }
            } else if(option == 1){
                while(true){
                    System.out.println(" 0 - Get All");
                    System.out.println(" 1 - Get By Id");
                    System.out.println(" 2 - Add");
                    System.out.println(" 3 - Update");
                    System.out.println(" 4 - Delete");
                    System.out.println(" 5 - Exit");
                    int opt = scanner.nextInt();
                    if(opt == 0){
                        for(int i = 0; i < trainService.getTrains().size(); ++i){
                            trainService.getTrains().get(i).trainInfo();
                        }
                    } else if(opt == 1){
                        int index = scanner.nextInt();
                        for(int i = 0; i < trainService.getTrains().size(); ++i){
                            if(trainService.getTrains().get(i).getId() == index){
                                trainService.getTrains().get(i).trainInfo();
                                break;
                            }
                        }
                    } else if(opt == 2){
                        Train train = readTrain();
                        trainService.addTrain(train);
                    } else if(opt == 3){
                        int index = scanner.nextInt();
                        for(int i = 0; i < trainService.getTrains().size(); ++i){
                            if(trainService.getTrains().get(i).getId() == index){
                                Train train = readTrain();
                                trainService.updateTrain(index, train);
                                break;
                            }
                        }
                    } else if(opt == 4){
                        int index = scanner.nextInt();
                        trainService.deteleTrain(index);
                    } else {
                        break;
                    }
                }

            } else if(option == 2){
                while(true){
                    System.out.println(" 0 - Get All");
                    System.out.println(" 1 - Get By Id");
                    System.out.println(" 2 - Add");
                    System.out.println(" 3 - Update");
                    System.out.println(" 4 - Delete");
                    System.out.println(" 5 - Exit");
                    int opt = scanner.nextInt();
                    if(opt == 0){
                        for(int i = 0; i < routeService.getRoutes().size(); ++i){
                            routeService.getRoutes().get(i).routeInfo();
                        }
                    } else if(opt == 1){
                        int index = scanner.nextInt();
                        for(int i = 0; i < routeService.getRoutes().size(); ++i){
                            if(routeService.getRoutes().get(i).getId() == index){
                                routeService.getRoutes().get(i).routeInfo();
                                break;
                            }
                        }
                    } else if(opt == 2){
                        Route route = readRoute();
                        routeService.addRoute(route);
                    } else if(opt == 3){
                        int index = scanner.nextInt();
                        for(int i = 0; i < routeService.getRoutes().size(); ++i){
                            if(routeService.getRoutes().get(i).getId() == index){
                                Route route = readRoute();
                                routeService.updateRoute(index, route);
                                break;
                            }
                        }
                    } else if(opt == 4){
                        int index = scanner.nextInt();
                        routeService.deteleRoute(index);
                    } else {
                        break;
                    }
                }
            } else if(option == 3){
                while(true){
                    System.out.println(" 0 - Get All");
                    System.out.println(" 1 - Get By Id");
                    System.out.println(" 2 - Add");
                    System.out.println(" 3 - Update");
                    System.out.println(" 4 - Delete");
                    System.out.println(" 5 - Exit");
                    int opt = scanner.nextInt();
                    if(opt == 0){
                        for(int i = 0; i < stationsService.getStations().size(); ++i){
                            stationsService.getStations().get(i).stationInfo();
                        }
                    } else if(opt == 1){
                        int index = scanner.nextInt();
                        for(int i = 0; i < stationsService.getStations().size(); ++i){
                            if(stationsService.getStations().get(i).getId() == index){
                                stationsService.getStations().get(i).stationInfo();
                                break;
                            }
                        }
                    } else if(opt == 2){
                        Station station = readStation();
                        stationsService.addStation(station);
                    } else if(opt == 3){
                        int index = scanner.nextInt();
                        for(int i = 0; i < stationsService.getStations().size(); ++i){
                            if(stationsService.getStations().get(i).getId() == index){
                                Station station = readStation();
                                stationsService.updateStation(index, station);
                                break;
                            }
                        }
                    } else if(opt == 4){
                        int index = scanner.nextInt();
                        stationsService.deteleStation(index);
                    } else {
                        break;
                    }
                }
            } else if(option == 4){
                while(true){
                    System.out.println(" 0 - Get All");
                    System.out.println(" 1 - Get By Id");
                    System.out.println(" 2 - Add");
                    System.out.println(" 3 - Update");
                    System.out.println(" 4 - Delete");
                    System.out.println(" 5 - Exit");
                    int opt = scanner.nextInt();
                    if(opt == 0){
                        for(int i = 0; i < userService.getUsers().size(); ++i){
                            userService.getUsers().get(i).userInfo();
                        }
                    } else if(opt == 1){
                        int index = scanner.nextInt();
                        for(int i = 0; i < userService.getUsers().size(); ++i){
                            if(userService.getUsers().get(i).getId() == index){
                                userService.getUsers().get(i).userInfo();
                                break;
                            }
                        }
                    } else if(opt == 2){
                        User user = readUser();
                        userService.addUser(user);
                    } else if(opt == 3){
                        int index = scanner.nextInt();
                        for(int i = 0; i < userService.getUsers().size(); ++i){
                            if(userService.getUsers().get(i).getId() == index){
                                User user = readUser();
                                userService.updateUser(index, user);
                                break;
                            }
                        }
                    } else if(opt == 4){
                        int index = scanner.nextInt();
                        userService.deteleUser(index);
                    } else {
                        break;
                    }
                }
            } else if(option == 5){
                break;
            }
        }
    }

}
