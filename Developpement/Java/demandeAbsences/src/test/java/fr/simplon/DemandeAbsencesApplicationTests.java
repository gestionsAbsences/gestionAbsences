package fr.simplon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.simplon.dao.ServiceRhDao;
import fr.simplon.domain.Absence;
import fr.simplon.domain.Employe;
import fr.simplon.domain.ServiceRh;
import fr.simplon.services.ServiceRhService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Config.class)
public class DemandeAbsencesApplicationTests {
	//L'annotation 'Mock' prends une classe en argument
	//et retourne un objet de cette classe
	@Mock
	ServiceRhDao rhDao;
	
	@Mock
	ServiceRh rh;
	
	@Mock
	Absence absence;
	
	@Mock
	Employe employe;
	
	@InjectMocks
	ServiceRhService rhService;
	
	@Before
	public void servcieRhInit(){
		
	}
	
	@Test
	public void serviceRhBeanTest() {
//		//Verifie si une instance d'une classe existe
//		assertTrue (rh instanceof ServiceRh);
//		List<Absence> abs = new ArrayList<Absence>();
//		List<Employe> emp = new ArrayList<Employe>();
//		ServiceRh sce = new ServiceRh(anyLong(),null,"jean",abs,emp);
//		assertEquals("jean",sce.getNom());
//		assertNull(sce.getEmail());
	}

//	@Test
//	public void serviceRhTest() throws SQLException {
//		when(rhDao.findByName(anyString())).thenReturn(rh);
//		assertEquals(rh, rhService.getServiceRh(anyString()));
//	
//	}
	
	//test avec simulation d'exception
	@Test(expected  = Exception.class)
	public void serviceRhTestException() throws SQLException{
		when(rhDao.findByName(anyString())).thenThrow(new Exception());
		rhService.getServiceRh(anyString());
	}
	
	//Test avec une liste
//	@Test
//	public void listeRhTest() throws SQLException{
//	//	List<ServiceRh> serviceRh = new ArrayList<ServiceRh>();
//		Iterable<ServiceRh>  itRh= rhDao.findAll();
//		when(rhDao.findAll()).thenReturn(itRh);
//		
//		assertEquals(itRh,rhService.listeServicesRh());
//	}

}
