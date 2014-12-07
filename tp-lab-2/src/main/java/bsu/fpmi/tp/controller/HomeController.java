package bsu.fpmi.tp.controller;

import bsu.fpmi.tp.db.EmployeeDao;
import bsu.fpmi.tp.db.InventoryDao;
import bsu.fpmi.tp.model.Catalog;
import bsu.fpmi.tp.model.Employee;
import bsu.fpmi.tp.model.Inventory;
import bsu.fpmi.tp.util.EmployeeDetails;
import bsu.fpmi.tp.util.TPLabContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
@Controller
public class HomeController {

    @Autowired
    private InventoryDao inventoryDao;

    @RequestMapping("/")
    @PreAuthorize("hasAnyRole('ROLE_CLERK', 'ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SELLER')")
    public String indexPage(ModelMap modelMap) {
        EmployeeDetails userDetails = (EmployeeDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.put("employee", userDetails.getEmployee());
        return TPLabContract.Pages.INDEX;
    }

    @RequestMapping("login")
    public String loginPage() {
        return TPLabContract.Pages.LOGIN;
    }

    @RequestMapping("get_inventory")
    public ModelAndView getInventory() {
        List<Inventory> inventory = inventoryDao.getInventory();
        List<Catalog> catalog = inventoryDao.getProductFromInventory(inventory);
        ModelAndView model = new ModelAndView("getInventory");
        model.addObject("inventory", inventory);
        model.addObject("catalog", catalog);
        return model;
    }
}
