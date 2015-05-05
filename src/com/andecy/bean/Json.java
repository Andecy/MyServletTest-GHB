package com.andecy.bean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class Json extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JSONObject jObject = null;
		jObject = new JSONObject();
		try {
			jObject.put("result", "success");
			jObject.put("msg", "");
			JSONObject obj_info = new JSONObject();
			JSONArray array_goods = new JSONArray();
			JSONObject obj_goods = new JSONObject();
			obj_goods.put("i", 1);
			obj_goods.put("shop_price", "CNY 1542");
			obj_goods.put("currency_price", "£¤1542");
			obj_goods.put("promote_price", "CNY 0");
			obj_goods.put("rank_price", "£¤0");
			obj_goods.put("is_promote", 0);
			obj_goods.put("goods_id", "36");
			obj_goods.put("goods_name", "Elizabeth Olsen");
			obj_goods.put("english_name", "test");
			obj_goods.put("thumb",
					"images\\201307\\thumb_img\\36_thumb_G_1372878562802.jpg");
			obj_goods.put("goods_img",
					"images\\201307\\goods_img\\36_G_1372878562793.jpg");
			obj_goods.put("add_time", 1372878562);
			obj_goods.put("colorid", 12);
			obj_goods.put("colorname", "Ê¯ÂÌ");
			obj_goods.put("colorcode", "#48b5a1");
			obj_goods.put("colorurl", "http:\\\\www.baidu.com");
			JSONArray array_albums = new JSONArray();
			JSONObject obj_albums = new JSONObject();
			obj_albums.put("img_id", "55");
			obj_albums
					.put("img_url",
							"http:\\\\121.197.1.20\\images\\201307\\goods_img\\36_P_1372880021023.jpg");
			obj_albums
					.put("thumb_url",
							"http:\\\\121.197.1.20\\images\\201307\\thumb_img\\36_thumb_P_1372880021912.jpg");
			obj_albums.put("img_desc", "Violette d'Urso");
			array_albums.put(obj_albums);
			obj_albums = new JSONObject();

			obj_albums.put("img_id", "54");
			obj_albums
					.put("img_url",
							"http:\\\\121.197.1.20\\images\\201307\\goods_img\\36_P_1372879423227.jpg");
			obj_albums
					.put("thumb_url",
							"http:\\\\121.197.1.20\\images\\201307\\thumb_img\\36_thumb_P_1372879423809.jpg");
			obj_albums.put("img_desc", "MAIWENN");
			array_albums.put(obj_albums);
			obj_albums = new JSONObject();

			obj_albums.put("img_id", "53");
			obj_albums
					.put("img_url",
							"http:\\\\121.197.1.20\\images\\201307\\goods_img\\36_P_1372879254852.jpg");
			obj_albums
					.put("thumb_url",
							"http:\\\\121.197.1.20\\images\\201307\thumb_img\\36_thumb_P_1372880021912.jpg");
			obj_albums.put("img_desc", "Violette d'Urso");
			array_albums.put(obj_albums);

			obj_goods.put("albums", array_albums);
			array_goods.put(obj_goods);
			obj_info.put("goods", array_goods);
			obj_info.put("cat_name", "ÐÂÆ·");
			obj_info.put("cat_id", 35);
			obj_info.put("total_goods_num", 15);
			obj_info.put("total_page_num", 3);
			jObject.put("info", obj_info);
		} catch (Exception e) {
			// TODO: handle exception
		}

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String back = jObject.toString();
		out.println(back);
		out.flush();
		out.close();
	}
}
