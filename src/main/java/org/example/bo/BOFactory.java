package org.example.bo;

import org.example.bo.custom.Impl.CustomerBOImpl;

public class BOFactory {

    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        CUSTOMER
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case CUSTOMER:
                return new CustomerBOImpl();
           // case ITEM:
               // return new ItemBOImpl();
            default:
                return null;
        }
    }

}
