package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Borrowed;
import com.cookiebutter.Models.User;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * Created by luis on 03/10/16.
 */
public interface BorrowedRepository extends DataTablesRepository<Borrowed, Long> {
    Borrowed findByArticleId(long articleId);
    Borrowed findByClientId(long clientId);
    Borrowed findByClientIdAndArticleId(long clientId, long articleId);
    Borrowed findById(long id);
    DataTablesOutput<Borrowed> findByActiveTrue(DataTablesInput dtin);
}
