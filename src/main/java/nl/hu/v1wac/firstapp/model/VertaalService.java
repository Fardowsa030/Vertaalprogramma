package nl.hu.v1wac.firstapp.model;

import java.sql.SQLException;

import nl.hu.v1wac.firstapp.persistence.EngelsDao;
import nl.hu.v1wac.firstapp.persistence.EngelsDaoImpl;

import nl.hu.v1wac.firstapp.persistence.LidwoordDao;
import nl.hu.v1wac.firstapp.persistence.LidwoordDaoImpl;
import nl.hu.v1wac.firstapp.persistence.StructuurDao;
import nl.hu.v1wac.firstapp.persistence.StructuurDaoImpl;
import nl.hu.v1wac.firstapp.persistence.WerkwoordDao;
import nl.hu.v1wac.firstapp.persistence.WerkwoordDaoImpl;
import nl.hu.v1wac.firstapp.persistence.ZelfstandignaamwoordDao;
import nl.hu.v1wac.firstapp.persistence.ZelfstandignaamwoordDaoImpl;

public class VertaalService {
	
	private EngelsDao edao = new EngelsDaoImpl();
	private LidwoordDao ldao = new LidwoordDaoImpl();
	private WerkwoordDao wdao = new WerkwoordDaoImpl();
	private ZelfstandignaamwoordDao zdao = new ZelfstandignaamwoordDaoImpl();
	private StructuurDao sdao = new StructuurDaoImpl();
	
	
	public Engels getEngels(String zin) throws SQLException {
		return edao.getEngels(zin);
	}
	
	public String Check(String zin) {
		return edao.checkCharacters(zin);
	}
	
	public Lidwoord save(Lidwoord lidwoord) {
		return ldao.save(lidwoord);	
		
	}
	
	public Werkwoord save(Werkwoord werkwoord) {
		return wdao.Save(werkwoord);	
		
	}
	

	public Zelfstandignaamwoord save(Zelfstandignaamwoord zelfstandignaamwoord) {
		return zdao.Save(zelfstandignaamwoord);	
		
	}
	
	 public int createUniqueIDLidwoord() {
		 return ldao.createUniqueID();
	 }
	 
	 public int createUniqueIDWerkwoord() {
		 return wdao.createUniqueIDWerkwoord();
	 }
	 
	 public int createUniqueIDZelfstandignaamwoord() {
		 return zdao.createUniqueIDZelfstandignaamwoord();
	 }
	 
	 
	 public boolean checkLidwoordDatabase(Lidwoord lidwoord) throws SQLException {
		 return ldao.checkLidwoordDatabase(lidwoord);
		 
	 } 
	 
	 public boolean checkWerkwoordDatabase(Werkwoord werkwoord) throws SQLException {
		 return wdao.checkWerkwoordDatabase(werkwoord);
		 
	 } 
	 
	 
	 public boolean checkZelfstandignaamwoordDatabase(Zelfstandignaamwoord zelfstandignaamwoord) throws SQLException {
		 return zdao.checkZelfstandignaamwoordDatabase(zelfstandignaamwoord);
		 
	 } 
	 
	 public Structuur getStructuur(String zin) {
		 return sdao.getStructuur(zin);
		 
	 }
	 
	 
	
	
}
