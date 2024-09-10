package EPICODE.SpringWebService.controllers;

import EPICODE.SpringWebService.entities.Author;
import EPICODE.SpringWebService.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    //importiamoci il service per avere i metodi
    @Autowired
    private AuthorService as;


    //    1. GET http://localhost:3001/blogPosts
    @GetMapping
    private List<Author> findAll() {
        return as.findAll();
    }


    //            2. GET  http://localhost:3001/blogPosts/{userId}
    @GetMapping("/{authorID}")
    private Author findByID(@PathVariable int authorID) {
        return as.findByID(authorID);
    }


    //            3. POST http://localhost:3001/blogPosts (+ body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Author createBlog(@RequestBody Author body) {
        return as.save(body);
    }

    //            4. PUT http://localhost:3001/blogPosts/{userId} (+ body)
    @PutMapping("/{authorID}")
    private Author findandupdate(@PathVariable int authorID, @RequestBody Author updateBlog) {
        return as.update(authorID, updateBlog);
    }

    // 5. DELETE http://localhost:3001/blogPosts/{userId}
    @DeleteMapping("/{authorID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void findandDelete(@PathVariable int authorID) {
        as.findByIDandDelete(authorID);

    }
}
