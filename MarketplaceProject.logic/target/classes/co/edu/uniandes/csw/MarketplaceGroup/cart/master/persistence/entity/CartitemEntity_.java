package co.edu.uniandes.csw.MarketplaceGroup.cart.master.persistence.entity;

import co.edu.uniandes.csw.MarketplaceGroup.item.persistence.entity.ItemEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-05-01T20:44:05")
@StaticMetamodel(CartitemEntity.class)
public class CartitemEntity_ { 

    public static volatile SingularAttribute<CartitemEntity, Long> itemId;
    public static volatile SingularAttribute<CartitemEntity, ItemEntity> itemIdEntity;
    public static volatile SingularAttribute<CartitemEntity, Long> cartId;
    public static volatile SingularAttribute<CartitemEntity, ItemEntity> cartIdEntity;

}