package com.software.model;

public class Order {
	private int order_id;
	private String order_number;
	private String order_creation_time;
	private int user_id;
	private int train_id;
	private float order_tiket_price;
	private String order_pay_type;
	private String order_seat_type;

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getOrder_creation_time() {
		return order_creation_time;
	}
