package com.cookiebutter.Repositories;

import com.cookiebutter.Models.Family;
import com.cookiebutter.Models.Invoice;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by luis on 13/10/16.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
}
