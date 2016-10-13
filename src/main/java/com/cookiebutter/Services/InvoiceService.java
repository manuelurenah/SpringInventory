package com.cookiebutter.Services;

import com.cookiebutter.Models.Invoice;
import com.cookiebutter.Repositories.InvoiceRepository;
import org.aspectj.apache.bcel.generic.INVOKEINTERFACE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by luis on 13/10/16.
 */
@Service
@Transactional
public class InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    public Invoice create(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }


}
