package com.thadb.springmvctest.tests;

import java.util.Random;

import com.thadb.springmvctest.Services.ZipService;
import com.thadb.springmvctest.dao.User;

public class ZipBuilderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZipService zipService = new ZipService();
		User user = new User();
		//user.selectAllChamps();

		zipService.getFileFor(user);
	}

}
