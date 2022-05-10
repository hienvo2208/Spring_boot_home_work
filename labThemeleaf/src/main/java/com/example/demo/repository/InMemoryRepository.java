package com.example.demo.repository;

import com.example.demo.model.Country;
import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.attach.VirtualMachine.list;

@Repository
@Getter
public class InMemoryRepository {
    private ArrayList<Product> products;
    private ArrayList<Country> countries;
    private ArrayList<Person> people;
    private ArrayList<User> users;

    public InMemoryRepository() {
        products = new ArrayList<>(List.of(new Product("Sony WX", "Sony", 150000),
                new Product("IP14", "Apple", 20000),
                new Product("1080", "Nokia", 300),
                new Product("Macbook Pro", "Apple", 30000),
                new Product("Ipad", "Apple", 2500),
                new Product("BPhone pro", "BKAV", 3000)
        ));
        countries = new ArrayList<>(List.of(
                new Country("Vietnam", "vi"),
                new Country("China", "cn"),
                new Country("USA", "us"),
                new Country("France", "fr"),
                new Country("Singapore", "sg"),
                new Country("Japan", "jp")
        ));

        SimpleDateFormat yMdFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            people = new ArrayList<>(List.of(
                    new Person("Tom", "USA", new SimpleDateFormat("yyyy-MM-dd").parse("1976-12-01"), "male"),
                    new Person("Lara", "French", new SimpleDateFormat("yyyy-MM-dd").parse("1970-11-02"), "male"),
                    new Person("Zhiang", "China", new SimpleDateFormat("yyyy-MM-dd").parse("1988-22-08"), "female"),
                    new Person("Lien", "Vietnamese", new SimpleDateFormat("yyyy-MM-dd").parse("1971-03-01"), "female")
            ));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        users = new ArrayList<>(List.of(new User("Tom", "admin"),
                new User("Lara", "user"),
                new User("Zhiang", "user"),
                new User("Lien", "admin"),
                new User("Tom", "admin")
        ));

    }


}
