package com.qa.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PizzaManager {

	DBManager manager = new DBManager();
	Connection conn = manager.connectDB();

	public Statement databaseSetup() {

		Statement statement = null;
		try {
			statement = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statement;
	}

	public boolean addSetPizza() {
		try {

			String query = "INSERT INTO pizzas (flavour, slices, stuffed_crust) VALUES (\"Pepperoni\", 12, true);";
			databaseSetup().executeUpdate(query); // Puts our query into the statement object, and runs the query
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addPizza(Pizza pizza) {
		try {
			String query = "INSERT INTO pizzas (flavour, slices, stuffed_crust) VALUES (\"" + pizza.getFlavour()
					+ "\", " + pizza.getSlices() + ", " + pizza.isStuffedCrust() + ");";
			databaseSetup().executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean addPizzaLoop() {
		try {
			ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
			pizzaList.add(new Pizza("Veggie Hot", 10, false));
			pizzaList.add(new Pizza("Pepperoni", 8, true));

			// for each object of type pizza in my pizzalist
			for (Pizza pizza : pizzaList) {
				addPizza(pizza);
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// A method to request ALL data from the database
	public ArrayList<Pizza> getAllPizzas() {
		
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();
		
		try {
			String query = "SELECT * FROM pizzas";
			ResultSet result = databaseSetup().executeQuery(query); // returns a ResultSet object
			while (result.next()) {
				Pizza newPizza = manager.convertResults(result);
				System.out.println(newPizza);
				pizzaList.add(newPizza);
			}

			return pizzaList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean getAllStuffedCrust() {
		try {

			String query = "SELECT * FROM pizzas WHERE stuffed_crust = true";
			ResultSet result = databaseSetup().executeQuery(query);
			while (result.next()) {
				System.out.println(manager.convertResults(result));
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean getAllQuery(String query) {
		try {
			ResultSet result = databaseSetup().executeQuery(query);
			System.out.println(" ");
			System.out.println(query);
			while (result.next()) {
				System.out.println(manager.convertResults(result));
			}

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deletePizza(long id) {
		try {
			// ? is a stand in for our id variable we will set
			String query = "DELETE FROM pizzas WHERE pizza_id = ?";
			PreparedStatement preState = conn.prepareStatement(query);
			preState.setLong(1, id);
			preState.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean addPizzaPrepState(Pizza pizza) {
		try {

			String query = "INSERT INTO pizzas (flavour, slices, stuffed_crust) VALUES (?, ?, ?);";
			PreparedStatement preState = conn.prepareStatement(query);

			preState.setString(1, pizza.getFlavour());
			preState.setInt(2, pizza.getSlices());
			preState.setBoolean(3, pizza.isStuffedCrust());
			preState.executeUpdate();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean updatePizza(int id, Pizza pizza) {
		try {
			String query = "UPDATE pizzas SET flavour = ?, slices = ?, stuffed_crust = ? WHERE pizza_id = ?";
			PreparedStatement preStmt = conn.prepareStatement(query);

			preStmt.setString(1, pizza.getFlavour());
			preStmt.setInt(2, pizza.getSlices());
			preStmt.setBoolean(3, pizza.isStuffedCrust());
			preStmt.setInt(4, id);

			preStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteAll() {
		try {
			// ? is a stand in for our id variable we will set
			String query = "TRUNCATE TABLE pizzas";
			PreparedStatement preState = conn.prepareStatement(query);
			preState.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
