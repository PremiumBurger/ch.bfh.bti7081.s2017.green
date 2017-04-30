package ch.bfh.bti7081.s2017.green.data;

import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<T extends BaseEntity> extends PagingAndSortingRepository<T, Long> {


}
