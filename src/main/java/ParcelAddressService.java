package main.java;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;

@Path("/sent")
public class ParcelAddressService {
	private Dao<PriceTable, String>priceDao;
	private Dao<Country, String>cDao;
	private ConnectionSource con;
	
	public ParcelAddressService() {
		// TODO Auto-generated constructor stub
		DatabaseHandler db = DatabaseHandler.getDatabaseHandler();
		con = db.connect("jdbc:mysql://localhost:3306/ms_parcel_address?user=root&password=hskempten2014tool!!");
		try {
			priceDao = DaoManager.createDao(con, PriceTable.class);
			cDao = DaoManager.createDao(con, Country.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("address")
	public Response calculateParcelPrice(String json) {
		Gson g = new Gson();
		
		Parcel parcel = g.fromJson(json, Parcel.class);
		String resp="";
		if(parcel != null){
			String country = parcel.getRecipient().getCountry();
		 	String size = parcel.getSize().toString();
			
			try {
				String query = "SELECT pricetable.* "
							 + "FROM country LEFT JOIN zone ON country.zone_id = zone.id "
							 			  + "LEFT JOIN pricetable ON zone.id = pricetable.zone_id "
							 			  + "LEFT JOIN size ON size.id = pricetable.size_id "
							 + "WHERE country = '"+country+"' AND label = '"+size+"'";
				GenericRawResults<String []> raw = cDao.queryRaw(query);
				
				List<String []> result = raw.getResults();
				
				double price=0.0;
				for(String [] res : result){
					price = Double.parseDouble(res[3]);
				}
				
				if(price != 0.0){
					parcel.setPrice(price);
					System.out.println("Price to pay: " + price);
					resp = g.toJson(parcel);
				}else
					resp = "Zu der angegebenen Adresse liefern wir leider nicht!";
			    
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println(resp);
		return Response
			      .status(200)
			      .header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .entity(resp)
			      .build();
	}
	
}
