package com.deevyanshu.userservice.model;


public class Rating {

    private String ratingId;

    private String userId;

    private String hotelId;

    private int rating;

    private String feedback;

    private Hotel hotel;

    public Rating()
    {

    }

    public Rating(String ratingId, String userId, String hotelId, int rating, String feedback,Hotel hotel)
    {
        this.feedback=feedback;
        this.hotelId=hotelId;
        this.ratingId=ratingId;
        this.rating=rating;
        this.userId=userId;
        this.hotel=hotel;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getHotelId() {
        return hotelId;
    }

    public String getratingId() {
        return ratingId;
    }

    public int getRating() {
        return rating;
    }

    public String getUserId() {
        return userId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
    
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setratingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    

}
