/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phamduchoang
 */
public class StockDTO {

    private String StockID;
    private String StockName;
    private String Address;
    private String DateAvailable;
    private String Note;

    public StockDTO() {
    }

    public StockDTO(String StockID, String StockName, String Address, String DateAvailable, String Note) {
        this.StockID = StockID;
        this.StockName = StockName;
        this.Address = Address;
        this.DateAvailable = DateAvailable;
        this.Note = Note;
    }

    public String getStockID() {
        return StockID;
    }

    public String getStockName() {
        return StockName;
    }

    public void setStockName(String StockName) {
        this.StockName = StockName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getDateAvailable() {
        return DateAvailable;
    }

    public void setDateAvailable(String DateAvailable) {
        this.DateAvailable = DateAvailable;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

}
