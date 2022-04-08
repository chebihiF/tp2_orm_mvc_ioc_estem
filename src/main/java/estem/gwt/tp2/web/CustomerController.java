package estem.gwt.tp2.web;

import estem.gwt.tp2.entities.Customer;
import estem.gwt.tp2.metier.ICustomerMetier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final ICustomerMetier metier;

    public CustomerController(ICustomerMetier metier) {
        this.metier = metier;
    }

    @GetMapping
    public String getAllCustomers(Model model){
        try {
            //initCustomers();
            model.addAttribute("customers",metier.getAllCustomers());
        } catch (Exception e) {
            model.addAttribute("error",e.getMessage());
            e.printStackTrace();
        }
        return "customers";
    }

    public void initCustomers() throws Exception{
        for(int i=0;i<10;i++)
            metier.subscribe(new Customer(null,"customer "+i,"customer"+i+"@gmail.com",null));
    }
}
