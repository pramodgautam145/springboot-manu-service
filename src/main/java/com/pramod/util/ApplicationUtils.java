package com.pramod.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pramod.entity.Items;
import com.pramod.entity.Manu;
import com.pramod.entity.Product;
import com.pramod.entity.SubManu;
import com.pramod.response.ItemsDTO;
import com.pramod.response.ProductDto;
import com.pramod.response.Request;
import com.pramod.response.Response;
import com.pramod.response.SubManuDto;

/**
 * @author HP
 *
 */
public class ApplicationUtils {
   
	
	public static Manu prepareDataForManuItem() {
		Manu manu =new Manu();
		manu.setManuName("Electronic");
		SubManu submanu =new SubManu();
		submanu.setSubManuName("Mobiles");
		//manu.getSubmanuList().add(submanu);
		List<SubManu> subManuList=new ArrayList<SubManu>();
		subManuList.add(submanu);
		submanu.setManu(manu);
		manu.setSubmanuList(subManuList);
		Product product =new Product();
		product.setProductName("MI");
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		submanu.setProductList(productList);
		product.setSubManu(submanu);
		Items item =new Items();
		item.setItemName("C21");
		List<Items> itemList =new ArrayList<Items>();
		item.setProduct(product);
		itemList.add(item);
		
		product.setItemList(itemList);
		String s=ApplicationUtils.getJson(manu);
		System.out.println(s);
		return manu;
	}
	
	public static String getJson(Manu request) {
		ObjectMapper Obj = new ObjectMapper();
		try {
			String jsonStr = Obj.writeValueAsString(request);
			System.out.println(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static List<Response> prepareResponse(List<Manu> manulist) {

		List<Response> listResponse = new ArrayList<Response>();
		for (Manu manu : manulist) {
			Response response = new Response();
			response.setManuId(manu.getManuId());
			response.setManuName(manu.getManuName());
			// response.setSubmanuList(manu.getSubmanuList());

			List<SubManu> listsubmanu = manu.getSubmanuList();
			if (listsubmanu != null && listsubmanu.size() > 0) {
				List<SubManuDto> sublistDto = new ArrayList<SubManuDto>();
				for (SubManu submanu : listsubmanu) {
					SubManuDto subManuDto = new SubManuDto();
					subManuDto.setSubManuId(submanu.getSubManuId());
					subManuDto.setSubManuName(submanu.getSubManuName());
					List<Product> productList = submanu.getProductList();
					if (productList != null && productList.size() > 0) {
						List<ProductDto> productLisrDto = new ArrayList<ProductDto>();
						for (Product product : productList) {
							ProductDto productDto = new ProductDto();
							productDto.setProductId(product.getProductId());
							productDto.setProductName(product.getProductName());

							List<Items> itemList = product.getItemList();
							if (itemList != null && itemList.size() > 0) {
								List<ItemsDTO> itemListDto = new ArrayList<ItemsDTO>();
								for (Items item : itemList) {
									ItemsDTO itemDto = new ItemsDTO();
									itemDto.setItemid(item.getItemid());
									itemDto.setItemName(item.getItemName());
									// itemDto.setProduct(product);
									itemListDto.add(itemDto);
								}
								productDto.setItemList(itemListDto);
							}
							productLisrDto.add(productDto);
						}
						subManuDto.setProductList(productLisrDto);
					}
					sublistDto.add(subManuDto);
				}
				response.setSubmanuList(sublistDto);
			}
			listResponse.add(response);
		}

		return listResponse;
	}
	
	
	
	
	public static Manu prepareRequestForEntity(Request request) {

		Manu manu = new Manu();
		manu.setManuId(request.getManuId());
		manu.setManuName(request.getManuName());
		List<SubManuDto> listsubmanu = request.getSubmanuList();
		if (listsubmanu != null && listsubmanu.size() > 0) {
			List<SubManu> sublist = new ArrayList<SubManu>();
			for (SubManuDto subManuDto : listsubmanu) {
				SubManu subManu = new SubManu();
				subManu.setSubManuId(subManuDto.getSubManuId());
				subManu.setSubManuName(subManuDto.getSubManuName());
				List<ProductDto> productList = subManuDto.getProductList();
				if (productList != null && productList.size() > 0) {
					List<Product> productLisr = new ArrayList<Product>();
					for (ProductDto productDto : productList) {
						Product product = new Product();
						product.setProductId(productDto.getProductId());
						product.setProductName(productDto.getProductName());

						List<ItemsDTO> itemListDto = productDto.getItemList();
						if (itemListDto != null && itemListDto.size() > 0) {
							List<Items> itemList = new ArrayList<Items>();
							for (ItemsDTO itemsDTO : itemListDto) {
								Items item = new Items();
								item.setItemid(itemsDTO.getItemid());
								item.setItemName(itemsDTO.getItemName());
								// itemDto.setProduct(product);
								itemList.add(item);
								item.setProduct(product);
							}
							product.setItemList(itemList);
						}
						productLisr.add(product);
						product.setSubManu(subManu);
					}
					subManu.setProductList(productLisr);
				}
				sublist.add(subManu);
				subManu.setManu(manu);
			}
			manu.setSubmanuList(sublist);
		}
		return manu;
	}
	
			

}
