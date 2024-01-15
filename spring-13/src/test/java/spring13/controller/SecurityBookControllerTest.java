package spring13.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import spring13.repository.BookRepository;
import spring13.service.AuthorService;
import spring13.service.BookService;
import spring13.service.BookServiceImpl;
import spring13.service.GenreService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    @WithMockUser(username = "admin", password = "proba", roles = {"ADMIN"})
    public void test_auth_admin() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "user", password = "proba", roles = {"USER"})
    public void test_auth_user() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "proba", roles = {"USER"})
    public void test_auth_forbidden_user() throws Exception {
        mockMvc.perform(post("/edit"))
                .andExpect(status().isForbidden());
    }
    @Test
    public void test_unauth() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }
}