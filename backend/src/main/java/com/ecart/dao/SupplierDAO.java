package com.ecart.dao;

import java.util.List;

import com.ecart.model.Supplier;

public interface SupplierDAO {
	public boolean addSupplier(Supplier supplier);
	public Supplier getSupplier(int supplierId);
	public boolean deleteSupplier(Supplier supplier);
	public boolean updateSuppplier(Supplier supplier);
	public List<Supplier> getSupplier();

}
