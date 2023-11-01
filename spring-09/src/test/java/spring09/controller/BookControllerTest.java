package spring09.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import spring09.dto.BookDto;
import spring09.mapper.BookMapperImpl;
import spring09.service.AuthorService;
import spring09.service.BookService;
import spring09.service.GenreService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
@Import(BookController.class)
@ContextConfiguration(classes = {BookMapperImpl.class})
class BookControllerTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @MockBean
    private AuthorService authorService;

    @MockBean
    private GenreService genreService;

    BookDto expectedDto1 = new BookDto(1L, "Dracula", "Unknown", "Horror");

    @Test
    void listPage() throws Exception {
        List<BookDto> books = List.of(expectedDto1);

        when(bookService.getAll()).thenReturn(books);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("books"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("books"));
    }

    @Test
    void editPage() throws Exception {
        when(bookService.getBookById(1L)).thenReturn(expectedDto1);

        mockMvc.perform(MockMvcRequestBuilders.get("/edit?id=" + 1L))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("edit"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("authors"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("genres"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("book"));
    }

    @Test
    void updateBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/edit"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    @Test
    void newBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/add"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("new"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("authors"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("genres"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("book"));
    }

    @Test
    void saveNewBook() throws Exception {
        doNothing().when(bookService).saveBook(any(), any(), any());

        mockMvc.perform(MockMvcRequestBuilders.post("/save"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"));
    }

    @Test
    void deleteBook() throws Exception {
        doNothing().when(bookService).deleteBookById(1L);

        mockMvc.perform(MockMvcRequestBuilders.post("/id?id=" + 1L))
                .andDo(print());
    }
}