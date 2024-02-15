package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Author;
import lk.ijse.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
        Transaction transaction = session.beginTransaction();

        Book book1 = new Book();
        book1.setTitle("The Adventures Of Tintin:- Red Rackham's Treasure");
        book1.setPublicationYear(LocalDate.of(1943, 8, 23));
        book1.setPrice(2000.00);

        Book book2 = new Book();
        book2.setTitle("Diary of a Wimpy Kid: Rodrick Rules");
        book2.setPublicationYear(LocalDate.of(2008, 2, 1));
        book2.setPrice(2850.00);

        Book book3 = new Book();
        book3.setTitle("Harry Potter and the Prisoner of Azkaban");
        book3.setPublicationYear(LocalDate.of(1999, 7, 8));
        book3.setPrice(3190.00);

        Book book4 = new Book();
        book4.setTitle("Diary of a Wimpy Kid: Long Haul");
        book4.setPublicationYear(LocalDate.of(2017, 7, 8));
        book4.setPrice(3190.00);

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        Author author1 = new Author();
        author1.setName("Hergé");
        author1.setCountry("Belgium");
        author1.setBooks(bookList);

        Author author2 = new Author();
        author2.setName("Jeff Kinney");
        author2.setCountry("USA");
        author2.setBooks(bookList);

        Author author3 = new Author();
        author3.setName("J. K. Rowling");
        author3.setCountry("UK");
        author3.setBooks(bookList);

        book1.setAuthor(author1);
        book2.setAuthor(author2);
        book3.setAuthor(author3);
        book4.setAuthor(author2);

        /*session.save(author1);
        session.save(book1);
        session.save(author2);
        session.save(book2);
        session.save(author3);
        session.save(book3);
        session.save(book4);*/

        /*Query query = session.createQuery("from Book where year(publicationYear)  >= :year");
        query.setParameter("year", 2010);
        List<Book> books = query.list();
        for (Book book : books) {
            System.out.println("Book ID: " + book.getId());
            System.out.println("Price: " + book.getPrice());
            System.out.println("Publication Year: " + book.getPublicationYear());
            System.out.println("Name: " + book.getTitle() + "\n");
        }*/

        /*Query query = session.createQuery("update Book set price = price * 1.1 where author.id IN (:authorID)");
        query.setParameter("authorID", 2);*/

        /*Query query = session.createQuery("select avg (price) from Book");
        Double avg = (Double) query.uniqueResult();
        System.out.println(avg);*/


        transaction.commit();
        session.close();
    }
}