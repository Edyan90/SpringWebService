package EPICODE.SpringWebService.services;

import EPICODE.SpringWebService.entities.Blog;
import EPICODE.SpringWebService.exceptions.NotFoundEx;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<Blog> blogList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogList;
    }

    public Blog findByID(int blogID) {
        Blog found = null;
        for (Blog blog : blogList) {
            if (blog.getId() == blogID)
                found = blog;
        }
        if (found == null) throw new NotFoundEx(blogID, "Il blog con ID" + blogID + "non è stato trovato");
        return found;

    }

    public Blog save(Blog blogBody) {
        Random rdm = new Random();
        blogBody.setId(rdm.nextInt(1, 10000));
        blogBody.setCover("https://picsum.photos/id/1/200/300");
        this.blogList.add(blogBody);
        return blogBody;
    }

    public Blog update(int bodyID, Blog blogUpdate) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == bodyID) {
                found = blog;
                found.setCategoria(blogUpdate.getCategoria());
                found.setTitolo(blogUpdate.getTitolo());
                found.setContenuto(blogUpdate.getContenuto());
                found.setTempoDiLettura(blogUpdate.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundEx(bodyID, "Il blog con ID " + bodyID + " non è stato trovato.");
        return found;
    }

    public void findByIDandDelete(int blogID) {
        Blog found = findByID(blogID);
        this.blogList.remove(found);
    }
}
