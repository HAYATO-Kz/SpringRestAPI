package th.ku.bookservice;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping({"/book"})
public class BookService {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public List<Book> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public Book create(@RequestBody Book book){
        repository.save(book);
        return repository.findById(book.getId()).get();
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book) {
        Book record = repository.findById(id).get();
        record.setName(book.getName());
        record.setPrice(book.getPrice());
        repository.save(book);
        return record;
    }

    @DeleteMapping("/{id}")
    public Book delete(@PathVariable("id") int id) {
        Book book = repository.findById(id).get();
        repository.deleteById(id);
        return book;
    }
}

