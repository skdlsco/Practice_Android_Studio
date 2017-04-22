package com.example.eka.weather;

/**
 * Created by eka on 2017. 4. 11..
 */

public class WeatherTemperature {

    public Response response = new Response();
    public class Response{
        public Body body = new Body();

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }
    }
    public class Body{
        public Items items =new Items();

        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }
    }
    public class Items{
        public Item item = new Item();

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }
    }
    public class Item{
        public String taMin3;
        public String taMax3;

        public String getTaMax3() {
            return taMax3;
        }

        public void setTaMax3(String taMax) {
            this.taMax3 = taMax3;
        }

        public String getTaMin3() { return taMin3; }

        public void setTaMin3(String taMin) {
            this.taMin3 = taMin3;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
