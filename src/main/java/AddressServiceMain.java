package main.java;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class AddressServiceMain {
	private static void initPriceTable(){
		DatabaseHandler db = DatabaseHandler.getDatabaseHandler();
		Dao<Zone, String> zoneDao;
		Dao<Size, String> sizeDao;
		Dao<PriceTable, String> priceDao;
		
		ConnectionSource con = db.connect("jdbc:mysql://localhost:3306/ms_parcel_address?user=root&password=hskempten2014tool!!");
		db.initTables();
		
		try {
			zoneDao = DaoManager.createDao(con, Zone.class);
			sizeDao = DaoManager.createDao(con, Size.class);
			priceDao = DaoManager.createDao(con, PriceTable.class);
			
			Zone z = new Zone();
			z.setName("Euro1");
			
			Zone z2 = new Zone();
			z2.setName("Euro2");
			
			Zone z3 = new Zone();
			z3.setName("Euro3");
			
			Zone z4 = new Zone();
			z4.setName("Euro4");
			
			Zone z0 = new Zone();
			z0.setName("DE");
			
			zoneDao.create(z0);
			zoneDao.create(z);
			zoneDao.create(z2);
			zoneDao.create(z3);
			zoneDao.create(z4);
			
			Size s0 = new Size();
			s0.setLabel("XS");
			
			Size s1 = new Size();
			s1.setLabel("S");
			
			Size s2 = new Size();
			s2.setLabel("M");
			
			Size s3 = new Size();
			s3.setLabel("L");
			
			Size s4 = new Size();
			s4.setLabel("XL");
			
			sizeDao.create(s0);
			sizeDao.create(s1);
			sizeDao.create(s2);
			sizeDao.create(s3);
			sizeDao.create(s4);
			
			PriceTable p0 = new PriceTable(z0,s0,3.89);
			PriceTable p1 = new PriceTable(z0,s1,4.29);
			PriceTable p2 = new PriceTable(z0,s2,5.89);
			PriceTable p3 = new PriceTable(z0,s3,9.89);
			PriceTable p4 = new PriceTable(z0,s4,15.99);
			
			PriceTable p5 = new PriceTable(z,s0,9.19);
			PriceTable p6 = new PriceTable(z,s1,11.49);
			PriceTable p7 = new PriceTable(z,s2,15.29);
			PriceTable p8 = new PriceTable(z,s3,18.49);
			PriceTable p9 = new PriceTable(z,s4,24.99);
			
			PriceTable p10 = new PriceTable(z2,s0,12.39);
			PriceTable p11 = new PriceTable(z2,s1,12.99);
			PriceTable p12 = new PriceTable(z2,s2,18.29);
			PriceTable p13 = new PriceTable(z2,s3,22.49);
			PriceTable p14 = new PriceTable(z2,s4,29.99);
			
			PriceTable p15 = new PriceTable(z3,s0,14.89);
			PriceTable p16 = new PriceTable(z3,s1,18.79);
			PriceTable p17 = new PriceTable(z3,s2,19.99);
			PriceTable p18 = new PriceTable(z3,s3,27.19);
			PriceTable p19 = new PriceTable(z3,s4,31.99);
			
			PriceTable p20 = new PriceTable(z4,s0,17.89);
			PriceTable p21 = new PriceTable(z4,s1,24.49);
			PriceTable p22 = new PriceTable(z4,s2,25.99);
			PriceTable p23 = new PriceTable(z4,s3,30.99);
			PriceTable p24 = new PriceTable(z4,s4,43.49);
			
			priceDao.create(p0);
			priceDao.create(p1);
			priceDao.create(p2);
			priceDao.create(p3);
			priceDao.create(p4);
			priceDao.create(p5);
			priceDao.create(p6);
			priceDao.create(p7);
			priceDao.create(p8);
			priceDao.create(p9);
			priceDao.create(p10);
			priceDao.create(p11);
			priceDao.create(p12);
			priceDao.create(p13);
			priceDao.create(p14);
			priceDao.create(p15);
			priceDao.create(p16);
			priceDao.create(p17);
			priceDao.create(p18);
			priceDao.create(p19);
			priceDao.create(p20);
			priceDao.create(p21);
			priceDao.create(p22);
			priceDao.create(p23);
			priceDao.create(p24);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void initCountryDB(){
		DatabaseHandler db = DatabaseHandler.getDatabaseHandler();
		Dao<Country, String> cDao;
		Dao<Zone, String> zoneDao;
		ConnectionSource con = db.connect("jdbc:mysql://localhost:3306/ms_parcel_address?user=root&password=hskempten2014tool!!");
		db.initTables();
		
		try {
			cDao = DaoManager.createDao(con, Country.class);
			zoneDao = DaoManager.createDao(con, Zone.class);
			
			List<Zone> zones = zoneDao.queryForAll();
			Zone de = zones.get(0);
			Zone e1 = zones.get(1);
			Zone e2 = zones.get(2);
			Zone e3 = zones.get(3);
			Zone e4 = zones.get(4);
			
			Country c0 = new Country(de, "Deutschland");
			Country c1 = new Country(e1, "Belgien");
			Country c2 = new Country(e1, "Dänemark");
			Country c3 = new Country(e1, "Frankreich");
			Country c4 = new Country(e1, "Luxemburg");
			Country c5 = new Country(e1, "Monaco");
			Country c6 = new Country(e1, "Niederlande");
			Country c7 = new Country(e1, "Österreich");
			Country c8 = new Country(e2, "Großbritannien");
			
			Country c9 = new Country(e2, "Italien");
			Country c10 = new Country(e2, "Polen");
			Country c11 = new Country(e2, "Slowenien");
			Country c12 = new Country(e2, "Spanien");
			Country c13 = new Country(e2, "Tschechien");
			
			Country c14 = new Country(e2, "Ungarn");
			Country c15 = new Country(e3, "Estland");
			Country c16 = new Country(e3, "Kroatien");
			Country c17 = new Country(e3, "Lettland");
			Country c18 = new Country(e3, "Litauen");
			Country c19 = new Country(e3, "Portugal");
			Country c20 = new Country(e3, "Schweden");
			Country c21 = new Country(e3, "Slowakai");
			Country c22 = new Country(e4, "Bulgarien");
			Country c23 = new Country(e4, "Finnland");
			Country c24 = new Country(e4, "Rumänien");
			
			cDao.create(c0);
			cDao.create(c1);
			cDao.create(c2);
			cDao.create(c3);
			cDao.create(c4);
			cDao.create(c5);
			cDao.create(c6);
			cDao.create(c7);
			cDao.create(c8);
			cDao.create(c9);
			cDao.create(c10);
			cDao.create(c11);
			cDao.create(c12);
			cDao.create(c13);
			cDao.create(c14);
			cDao.create(c15);
			cDao.create(c16);
			cDao.create(c17);
			cDao.create(c18);
			cDao.create(c19);
			cDao.create(c20);
			cDao.create(c21);
			cDao.create(c22);
			cDao.create(c23);
			cDao.create(c24);
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		HttpServer server;
		
		
		try {
			server = HttpServerFactory.create("http://localhost:1200/parcel");
			server.start();
			
			//while(true){}
			//JOptionPane.showMessageDialog(null, "ParcelSize-Service started!\nClick to end");
			//server.stop(0);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
