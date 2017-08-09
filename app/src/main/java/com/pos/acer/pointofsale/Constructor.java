package com.pos.acer.pointofsale;

/**
 * Created by Daly on 7/11/2017.
 */

public class Constructor {
    public Constructor(){};
    public static final String DATABASE_NAME = "POS";
    ///////////////////////////////1.init table user////////////////////////////////////////////
    public static final String TABLE_USER           = "user";
    public static final String TBU_ID               = "user_id";
    public static final String TBU_FULLNAME         = "fullname";
    public static final String TBU_USERNAME         = "username";
    public static final String TBU_GENDER           = "gender";
    public static final String TBU_AGE              = "age";
    public static final String TBU_DATE_OF_BIRTH    = "date_of_birth";
    public static final String TBU_ADDRESS          = "address";
    public static final String TBU_PHONE            = "phone";
    public static final String TBU_EMAIL            = "email";
    public static final String TBU_PASSWORD         = "password";
    public static final String TBU_IMG_PROFILE      = "img_profile";
    public static final String TBU_ROLE             = "role";
    public static final String CREATE_TABLE_USER    = "create table " + TABLE_USER + "("
                                                    + TBU_ID +              " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBU_FULLNAME +        " TEXT    ,"
                                                    + TBU_USERNAME +        " TEXT    ,"
                                                    + TBU_GENDER +          " TEXT    ,"
                                                    + TBU_AGE +             " INTEGER ,"
                                                    + TBU_DATE_OF_BIRTH +   " TEXT    ,"
                                                    + TBU_ADDRESS +         " TEXT    ,"
                                                    + TBU_PHONE +           " TEXT    ,"
                                                    + TBU_EMAIL +           " TEXT    ,"
                                                    + TBU_PASSWORD +        " TEXT    ,"
                                                    + TBU_IMG_PROFILE +     " TEXT    ,"
                                                    + TBU_ROLE +            " TEXT    );";
    public static final String DROP_TABLE_USER      = "drop table if exits " + TABLE_USER +"";

    ///////////////////////////////2.init table product//////////////////////////////////////////
    public static final String TABLE_PRODUCT        = "product";
    public static final String TBP_PRODUCT_ID       = "product_id";
    public static final String TBP_PRODUCT_TYPE_ID  = "product_type_id";
    public static final String TBP_PRODUCT_NAME     = "product_name";
    public static final String TBP_PRODUCT_PRICE    = "product_price";
    public static final String TBP_PRODUCT_TAX      = "product_tax";
    public static final String TBP_PRODUCT_IMG      = "product_image";
    public static final String TBP_PRODUCT_COMPANY  = "product_company";
    public static final String TBP_PRODUCT_BARCODE  = "product_barcode";
    public static final String CREATE_TABLE_PRODUCT = "create table " + TABLE_PRODUCT + "("
                                                    + TBP_PRODUCT_ID +              " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBP_PRODUCT_TYPE_ID +         " INTEGER    ,"
                                                    + TBP_PRODUCT_NAME +            " INTEGER    ,"
                                                    + TBP_PRODUCT_PRICE +           " INTEGER    ,"
                                                    + TBP_PRODUCT_TAX +             " INTEGER    ,"
                                                    + TBP_PRODUCT_COMPANY +         " TEXT       ,"
                                                    + TBP_PRODUCT_BARCODE +         " TEXT       ,"
                                                    + TBP_PRODUCT_IMG +             " TEXT       );";
    public static final String DROP_TABLE_PRODUCT   = "drop table if exits " + TABLE_PRODUCT+"";

    ////////////////////////////////3.init table product_type//////////////////////////////////
    public static final String TABLE_PRODUCT_TYPE   = "product_type";
    public static final String TBPT_ID              = "product_type_id";
    public static final String TBPT_TYPE            = "product_type_name";
    public static final String CREATE_TABLE_PRODUCT_TYPE = "create table " + TABLE_PRODUCT_TYPE + "("
                                                    + TBPT_ID +              " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBPT_TYPE +            " TEXT );";
    public static final String DROP_TABLE_PRODUCT_TYPE = "drop table if exits " + TABLE_PRODUCT_TYPE +"";


    ////////////////////////////////4.init table product_promotion///////////////////////////////
    public static final String TABLE_PROMOTION             = "promotion";
    public static final String TBPMT_ID                    = "promotion_id";
    public static final String TBPMT_DISCOUNT_PERCENTAGE   = "discount_percentage";
    public static final String TBPMT_LIMIT_ITEM            = "limit_item";
    public static final String TBPMT_FREE_ITEM             = "free_item";
    public static final String TBPMT_PROMOTION_START_DATE  = "promotion_start_date";
    public static final String TBPMT_PROMOTION_END_DATE    = "promotion_end_date";
    public static final String CREATE_TABLE_PROMOTION = "create table " + TABLE_PROMOTION + "("
                                                    + TBPMT_ID +                   " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBPMT_DISCOUNT_PERCENTAGE +  " INTEGER    ,"
                                                    + TBPMT_LIMIT_ITEM +           " INTEGER    ,"
                                                    + TBPMT_FREE_ITEM +            " INTEGER    ,"
                                                    + TBPMT_PROMOTION_START_DATE + " TEXT       ,"
                                                    + TBPMT_PROMOTION_END_DATE +   " TEXT       );";
    public static final String DROP_TABLE_PROMOTION    = "drop table if exits " + TABLE_PROMOTION +"";


    ////////////////////////////////5. init table receipt///////////////////////////////
    public static final String TABLE_RECEIPT        = "product_receipt";
    public static final String TBRC_ID              = "product_receipt_id";
    public static final String TBRC_USER_ID         = "user_id";
    public static final String TBRC_TOTAL           = "total";
    public static final String TBRC_DATE            = "receipt_date";
    public static final String CREATE_TABLE_RECEIPT = "create table " + TABLE_RECEIPT + "("
                                                    + TBRC_ID +                 " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBRC_USER_ID +            " INTEGER    ,"
                                                    + TBRC_TOTAL +              " INTEGER    ,"
                                                    + TBRC_DATE +               " TEXT       );";
    public static final String DROP_TABLE_RECEIPT   = "drop table if exits " + TABLE_RECEIPT +"";

    ////////////////////////////////6. init table product record///////////////////////////////
    public static final String TABLE_PRODUCT_RECORD = "product_record";
    public static final String TBPRC_ID             = "product_record_id";
    public static final String TBPRC_PRODUCT_ID     = "product_id";
    public static final String TBPRC_QUANTITY       = "quantity";
    public static final String CREATE_TABLE_PRODUCT_RECORD  = "create table " + TABLE_PRODUCT_RECORD + "("
                                                    + TBPRC_ID +                  " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBPRC_PRODUCT_ID +          " INTEGER    ,"
                                                    + TBPRC_QUANTITY +            " INTEGER   );";
    public static final String DROP_TABLE_PRODUCT_RECORD = "drop table if exits " + TABLE_PRODUCT_RECORD+"";

    ////////////////////////////////7. init table receipt record///////////////////////////////
    public static final String TABLE_RECEIPT_RECORD = "receipt_record";
    public static final String TBRCRC_ID            = "receipt_record_id";
    public static final String TBRCRC_RECEIPT_ID    = "product_receipt_id";
    public static final String TBRCRC_RECORD_ID     = "product_record_id";
    public static final String CREATE_TABLE_RECEIPT_RECORD  = "create table " + TABLE_RECEIPT_RECORD + "("
                                                    + TBRCRC_ID +                  " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBRCRC_RECEIPT_ID +          " INTEGER    ,"
                                                    + TBRCRC_RECORD_ID +           " INTEGER   );";
    public static final String DROP_TABLE_RECEIPT_RECORD = "drop table if exits " + TABLE_RECEIPT_RECORD+"";


    ////////////////////////////////8. init table product promotion/////////////////////////////////
    public static final String TABLE_PRODUCT_PROMOTION = "product_promotion";
    public static final String TBPP_ID                 = "product_promotion_id";
    public static final String TBPP_PRODUCT_ID         = "product_id";
    public static final String TBPP_PROMOTION_ID       = "promotion_id";
    public static final String CREATE_TABLE_PRODUCT_PROMOTION  = "create table " + TABLE_PRODUCT_PROMOTION + "("
            + TBPP_ID +                  " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + TBPP_PRODUCT_ID +          " INTEGER    ,"
            + TBPP_PROMOTION_ID +        " INTEGER   );";
    public static final String DROP_TABLE_PRODUCT_PROMOTION  = "drop table if exits " + TABLE_PRODUCT_PROMOTION+"";


    ////////////////////////////////9. init table user's product///////////////////////////////
    public static final String TABLE_USER_PRODUCT       = "user_product";
    public static final String TBUP_ID                  = "user_product_id";
    public static final String TBUP_USER_ID             = "user_id";
    public static final String TBUP_PRODUCT_ID          = "product_id";
    public static final String CREATE_TABLE_USER_PRODUCT  = "create table " + TABLE_USER_PRODUCT + "("
                                                    + TBUP_ID +                    " INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                    + TBUP_USER_ID +               " INTEGER    ,"
                                                    + TBUP_PRODUCT_ID +            " INTEGER   );";
    public static final String DROP_TABLE_USER_PRODUCT = "drop table if exits " + TABLE_USER_PRODUCT+"";
}