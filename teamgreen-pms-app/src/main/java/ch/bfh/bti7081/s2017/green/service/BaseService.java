package ch.bfh.bti7081.s2017.green.service;

import ch.bfh.bti7081.s2017.green.bean.EntityBean;
import ch.bfh.bti7081.s2017.green.data.BaseRepository;
import ch.bfh.bti7081.s2017.green.domain.BaseEntity;
import com.google.common.collect.Sets;

import java.util.Set;
import java.util.function.Function;

public abstract class BaseService<T extends BaseEntity, U extends EntityBean, R extends BaseRepository<T>> {

    private final R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    protected R getRepository() {
        return repository;
    }

    protected abstract Class<U> getType();

    public Set<U> getAll() {
        Set<U> result = Sets.newHashSet();

        repository.findAll().forEach(hv -> {
            result.add(initBean(hv));
        });
        return result;
    }

    public long save(U bean) {
        T entity = (T) bean.updateEntity();
        T saved = repository.save(entity);
        return saved.getId();
    }

    public void delete(U bean) {
        repository.delete(bean.getId());
    }

    public U getOne(long id) {
        T hv = repository.findOne(id);
        if (hv != null) {
            return initBean(hv);
        }
        return null;
    }

    public Set<U> find(Function<R, Set<T>> function) {
        Set<U> result = Sets.newHashSet();
        function.apply(repository).forEach(hv -> result.add(initBean(hv)));
        return result;
    }

    private U initBean(T hv) {
        U bean = null;
        try {
            bean = getType().newInstance();
            bean.setEntity(hv, true);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
