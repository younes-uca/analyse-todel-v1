package ma.sir.obs.dao.facade.history;

import ma.sir.obs.zynerator.repository.AbstractHistoryRepository;
import ma.sir.obs.bean.history.AnimalSpecieHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalSpecieHistoryDao extends AbstractHistoryRepository<AnimalSpecieHistory,Long> {

}