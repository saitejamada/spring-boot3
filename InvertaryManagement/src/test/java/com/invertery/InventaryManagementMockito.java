package com.invertery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.invertery.model.Customer;
import com.invertery.model.Inventory;
import com.invertery.model.Payment;
import com.invertery.model.Role;
import com.invertery.model.Stock;
import com.invertery.service.*;




@SpringBootTest
public class InventaryManagementMockito {

	CustomerService c=Mockito.mock(CustomerService.class);
	InventoryService is=Mockito.mock(InventoryService.class);
	PaymentService ps=Mockito.mock(PaymentService.class);
	PermissionService perser=Mockito.mock(PermissionService.class);
	RoleService rs=Mockito.mock(RoleService.class);
	StockService ss=Mockito.mock(StockService.class);
	Customer cust=new Customer("sai", "98798798", "sai@abc.com", "sai@19", "iugaid78", "jbvj");
	Inventory inv=new  Inventory("New Inventory","2211","goods","food");
	Payment pay=new Payment(cust, "768", "food", new java.sql.Date(2022, 2, 22));
	Role r=new Role("user", "all user roles");
	Stock s=new Stock("goods", "99","wheat", "30",70);;
	List<Stock> list=new ArrayList<>();
	@Test
	void testCustomerSave() {
		when(c.saveCustomer(cust)).thenReturn(cust);
		assertEquals(c.saveCustomer(cust), cust);
	}
	@Test
	void testCustomerGetById() {
		when(c.getCustomer(0)).thenReturn(cust);
		assertEquals(c.getCustomer(0), cust);
	}
	@Test
	void testInventorySave() {
		when(is.saveInventory(inv)).thenReturn(inv);
		assertEquals(is.saveInventory(inv), inv);
	}
	@Test
	void testInventoryGetById() {
		when(is.getInventory(0)).thenReturn(inv);
		assertEquals(is.getInventory(0), inv);
	}
	@Test
	void testInventoryNullPointer() {
		doThrow(new NullPointerException("No Inventory Found")).when(is).getInventory(1);	
	}
}
