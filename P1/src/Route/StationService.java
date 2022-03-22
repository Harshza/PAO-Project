package Route;

import java.util.ArrayList;

public class StationService {
    private ArrayList<Station> stations = new ArrayList<>();

    private static StationService instance;

    public static StationService getInstance(){
        if(instance == null){
            instance = new StationService();
        }
        return instance;
    }

    public ArrayList<Station> getStations() {
        ArrayList<Station> stationsCopy = new ArrayList<>();
        stationsCopy.addAll(this.stations);
        return stationsCopy;
    }

    public Station getStationById(int index){
        Station station = new Station();
        for(int i = 0; i < this.stations.size(); ++i){
            if(this.stations.get(i).getId() == index){
                station = this.stations.get(i);
            }
        }
        return station;
    }

    public void updateStation(int index, Station station){
        for(int i = 0; i < this.stations.size(); ++i){
            if(this.stations.get(i).getId() == index){
                this.stations.remove(i);
                this.stations.add(index, station);
                break;
            }
        }
    }

    public void addStation(Station station){
        this.stations.add(station);
    }

    public void deteleStation(int index){
        for(int i = 0; i < this.stations.size(); ++i){
            if(this.stations.get(i).getId() == index) {
                this.stations.remove(i);
                break;
            }
        }
    }
}
