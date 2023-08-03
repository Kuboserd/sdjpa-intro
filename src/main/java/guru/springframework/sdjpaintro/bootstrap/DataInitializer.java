package guru.springframework.sdjpaintro.bootstrap;

import guru.springframework.sdjpaintro.model.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Book bookDDD = new Book("Domain Driven Development", "123", "RandomHouse");
        System.out.println(bookDDD.getId());
        Book savedDDD = bookRepository.save(bookDDD);
        System.out.println(savedDDD.getId());

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely");
        Book savedSIA = bookRepository.save(bookSIA);
        bookRepository.findAll().forEach(book -> {
            System.out.println(book.getId());
            System.out.println(book.getName());
        });
    }
}
