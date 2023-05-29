package ma.sir.obs.dao.facade.history;

import ma.sir.obs.zynerator.repository.AbstractHistoryRepository;
import ma.sir.obs.bean.history.BrandHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandHistoryDao extends AbstractHistoryRepository<BrandHistory,Long> {

}