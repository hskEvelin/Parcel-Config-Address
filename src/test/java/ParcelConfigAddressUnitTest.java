package test.java;

import static org.junit.Assert.assertEquals;
import javax.ws.rs.core.Response;
import org.junit.Test;
import com.google.gson.Gson;
import main.java.Address;
import main.java.Parcel;
import main.java.ParcelAddressService;
import main.java.Parcelsize;

public class ParcelConfigAddressUnitTest {

	
	@Test
	public void testPriceForZoneDE(){
		Gson g = new Gson();
		
		ParcelAddressService service = new ParcelAddressService();
		Address recpient = new Address("Lucas Greising", "Sommerstraße", "31", "81543", "München", "Deutschland");
		Address sender = new Address("Alex Greising", "Neumummen", "2", "87509", "Immenstadt", "");
		
		Parcel parcel = new Parcel();
		parcel.setSender(sender);
		parcel.setRecipient(recpient);
		parcel.setSize(Parcelsize.XS);
		
		String json = g.toJson(parcel);
		
		Response resp = service.calculateParcelPrice(json);
		json = (String) resp.getEntity();
		parcel = g.fromJson(json, Parcel.class);
		
		assertEquals(3.89, parcel.getPrice(), 0.0);
		
	}
	
	@Test
	public void testPriceForZoneE1(){
		Gson g = new Gson();
		
		ParcelAddressService service = new ParcelAddressService();
		Address recpient = new Address("Lucas Greising", "Sommerstraße", "31", "81543", "München", "Österreich");
		Address sender = new Address("Alex Greising", "Neumummen", "2", "87509", "Immenstadt", "");
		
		Parcel parcel = new Parcel();
		parcel.setSender(sender);
		parcel.setRecipient(recpient);
		parcel.setSize(Parcelsize.XS);
		
		String json = g.toJson(parcel);
		
		Response resp = service.calculateParcelPrice(json);
		json = (String) resp.getEntity();
		parcel = g.fromJson(json, Parcel.class);
		
		assertEquals(9.19, parcel.getPrice(), 0.0);
	}
}
