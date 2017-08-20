package prisMotor;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import prisMotor.Bestilling;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BestillingsTest extends junit.framework.TestCase {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getLists() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());        
	}

	@Test
	public void getPris() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/kalkulator").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());		
	}

	String pingTest = "Pingvinører";
	int pingTestEnh = 5;
	int pingTestKart = 3;

	String hestSkoTest = "Hestesko";
	int hestSkoTestEnh = 3;
	int hestSkoTestKart = 3;

	Bestilling testPingBest = new Bestilling();
	Bestilling testPingBestKar = new Bestilling();

	Bestilling testHestBest = new Bestilling();
	Bestilling testHestBestKar = new Bestilling();

	PrisMotor pmTest = new PrisMotor();

	// Test av Kalkulatorfunksjonen.
	@Test
	public void testKalkulator() {
		assertEquals(56.875, testPingBest.kalkulator(pingTest, pingTestEnh, 0));
		assertEquals(472.5, testPingBestKar.kalkulator(pingTest, 0, pingTestKart));

		assertEquals(643.5, testHestBest.kalkulator(hestSkoTest, hestSkoTestEnh, 0));
		assertEquals(2227.5, testHestBestKar.kalkulator(hestSkoTest, 0, hestSkoTestKart));
	}

	//Tester lengde på prismotorliste. 50 stk pluss overskrift. 
	@Test
	public void testPrisMotor() {
		List<String> pingvinListe = pmTest.prisMotor("Pingvinører");

		assertEquals(51 , pingvinListe.size());
	}

}
