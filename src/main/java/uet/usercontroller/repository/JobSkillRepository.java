package uet.usercontroller.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import uet.usercontroller.model.JobSkill;
import uet.usercontroller.model.PartnerInfo;

@Repository
public interface JobSkillRepository extends CrudRepository<JobSkill,Integer>, PagingAndSortingRepository<JobSkill, Integer> {
    JobSkill findById(int id);
}
