package Zajednicko;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTable;

import Exceptions.UnexpectedErrorException;


public class CRUD_Ops {
	 static HelperPrikaz HP = new HelperPrikaz();

	static Helper Helper = new Helper();
	static HelperPrikaz HelperP = new HelperPrikaz();
	
	public static String prikaz(JTable table) {
		String query = "SELECT * FROM Knjizara";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 

	public static void Dodaj(String Naziv, String Kolicina, String Proizvodjac, String Cena) throws UnexpectedErrorException {
    	if(Naziv.equals("") ||  Kolicina.equals("") || Proizvodjac.equals("") || Cena.equals("")) {
    		throw new UnexpectedErrorException("Greška pri dodavanju (Nisu popunjena sva polja)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.getConnection();
			String query = "INSERT INTO Knjizara(Naziv, Kolicina, Proizvodjac, Cena) VALUES ('"+Naziv+"', '"+Integer.valueOf(Kolicina)+"', '"+Proizvodjac+"', '"+Integer.valueOf(Cena)+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
	
	public static void Izmeni(String Naziv, String Kolicina, String Proizvodjac, String Cena, String ID) throws UnexpectedErrorException {
    	if(Naziv.equals("") ||  Kolicina.equals("") || Proizvodjac.equals("") || Cena.equals("")) {
    		throw new UnexpectedErrorException("Greška pri izmeni (Neka polja su ostala prazna, ili ništa nije promenjeno)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.getConnection();
			String query = "UPDATE Knjizara SET Naziv ='"+Naziv+"', Kolicina = '"+Integer.valueOf(Kolicina)+"', Proizvodjac='"+Proizvodjac+"', Cena ='"+Integer.valueOf(Cena)+"' WHERE ID = "+ID+"";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }


    public static void Obrisi(String Naziv, String Kolicina, String Proizvodjac, String Cena, String ID) throws UnexpectedErrorException   {
    	Connection connect = Zajednicko.Helper.getConnection();
		String sql = "DELETE FROM Knjizara WHERE ID = "+ID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
	public static String PrikazRadnika(JTable table) {
		String query = "SELECT * FROM Radnici";
		HelperP.PopuniTabelu(query, table);
		return query;
	}
 
    public static void DodajRadnika(String Ime, String Prezime, String Brojtel, String Adresa, String Email, String PTT, String SSB) throws UnexpectedErrorException {
    	if(Ime.equals("") ||  Prezime.equals("") || Brojtel.equals("") || Adresa.equals("") || Email.equals("") || SSB.equals("") || PTT.equals("")) {
    		throw new UnexpectedErrorException("Greška pri dodavanju (Nisu popunjena sva polja)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.getConnection();
			String query = "INSERT INTO Radnici(Ime, Prezime, BrojTel, Adresa, Email, PTT, SSB) VALUES ('"+Ime+"', '"+Prezime+"', '"+Integer.valueOf(Brojtel)+"', '"+Adresa+"', '"+Email+"', '"+Integer.valueOf(PTT)+"', '"+Integer.valueOf(SSB)+"')";
			
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}

	  }

}
    
    public static void IzmeniRadnika(String Ime, String Prezime, String Brojtel, String Adresa, String Email, String PTT, String SSB, String ID) throws UnexpectedErrorException {
    	if(Ime.equals("") ||  Prezime.equals("") || Brojtel.equals("") || Adresa.equals("") || Email.equals("") || PTT.equals("") || SSB.equals("")) {
    		throw new UnexpectedErrorException("Greška pri izmeni (Neka polja su ostala prazna, ili ništa nije promenjeno)!");
		}else { 
			
			Connection conn = Zajednicko.Helper.getConnection();
			String query = "UPDATE Radnici SET Ime = '"+Ime+"', Prezime = '"+Prezime+"', BrojTel = '"+Integer.valueOf(Brojtel)+"', Adresa = '"+Adresa+"', Email = '"+Email+"', PTT = '"+Integer.valueOf(PTT)+"', SSB = '"+Integer.valueOf(SSB)+"' WHERE ID = '"+Integer.valueOf(ID)+"'";
					
			try {
				java.sql.Statement stm = conn.createStatement();
				stm.execute(query);
				
				conn.close();
				
			}
			catch(Exception be){
					be.printStackTrace();
			}
			
			
		}		
    }
    
    public static void ObrisiRadnika(String Ime, String Prezime, String Brojtel, String Adresa, String Email, String SSB, String PTT, String ID) throws UnexpectedErrorException   {
    	Connection connect = Zajednicko.Helper.getConnection();
		String sql = "DELETE FROM Radnici WHERE ID = "+ID+"";
		System.out.print(sql);
		
		Statement stm;
		try {
			stm = connect.createStatement();
			stm.execute(sql);
			   
			connect.close();		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new UnexpectedErrorException("Greška pri brisanju.");
		}
		
	}
    
    
}