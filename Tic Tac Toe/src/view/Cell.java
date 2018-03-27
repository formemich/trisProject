package view;

import javax.swing.*;

/**
 * Created by deletefile on 12/03/18.
 */
public class Cell extends JButton {

    public enum CellStatus {
        EMPTY,
        O,
        X
    }

    private CellStatus cellStatus;
    private int positionX;
    private int positionY;

    public int getPositionX() {
        return positionX;
    }

    public Cell() {

    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public CellStatus getCellStatus() {
        return cellStatus;
    }

    public void setCellStatus(CellStatus cellStatus) {
        this.cellStatus = cellStatus;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}
