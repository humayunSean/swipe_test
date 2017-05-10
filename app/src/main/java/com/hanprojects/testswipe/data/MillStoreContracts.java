package com.hanprojects.testswipe.data;

import android.provider.BaseColumns;

/**
 * Created by humayun on 3/7/2017.
 */

public class MillStoreContracts {

    public static final class CategoryEntry implements BaseColumns{

        public static final String TABLE_NAME = "mill_category";

        public static final String COLUMN_ITEM_NAME = "category_name";

        public static final String COLUMN_DESCRIPTION = "descripition";

        public static final String COLUMN_SHORT_DESCRIPTION = "short_description";

        public static final String COLUMN_ACTIVE = "active";

        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";

        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";

        public static final String COLUMN_PARENT_CATEGORY = "parent_category";

        public static final String COLUMN_IMAGE = "image";
        
        public static final String COLUMN_ICON = "icon";
        
        public static final String COLUMN_TAB_CATEGORY = "tab_category";
        
         public static final String COLUMN_FULLFILLMENT_GROUP = "fullfillment_group";

    }

    public static final class ItemEntry implements BaseColumns{

        public static final String TABLE_NAME = "mill_item";

        public static final String COLUMN_ITEM_NAME = "item_name";

        public static final String COLUMN_CATEGORY = "category_id";

        public static final String COLUMN_DESCRIPTION = "descripition";

        public static final String COLUMN_SHORT_DESCRIPTION = "short_description";

        public static final String COLUMN_IMAGE = "image";
        
        public static final String COLUMN_ICON = "icon";

        public static final String COLUMN_ACTIVE = "active";

        public static final String COLUMN_AVAILABILTY = "availability";

        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";

        public static final String COLUMN_VENDOR = "vendor";

        public static final String COLUMN_FULLFILLMENT_GROUP = "fullfillment_group";

        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";

        public static final String COLUMN_COST = "cost";
        
//        public static final String COLUMN_CART = "cart";
//        public static final String COLUMN_SHOW_QUANTITY = "show_quantity";
//        public static final String COLUMN_QUANTITY = "quantity";        
    }
    
    public static final class CartEntry implements BaseColumns{
        
        public static final String TABLE_NAME = "mill_cart";
        
        public static final String COLUMN_ACTIVE = "active";

        public static final String COLUMN_ITEM_NAME = "cart_name";

        public static final String COLUMN_USER = "user";

        public static final String COLUMN_ADDRESS = "delivery_address";

        public static final String COLUMN_TOTAL_ITEM = "total_item";

        public static final String COLUMN_TOTAL_COST = "total_cost";
         
        public static final String COLUMN_CART_ITEM = "cart_item";
        
    }
    
    public static final class CartItemEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_cart_item";
        
        public static final String COLUMN_ACTIVE = "active";

        public static final String COLUMN_Item = "item";

        public static final String COLUMN_QUANTITY = "quantity";
        
        public static final String COLUMN_COST = "cost";

        public static final String COLUMN_ORDER_NO = "order_no";
         
        public static final String COLUMN_DATE_PLACED = "date_placed";
        
    }
    
    public static final class OrderDetailEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_order_detail";
        
        public static final String COLUMN_USER = "user";

        public static final String COLUMN_ADDRESS = "delivery_address";

        public static final String COLUMN_ORDER_NO = "order_no";
        
        public static final String COLUMN_ORDER_QUANTITY = "order_quantity";

        public static final String COLUMN_ORDER_COST = "order_cost";
        
        public static final String COLUMN_DATE_PLACED = "date_placed";

        public static final String COLUMN_DATE_DELIVERED = "date_delivered";
        
        public static final String COLUMN_STATE = "state";
        
    }
    
    public static final class RequestEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_request";
        
        public static final String COLUMN_ACTIVE = "active";
        
        public static final String COLUMN_REQUEST_DATE = "request_date";
        
        public static final String COLUMN_DELIVERY_TIME = "delivery_time";
        
        public static final String COLUMN_AUTHENTICATED = "authenticated";
        
        public static final String COLUMN_PAYMENT_RECEIVED = "payment_received";
        
        public static final String COLUMN_ASSIGNED_TO = "assigned_to";
        
        public static final String COLUMN_ASSIGNMENT_GROUP = "assignment_group";
        
        public static final String COLUMN_STATE = "state";
        
        public static final String COLUMN_CONTACT_NO = "contact_no";
        
        public static final String COLUMN_ADDRESS = "delivery_address";
        
        public static final String COLUMN_REQUESTER = "requester";
        
        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";
        
        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";
        
        public static final String COLUMN_RITM = "ritm";
        
        public static final String COLUMN_TOTAL_COST = "total_cost";
        
        public static final String COLUMN_PRIORITY = "priority";

        public static final String COLUMN_PARTIAL_ORDER = "partial_order";
        
        public static final String COLUMN_OPENED = "opened";

        public static final String COLUMN_OPENED_BY = "opened_by";
        
    }
    
    public static final class RITMEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_ritm";
        
        public static final String COLUMN_ACTIVE = "active";
        
        public static final String COLUMN_ASSIGNED_TO = "assigned_to";
        
        public static final String COLUMN_ASSIGNMENT_GROUP = "assignment_group";
        
        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";
        
        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";
        
        public static final String COLUMN_OPENED = "opened";

        public static final String COLUMN_OPENED_BY = "opened_by";
        
        public static final String COLUMN_STATE = "state";
        
        public static final String COLUMN_QUANTITY = "quantity";
        
        public static final String COLUMN_PRIORITY = "priority";
        
        public static final String COLUMN_COST = "cost";
        
        public static final String COLUMN_ITEM = "item";
        
    }
    
    public static final class UserEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_user";
        
        public static final String COLUMN_ACTIVE = "active";
        
        public static final String COLUMN_NAME = "name";
        
        public static final String COLUMN_FIRST_NAME = "first_name";
        
        public static final String COLUMN_MIDDLE_NAME = "middle_name";
        
        public static final String COLUMN_LAST_NAME = "last_name";
        
        public static final String COLUMN_USER_ID = "user_id";
        
        public static final String COLUMN_EMAIL_ID = "email_id";
        
        public static final String COLUMN_MOBILE = "mobile";
        
        public static final String COLUMN_LANDLINE = "landline";
        
        public static final String COLUMN_LOCATION = "location";
        
        public static final String COLUMN_COMPANY = "company";
        
        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";
        
        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";
        
        public static final String COLUMN_GENDER = "gender";

        public static final String COLUMN_LAST_LOGIN = "last_login";
        
        public static final String COLUMN_PASSWORD = "password";
        
        public static final String COLUMN_PHOTO = "photo";
        
        public static final String COLUMN_PREFIX = "prefix";
        
    }
    
     public static final class LocationEntry implements BaseColumns{
         
        public static final String TABLE_NAME = "mill_location";
        
        public static final String COLUMN_ACTIVE = "active";
        
        public static final String COLUMN_CITY = "city";
         
         public static final String COLUMN_DISTRICT = "district";
        
        public static final String COLUMN_STATE = "state";
        
        public static final String COLUMN_COUNTRY = "country";
        
        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";
        
        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";
        
        public static final String COLUMN_STREET = "street";

        public static final String COLUMN_ADDRESS1 = "address1";
        
        public static final String COLUMN_ADDRESS2 = "address2";
        
        public static final String COLUMN_ZIP_CODE = "zip_code";
        
    }
}
