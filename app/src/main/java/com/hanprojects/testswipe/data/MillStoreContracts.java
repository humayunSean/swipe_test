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

    }

    public static final class ItemEntry implements BaseColumns{

        public static final String TABLE_NAME = "mill_item";

        public static final String COLUMN_ITEM_NAME = "item_name";

        public static final String COLUMN_CATEGORY = "category_id";

        public static final String COLUMN_DESCRIPTION = "descripition";

        public static final String COLUMN_SHORT_DESCRIPTION = "short_description";

        public static final String COLUMN_IMAGE = "image";

        public static final String COLUMN_ACTIVE = "active";

        public static final String COLUMN_AVAILABILTY = "availability";

        public static final String COLUMN_CART = "cart";

        public static final String COLUMN_CREATED = "created";

        public static final String COLUMN_CREATED_BY = "created_by";

        public static final String COLUMN_QUANTITY = "quantity";

        public static final String COLUMN_VENDOR = "vendor";

        public static final String COLUMN_FULLFILLMENT_GROUP = "fullfillment_group";

        public static final String COLUMN_SHOW_QUANTITY = "show_quantity";

        public static final String COLUMN_UPDATED = "updated";

        public static final String COLUMN_UPDATED_BY = "updated_by";

        public static final String COLUMN_COST = "cost";
    }
}
