package EPICODE.SpringWebService.services;

import EPICODE.SpringWebService.entities.Author;
import EPICODE.SpringWebService.exceptions.NotFoundEx;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AuthorService {
    private List<Author> authorList = new ArrayList<>();

    public List<Author> findAll() {
        return this.authorList;
    }

    public Author findByID(int authorID) {
        Author found = null;
        for (Author autore : authorList) {
            if (autore.getId() == authorID)
                found = autore;
        }
        if (found == null) throw new NotFoundEx(authorID, "l'autore con ID" + authorID + "non è stato trovato");
        return found;

    }

    public Author save(Author autore) {
        Random rdm = new Random();
        autore.setId(rdm.nextInt(1, 10000));
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        this.authorList.add(autore);
        return autore;
    }

    public Author update(int bodyID, Author authorUpdate) {
        Author found = null;
        for (Author blog : this.authorList) {
            if (blog.getId() == bodyID) {
                found = blog;
                found.setNome(authorUpdate.getNome());
                found.setCognome(authorUpdate.getCognome());
                found.setEmail(authorUpdate.getEmail());
                found.setDataDiNascita(authorUpdate.getDataDiNascita());
            }
        }
        if (found == null) throw new NotFoundEx(bodyID, "Il blog con ID " + bodyID + " non è stato trovato.");
        return found;
    }

    public void findByIDandDelete(int blogID) {
        Author found = findByID(blogID);
        this.authorList.remove(found);
    }
}
