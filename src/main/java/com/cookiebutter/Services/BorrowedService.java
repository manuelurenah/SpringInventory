package com.cookiebutter.Services;

import com.cookiebutter.Models.Article;
import com.cookiebutter.Models.Borrowed;
import com.cookiebutter.Models.User;
import com.cookiebutter.Repositories.BorrowedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 12/10/16.
 */
@Service
@Transactional
public class BorrowedService {
    @Autowired
    BorrowedRepository borrowedRepository;

    public Borrowed create(Borrowed borrowed) {
        return borrowedRepository.save(borrowed);
    }

    public Borrowed save(Borrowed borrowed){
        return borrowedRepository.save(borrowed);
    }

    public void delete(Borrowed borrowed) {
        borrowedRepository.delete(borrowed);
    }

    public Borrowed isBorrowedByClient(User client, Article article) {
        return borrowedRepository.findByClientIdAndArticleId(client.getId(), article.getId());
    }
}
