package com.yusuf.project.global;

import java.util.ArrayList;
import java.util.List;

import com.yusuf.project.model.Product;

public class GlobalData {
	public static List<Product> cart;
	static {
		cart = new ArrayList<Product>();
	}

}
