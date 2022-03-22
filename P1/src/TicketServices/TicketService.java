package TicketServices;

import Ticket.Ticket;
import Train.Boogie;
import Ticket.FirstClass;
import Ticket.SecondClass;
import Ticket.BunkBed;
import java.util.ArrayList;

public class TicketService {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    private static TicketService instance;

    public static TicketService getInstance(){
        if(instance == null){
            instance = new TicketService();
        }
        return instance;
    }

    public ArrayList<Ticket> getTickets() {
        ArrayList<Ticket> ticketCopy = new ArrayList<>();
        ticketCopy.addAll(this.tickets);
        return ticketCopy;
    }

    public Ticket getTicketById(int index){
        Ticket ticket = null;
        for(int i = 0; i < this.tickets.size(); ++i){
            if(this.tickets.get(i).getId() == index){
                if(this.tickets.get(i) instanceof FirstClass){
                    if(this.tickets.get(i) instanceof BunkBed)
                        ticket =  (BunkBed) this.tickets.get(i);
                    ticket = (FirstClass) this.tickets.get(i);
                }
                else if (this.tickets.get(i) instanceof SecondClass){
                    ticket = (SecondClass) this.tickets.get(i);
                }
            }
        }
        return ticket;
    }

    public void updateTicket(int index, Ticket ticket){
        for(int i = 0; i < this.tickets.size(); ++i){
            if(this.tickets.get(i).getId() == index){
                this.tickets.remove(i);
                this.tickets.add(index, ticket);
                break;
            }
        }
    }

    public void addTicket(Ticket ticket){
        this.tickets.add(ticket);
    }

    public void deteleTicket(int index){
        for(int i = 0; i < this.tickets.size(); ++i){
            if(this.tickets.get(i).getId() == index) {
                this.tickets.remove(i);
                break;
            }
        }
    }
}
