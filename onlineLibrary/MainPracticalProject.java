package com.howtodoinjava.hibernate.test.dto.practicalproject;

import com.howtodoinjava.hibernate.test.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

import static org.hibernate.Hibernate.list;


public class MainPracticalProject {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option [1-20]");
        System.out.println("1: Insert author");
        System.out.println("2: Insert book");
        System.out.println("3: Insert publishing house");
        System.out.println("4: Insert the name of the book whose authors you want to add");
        System.out.println("5: Insert the name of the publishing house to which you want to add books");
        System.out.println("6: Display a specific book found by its number of pages");
        System.out.println("7: Display the list of the books");
        System.out.println("8: Display the list of the authors");
        System.out.println("9: Display the author book's genre after surname and name");
        System.out.println("10: Display the age and surname of the author who wrote a book");
        System.out.println("11: Display the genre and the title of a book after publishing house");
        System.out.println("12: Display the oldest book and the author's experience years");
        System.out.println("13: Display the newest publishing house and the book contained");
        System.out.println("14: Check the status of a specific book");
        System.out.println("15: Update an author by modifying all its class' attributes");
        System.out.println("16: Update a book by modifying all its class' attributes");
        System.out.println("17: Update a publishing house by modifying all its class' attributes");
        System.out.println("18: Erase an author/s found by age");
        System.out.println("19: Erase a book/s found by a specific status");
        System.out.println("20: Erase a publishing house");

        int option = scanner.nextInt();

        do {
//Insert an author
            if (option == 1) {
                System.out.println("Insert the surname of the author");
                scanner.nextLine();
                String input = scanner.nextLine();
                System.out.println("Insert the name of the author");
                String input2 = scanner.nextLine();
                System.out.println("Insert the age of the author");
                Integer input3 = scanner.nextInt();
                System.out.println("Insert the years of experience of the author");
                Integer input4 = scanner.nextInt();
                System.out.println("Insert the book's genre wrote by the author");
                scanner.nextLine();
                String input5 = scanner.nextLine();


                Author authors = new Author();
                authors.setSurnameAuthor(input);
                authors.setNameAuthor(input2);
                authors.setAgeAuthor(input3);
                authors.setExperienceYears(input4);
                authors.setGenre(input5);

                session.persist(authors);
                System.out.println("AUTHOR has been successfully added!");

            }

//Insert a book
            if (option == 2) {
                System.out.println("Insert the title of the book");
                scanner.nextLine();
                String input = scanner.nextLine();
                System.out.println("Insert the year of book's appearance");
                Integer input2 = scanner.nextInt();
                System.out.println("Insert the genre");
                scanner.nextLine();
                String input3 = scanner.nextLine();
                System.out.println("Insert the number of pages");
                Integer input4 = scanner.nextInt();
                System.out.println("Insert the status of the book");
                scanner.nextLine();
                String input5 = scanner.nextLine();

                Book book = new Book();
                book.setTitle(input);
                book.setPublishingYear(input2);
                book.setGenre(input3);
                book.setNumberOfPages(input4);
                book.setStatus(input5);

                session.persist(book);
                System.out.println("THE BOOK has been successfully added");

            }

//Insert a publishing house
            if (option == 3) {
                System.out.println("Insert the name of publishing house");
                scanner.nextLine();
                String input = scanner.nextLine();
                System.out.println("Insert the year of appearance");
                Integer input1 = scanner.nextInt();
                System.out.println("Insert rankingul");
                Integer input2 = scanner.nextInt();
                System.out.println("Insert the name of the book published by this publishing house");
                scanner.nextLine();
                String input3 = scanner.nextLine();

                Query query = session.createQuery("From Book where title =: t");
                query.setParameter("t", input3);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                Book b = (Book) o;

                PublishingHouse publishingHouse = new PublishingHouse();
                publishingHouse.setPublishingHouseName(input);
                publishingHouse.setYearOfAppearance(input1);
                publishingHouse.setRanking(input2);
                publishingHouse.setBook(b);

                session.persist(publishingHouse);
                System.out.println("THE PUBLISHING HOUSE has been successfully added");
            }

//Insert the name of the book whose authors you want to add
            if (option == 4) {
                System.out.println("Insert the name of the book whose authors you want to add");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Book where title =: t");
                query.setParameter("t", input);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                Book book = (Book) o;

                System.out.println("Insert the name of the authors that contributed to the writing of this book");
                String input2 = scanner.nextLine();

                Query query1 = session.createQuery("From Author where nameAuthor =: n");
                query1.setParameter("n", input2);

                List list1 = ((Query<?>) query1).list();
                Object o1 = list1.get(0);
                Author a = (Author) o1;

                book.getAuthors().add(a);
                session.update(book);
                session.getTransaction().commit();
                System.out.println("AUTHORS successfully added to the book");
            }

//Insert the name of the publishing house to which you want to attach books
            if (option == 5) {
                System.out.println("Insert the name of the publishing house to which you want to add books");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From PublishingHouse where publishingHouseName =:na");
                query.setParameter("na", input);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                PublishingHouse e = (PublishingHouse) o;

                System.out.println("Insert the name of the book you want to add to the publishing house");
                String input2 = scanner.nextLine();

                Query query1 = session.createQuery("From Book where title =:t");
                query1.setParameter("t", input2);

                List list2 = ((Query<?>) query1).list();
                Object o2 = list2.get(0);
                Book b = (Book) o2;
                e.setBook(b);

                session.update(e);
                session.getTransaction().commit();
                System.out.println("COMMITTED successfully!");
            }

//Display a specific book using the number of pages
            if (option == 6) {
                System.out.println("Display a book using the number of pages");
                Integer number = scanner.nextInt();

                Query query = session.createQuery("From Book where numberOfPages =: n");
                query.setParameter("n", number);

                List list = query.list();
                Object o = list.get(0);
                Book b = (Book) o;
                System.out.println("---------------------------------");
                System.out.println(b.getTitle());
            }

//Display the list of the books
            if (option == 7) {
                System.out.println("Display the list of the books");
                Query query = session.createQuery("From Book");
                List list = ((Query<?>) query).list();
                System.out.println("------ THE LIST of the books is: " + list);
            }

//Display the list of the authors
            if (option == 8) {
                System.out.println("Display the list of the authors");
                Query query = session.createQuery("From Author");
                List list = query.list();
                System.out.println("------ THE LIST of the authors is: " + list);
            }

//Display the author  book's genre after surname and name
            if (option == 9) {
                System.out.println("Insert the surname of the author you want to display");
                scanner.nextLine();
                String input = scanner.nextLine();

                System.out.println("Insert the name of the author you want to display");
                String input1 = scanner.nextLine();

                Query query = session.createQuery("From Author where surnameAuthor =:s and nameAuthor =:n");
                query.setParameter("s", input);
                query.setParameter("n", input1);

                List<?> list = ((Query<?>) query).list();
                Object o = list.get(0);
                Author a = (Author) o;

                System.out.println("---------------------------");
                System.out.println(a.getGenre());
            }

//Display the age and surname of the author who wrote a book
            if (option == 10) {
                System.out.println("Insert the name of the book");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from Book where title =:t");
                query.setParameter("t", input);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                Book b = (Book) o;
                for (Author author : b.getAuthors()) {
                    System.out.println("THE SURNAME and AGE of the authors who wrote the book are: " +
                            author.getSurnameAuthor() + " " + author.getAgeAuthor());
                }
            }

//Display the genre and the title of a book after publishing house
            if (option == 11) {
                System.out.println("Insert the publishing house");
                scanner.nextLine();
                String input1 = scanner.nextLine();

                Query query = session.createQuery("From PublishingHouse where publishingHouseName =:n");
                query.setParameter("n", input1);

                List list1 = ((Query<?>) query).list();
                Object o = list1.get(0);
                PublishingHouse pub = (PublishingHouse) o;
                System.out.println("THE GENRE is: " + pub.getBook().getGenre() + " and THE TITLE is: " + pub.getBook().getTitle());

            }

//Display the oldest book and the author's experience years
            if (option == 12) {
                Query query = session.createQuery("From Book order by publishingYear");

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                Book b = (Book) o;
                for (Author author : b.getAuthors()) {
                    System.out.println("  THE OLDEST book is published in: " + b.getPublishingYear() + " THE AUTHOR'S experience years: "
                            + author.getExperienceYears());
                }
            }

//Display the newest publishing house and the book contained
            if (option == 13) {
                Query query = session.createQuery("From PublishingHouse order by yearOfAppearance desc");

                List list = query.list();
                Object o = list.get(0);
                PublishingHouse p = (PublishingHouse) o;
                System.out.println("THE NEWEST publishing house is: " + p.getPublishingHouseName() + " THE BOOK contained is: " + p.getBook().getTitle());
            }

//Check the status of a specific book
            if (option == 14) {
                System.out.println("Insert the name of the book");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Book where title =:t");
                query.setParameter("t", input);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                Book b = (Book) o;
                System.out.println("THE BOOK'S status is: " + b.getStatus());
            }

//Update an author by modifying all its class' attributes
            if (option == 15) {
                System.out.println("Insert the surname of the author you want to update");
                scanner.nextLine();
                String input = scanner.nextLine();

                System.out.println("Insert the name of the author you want to update");
                String input1 = scanner.nextLine();


                Query query = session.createQuery("From Author where surnameAuthor =:s and nameAuthor =:n ");
                query.setParameter("s", input);
                query.setParameter("n", input1);
                System.out.println("Choose from author's options of update  [1-5]");
                System.out.println("1: Modify the years of author's experience");
                System.out.println("2: Modify the genre of the author's books");
                System.out.println("3: Modify the author's surname");
                System.out.println("4: Modify the author's name");
                System.out.println("5: Modify the author's age");
                int input2 = scanner.nextInt();

                do {

                    if (input2 == 1) {
                        System.out.println("Insert the new value");
                        Integer yearsOfExperince = scanner.nextInt();

                        List list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        Author a = (Author) o;
                        a.setExperienceYears(yearsOfExperince);
                        session.update(a);
                        session.getTransaction().commit();
                        System.out.println("THE EXPERIENCE YEARS of the author had been updated");
                    }
                    if (input2 == 2) {
                        System.out.println("Insert the new value");
                        scanner.nextLine();
                        String genre = scanner.nextLine();

                        List list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        Author a = (Author) o;
                        a.setGenre(genre);
                        session.update(a);
                        session.getTransaction().commit();
                        System.out.println("GENRE'S book written by the author has been changed");
                    }
                    if (input2 == 3) {
                        System.out.println("Insert the new value");
                        scanner.nextLine();
                        String surname = scanner.nextLine();

                        List<?> list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        Author a = (Author) o;
                        a.setSurnameAuthor(surname);
                        session.update(a);
                        session.getTransaction().commit();
                        System.out.println("THE SURNAME of the author has been successfully updated");
                    }

                    if (input2 == 4) {
                        System.out.println("Insert the new value");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        List<?> list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        Author a = (Author) o;
                        a.setNameAuthor(name);
                        session.update(a);
                        session.getTransaction().commit();
                        System.out.println("THE NAME of the author has been successfully updated");
                    }

                    if (input2 == 5) {
                        System.out.println("Insert the new value");
                        Integer age = scanner.nextInt();

                        List<?> list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        Author a = (Author) o;
                        a.setAgeAuthor(age);
                        session.update(a);
                        System.out.println("THE AGE of the author has been successfully updated");
                    }
                    System.out.println("Choose from options [1-5]");
                    input2 = scanner.nextInt();
                } while (input2 > 0 && input2 < 6);
            }

// Update a book by modifying all its class' attributes
            if (option == 16) {
                System.out.println("Insert the title of the book you want to update");
                String input = scanner.nextLine();

                Query query = session.createQuery("From Book where title =: t");
                query.setParameter("t", input);

                System.out.println("Choose from book's options of update [1-5]");
                System.out.println("1: Update title");
                System.out.println("2: Update publishingYear");
                System.out.println("3: Update genre");
                System.out.println("4: Update number of pages");
                System.out.println("5: Update status");
                int input1 = scanner.nextInt();

                do {
                    if (input1 == 1) {
                        System.out.println("Insert the new title");
                        String title1 = scanner.nextLine();

                        List list = query.list();
                        Object o = list.get(0);
                        Book b = (Book) o;
                        b.setTitle(title1);
                        session.update(b);
                        System.out.println("TITLE updated");
                    }
                    if (input1 == 2) {
                        System.out.println("Insert the new publishingYear");
                        Integer pYear = scanner.nextInt();

                        List list = query.list();
                        Object o = list.get(0);
                        Book b = (Book) o;
                        b.setPublishingYear(pYear);
                        session.update(b);
                        System.out.println("PUBLISING year updated");
                    }
                    if (input1 == 3) {
                        System.out.println("Insert the new genre");
                        String genre = scanner.nextLine();

                        List list = query.list();
                        Object o = list.get(0);
                        Book b = (Book) o;
                        b.setGenre(genre);
                        session.persist(b);
                        System.out.println("GENRE updated");
                    }
                    if (input1 == 4) {
                        System.out.println("Insert the new value of number of pages");
                        Integer nPages = scanner.nextInt();

                        List list = query.list();
                        Object o = list.get(0);
                        Book b = (Book) o;
                        b.setNumberOfPages(nPages);
                        session.update(b);
                        System.out.println("NUMBER of pages updated");
                    }
                    if (input1 == 5) {
                        System.out.println("Insert the new status");
                        String status = scanner.nextLine();

                        List list = query.list();
                        Object o = list.get(0);
                        Book b = (Book) o;
                        b.setStatus(status);
                        session.update(b);
                        System.out.println("STATUS updated");
                    }

                    System.out.println("Choose from options [1-5]");
                    input1 = scanner.nextInt();

                } while (input1 > 0 && input1 < 6);
            }

//Update a publishing house by modifying all its class' attributes
            if (option == 17) {
                System.out.println("Insert the name of the publishing house you want to update");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("from PublishingHouse where publishingHouseName =:na and yearOfAppearance =:y");
                query.setParameter("na", input);

                System.out.println("Choose from publishing house's options of update [1-4]");
                System.out.println("1: Modify the year of appearance");
                System.out.println("2: Modify the name of the publishing house");
                System.out.println("3: Modify the ranking of the publishing house");
                System.out.println("4: Modify the name of the book from this publishing house");
                int input2 = scanner.nextInt();

                do {
                    if (input2 == 1) {
                        System.out.println("Insert the new value");
                        Integer yearOfAppearance = scanner.nextInt();

                        List list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        PublishingHouse p = (PublishingHouse) o;
                        p.setYearOfAppearance(yearOfAppearance);
                        session.update(p);
                        System.out.println("YEAR OF APPEARANCE updated");
                    }

                    if (input2 == 2) {
                        System.out.println("Insert the new value");
                        scanner.nextLine();
                        String name = scanner.nextLine();

                        List list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        PublishingHouse p = (PublishingHouse) o;
                        p.setPublishingHouseName(name);
                        session.update(p);
                        System.out.println("PUBLISHING house' name updated");
                    }

                    if (input2 == 3) {
                        System.out.println("Insert the new value");
                        Integer ranking = scanner.nextInt();

                        List list = ((Query<?>) query).list();
                        Object o = list.get(0);
                        PublishingHouse p = (PublishingHouse) o;
                        p.setRanking(ranking);
                        session.update(p);
                        System.out.println("RANKING updated");
                    }

                    if (input2 == 4) {
                        System.out.println("Insert the new value");
                        scanner.nextLine();
                        String book = scanner.nextLine();

                        Query query1 = session.createQuery("from Book where title =: t");
                        query.setParameter("t", book);

                        List list = ((Query<?>) query1).list();
                        Object o = list.get(0);
                        Book b = (Book) o;

                        List list1 = ((Query<?>) query1).list();
                        Object o1 = list1.get(0);
                        PublishingHouse p = (PublishingHouse) o1;
                        p.setBook(b);
                        session.update(b);
                        session.getTransaction().commit();
                        System.out.println("BOOK's name updated");
                    }
                    System.out.println("Choose from options [1-5]");
                    input2 = scanner.nextInt();
                } while (input2 > 0 && input2 < 6);
            }

//erase an author found by age
            if (option == 18) {
                System.out.println("Insert the age of the author you want to erase");
                scanner.nextLine();
                Integer age = scanner.nextInt();

                Query query = session.createQuery("From Author where ageAuthor =: a");
                query.setParameter("a", age);

                List list = query.list();
                Object o = list.get(0);
                session.delete(o);
                session.getTransaction().commit();
                System.out.println("THE AUTHOR has been erased");
            }

//erase a book/s found by a specific status
            if (option == 19) {
                System.out.println("Insert the status of the book you want to erase");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From Book where status =: s");
                query.setParameter("s", input);

                List list = ((Query<?>) query).list();
                session.delete(list.subList(0, 1));
                session.getTransaction().commit();
                System.out.println("THE BOOK has been erased");
                System.out.println("Press key 0 for main options");
            }

//erase a publishing house
            if (option == 20) {
                System.out.println("Insert the name of the publishing house you want to erase");
                scanner.nextLine();
                String input = scanner.nextLine();

                Query query = session.createQuery("From PublishingHouse where publishingHouseName =: name");
                query.setParameter("name", input);

                List list = ((Query<?>) query).list();
                Object o = list.get(0);
                PublishingHouse p = (PublishingHouse) o;

                session.delete(p);
                session.getTransaction().commit();
                System.out.println("PUBLISHING HOUSE erased!");
            }
            System.out.println("Choose from the main options [1-20]");
            option = scanner.nextInt();

        } while (option > 0 && option < 21);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}