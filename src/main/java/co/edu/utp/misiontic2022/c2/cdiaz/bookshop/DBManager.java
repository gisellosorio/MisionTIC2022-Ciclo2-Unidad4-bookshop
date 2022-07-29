package co.edu.utp.misiontic2022.c2.cdiaz.bookshop;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBManager implements AutoCloseable {
    private Connection connection;

    public DBManager() throws SQLException {
        connect();
    }

    private void connect() throws SQLException {
        // TO DO: program this method
        //Class.forName("org.sqlite.JDBC"); 
        String url="jdbc:sqlite:C:/Users/Gisell/OneDrive/Escritorio/PROYECTOS 2022/Mision TIC/Ciclo 2/Programación básica/Semana 6/Clase 14/Bookshop.db";
        connection=DriverManager.getConnection(url);
    }

    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }

     /**
     * Return the number of units in stock of the given book.
     *
     * @param book The book object.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     * @throws SQLException If somthing fails with the DB.
     */
    public int getStock(Book book) throws SQLException {
        return getStock(book.getId());
    }

    /**
     * Return the number of units in stock of the given book.
     *
     * @param bookId The book identifier in the database.
     * @return The number of units in stock, or 0 if the book does not
     *         exist in the database.
     */
    public int getStock(int bookId) throws SQLException {
        // TO DO: program this method
        return 0;
    }

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
        // TO DO: program this method
        Book respuesta=null;
        Statement s=null;
        ResultSet rs=null;
        try{
            s=connection.createStatement();
            rs=s.executeQuery("Select * From Book Where isbn= '"+isbn+"'");
            if(rs.next()){
                respuesta=new Book();
                respuesta.setId(rs.getInt("id"));
                respuesta.setTitle(rs.getString("title"));
                respuesta.setIsbn(rs.getString("isbn"));
                respuesta.setYear(rs.getInt("year"));

            }
        }
        finally { 
            try { 
            if (rs != null){
            rs.close(); 
            }
            if (s != null) {
            s.close(); 
            }
            if (connection != null){
            connection.close(); 
            }
            } catch (SQLException e) {
            }
            } 
            
        return respuesta;
    }

    /**
     * Sell a book.
     *
     * @param book The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    /**
     * Sell a book.
     *
     * @param book The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int book, int units) throws SQLException {
        // TO DO: program this method
        return false;
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        // TO DO: program this method
        return new ArrayList<Book>();
    }
}
