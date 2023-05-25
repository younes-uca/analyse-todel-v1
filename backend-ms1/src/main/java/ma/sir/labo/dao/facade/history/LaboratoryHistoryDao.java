package ma.sir.labo.dao.facade.history;

import ma.sir.labo.zynerator.repository.AbstractHistoryRepository;
import ma.sir.labo.bean.history.LaboratoryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryHistoryDao extends AbstractHistoryRepository<LaboratoryHistory,Long> {

}
