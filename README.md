ORM-Suppliementary-Assignment

1)  Query query = session.createQuery("from Book where year(publicationYear)  >= :year");
    query.setParameter("year", 2010);
    List<Book> books = query.list();
    for (Book book : books) {
       System.out.println("Book ID : " + book.getId());
       System.out.println("Price : " + book.getPrice());
       System.out.println("Publication Year : " + book.getPublicationYear());
       System.out.println("Name : " + book.getTitle() + "\n");
    }
2) scs
3) Query query = session.createQuery("update Book set price = price * 1.1 where author.id IN (:authorID)");
   query.setParameter("authorID", 2);
4) Query query = session.createQuery("select avg (price) from Book");
   Double avg = (Double) query.uniqueResult();
   System.out.println(avg);