package com.example.eka.weather;

/**
 * Created by eka on 2017. 4. 11..
 */

public class WeatherTextReturn {

    public Response response = new Response();

    public class Response{
        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        public Body body = new Body();
    }
    public class Body{
        public Items getItems() {
            return items;
        }

        public void setItems(Items items) {
            this.items = items;
        }

        public Items items = new Items();
    }
    public class Items{
        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public Item item = new Item();
    }
    public class Item{
        public String wfSv;

        public String getWfSv() {
            return wfSv;
        }

        public void setWfSv(String wfSv) {
            this.wfSv = wfSv;
        }
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}