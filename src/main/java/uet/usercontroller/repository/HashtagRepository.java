package uet.usercontroller.repository;

import org.springframework.data.repository.CrudRepository;
import uet.usercontroller.model.Hashtag;

import java.util.List;

/**
 * Created by trung on 2/17/2017.
 */
public interface HashtagRepository extends CrudRepository<Hashtag, Integer>{
    Hashtag findByTag(String tag);
}
