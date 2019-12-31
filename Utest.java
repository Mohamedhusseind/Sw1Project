package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import Model.*;
public class Utest {

	@Test
	public void signUp() {
		User u=new User();
	 UserManagment um=new UserManagment();
		u.SetUserName("esr");
		u.SetPassword("123456");
		u.SetPhone("01150447106");
		u.SetAddress("asd123");
		um.SetUser(u);
		boolean x= u.SignUp(um);
		System.out.println(x);
		assertTrue(x);
	}
	@Test
	public void signUpFail() {
		User u=new User();
	 UserManagment um=new UserManagment();
		u.SetUserName("ahmed");
		u.SetPassword("wrongpass");
		u.SetPhone("01150447106");
		u.SetAddress("asd123");
		um.SetUser(u);
		boolean x= u.SignUp(um);
		assertFalse(x);
	}

    private void assertFalse(boolean x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	

}