package spring12.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import spring12.repository.BookRepository;
import spring12.service.AuthorService;
import spring12.service.BookService;
import spring12.service.BookServiceImpl;
import spring12.service.GenreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(BookController.class)
@Import({BookController.class, BookServiceImpl.class})
class SecurityBookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    BookRepository repository;
    @MockBean
    AuthorService authorService;
    @MockBean
    GenreService genreService;

    @MockBean
    private BookService bookService;

    @Test
    @WithMockUser(username = "admin", password = "proba")
    public void test_auth() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    @Test
    public void test_unauth() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }
}