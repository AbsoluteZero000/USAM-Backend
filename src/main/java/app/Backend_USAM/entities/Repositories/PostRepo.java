package app.Backend_USAM.entities.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import app.Backend_USAM.entities.Post;
import jakarta.transaction.Transactional;


@Service
@Transactional
public interface PostRepo extends CrudRepository<Post, Integer>{

}
