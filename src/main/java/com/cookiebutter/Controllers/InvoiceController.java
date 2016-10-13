package com.cookiebutter.Controllers;

import com.cookiebutter.Models.*;
import com.cookiebutter.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by luis on 13/10/16.
 */
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    UserService userService;
    @Autowired
    ArticleService articleService;
    @Autowired
    InvoiceService invoiceService;
    @Autowired
    BorrowedService borrowedService;
    @Autowired
    ArticleInvoiceService articleInvoiceService;
    @Autowired
    ReturnedService returnedService;

    @GetMapping("/return")
    @PreAuthorize("hasAnyRole('ROLE_USER')")
    public String returnItems(Principal principal,
                              Model model) {
        // Load all items to be returned:
        User user = userService.findByUsername(principal.getName());
        List<Borrowed> toReturn = user.getBorroweds().stream().filter(Borrowed::isActive).collect(Collectors.toList());
        model.addAttribute("toReturn", toReturn);
        model.addAttribute("template_name", "invoice/return.ftl");

        return Constants.BASE_LAYOUT;
    }

    @PostMapping("/return")
    @PreAuthorize("hasRole('ROLE_USER')")
    @Transactional
    public String makeReturn(Principal principal,
                             Model model,
                             @RequestParam("borrows[]") List<Integer> borrowsIds,
                             @RequestParam("quantities[]") List<Integer> quantitiesIds){
        // Here we are
        User user = userService.findByUsername(principal.getName());
        Invoice invoice = new Invoice();
        invoice.setClient(user);
        invoice.setCreatedAt(new Date());
        ArrayList<Returned> returneds = new ArrayList<>();
        for(int i = 0; i < borrowsIds.size(); i++) {
            int borrowId = borrowsIds.get(i);
            int quantity = quantitiesIds.get(i);
            if(quantity != 0) {
                Borrowed b = borrowedService.getById(borrowId);
                Returned r = new Returned();
                r.setReturnDate(new Date());
                r.setBorrowed(b);
                r.setReturned(quantity);
                r.setTakenOn(b.getTakenOn());

                b.getReturns().add(r);
                b.getQuantity();
                returnedService.save(r);
                borrowedService.save(b);

                returneds.add(r);
            }
        }

        if(returneds.size() != 0) {
            //SAVE and create invoice:
            for(Returned r: returneds) {
                ArticleInvoice ai = new ArticleInvoice();
                ai.setQuantity(r.getReturned());
                ai.setArticle(r.getBorrowed().getArticle());
                ai.setInvoice(invoice);
                ai.setDays((int)TimeUnit.DAYS.convert(r.getReturnDate().getTime() - r.getTakenOn().getTime(), TimeUnit.MILLISECONDS) + 1);
                articleInvoiceService.save(ai);
                invoice.getArticleInvoices().add(ai);
            }

            invoiceService.save(invoice);
        }

        return "redirect:/user/view/"+principal.getName();
    }
}
