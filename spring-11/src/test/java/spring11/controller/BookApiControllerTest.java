package spring11.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Author;
import spring11.domain.Book;
import spring11.domain.Genre;
import spring11.dto.AuthorDto;
import spring11.dto.BookDto;
import spring11.dto.GenreDto;
import spring11.repository.AuthorRepository;
import spring11.repository.BookRepository;
import spring11.repository.GenreRepository;
import spring11.service.BookService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@WebFluxTest(BookApiController.class)
@ContextConfiguration(classes = {BookApiController.class})
class BookApiControllerTest {
    BookDto expectedDto1 = new BookDto(1L, "Dracula","Unknown", "Horr");
    BookDto expectedDto2 = new BookDto(1L, "Dracula","Unknown", "Fan");

    @MockBean
    BookService bookService;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void listBooks() {
        when(bookService.getAll()).thenReturn(Flux.just(expectedDto1));

        List<BookDto> result = webTestClient
                .get().uri("/api/books/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BookDto.class)
                .hasSize(1)
                .returnResult()
                .getResponseBody();

        verify(bookService).getAll();
        assertThat(result).containsExactlyElementsOf(List.of(expectedDto1));
    }

    @Test
    void getBookById() {
        when(bookService.getBookById(anyLong())).thenReturn(Mono.just(expectedDto1));

        BookDto result = webTestClient
                .get().uri("/api/books/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        verify(bookService).getBookById(1L);
        assertEquals(expectedDto1, result);
    }

    @Test
    void updateBook() {
        when(bookService.getBookById(anyLong())).thenReturn(Mono.just(expectedDto1));
        when(bookService.updateBook(any())).thenReturn(Mono.just(expectedDto2));

        BookDto result = webTestClient
                .put().uri("/api/books/{id}", 1L)
                .bodyValue(expectedDto2)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        verify(bookService).updateBook(expectedDto2);
        assertEquals(expectedDto2, result);
    }

    @Test
    void saveNewBook() {
        when(bookService.saveBook(any())).thenReturn(Mono.just(expectedDto1));

        BookDto result = webTestClient
                .post().uri("/api/books/")
                .bodyValue(expectedDto1)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .returnResult()
                .getResponseBody();

        assertEquals(expectedDto1, result);
    }
    @Test
    void delete() {
         webTestClient
                .delete().uri("/api/books/{id}", 1L)
                .exchange()
                .expectStatus().isOk();

        verify(bookService).deleteBookById(1L);
    }
}