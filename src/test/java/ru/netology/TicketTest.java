package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.manager.Manager;


public class TicketTest {

    private Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket ticket1 = new Ticket(1, 500, "UFA", "ROV", 150);
    Ticket ticket2 = new Ticket(2, 700, "AAQ", "SVO", 70);
    Ticket ticket3 = new Ticket(3, 300, "SVO", "SEN", 400);
    Ticket ticket4 = new Ticket(4, 750, "AAQ", "SVO", 55);
    Ticket ticket5 = new Ticket(5, 230, "CEE", "VKO", 250);

    @Test
    public void Add() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveById() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.removeById(1);
        repo.removeById(2);
        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket3, ticket4, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByFromAndTo() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        Ticket[] actual = manager.findAllByFromTo("SVO", "SEN");
        Ticket[] expected = {ticket3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindNoAnyIfFirstIncorrect() {
        Ticket[] actual = manager.findAllByFromTo("O", "KLG");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindNoAnyIfSecondIncorrect() {
        Ticket[] actual = manager.findAllByFromTo("SVO", "G");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void FindTwoAndSortByCost() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        Ticket[] actual = manager.findAllByFromTo("AAQ", "SVO");
        Ticket[] expected = {ticket4, ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }
}
