package uet.usercontroller.repository;

import javafx.geometry.Pos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uet.usercontroller.model.Partner;
import uet.usercontroller.model.Post;
import uet.usercontroller.model.Student;

import java.util.List;

/**
 * Created by Trung on 8/29/2016.
 */
@Repository
public interface PostRepository extends CrudRepository<Post,Integer>, PagingAndSortingRepository<Post, Integer> {
    Post findById(int id);

    List<Post> findByDescribePostContaining(String describePost);

    List<Post> findByContentContaining(String content);

    List<Post> findByStatus(String status);

    List<Post> findByPartnerIdAndStatus(int partnerId, String status);


    Page<Post> findTop10ByOrderByIdDesc(Pageable pageable);

    Page<Post> findTop10ByStatusOrderByIdDesc(String status, Pageable pageable);

//    List<Post> findTop10ByStatusOrderByIdDesc(String status);

    List<Post> findTop5ByOrderByIdDesc();

    Page<Post> findAllByStatusOrderByIdDesc(String status, Pageable pageable);

    Page<Post> findAllByOrderByIdDesc(Pageable pageable);
}