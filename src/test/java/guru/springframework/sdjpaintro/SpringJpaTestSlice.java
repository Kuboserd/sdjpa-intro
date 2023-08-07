package guru.springframework.sdjpaintro;

import guru.springframework.sdjpaintro.model.Book;
import guru.springframework.sdjpaintro.repositories.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpringJpaTestSlice {
    @Autowired
    BookRepository bookRepository;
    @Test
    @Order(1)
    @Commit
    void testJpaSplice(){
        long countBefore = bookRepository.count();
        bookRepository.save(new Book("Hobbit","1234","Tolkien"));
        long countAfter = bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }
    @Test
    @Order(2)
    void testJpaSpliceTransactional(){
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(1);
    }
}
