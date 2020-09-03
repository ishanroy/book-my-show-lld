package com.isroy.dev.bms.entities;

import com.isroy.dev.bms.exceptions.InvalidOperationException;
import com.isroy.dev.bms.exceptions.SeatNotLockedException;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class Seat {
    private long seatId;
    private AtomicLong userId;
    private AtomicBoolean isBooked;
    private long lockTimeStamp;

    public Seat(long seatId) {
        lockTimeStamp = 0L;
        this.seatId = seatId;
        this.userId = new AtomicLong();
        this.isBooked = new AtomicBoolean();
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public long getUserId() {
        return userId.get();
    }

    public Boolean isBooked() {
        return isBooked.get();
    }

    public Boolean isLocked() {
        if(userId.get() == 0)
            return false;
        else
            return true;
    }

    public Boolean lockSeat(long userId){
        long presentVal  = this.userId.get();
        while(presentVal == 0) {
                if (this.userId.compareAndSet(presentVal, userId)){
                    this.lockTimeStamp = System.currentTimeMillis();
                    return true;
                }
                else
                    presentVal = this.userId.get();
        }
        return false;
    }

    public Boolean bookSeat(long userId) throws SeatNotLockedException {
        if(this.userId.get() != userId)
            throw new SeatNotLockedException("Please lock the seat before booking.");
        boolean presentStatus = isBooked.get();
        while(presentStatus == false){
            if(this.isBooked.compareAndSet(presentStatus,true))
                return true;
            else
                presentStatus = this.isBooked.get();
        }
        return false;
    }

    public void unLockSeat() throws  InvalidOperationException{
        if(this.isBooked.get() == true)
            throw new InvalidOperationException("This seat is already booked.");
        this.userId.set(0);
    }

    public void cancelSeatBooking(){
        this.isBooked.set(false);
        this.userId.set(0);
    }


}
