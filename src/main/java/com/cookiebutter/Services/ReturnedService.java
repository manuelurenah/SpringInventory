package com.cookiebutter.Services;

import com.cookiebutter.Models.Invoice;
import com.cookiebutter.Models.Returned;
import com.cookiebutter.Repositories.InvoiceRepository;
import com.cookiebutter.Repositories.ReturnedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 13/10/16.
 */
@Service
@Transactional
public class ReturnedService {
    @Autowired
    ReturnedRepository returnedRepository;

    public Returned create(Returned returned) {
        return returnedRepository.save(returned);
    }
    public Returned save(Returned returned) {
        return returnedRepository.save(returned);
    }


}
