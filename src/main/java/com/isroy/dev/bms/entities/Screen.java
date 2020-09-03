package com.isroy.dev.bms.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Screen {

    private long screenId;
    private HashMap<Long,Seat> seatMap;
    private int rows;
    private int cols;

    public Screen(long screenId){
        this.screenId = screenId;
    };

    public Screen(long screenId, Boolean[][] layout) {
        this.screenId = screenId;
        this.rows = layout.length;
        if(layout != null)
            this.cols = layout[0].length;
        this.seatMap = new HashMap<>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                long id  = (i * rows) + j + 1;
                if(layout[i][j] == true)
                    seatMap.put(id,new Seat(id));
                else
                    seatMap.put(id,null);
            }
        }
    }

    public long getScreenId() {
        return screenId;
    }

    public void setScreenId(long screenId) {
        this.screenId = screenId;
    }

    public HashMap<Long,Seat> getSeatMap() {
        return seatMap;
    }


    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }
}
