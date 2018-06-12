package com.bootdo.system.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootdo.system.domain.AddressDO;
import com.bootdo.system.service.AddressService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * 地址管理
 * 
 * @author geyy
 * @email geyueyuan@qq.com
 * @date 2018-06-06 15:56:47
 */
 
@Controller
@RequestMapping("/system/address")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping()
	@RequiresPermissions("system:address:address")
	String Address(){
	    return "system/address/address";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("system:address:address")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AddressDO> addressList = addressService.list(query);
		int total = addressService.count(query);
		PageUtils pageUtils = new PageUtils(addressList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("system:address:add")
	String add(){
	    return "system/address/add";
	}

	@GetMapping("/edit/{addressId}")
	@RequiresPermissions("system:address:edit")
	String edit(@PathVariable("addressId") Long addressId,Model model){
		AddressDO address = addressService.get(addressId);
		model.addAttribute("address", address);
	    return "system/address/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("system:address:add")
	public R save( AddressDO address){
		if(addressService.save(address)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@PostMapping("/update")
	@RequiresPermissions("system:address:edit")
	public R update( AddressDO address){
		addressService.update(address);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("system:address:remove")
	public R remove( Long addressId){
		if(addressService.remove(addressId)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("system:address:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] addressIds){
		addressService.batchRemove(addressIds);
		return R.ok();
	}
	
}
