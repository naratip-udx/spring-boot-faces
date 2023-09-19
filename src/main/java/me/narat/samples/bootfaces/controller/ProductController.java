package me.narat.samples.bootfaces.controller;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.narat.samples.bootfaces.model.Product;
import me.narat.samples.bootfaces.persistence.ProductRepository;

@Scope("session")
@RequiredArgsConstructor
@Component("productCtrl")
@ELBeanName("productCtrl")
@Join(path = "/product", to = "/product/product-form.jsf")
public class ProductController {

	private final ProductRepository productRepository;

	private Product product = new Product();

	public String save() {
		productRepository.save(product);
		product = new Product();
		return "/product/product-list.xhtml?faces-redirect=true";
	}

	public Product getProduct() {
		return product;
	}
}
