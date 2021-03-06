package uet.usercontroller.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uet.usercontroller.model.Partner;
import uet.usercontroller.model.Student;


import java.util.List;

/**
 * Created by Tu on 03-May-16.
 */
@Repository
public interface PartnerRepository extends CrudRepository<Partner,Integer>, PagingAndSortingRepository<Partner, Integer> {
    Partner findById(int id);

    Partner findByPostId(int postId);

    Partner findByPartnerContactsId(int partnerContactId);

    Partner findByPartnerInfoId(int partnerInfoId);

}

