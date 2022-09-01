package com.bloodbank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.bloodbank.model.Blood;
import com.bloodbank.model.Donor;
import com.bloodbank.model.Patient;
import com.bloodbank.model.Permission;
import com.bloodbank.model.Role;
import com.bloodbank.model.User;
import com.bloodbank.service.BloodService;
import com.bloodbank.service.DonorService;
import com.bloodbank.service.PatientService;
import com.bloodbank.service.PermissionService;



@SpringBootTest
public class BloodBankMockitoTestCases {

	BloodService bs=Mockito.mock(BloodService.class);
	DonorService ds=Mockito.mock(DonorService.class);
	PatientService ps=Mockito.mock(PatientService.class);
	PermissionService pers=Mockito.mock(PermissionService.class);
	Donor d;
	Blood b;
	Patient p;
	Permission per;
	@Test
	void test1() {
		when(ds.findDonor(1)).thenReturn(new Donor("vijay","46541665","vijay@1996","hyderbad",new User()));
		assertNotEquals(new Donor("vijay","46541665","vijay@1996","hyderbad",new User()), ds.findDonor(1));
	}
	@Test
	void test2(){
		d=new Donor("vijay","46541665","vijay@1996","hyderbad",new User());
		when(ds.saveDonor(d)).thenReturn(d);
		assertEquals(ds.saveDonor(d),d);
	}
	@Test
	void test3() {
		when(bs.findBlood(1)).thenReturn(new Blood("AB", "Positive", "Blood Bank", d));
		assertNotEquals(bs.findBlood(1),new Blood("AB", "Positive", "Blood Bank", d));
		}
	
	@Test
	void test4() {
		b=new Blood("AB", "Positive", "Blood Bank", d);
		when(bs.saveBlood(b)).thenReturn(b);
		assertEquals(bs.saveBlood(b), b);
	}
	@Test
	void test5() {
		p=new Patient("sai","97988998", "hyd", "sai@abc","sai", "sai", per);
		when(ps.savePatient(p)).thenReturn(p);
		assertEquals(ps.savePatient(p), p);
	}
	@Test
	void test6() {
		when(ps.getPatient(1)).thenReturn(p);
		assertEquals(ps.getPatient(1), p);
	}
	@Test
	void test7() {
		per=new Permission("admin",new Role());
		when(pers.savePermission(per)).thenReturn(per);
		assertEquals(pers.savePermission(per), per);
	}
	@Test
	void test8() {
		when(pers.getPermission(1)).thenReturn(per);
		assertEquals(pers.getPermission(1), per);
	}
	@Test
	void test9() {
		doThrow(new NullPointerException()).when(pers).getPermission(0);
	}
	@Test
	void test10() {
		doThrow(new NullPointerException()).when(ps).getPatient(0);
	}
}
