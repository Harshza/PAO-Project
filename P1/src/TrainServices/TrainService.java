package TrainServices;

import Train.Train;
import Train.Boogie;
import Train.PassengerTrain;

import java.util.ArrayList;

public class TrainService {
    private ArrayList<Train> trains = new ArrayList<>();

    private static TrainService instance;

    public static TrainService getInstance(){
        if(instance == null){
            instance = new TrainService();
        }
        return instance;
    }

    public ArrayList<Train> getTrains() {
        ArrayList<Train> trainsCopy = new ArrayList<>();
        trainsCopy.addAll(this.trains);
        return trainsCopy;
    }

    public Train getTicketById(int index){
        Train train = null;
        for(int i = 0; i < this.trains.size(); ++i){
            if(this.trains.get(i).getId() == index){
                if(this.trains.get(i) instanceof Boogie){
                    train = (Boogie) this.trains.get(i);
                }
                else if (this.trains.get(i) instanceof PassengerTrain){
                    train = (PassengerTrain) this.trains.get(i);
                }
            }
        }
        return train;
    }

    public void updateTrain(int index, Train train){
        for(int i = 0; i < this.trains.size(); ++i){
            if(this.trains.get(i).getId() == index){
                this.trains.remove(i);
                this.trains.add(index, train);
                break;
            }
        }
    }

    public void addTrain(Train train){
        this.trains.add(train);
    }

    public void deteleTrain(int index){
        for(int i = 0; i < this.trains.size(); ++i){
            if(this.trains.get(i).getId() == index) {
                this.trains.remove(i);
                break;
            }
        }
    }
}
