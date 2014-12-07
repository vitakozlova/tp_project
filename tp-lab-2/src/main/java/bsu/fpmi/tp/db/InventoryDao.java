package bsu.fpmi.tp.db;

import bsu.fpmi.tp.model.Catalog;
import bsu.fpmi.tp.model.Inventory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@SuppressWarnings("unchecked")
public class InventoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Inventory> getInventory() {
        Query query = getSession().createQuery("from Inventory");
        List<Inventory> inventoryList = (List<Inventory>) query.list();
        return inventoryList;
    }
    @Transactional(readOnly = true)
    public List<Catalog> getProductFromInventory(List<Inventory> inventoryList) {
        List<Catalog> catalogList = new ArrayList<Catalog>();
        Query query1 = getSession().createQuery("from Catalog where id = :productId");
        for(int i=0;i<inventoryList.size();i++) {
            query1.setParameter("productId", inventoryList.get(i).getId());
            List list = query1.list();
            catalogList.add((Catalog) list.get(0));
        }
        return catalogList;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}