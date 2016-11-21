import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.ResultSet;


public class Customer {

	private String id;
	private String name;
	private int  cardnumber;
	private int pin;
	//java.sql.Connection connect;
	
	 java.sql.Connection connect= null;
	private java.sql.ResultSet result = null;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}

	public Customer(String id, String name, int cardnumber, int pin) {
		super();
		this.id = id;
		this.name = name;
		this.cardnumber = cardnumber;
		this.pin = pin;
		connect =  Database.getDatabaseConnection() ;
	}

	public Customer() {
		super();
		connect =  Database.getDatabaseConnection() ;
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.cardnumber = cardnumber;
		this.pin = pin;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
	public void  check(int cardnumber)throws Exception{
		Customer cos =null;
		 try {
			Statement start = connect.createStatement();
			String	query	=	"SELECT * FROM customer WHERE ID "+cardnumber+")";
		 result =start.executeQuery(query);
		 
		 while(result.next()){
			 cos = new Customer();
			 cos.setId(result.getString(1));
			 cos.setName(result.getString(1));
			 cos.setCardnumber(Integer.parseInt(result.getString(3)));
			 cos.setPin(Integer.parseInt(result.getString(4)));	 
		 }
		 
		 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }

	
}
