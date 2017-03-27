package uet.usercontroller.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uet.usercontroller.model.InfoBySchool;
import uet.usercontroller.model.PartnerInfo;

/**
 * Created by Tu on 07-Jul-16.
 */
@Repository
public interface InfoBySchoolRepository extends CrudRepository<InfoBySchool, Integer>, PagingAndSortingRepository<InfoBySchool, Integer> {

}
