package uet.usercontroller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uet.usercontroller.model.Follow;
import uet.usercontroller.model.Post;
import uet.usercontroller.model.Student;

import java.util.List;

/**
 * Created by nhkha on 16/02/2017.
 */
@Repository
public interface FollowRepository extends CrudRepository<Follow,Integer> {
    List<Follow> findByPostId(int postId);
    List<Follow> findByStudentId(int studentId);
    Follow findByStudentIdAndPostId(int studentId, int postId);
}


