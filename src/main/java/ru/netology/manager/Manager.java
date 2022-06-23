package ru.netology.manager;

import ru.netology.Repository;
import ru.netology.Ticket;

import java.util.Arrays;

public class Manager {
    private Repository repo;
    private Ticket[] tickets = new Ticket[0];

    public Manager(Repository repo) {
        this.repo = repo;
    }
    //private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAllByFromTo(String from, String to) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (ticket.getFromAirport() == from && ticket.getToAirport() == to) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;

            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
