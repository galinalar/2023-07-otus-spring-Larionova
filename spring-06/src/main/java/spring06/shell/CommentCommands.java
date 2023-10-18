package spring06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import spring06.domain.Comment;
import spring06.service.BookService;
import spring06.service.CommentService;

@RequiredArgsConstructor
@ShellComponent
public class CommentCommands {
    private final BookService bookService;

    private final CommentService commentService;

    @ShellMethod(value = "get comment by id", key = {"com_id"})
    public String getCommentById(@ShellOption Long id) {
        return commentService.getCommentById(id).toString();
    }

    @ShellMethod(value = "delete comment by id", key = {"delete_c", "dc"})
    public void deleteCommentById(@ShellOption Long id) {
        commentService.deleteCommentById(id);
    }

    @ShellMethod(value = "add comment", key = {"ac"})
    public void addComment(@ShellOption String text, @ShellOption Long bookId) {
        Comment comment = new Comment(null, text, bookService.getBookDomainById(bookId));
        commentService.saveComment(comment);
    }

    @ShellMethod(value = "update comment", key = {"update_c", "uc"})
    public void updateComment(@ShellOption Long id, @ShellOption String text, @ShellOption Long bookId) {
        Comment comment = new Comment(id, text, bookService.getBookDomainById(bookId));
        commentService.updateComment(comment);
    }

    @ShellMethod(value = "get comments of book", key = {"cb"})
    public String getCommentBook(@ShellOption Long id) {
        return commentService.getByBookId(id).toString();
    }

    @ShellMethod(value = "get comments of book", key = {"cb2"})
    public String getCommentBook2(@ShellOption Long id) {
        return commentService.getComByBookId(id).toString();
    }
}
