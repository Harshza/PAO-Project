package Route;

import User.User;

import java.util.ArrayList;

public class RouteServices {
    private ArrayList<Route> routes = new ArrayList<>();

    private static RouteServices instance;

    public static RouteServices getInstance(){
        if(instance == null){
            instance = new RouteServices();
        }
        return instance;
    }

    public ArrayList<Route> getRoutes() {
        ArrayList<Route> routesCopy = new ArrayList<>();
        routesCopy.addAll(this.routes);
        return routesCopy;
    }

    public Route getRouteById(int index){
        Route route = new Route();
        for(int i = 0; i < this.routes.size(); ++i){
            if(this.routes.get(i).getId() == index){
                route = this.routes.get(i);
            }
        }
        return route;
    }

    public void updateRoute(int index, Route route){
        for(int i = 0; i < this.routes.size(); ++i){
            if(this.routes.get(i).getId() == index){
                this.routes.remove(i);
                this.routes.add(index, route);
                break;
            }
        }
    }

    public void addRoute(Route route){
        this.routes.add(route);
    }

    public void deteleRoute(int index){
        for(int i = 0; i < this.routes.size(); ++i){
            if(this.routes.get(i).getId() == index) {
                this.routes.remove(i);
                break;
            }
        }
    }
}
