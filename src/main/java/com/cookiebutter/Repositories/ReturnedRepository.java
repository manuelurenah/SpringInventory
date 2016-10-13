package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Invoice;
import com.cookiebutter.Models.Returned;
import org.hibernate.loader.custom.Return;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by luis on 13/10/16.
 */
public interface ReturnedRepository extends CrudRepository<Returned, Long> {
}
