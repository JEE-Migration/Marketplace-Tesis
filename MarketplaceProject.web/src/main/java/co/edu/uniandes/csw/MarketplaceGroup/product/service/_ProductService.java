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

package co.edu.uniandes.csw.MarketplaceGroup.product.service;


import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.inject.Inject;

import co.edu.uniandes.csw.MarketplaceGroup.product.logic.dto.ProductDTO;
import co.edu.uniandes.csw.MarketplaceGroup.product.logic.dto.ProductPageDTO;
import co.edu.uniandes.csw.MarketplaceGroup.product.logic.ejb.ProductLogicService;


public abstract class _ProductService {

	@Inject
	protected ProductLogicService productLogicService;
	
	@POST
	public ProductDTO createProduct(ProductDTO product){
		return productLogicService.createProduct(product);
	}
	
	@DELETE
	@Path("{id}")
	public void deleteProduct(@PathParam("id") Long id){
		productLogicService.deleteProduct(id);
	}
	
	@GET
	public ProductPageDTO getProducts(@QueryParam("page") Integer page, @QueryParam("maxRecords") Integer maxRecords){
		return productLogicService.getProducts(page, maxRecords);
	}
	
	@GET
	@Path("{id}")
	public ProductDTO getProduct(@PathParam("id") Long id){
		return productLogicService.getProduct(id);
	}
	
	@PUT
	public void updateProduct(@PathParam("id") Long id, ProductDTO product){
		productLogicService.updateProduct(product);
	}
	
}