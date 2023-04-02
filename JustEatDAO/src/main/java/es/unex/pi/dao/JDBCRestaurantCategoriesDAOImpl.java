package es.unex.pi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import es.unex.pi.model.Restaurant_Category;

public class JDBCRestaurantCategoriesDAOImpl implements RestaurantCategoriesDAO {

	private Connection conn;
	private static final Logger logger = Logger.getLogger(JDBCRestaurantCategoriesDAOImpl.class.getName());

	@Override
	public List<Restaurant_Category> getAll() {

		if (conn == null) return null;
						
		ArrayList<Restaurant_Category> restaurantCategoriesList = new ArrayList<Restaurant_Category>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RestaurantCategories");
						
			while ( rs.next() ) {
				Restaurant_Category restaurantCategories = new Restaurant_Category();
				restaurantCategories.setIdr(rs.getInt("idr"));
				restaurantCategories.setIdct(rs.getInt("idct"));
						
				restaurantCategoriesList.add(restaurantCategories);
				logger.info("fetching all RestaurantCategories: "+restaurantCategories.getIdr()+" "+restaurantCategories.getIdct());
					
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restaurantCategoriesList;
	}

	@Override
	public List<Restaurant_Category> getAllByCategory(long idct) {
		
		if (conn == null) return null;
						
		ArrayList<Restaurant_Category> restaurantCategoriesList = new ArrayList<Restaurant_Category>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RestaurantCategories WHERE idct="+idct);

			while ( rs.next() ) {
				Restaurant_Category restaurantCategories = new Restaurant_Category();
				restaurantCategories.setIdr(rs.getInt("idr"));
				restaurantCategories.setIdct(rs.getInt("idct"));

				restaurantCategoriesList.add(restaurantCategories);
				logger.info("fetching all RestaurantCategories by idr: "+restaurantCategories.getIdr()+"->"+restaurantCategories.getIdct());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return restaurantCategoriesList;
	}
	
	@Override
	public List<Restaurant_Category> getAllByRestaurant(long idr) {
		
		if (conn == null) return null;
						
		ArrayList<Restaurant_Category> restaurantCategoriesList = new ArrayList<Restaurant_Category>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RestaurantCategories WHERE Idr="+idr);

			while ( rs.next() ) {
				Restaurant_Category restaurantCategories = new Restaurant_Category();
				restaurantCategories.setIdr(rs.getInt("idr"));
				restaurantCategories.setIdct(rs.getInt("idct"));
							
				restaurantCategoriesList.add(restaurantCategories);
				logger.info("fetching all RestaurantCategories by idct: "+restaurantCategories.getIdct()+"-> "+restaurantCategories.getIdr());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return restaurantCategoriesList;
	}
	
	
	@Override
	public Restaurant_Category get(long idr,long idct) {
		if (conn == null) return null;
		
		Restaurant_Category restaurantCategories = null;		
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM RestaurantCategories WHERE idr="+idr+" AND idct="+idct);			 
			if (!rs.next()) return null;
			restaurantCategories= new Restaurant_Category();
			restaurantCategories.setIdr(rs.getInt("idr"));
			restaurantCategories.setIdct(rs.getInt("idct"));

			logger.info("fetching RestaurantCategories by idr: "+restaurantCategories.getIdr()+"  and idct: "+restaurantCategories.getIdct());
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return restaurantCategories;
	}
	
	

	@Override
	public boolean add(Restaurant_Category restaurantCategories) {
		boolean done = false;
		if (conn != null){
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("INSERT INTO RestaurantCategories (idr,idct) VALUES('"+
									restaurantCategories.getIdr()+"','"+
									restaurantCategories.getIdct()+"')");
						
				logger.info("creating RestaurantCategories:("+restaurantCategories.getIdr()+" "+restaurantCategories.getIdct());
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean update(Restaurant_Category dbObject, Restaurant_Category newObject) {
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				stmt.executeUpdate("UPDATE RestaurantCategories SET idct="+newObject.getIdct()
				+" WHERE idr = "+dbObject.getIdr() + " AND idct = " + dbObject.getIdct());
				
				logger.info("updating RestaurantCategories:("+dbObject.getIdr()+" "+dbObject.getIdct());
				
				done= true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public boolean delete(long idr, long idct) {
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				stmt.executeUpdate("DELETE FROM RestaurantCategories WHERE idr ="+idr+" AND idct="+idct);
				logger.info("deleting RestaurantCategories: "+idr+" , idct="+idct);
				done= true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return done;
	}

	@Override
	public void setConnection(Connection conn) {
		// TODO Auto-generated method stub
		this.conn = conn;
	}
	
}
