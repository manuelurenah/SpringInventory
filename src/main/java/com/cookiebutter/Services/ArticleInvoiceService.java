package com.cookiebutter.Services;

import com.cookiebutter.Models.ArticleInvoice;
import com.cookiebutter.Models.Invoice;
import com.cookiebutter.Repositories.ArticleInvoiceRepository;
import com.cookiebutter.Repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 13/10/16.
 */
@Service
@Transactional
public class ArticleInvoiceService {
    @Autowired
    ArticleInvoiceRepository articleInvoiceRepository;

    public ArticleInvoice create(ArticleInvoice invoice) {
        return articleInvoiceRepository.save(invoice);
    }
    public ArticleInvoice save(ArticleInvoice invoice) {
        return articleInvoiceRepository.save(invoice);
    }


}
