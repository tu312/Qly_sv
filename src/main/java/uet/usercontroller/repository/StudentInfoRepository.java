package uet.usercontroller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import uet.usercontroller.model.Student;
import uet.usercontroller.model.StudentInfo;

import java.util.List;

/**
 * Created by root on 7/20/16.
 */
public interface StudentInfoRepository extends CrudRepository<StudentInfo, Integer> , PagingAndSortingRepository<StudentInfo, Integer> {
    List<StudentInfo> findByFullNameContaining(String studentName);
}
