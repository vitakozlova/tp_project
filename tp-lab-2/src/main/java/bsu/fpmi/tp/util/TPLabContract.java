package bsu.fpmi.tp.util;

/**
 * @author Vlad Abramov
 * @since 18.11.2014
 */
public interface TPLabContract {

    public interface DB {
        public interface Employee {
            public static final String TABLE_NAME = "Employee";

            public static final String ID = "userId";
            public static final String LOGIN = "login";
            public static final String PASSWORD_HASH = "passwordHash";
            public static final String EMPLOYEE_ROLE = "employeeRole";
            public static final String FIRST_NAME = "firstName";
            public static final String LAST_NAME = "lastName";
        }

        public interface Demands {
            public static final String TABLE_NAME = "Demands";

            public static final String ID = "demandId";
            public static final String CLIENT_NAME = "clientName";
            public static final String CLIENT_PHONE = "clientPhone";
            public static final String CLIENT_EMAIL = "clientEmail";
            public static final String CLIENT_ADDRESS = "clientAddress";
            public static final String DEMAND_STATE = "demandState";
            public static final String DEMAND_EXECUTE_STATE = "demandExecuteState";
            public static final String PRODUCT_LIST_ID = "productListId";

        }

        public interface ProductList {
            public static final String TABLE_NAME = "ProductsList";

            public static final String ID = "productListId";
            public static final String PRODUCT_COUNT = "productCount";
            public static final String PRODUCT_FIX_COST = "productFixCost";
            public static final String PRODUCT_ID = "productId";
        }

        public interface Catalog {
            public static final String TABLE_NAME = "Catalog";

            public static final String ID = "productId";
            public static final String PRODUCT_DESCRIPTION = "productDesc";
            public static final String PRODUCT_COST = "productCost";
        }

        public interface Inventory {
            public static final String TABLE_NAME = "Inventory";

            public static final String PRODUCT_COUNT = "productCount";
            public static final String ID = "productId";
        }

        public interface Orders {
            public static final String TABLE_NAME = "Demands";

            public static final String ID = "orderId";
            public static final String ORDER_SUM = "orderSum";
            public static final String CLIENT_NAME = "clientName";
            public static final String CLIENT_PHONE = "clientPhone";
            public static final String CLIENT_EMAIL = "clientEmail";
            public static final String CLIENT_ADDRESS = "clientAddress";
            public static final String DEMAND_ID = "demandId";
            public static final String PRODUCT_LIST_ID = "productListId";
        }
    }

    public interface Pages {
        public static final String INDEX = "index";
        public static final String LOGIN = "login";
        public static final String GET_INVENTORY = "getInventory";
    }

}
