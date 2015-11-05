/* ========================================================================
 * Copyright 2014 MarketplaceGroup
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 MarketplaceGroup

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.qualifier

*/

package co.edu.uniandes.csw.MarketplaceGroup.cart.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.MarketplaceGroup.cart.logic.dto.CartDTO;
import co.edu.uniandes.csw.MarketplaceGroup.cart.logic.dto.CartPageDTO;
import co.edu.uniandes.csw.MarketplaceGroup.cart.persistence.api._ICartPersistence;
import co.edu.uniandes.csw.MarketplaceGroup.cart.persistence.converter.CartConverter;
import co.edu.uniandes.csw.MarketplaceGroup.cart.persistence.entity.CartEntity;

public abstract class _CartPersistence implements _ICartPersistence {

  	@PersistenceContext(unitName="MarketplaceProjectPU")
 
	protected EntityManager entityManager;
	
	public CartDTO createCart(CartDTO cart) {
		CartEntity entity=CartConverter.persistenceDTO2Entity(cart);
		entityManager.persist(entity);
		return CartConverter.entity2PersistenceDTO(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<CartDTO> getCarts() {
		Query q = entityManager.createQuery("select u from CartEntity u");
		return CartConverter.entity2PersistenceDTOList(q.getResultList());
	}

	@SuppressWarnings("unchecked")
	public CartPageDTO getCarts(Integer page, Integer maxRecords) {
		Query count = entityManager.createQuery("select count(u) from CartEntity u");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		Query q = entityManager.createQuery("select u from CartEntity u");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		CartPageDTO response = new CartPageDTO();
		response.setTotalRecords(regCount);
		response.setRecords(CartConverter.entity2PersistenceDTOList(q.getResultList()));
		return response;
	}

	public CartDTO getCart(Long id) {
		return CartConverter.entity2PersistenceDTO(entityManager.find(CartEntity.class, id));
	}

	public void deleteCart(Long id) {
		CartEntity entity=entityManager.find(CartEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCart(CartDTO detail) {
		CartEntity entity=entityManager.merge(CartConverter.persistenceDTO2Entity(detail));
		CartConverter.entity2PersistenceDTO(entity);
	}

}