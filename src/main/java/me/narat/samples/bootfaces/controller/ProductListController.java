package me.narat.samples.bootfaces.controller;

import java.util.ArrayList;
import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.narat.samples.bootfaces.model.Product;
import me.narat.samples.bootfaces.persistence.ProductRepository;

@Scope("session")
@RequiredArgsConstructor
@Component("productListCtrl")
@ELBeanName("productListCtrl")
@Join(path = "/", to = "/product/product-list.jsf")
public class ProductListController {

	private final ProductRepository productRepository;

	private List<Product> products = new ArrayList<>();

	@Deferred
	@RequestAction
	@IgnorePostback
	public void loadData() {
		products = productRepository.findAll();
	}

	public List<Product> getProducts() {
		return products;
	}

	public String delete(Product product) {
		productRepository.deleteById(product.getId());
		loadData();
		return null;
	}
}
